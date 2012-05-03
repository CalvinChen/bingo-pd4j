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
import static bingo.pd4j.pdm.util.PdmNodeName.A_CODE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_EXTENDED_ATTRIBUTES_TEXT;
import static bingo.pd4j.pdm.util.PdmNodeName.A_HISTORY;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODEL_OPTIONS_TEXT;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFICATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFIER;
import static bingo.pd4j.pdm.util.PdmNodeName.A_NAME;
import static bingo.pd4j.pdm.util.PdmNodeName.A_OBJECT_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.A_PACKAGE_OPTIONS_TEXT;
import static bingo.pd4j.pdm.util.PdmNodeName.C_DBMS;
import static bingo.pd4j.pdm.util.PdmNodeName.C_DEFAULT_DIAGRAM;
import static bingo.pd4j.pdm.util.PdmNodeName.C_DEFAULT_GROUPS;
import static bingo.pd4j.pdm.util.PdmNodeName.C_DOMAINS;
import static bingo.pd4j.pdm.util.PdmNodeName.C_GENERATION_ORIGINS;
import static bingo.pd4j.pdm.util.PdmNodeName.C_PACKAGES;
import static bingo.pd4j.pdm.util.PdmNodeName.C_PHYSICAL_DIAGRAMS;
import static bingo.pd4j.pdm.util.PdmNodeName.C_REFERENCES;
import static bingo.pd4j.pdm.util.PdmNodeName.C_TABLES;
import static bingo.pd4j.pdm.util.PdmNodeName.C_TARGET_MODELS;
import static bingo.pd4j.pdm.util.PdmNodeName.META_ID;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLModel}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLModel implements WithId{
	
	private static final Logger log = LoggerFactory.getLogger(XMLModel.class);

	private String id;
	
	private String objectId;
	private String name;
	private String code;
	private String creationDate;
	private String creator;
	private String modificationDate;
	private String modifier;
	private String history;
	private String packageOptionsText;
	private String modelOptionsText;
	private String extendedAttributesText;
	
	private XMLGenerationOrigins generationOrigins;
	private XMLDBMS dbms;
	private XMLPhysicalDiagrams physicalDiagrams;
	private XMLPackages packages;
	private XMLPhysicalDiagrams defaultDiagram;
	private XMLDomains domains;
	private XMLTables tables;
	private XMLReferences references;
	private XMLGroups defaultGroups;
	private XMLTargetModels targetModels;
	
	private XMLChildren superChildren;
	
	/**
	 * @param currentNode
	 * @param xmlChildren
	 */
	public XMLModel(Node currentNode, XMLChildren xmlChildren) {
		this.superChildren = xmlChildren;
		
		setId(getNodeText(META_ID, currentNode));
		setObjectId(getNodeText(A_OBJECT_ID, currentNode));
		setName(getNodeText(A_NAME, currentNode));
		setCode(getNodeText(A_CODE, currentNode));
		setCreationDate(getNodeText(A_CREATION_DATE, currentNode));
		setCreator(getNodeText(A_CREATOR, currentNode));
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setModifier(getNodeText(A_MODIFIER, currentNode));
		setHistory(getNodeText(A_HISTORY, currentNode));
		setPackageOptionsText(getNodeText(A_PACKAGE_OPTIONS_TEXT, currentNode));
		setModelOptionsText(getNodeText(A_MODEL_OPTIONS_TEXT, currentNode));
		setExtendedAttributesText(getNodeText(A_EXTENDED_ATTRIBUTES_TEXT, currentNode));
		
		Node node = getNode(C_GENERATION_ORIGINS, currentNode);
		if(node != null){
			setGenerationOrigins(new XMLGenerationOrigins(node, this));
		}
		
		node = getNode(C_DBMS, currentNode);
		if(node != null){
			setDbms(new XMLDBMS(node, this));
		}
		
		node = getNode(C_PHYSICAL_DIAGRAMS, currentNode);
		if(node != null){
			setPhysicalDiagrams(new XMLPhysicalDiagrams(node, this));
		}
		
		node = getNode(C_PACKAGES, currentNode); 
		if(node != null){
			setPackages(new XMLPackages(node, this));
		}
		
		node = getNode(C_DEFAULT_DIAGRAM, currentNode);
		if(node != null){
			setDefaultDiagram(new XMLPhysicalDiagrams(node, this));
		}
		
		node = getNode(C_DOMAINS, currentNode);
		if(node != null){
			setDomains(new XMLDomains(node, this));
		}
		
		node = getNode(C_TABLES, currentNode); 
		if(node != null){
			setTables(new XMLTables(node, this));
		}
		
		node = getNode(C_REFERENCES, currentNode);
		if(node != null){
			setReferences(new XMLReferences(node, this));
		}
		
		node = getNode(C_DEFAULT_GROUPS, currentNode); 
		if(node != null){
			setDefaultGroups(new XMLGroups(node, this));
		}
		
		node = getNode(C_TARGET_MODELS, currentNode);
		if(node != null){
			setTargetModels(new XMLTargetModels(node, this));
		}
		
		log.debug(INITIALLIZED_NAME, "XMLModel");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
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
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getPackageOptionsText() {
		return packageOptionsText;
	}
	public void setPackageOptionsText(String packageOptionsText) {
		this.packageOptionsText = packageOptionsText;
	}
	public String getModelOptionsText() {
		return modelOptionsText;
	}
	public void setModelOptionsText(String modelOptionsText) {
		this.modelOptionsText = modelOptionsText;
	}
	public String getExtendedAttributesText() {
		return extendedAttributesText;
	}
	public void setExtendedAttributesText(String extendedAttributesText) {
		this.extendedAttributesText = extendedAttributesText;
	}
	public XMLGenerationOrigins getGenerationOrigins() {
		return generationOrigins;
	}
	public void setGenerationOrigins(XMLGenerationOrigins generationOrigins) {
		this.generationOrigins = generationOrigins;
	}
	public XMLDBMS getDbms() {
		return dbms;
	}
	public void setDbms(XMLDBMS dbms) {
		this.dbms = dbms;
	}
	public XMLPhysicalDiagrams getPhysicalDiagrams() {
		return physicalDiagrams;
	}
	public void setPhysicalDiagrams(XMLPhysicalDiagrams physicalDiagrams) {
		this.physicalDiagrams = physicalDiagrams;
	}
	public XMLPackages getPackages() {
		return packages;
	}
	public void setPackages(XMLPackages packages) {
		this.packages = packages;
	}
	public XMLPhysicalDiagrams getDefaultDiagram() {
		return defaultDiagram;
	}
	public void setDefaultDiagram(XMLPhysicalDiagrams defaultDiagram) {
		this.defaultDiagram = defaultDiagram;
	}
	public XMLDomains getDomains() {
		return domains;
	}
	public void setDomains(XMLDomains domains) {
		this.domains = domains;
	}
	public XMLTables getTables() {
		return tables;
	}
	public void setTables(XMLTables tables) {
		this.tables = tables;
	}
	public XMLReferences getReferences() {
		return references;
	}
	public void setReferences(XMLReferences references) {
		this.references = references;
	}
	public XMLGroups getDefaultGroups() {
		return defaultGroups;
	}
	public void setDefaultGroups(XMLGroups defaultGroups) {
		this.defaultGroups = defaultGroups;
	}
	public XMLTargetModels getTargetModels() {
		return targetModels;
	}
	public void setTargetModels(XMLTargetModels targetModels) {
		this.targetModels = targetModels;
	}
	public XMLChildren getSuperChildren() {
		return superChildren;
	}
	public void setSuperChildren(XMLChildren superChildren) {
		this.superChildren = superChildren;
	}

}
