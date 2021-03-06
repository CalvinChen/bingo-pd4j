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
package bingo.pd4j.pdm.model.xml;

import static bingo.pd4j.pdm.internal.LogUtil.INITIALLIZED_NAME_VALUE;
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNode;
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodeText;
import static bingo.pd4j.pdm.util.PdmNodeName.*;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.Index;
import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLIndex}</code>
 *
 * represents a XMLIndex xml node in pdm file.
 *
 * @author Calvin Chen
 */
public class XMLIndex extends Index implements WithId{
	
	private static final Logger log = LoggerFactory.getLogger(XMLIndex.class);

	/*
	 * original xml nodes.
	 */
	private String id;
	private String objectID;
	private String creationDate;
	private String creator;
	private String modificationDate;
	private String modifier;
	private String unique;
	private XMLKeys linkedObject;
	private XMLIndexColumns indexColumns;
	
	/*
	 * super nodes.
	 */
	private XMLIndexes superIndexes;
	
	/**
	 * @param node
	 * @param xmlIndexes
	 */
	public XMLIndex(Node currentNode, XMLIndexes xmlIndexes) {
		this.superIndexes = xmlIndexes;

		setId(getNodeText(META_ID, currentNode));
		setObjectID(getNodeText(A_OBJECT_ID, currentNode));
		setName(getNodeText(A_NAME, currentNode));
		setCode(getNodeText(A_CODE, currentNode));
		setComment(getNodeText(A_COMMENT, currentNode));
		setCreationDate(getNodeText(A_CREATION_DATE, currentNode));
		setCreator(getNodeText(A_CREATOR, currentNode));
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setModifier(getNodeText(A_MODIFIER, currentNode));
		setUnique(getNodeText(A_UNIQUE, currentNode));
		
		Node node = getNode(C_LINKED_OBJECT, currentNode);
		if(node != null){
			setLinkedObject(new XMLKeys(node, this));	
		}
		node = getNode(C_INDEX_COLUMNS, currentNode);
		if(node != null){
			setIndexColumns(new XMLIndexColumns(node, this));	
		}
		
		log.debug(INITIALLIZED_NAME_VALUE, "XMLIndex", getName());
	}
	
	/*
	 * getter and setter.
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObjectID() {
		return objectID;
	}
	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getUnique() {
		return unique;
	}
	public void setUnique(String unique) {
		this.unique = unique;
	}
	public XMLKeys getLinkedObject() {
		return linkedObject;
	}
	public void setLinkedObject(XMLKeys linkedObject) {
		this.linkedObject = linkedObject;
	}
	public XMLIndexColumns getIndexColumns() {
		return indexColumns;
	}
	public void setIndexColumns(XMLIndexColumns indexColumns) {
		this.indexColumns = indexColumns;
	}
	public XMLIndexes getSuperIndexes() {
		return superIndexes;
	}
	public void setSuperIndexes(XMLIndexes superIndexes) {
		this.superIndexes = superIndexes;
	}
	
}
