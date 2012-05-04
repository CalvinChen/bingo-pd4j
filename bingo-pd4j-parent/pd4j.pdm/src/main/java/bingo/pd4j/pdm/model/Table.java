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
import bingo.pd4j.pdm.model.xml.XMLTable;

/**
 * <code>{@link Table}</code>
 *
 * represents a Table in powerdesigner.
 *
 * @author Calvin Chen
 */
public class Table implements WithName{

	/*
	 * original xml nodes.
	 */
	private String name;
	private String code;
	private String comment;
	
	/*
	 * inner subclass.
	 */
	private XMLTable xmlTable;

	/**
	 * get a {@link Column} by the given index.
	 */
	public Column getColumn(int index){
		return xmlTable.getColumn(index);
	}
	
	/**
	 * get a {@link Column} by the given name.
	 */
	public Column getColumn(String name){
		return xmlTable.getColumn(name);
	}
	
	/**
	 * get a {@link Key} by the given index.
	 */
	public Key getKey(int index){
		return xmlTable.getKey(index);
	}
	
	/**
	 * get a {@link Key} by the given index.
	 */
	public Key getKey(String name){
		return xmlTable.getKey(name);
	}
	
	/* 
	 * getter and setter.
	 */
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
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
}