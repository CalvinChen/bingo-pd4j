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
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodeText;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CODE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFICATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFIER;
import static bingo.pd4j.pdm.util.PdmNodeName.A_NAME;
import static bingo.pd4j.pdm.util.PdmNodeName.A_OBJECT_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.META_ID;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLGroup}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLGroup implements WithId{
	
	private static final Logger log = LoggerFactory.getLogger(XMLGroup.class);
	private String id;
	
	private String objectID;
	private String name;
	private String code;
	private String creationDate;
	private String creator;
	private String modificationDate;
	private String modifier;
	
	private XMLGroups superGroups;
	
	/**
	 * @param node
	 * @param xmlGroups
	 */
	public XMLGroup(Node currentNode, XMLGroups xmlGroups) {
		this.superGroups = xmlGroups;
		
		setId(getNodeText(META_ID, currentNode));
		setObjectID(getNodeText(A_OBJECT_ID, currentNode));
		setName(getNodeText(A_NAME, currentNode));
		setCode(getNodeText(A_CODE, currentNode));
		setCreationDate(getNodeText(A_CREATION_DATE, currentNode));
		setCreator(getNodeText(A_CREATOR, currentNode));
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setModifier(getNodeText(A_MODIFIER, currentNode));
		
		log.debug(INITIALLIZED_NAME_VALUE, "XMLGroup", getName());
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
	public XMLGroups getSuperGroups() {
		return superGroups;
	}
	public void setSuperGroups(XMLGroups superGroups) {
		this.superGroups = superGroups;
	}

	
}
