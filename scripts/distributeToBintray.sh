#!/bin/sh
set -e

BUILD_DIR=$TRAVIS_BUILD_DIR
TARGET_DIR=$BUILD_DIR/target/distribute

VERSION=$(grep -oPm2 "(?<=<version>)[^<]+" "$BUILD_DIR/pom.xml" | sed -n 2p)
PROJECTS=$(mvn -f $BUILD_DIR/pom.xml -Dexec.executable='echo' -Dexec.args='${project.artifactId}' exec:exec -q)
SUFFIXES='.pom .jar -javadoc.jar -sources.jar'

ARTIFACTORY_URL="https://oss.jfrog.org/artifactory/oss-release-local/com/github/tomschi"
BINTRAY_URL="https://api.bintray.com/content/tomschi/oss-repo"

if case $VERSION in *-SNAPSHOT) true;; *) false;; esac; then
    echo "Skip distribution to bintray, because it is a snapshot version."
    exit 0
fi

# DOWNLOAD FROM ARTIFACTORY

for project in $PROJECTS ; do
  PROJECT_TARGET_DIR=$TARGET_DIR/$project
  mkdir -p $PROJECT_TARGET_DIR && cd $PROJECT_TARGET_DIR

  if case $project in *-parent) true;; *) false;; esac; then
    DOWNLOAD_URL="$ARTIFACTORY_URL/$project/$VERSION/$project-$VERSION.pom"
    echo "Download: $DOWNLOAD_URL"
    curl -Ofs $DOWNLOAD_URL
  fi

  if case $project in *-parent) false;; *) true;; esac; then
    for suffix in $SUFFIXES ; do
      DOWNLOAD_URL="$ARTIFACTORY_URL/$project/$VERSION/$project-$VERSION$suffix"
      echo "Download: $DOWNLOAD_URL"
      curl -Ofs $DOWNLOAD_URL
    done
  fi
done

# UPLOAD TO BINTRAY

for project in $PROJECTS ; do
  PROJECT_TARGET_DIR=$TARGET_DIR/$project
  cd $PROJECT_TARGET_DIR

  if case $project in *-parent) true;; *) false;; esac; then
    FILE_NAME="$project-$VERSION.pom"
    UPLOAD_URL="$BINTRAY_URL/$project/$VERSION/com/github/tomschi/$project/$VERSION/$FILE_NAME"
    echo "Upload: $UPLOAD_URL"
    curl -fs -T $FILE_NAME -u"${BINTRAY_USERNAME}":"${BINTRAY_PASSWORD}" $UPLOAD_URL > /dev/null
  fi

  if case $project in *-parent) false;; *) true;; esac; then
    for suffix in $SUFFIXES ; do
      FILE_NAME="$project-$VERSION$suffix"
      UPLOAD_URL="$BINTRAY_URL/$project/$VERSION/com/github/tomschi/$project/$VERSION/$FILE_NAME"
      echo "Upload: $UPLOAD_URL"
      curl -fs -T $FILE_NAME -u"${BINTRAY_USERNAME}":"${BINTRAY_PASSWORD}" $UPLOAD_URL > /dev/null
    done
  fi
done
