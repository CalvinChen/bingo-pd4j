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

import java.util.List;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.internal.IdCollector;
import bingo.pd4j.pdm.model.api.SimpleList;
import bingo.pd4j.pdm.util.ListUtil;
import static bingo.pd4j.pdm.internal.LogUtil.*;
import static bingo.pd4j.pdm.util.PdmNodeFinder.*;
import static bingo.pd4j.pdm.util.PdmNodeName.*;
/**
 * <code>{@link XMLPhysicalDiagrams}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLPhysicalDiagrams extends SimpleList<XMLPhysicalDiagram>{

	private static final Logger log = LoggerFactory.getLogger(XMLPhysicalDiagrams.class);
	
	private XMLModel superModel;
	
	private SimpleList<String> idList;
	
	private XMLPackage superPackage;
	/**
	 * @param node
	 * @param xmlModel
	 */
	public XMLPhysicalDiagrams(Node currentNode, XMLModel xmlModel) {
		this.superModel = xmlModel;
		
		XMLPhysicalDiagram physicalDiagram = null;
		List<Node> nodeList = getNodes(O_PHYSICAL_DIAGRAM, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			if(getNode(META_REF, nodeList.get(0)) != null){
				idList = new SimpleList<String>();
				for (Node node : nodeList) {
					idList.add(getNodeText(META_REF, node));
				}
			} else {
				for (Node node : nodeList) {
					physicalDiagram = new XMLPhysicalDiagram(node, this);
					add(physicalDiagram);
					IdCollector.put(physicalDiagram.getId(), physicalDiagram);
				}
			}
			log.debug(INITIALLIZED_NAME, "XMLPhysicalDiagrams");
		}
	}
	/**
	 * @param node
	 * @param xmlPackage
	 */
	public XMLPhysicalDiagrams(Node currentNode, XMLPackage xmlPackage) {
		this.superPackage = xmlPackage;
		List<Node> nodeList = getNodes(O_PHYSICAL_DIAGRAM, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				add(new XMLPhysicalDiagram(node, this));
			}
			log.debug(INITIALLIZED_NAME, "XMLPhysicalDiagrams");
		}
	}

	/**
	 * get the {@link XMLPhysicalDiagram} by the given index.
	 */
	public XMLPhysicalDiagram get(int index){
		initInnerList();
		return super.get(index);
	}
	
	/**
	 * get the {@link XMLPhysicalDiagram} by the given name.
	 */
	public XMLPhysicalDiagram get(String name){
		initInnerList();
		for (XMLPhysicalDiagram one : getList()) {
	        if(one.getName().equals(name)){
	        	return one;
	        }
        }
		return null;
	}
	
	/**
	 * when this class has ref to some {@link XMLPhysicalDiagram}, 
	 * if it's the first time to visit the list,
	 * the inner list will init from the id list.
	 */
	private void initInnerList(){
		if(isListNull() && idList != null){
			for (String id : idList) {
	            add((XMLPhysicalDiagram) IdCollector.get(id));
            }
		} else if(isListNull() && idList == null){
			log.warn(WARN_NO_INNER_LIST_NAME, "XMLPhysicalDiagrams");
		}
	}
	
	/*
	 * getter and setter.
	 */
	public XMLPackage getSuperPackage() {
		return superPackage;
	}
	public void setSuperPackage(XMLPackage superPackage) {
		this.superPackage = superPackage;
	}
	public XMLModel getSuperModel() {
		return superModel;
	}
	public void setSuperModel(XMLModel superModel) {
		this.superModel = superModel;
	}

}
