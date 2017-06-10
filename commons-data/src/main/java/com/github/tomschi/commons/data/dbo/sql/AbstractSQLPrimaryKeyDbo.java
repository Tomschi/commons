package com.github.tomschi.commons.data.dbo.sql;

/**
 * The abstract class {@link AbstractSQLPrimaryKeyDbo} can be used
 * for database objects with a primary key. This class overrides the
 * {@link #equals(Object)} and {@link #hashCode()} method.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public abstract class AbstractSQLPrimaryKeyDbo<T> implements SQLPrimaryKeyDbo<T> {

    private static final long serialVersionUID = 1L;

    /**
     * Indicates if this object is equals to another object.
     * For checking this equality the primary key is used.
     * Two objects are equal, if the given object is this
     * object (<code>this == obj</code>) or the given object
     * has the same class like this and both primary keys
     * are equal. If primary key is <code>null</code> the
     * the method only check if the given object is this object.
     *
     * @param obj The reference object with which to compare.
     * @return <code>True</code>, if obj equals this, else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (getPrimaryKey() == null) return (this == obj);
        return (this.getClass() == obj.getClass())
                && getPrimaryKey().equals(((SQLPrimaryKeyDbo<?>) obj).getPrimaryKey());
    }

    /**
     * Returns a hash code value for the object. The value
     * is generated with the hashcode of the class name and
     * the hashcode of the primary key. If the primary key
     * is <code>null</code> {@link Object#hashCode()} is called.
     *
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        if (getPrimaryKey() == null) return super.hashCode();
        return this.getClass().getName().hashCode() * 13 + getPrimaryKey().hashCode();
    }

}
