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
import static bingo.pd4j.pdm.util.PdmNodeName.A_DATA_TYPE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_DEFAULT_VALUE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_HIGH_VALUE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_HISTORY;
import static bingo.pd4j.pdm.util.PdmNodeName.A_LENGTH;
import static bingo.pd4j.pdm.util.PdmNodeName.A_LIST_OF_VALUES;
import static bingo.pd4j.pdm.util.PdmNodeName.A_LOW_VALUE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFICATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFIER;
import static bingo.pd4j.pdm.util.PdmNodeName.A_NAME;
import static bingo.pd4j.pdm.util.PdmNodeName.A_OBJECT_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.A_PRECISTION;
import static bingo.pd4j.pdm.util.PdmNodeName.META_ID;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.Domain;
import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLPhysicalDomain}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLPhysicalDomain extends Domain implements WithId{
	
	private static final Logger log = LoggerFactory.getLogger(XMLPhysicalDomain.class);

	private String id;
	
	private String objectID;
	private String creationDate;
	private String creator;
	private String modificationDate;
	private String modifier;
	private String history;
	private String datatype;
	private String lowValue;
	private String highValue;
	private String defaultValue;
	private String listOfValues;
	
	private XMLDomains superDomains;
	
	/**
	 * init a {@link XMLPhysicalDomain} by a {@link XMLDomains}.
	 * @param node
	 * @param xmlDomains
	 */
	public XMLPhysicalDomain(Node currentNode, XMLDomains xmlDomains) {
		this.superDomains = xmlDomains;

		setId(getNodeText(META_ID, currentNode));
		setObjectID(getNodeText(A_OBJECT_ID, currentNode));
		setName(getNodeText(A_NAME, currentNode));
		setCode(getNodeText(A_CODE, currentNode));
		setCreationDate(getNodeText(A_CREATION_DATE, currentNode));
		setCreator(getNodeText(A_CREATOR, currentNode));
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setModifier(getNodeText(A_MODIFIER, currentNode));
		setHistory(getNodeText(A_HISTORY, currentNode));
		setDatatype(getNodeText(A_DATA_TYPE, currentNode));
		setLength(getNodeText(A_LENGTH, currentNode));
		setPrecision(getNodeText(A_PRECISTION, currentNode));
		setLowValue(getNodeText(A_LOW_VALUE, currentNode));
		setHighValue(getNodeText(A_HIGH_VALUE, currentNode));
		setDefaultValue(getNodeText(A_DEFAULT_VALUE, currentNode));
		setListOfValues(getNodeText(A_LIST_OF_VALUES, currentNode));
		
		log.debug(INITIALLIZED_NAME_VALUE, "XMLPhysicalDomain", getName());
	}

	/* getter and setter */
	
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
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getLowValue() {
		return lowValue;
	}
	public void setLowValue(String lowValue) {
		this.lowValue = lowValue;
	}
	public String getHighValue() {
		return highValue;
	}
	public void setHighValue(String highValue) {
		this.highValue = highValue;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getListOfValues() {
		return listOfValues;
	}
	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}
	public XMLDomains getSuperDomains() {
		return superDomains;
	}
	public void setSuperDomains(XMLDomains superDomains) {
		this.superDomains = superDomains;
	}

	public String getId() {
	    return id;
    }

	public void setId(String id) {
		this.id = id;
    }

}
