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
import static bingo.pd4j.pdm.util.PdmNodeName.A_CODE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_HISTORY;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFICATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFIER;
import static bingo.pd4j.pdm.util.PdmNodeName.A_NAME;
import static bingo.pd4j.pdm.util.PdmNodeName.A_OBJECT_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.A_USE_PARENT_NAME_SPACE;
import static bingo.pd4j.pdm.util.PdmNodeName.C_DEFAULT_DIAGRAM;
import static bingo.pd4j.pdm.util.PdmNodeName.C_PHYSICAL_DIAGRAMS;
import static bingo.pd4j.pdm.util.PdmNodeName.C_REFERENCES;
import static bingo.pd4j.pdm.util.PdmNodeName.C_TABLES;
import static bingo.pd4j.pdm.util.PdmNodeName.META_ID;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.Package;
import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLPackage}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLPackage extends Package implements WithId {
	
	private static final Logger log = LoggerFactory.getLogger(XMLPackage.class);

	private String id;

	private String objectID;
	private String creationDate;
	private String creator;
	private String modificationDate;
	private String modifier;
	private String history;
	private String useParentNamespace;
	
	private XMLPhysicalDiagrams physicalDiagrams;
	private XMLPhysicalDiagrams defaultDiagram;
	private XMLShortcuts tables;
	private XMLShortcuts references;
	
	private XMLPackages superPackages;
	/**
	 * @param node
	 * @param xmlPackages
	 */
	public XMLPackage(Node currentNode, XMLPackages xmlPackages) {
		this.superPackages = xmlPackages;

		setId(getNodeText(META_ID, currentNode));
		setObjectID(getNodeText(A_OBJECT_ID, currentNode));
		setName(getNodeText(A_NAME, currentNode));
		setCode(getNodeText(A_CODE, currentNode));
		setCreationDate(getNodeText(A_CREATION_DATE, currentNode));
		setCreator(getNodeText(A_CREATOR, currentNode));
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setModifier(getNodeText(A_MODIFIER, currentNode));
		setHistory(getNodeText(A_HISTORY, currentNode));
		setUseParentNamespace(getNodeText(A_USE_PARENT_NAME_SPACE, currentNode));
		
		Node node = getNode(C_PHYSICAL_DIAGRAMS, currentNode);
		if(node != null){
			setPhysicalDiagrams(new XMLPhysicalDiagrams(node, this));	
		}
		
		node = getNode(C_DEFAULT_DIAGRAM, currentNode);
		if(node != null){
			setDefaultDiagram(new XMLPhysicalDiagrams(node, this));	
		}
		
		node = getNode(C_TABLES, currentNode);
		if(node != null){
			setTables(new XMLShortcuts(node, this));	
		}
		
		node = getNode(C_REFERENCES, currentNode);
		if(node != null){
			setReferences(new XMLShortcuts(node, this));	
		}
		
		log.debug(INITIALLIZED_NAME_VALUE, "XMLPackage", getName());
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
	public String getUseParentNamespace() {
		return useParentNamespace;
	}
	public void setUseParentNamespace(String useParentNamespace) {
		this.useParentNamespace = useParentNamespace;
	}
	public XMLPhysicalDiagrams getPhysicalDiagrams() {
		return physicalDiagrams;
	}
	public void setPhysicalDiagrams(XMLPhysicalDiagrams physicalDiagrams) {
		this.physicalDiagrams = physicalDiagrams;
	}
	public XMLPhysicalDiagrams getDefaultDiagram() {
		return defaultDiagram;
	}
	public void setDefaultDiagram(XMLPhysicalDiagrams defaultDiagram) {
		this.defaultDiagram = defaultDiagram;
	}
	public XMLShortcuts getTables() {
		return tables;
	}
	public void setTables(XMLShortcuts tables) {
		this.tables = tables;
	}
	public XMLShortcuts getReferences() {
		return references;
	}
	public void setReferences(XMLShortcuts references) {
		this.references = references;
	}
	public XMLPackages getSuperPackages() {
		return superPackages;
	}
	public void setSuperPackages(XMLPackages superPackages) {
		this.superPackages = superPackages;
	}

}
