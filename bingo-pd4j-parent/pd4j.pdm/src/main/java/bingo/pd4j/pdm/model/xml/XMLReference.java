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
import static bingo.pd4j.pdm.util.PdmNodeName.A_CARDINALITY;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CODE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_DELETE_CONSTRAINT;
import static bingo.pd4j.pdm.util.PdmNodeName.A_EXTENDED_ATTRIBUTES_TEXT;
import static bingo.pd4j.pdm.util.PdmNodeName.A_HISTORY;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFICATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFIER;
import static bingo.pd4j.pdm.util.PdmNodeName.A_NAME;
import static bingo.pd4j.pdm.util.PdmNodeName.A_OBJECT_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.A_UPDATE_CONSTRAINT;
import static bingo.pd4j.pdm.util.PdmNodeName.C_CHILD_TABLE;
import static bingo.pd4j.pdm.util.PdmNodeName.C_JOINS;
import static bingo.pd4j.pdm.util.PdmNodeName.C_PARENT_KEY;
import static bingo.pd4j.pdm.util.PdmNodeName.C_PARENT_TABLE;
import static bingo.pd4j.pdm.util.PdmNodeName.META_ID;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.Key;
import bingo.pd4j.pdm.model.Reference;
import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLReference}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLReference extends Reference implements WithId{
	
	private static final Logger log = LoggerFactory.getLogger(XMLReference.class);

	private String id;
	
	private String objectID;
	private String creationDate;
	private String creator;
	private String modificationDate;
	private String modifier;
	private String history;
	private String cardinality;
	private String updateConstraint;
	private String deleteConstraint;
	private String extendedAttributesText;

	private XMLTables parentTable;
	private XMLTables childTable;
	private XMLKeys parentKey;
	private XMLJoins joins;

	private XMLReferences superReferences;
	/**
	 * @param node
	 * @param xmlReferences
	 */
	public XMLReference(Node currentNode, XMLReferences xmlReferences) {
		this.superReferences = xmlReferences;

		setId(getNodeText(META_ID, currentNode));
		setObjectID(getNodeText(A_OBJECT_ID, currentNode));
		setName(getNodeText(A_NAME, currentNode));
		setCode(getNodeText(A_CODE, currentNode));
		setCreationDate(getNodeText(A_CREATION_DATE, currentNode));
		setCreator(getNodeText(A_CREATOR, currentNode));
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setModifier(getNodeText(A_MODIFIER, currentNode));
		setHistory(getNodeText(A_HISTORY, currentNode));
		setCardinality(getNodeText(A_CARDINALITY, currentNode));
		setUpdateConstraint(getNodeText(A_UPDATE_CONSTRAINT, currentNode));
		setDeleteConstraint(getNodeText(A_DELETE_CONSTRAINT, currentNode));
		setExtendedAttributesText(getNodeText(A_EXTENDED_ATTRIBUTES_TEXT, currentNode));
		
		Node node = getNode(C_PARENT_TABLE, currentNode);
		if(node != null){
			parentTable = new XMLTables(node, this);	
		}
		
		node = getNode(C_CHILD_TABLE, currentNode);
		if(node != null){
			childTable = new XMLTables(node, this);	
		}
		
		node = getNode(C_PARENT_KEY, currentNode);
		if(node != null){
			parentKey = new XMLKeys(node, this);	
		}
		
		node = getNode(C_JOINS, currentNode);
		if(node != null){
			setJoins(new XMLJoins(node, this));	
		}
		
		log.debug(INITIALLIZED_NAME_VALUE, "XMLReference", getName());
	}

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

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getCardinality() {
		return cardinality;
	}

	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}

	public String getUpdateConstraint() {
		return updateConstraint;
	}

	public void setUpdateConstraint(String updateConstraint) {
		this.updateConstraint = updateConstraint;
	}

	public String getDeleteConstraint() {
		return deleteConstraint;
	}

	public void setDeleteConstraint(String deleteConstraint) {
		this.deleteConstraint = deleteConstraint;
	}

	public String getExtendedAttributesText() {
		return extendedAttributesText;
	}

	public void setExtendedAttributesText(String extendedAttributesText) {
		this.extendedAttributesText = extendedAttributesText;
	}

	public XMLJoins getJoins() {
		return joins;
	}

	public void setJoins(XMLJoins joins) {
		this.joins = joins;
	}

	public XMLReferences getSuperReferences() {
		return superReferences;
	}

	public void setSuperReferences(XMLReferences superReferences) {
		this.superReferences = superReferences;
	}

}
