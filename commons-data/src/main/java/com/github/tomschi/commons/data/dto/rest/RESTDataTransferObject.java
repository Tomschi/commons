/*-
 * #%L
 * commons-data
 * %%
 * Copyright (C) 2018 - 2019 Tomschi
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.tomschi.commons.data.dto.rest;

import com.github.tomschi.commons.data.dto.DataTransferObject;

import java.io.Serializable;

/**
 * The {@link RESTDataTransferObject} interface is the base interface
 * for all rest data transfer objects.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface RESTDataTransferObject extends DataTransferObject, Serializable {
}
