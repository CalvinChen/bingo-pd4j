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

import bingo.pd4j.pdm.model.api.WithName;
import bingo.pd4j.pdm.model.xml.XMLPackage;

/**
 * <code>{@link Package}</code>
 *
 * represents a Package in powerdesigner.
 *
 * @author Calvin Chen
 */
public class Package implements WithName {

	/*
	 * original xml nodes.
	 */
	private String name;
	private String code;
	private String comment;
	
	/*
	 * inner subclass.
	 */
	@SuppressWarnings("unused")
    private XMLPackage xmlPackage;

	/*
	 * getter and setter.
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getComment() {
    	return comment;
    }
	public void setComment(String comment) {
    	this.comment = comment;
    }
}