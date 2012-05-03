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
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodes;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CODE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CREATOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFICATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFIER;
import static bingo.pd4j.pdm.util.PdmNodeName.A_NAME;
import static bingo.pd4j.pdm.util.PdmNodeName.A_OBJECT_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.A_TARGET_CLASS_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.A_TARGET_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.A_TARGET_PACKAGE_PATH;
import static bingo.pd4j.pdm.util.PdmNodeName.A_TARGET_STEREO_TYPE;
import static bingo.pd4j.pdm.util.PdmNodeName.C_LINK_SHORTCUT_EXTREMITIES;
import static bingo.pd4j.pdm.util.PdmNodeName.META_ID;
import static bingo.pd4j.pdm.util.PdmNodeName.META_REF;

import java.util.List;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.api.SimpleList;
import bingo.pd4j.pdm.model.api.WithId;
import bingo.pd4j.pdm.util.ListUtil;
/**
 * <code>{@link XMLShortcut}</code>
 *
 * represents a XML Shortcut.
 *
 * @author Calvin Chen
 */
public class XMLShortcut implements WithId {
	
	private static final Logger log = LoggerFactory.getLogger(XMLShortcut.class);
	
	private String id;
	
	private String objectId;
	private String name;
	private String code;
	private String creationDate;
	private String creator;
	private String modificationDate;
	private String modifier;
	private String targetStereotype;
	private String targetID;
	private String targetClassID;
	private String targetPackagePath;
	
	private XMLGenerationOrigins superGenerationOrigins;
	
	private XMLDBMS superDbms;
	
	private XMLShortcuts superShortcuts;
	
	private SimpleList<String> idList;

	/**
	 * @param node
	 * @param xmlGenerationOrigins
	 */
	public XMLShortcut(Node currentNode, XMLGenerationOrigins xmlGenerationOrigins) {
		this(currentNode);
		this.superGenerationOrigins = xmlGenerationOrigins;
		
		log.debug(INITIALLIZED_NAME_VALUE, "XMLShortcut", getName());
	}

	/**
	 * @param node
	 * @param xmldbms
	 */
	public XMLShortcut(Node currentNode, XMLDBMS xmldbms) {
		this(currentNode);
		this.superDbms = xmldbms;

		log.debug(INITIALLIZED_NAME_VALUE, "XMLShortcut", getName());
	}
	
	public XMLShortcut(Node currentNode) {
		setId(getNodeText(META_ID, currentNode));
		setObjectId(getNodeText(A_OBJECT_ID, currentNode));
		setName(getNodeText(A_NAME, currentNode));
		setCode(getNodeText(A_CODE, currentNode));
		setCreationDate(getNodeText(A_CREATION_DATE, currentNode));
		setCreator(getNodeText(A_CREATOR, currentNode));
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setModifier(getNodeText(A_MODIFIER, currentNode));
		setTargetStereotype(getNodeText(A_TARGET_STEREO_TYPE, currentNode));
		setTargetID(getNodeText(A_TARGET_ID, currentNode));
		setTargetClassID(getNodeText(A_TARGET_CLASS_ID, currentNode));
		setTargetPackagePath(getNodeText(A_TARGET_PACKAGE_PATH, currentNode));
		
		List<Node> nodeList = getNodes(C_LINK_SHORTCUT_EXTREMITIES, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
		}
	}
	
	/**
	 * @param node
	 * @param xmlShortcuts
	 */
	public XMLShortcut(Node node, XMLShortcuts xmlShortcuts) {
		this(node);
		this.superShortcuts = xmlShortcuts;

		log.debug(INITIALLIZED_NAME_VALUE, "XMLShortcut", getName());
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

	public String getTargetStereotype() {
		return targetStereotype;
	}

	public void setTargetStereotype(String targetStereotype) {
		this.targetStereotype = targetStereotype;
	}

	public String getTargetID() {
		return targetID;
	}

	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}

	public String getTargetClassID() {
		return targetClassID;
	}

	public void setTargetClassID(String targetClassID) {
		this.targetClassID = targetClassID;
	}

	public String getTargetPackagePath() {
		return targetPackagePath;
	}

	public void setTargetPackagePath(String targetPackagePath) {
		this.targetPackagePath = targetPackagePath;
	}

	public SimpleList<String> getIdList() {
		return idList;
	}

	public void setIdList(SimpleList<String> idList) {
		this.idList = idList;
	}

	public XMLGenerationOrigins getSuperGenerationOrigins() {
		return superGenerationOrigins;
	}

	public void setSuperGenerationOrigins(
			XMLGenerationOrigins superGenerationOrigins) {
		this.superGenerationOrigins = superGenerationOrigins;
	}

	public XMLDBMS getSuperDbms() {
		return superDbms;
	}

	public void setSuperDbms(XMLDBMS superDbms) {
		this.superDbms = superDbms;
	}

	public XMLShortcuts getSuperShortcuts() {
		return superShortcuts;
	}

	public void setSuperShortcuts(XMLShortcuts superShortcuts) {
		this.superShortcuts = superShortcuts;
	}
	
}
