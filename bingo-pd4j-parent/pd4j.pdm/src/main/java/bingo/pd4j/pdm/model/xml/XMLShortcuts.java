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
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodeText;
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodes;
import static bingo.pd4j.pdm.util.PdmNodeName.META_REF;
import static bingo.pd4j.pdm.util.PdmNodeName.O_SHORTCUT;

import java.util.List;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.internal.IdCollector;
import bingo.pd4j.pdm.model.api.SimpleList;
import bingo.pd4j.pdm.util.ListUtil;
/**
 * <code>{@link XMLShortcuts}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLShortcuts extends SimpleList<XMLShortcut>{
	
	private static final Logger log = LoggerFactory.getLogger(XMLShortcuts.class);
	
	private XMLPackage superPackage;
	
	private XMLTargetModel superTargetModel;
	
	private SimpleList<String> idList;
	
	/**
	 * @param currentNode
	 * @param xmlPackage
	 */
	public XMLShortcuts(Node currentNode, XMLPackage xmlPackage) {
		this.superPackage = xmlPackage;
		
		XMLShortcut shortcut = null;
		List<Node> nodeList = getNodes(O_SHORTCUT, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				shortcut = new XMLShortcut(node, this); 
				add(shortcut);
				IdCollector.put(shortcut.getId(), shortcut);
			}
			log.debug(INITIALLIZED_NAME, "XMLShortcuts");
		}
	}

	/**
	 * @param node
	 * @param xmlTargetModel
	 */
	public XMLShortcuts(Node currentNode, XMLTargetModel xmlTargetModel) {
		this.superTargetModel = xmlTargetModel;
		
		List<Node> nodeList = getNodes(O_SHORTCUT, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "XMLShortcuts");
		}
	}

	public XMLPackage getSuperPackage() {
		return superPackage;
	}

	public void setSuperPackage(XMLPackage superPackage) {
		this.superPackage = superPackage;
	}

	public XMLTargetModel getSuperTargetModel() {
		return superTargetModel;
	}

	public void setSuperTargetModel(XMLTargetModel superTargetModel) {
		this.superTargetModel = superTargetModel;
	}

	public SimpleList<String> getIdList() {
		return idList;
	}

	public void setIdList(SimpleList<String> idList) {
		this.idList = idList;
	}
}
