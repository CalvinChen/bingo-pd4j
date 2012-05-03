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
 * <code>{@link Reference}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class Reference {

	private String name;
	private String code;
	private String comment;
	private Table parentTable;
	private String parentRole;
	private Table childTable;
	private String childRole;
	private Key parentKey;
	private Column parentTableColumn;
	private Column childTableColumn;
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
	public Table getParentTable() {
		return parentTable;
	}
	public void setParentTable(Table parentTable) {
		this.parentTable = parentTable;
	}
	public String getParentRole() {
		return parentRole;
	}
	public void setParentRole(String parentRole) {
		this.parentRole = parentRole;
	}
	public Table getChildTable() {
		return childTable;
	}
	public void setChildTable(Table childTable) {
		this.childTable = childTable;
	}
	public String getChildRole() {
		return childRole;
	}
	public void setChildRole(String childRole) {
		this.childRole = childRole;
	}
	public Key getParentKey() {
		return parentKey;
	}
	public void setParentKey(Key parentKey) {
		this.parentKey = parentKey;
	}
	public Column getParentTableColumn() {
		return parentTableColumn;
	}
	public void setParentTableColumn(Column parentTableColumn) {
		this.parentTableColumn = parentTableColumn;
	}
	public Column getChildTableColumn() {
		return childTableColumn;
	}
	public void setChildTableColumn(Column childTableColumn) {
		this.childTableColumn = childTableColumn;
	}
}
