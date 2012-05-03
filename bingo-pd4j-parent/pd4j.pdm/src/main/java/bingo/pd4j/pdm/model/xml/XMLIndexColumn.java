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

import static bingo.pd4j.pdm.internal.LogUtil.INITIALLIZED_NAME;
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNode;
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodeText;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFICATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFIER;
import static bingo.pd4j.pdm.util.PdmNodeName.A_OBJECT_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.C_COLUMN;
import static bingo.pd4j.pdm.util.PdmNodeName.META_ID;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLIndexColumn}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLIndexColumn implements WithId{
	
	private static final Logger log = LoggerFactory.getLogger(XMLIndexColumn.class);

	private String id;
	
	private String objectID;
	private String creationDate;
	private String creator;
	private String modificationDate;
	private String modifier;

	private XMLColumns column;
	
	private XMLIndexColumns superIndexColumns;

	/**
	 * @param node
	 * @param xmlIndexColumns
	 */
	public XMLIndexColumn(Node currentNode, XMLIndexColumns xmlIndexColumns) {
		this.superIndexColumns = xmlIndexColumns;

		setId(getNodeText(META_ID, currentNode));
		setObjectID(getNodeText(A_OBJECT_ID, currentNode));
		setCreationDate(getNodeText(A_CREATION_DATE, currentNode));
		setCreator(getNodeText(A_CREATOR, currentNode));
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setModifier(getNodeText(A_MODIFIER, currentNode));
		
		Node node = getNode(C_COLUMN, currentNode);
		if(node != null){
			setColumn(new XMLColumns(node, this));	
		}		
		
		log.debug(INITIALLIZED_NAME, "XMLIndexColumn");
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

	public XMLColumns getColumn() {
		return column;
	}

	public void setColumn(XMLColumns column) {
		this.column = column;
	}

	public XMLIndexColumns getSuperIndexColumns() {
		return superIndexColumns;
	}

	public void setSuperIndexColumns(XMLIndexColumns superIndexColumns) {
		this.superIndexColumns = superIndexColumns;
	}
	
}
