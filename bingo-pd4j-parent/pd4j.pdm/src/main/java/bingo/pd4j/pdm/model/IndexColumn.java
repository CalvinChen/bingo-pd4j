/*
 * Copyright 2012 the original author or authors.
 *
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
 */
package bingo.pd4j.pdm.model;


/**
 * <code>{@link IndexColumn}</code>
 *
 * just a normal column added attributes like "isAscending" for indexing.
 *
 * @author Calvin Chen
 */
public class IndexColumn extends Column{
	
	private Boolean isAscending = true;

	public String getName() {
		// TODO implement Named.getName
		return null;
	}

	public Boolean getIsAscending() {
		return isAscending;
	}

	public void setIsAscending(Boolean isAscending) {
		this.isAscending = isAscending;
	}
	
}
