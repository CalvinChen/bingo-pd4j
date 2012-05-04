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
import bingo.pd4j.pdm.model.xml.XMLColumn;

/**
 * <code>{@link Column}</code>
 *
 * represents a simple column in powerdesigner.
 *
 * @author Calvin Chen
 */
public class Column implements WithName{

	/*
	 * original xml nodes.
	 */
	private String name;
	private String code;
	private String comment;
	private String dataType;
	private String length;
	private String precision;
	
	/*
	 * added attributes.
	 */
	private Domain domain;
	private Boolean isPrimaryKey;
	private Boolean isForeignKey;
	private StandardChecks standChecks;
	
	/*
	 * inner subclass.
	 */
	@SuppressWarnings("unused")
    private XMLColumn xmlColumn;
	
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
	public String getDataType() {
    	return dataType;
    }
	public void setDataType(String dataType) {
    	this.dataType = dataType;
    }
	public String getLength() {
    	return length;
    }
	public void setLength(String length) {
    	this.length = length;
    }
	public String getPrecision() {
    	return precision;
    }
	public void setPrecision(String precision) {
    	this.precision = precision;
    }
	public Domain getDomain() {
    	return domain;
    }
	public void setDomain(Domain domain) {
    	this.domain = domain;
    }
	public Boolean getIsPrimaryKey() {
    	return isPrimaryKey;
    }
	public void setIsPrimaryKey(Boolean isPrimaryKey) {
    	this.isPrimaryKey = isPrimaryKey;
    }
	public Boolean getIsForeignKey() {
    	return isForeignKey;
    }
	public void setIsForeignKey(Boolean isForeignKey) {
    	this.isForeignKey = isForeignKey;
    }
	public StandardChecks getStandChecks() {
    	return standChecks;
    }
	public void setStandChecks(StandardChecks standChecks) {
    	this.standChecks = standChecks;
    }

}