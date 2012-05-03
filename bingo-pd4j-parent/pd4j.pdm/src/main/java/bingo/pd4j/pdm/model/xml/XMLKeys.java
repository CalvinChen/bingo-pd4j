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
 * <code>{@link XMLKeys}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLKeys extends SimpleList<XMLKey>{

	private static final Logger log = LoggerFactory.getLogger(XMLKeys.class);
	
	private XMLTable superTable;
	
	private XMLIndex superIndex;
	
	private XMLReference superReference;
	
	private SimpleList<String> idList;
	
	/**
	 * @param node
	 * @param xmlTable
	 */
	public XMLKeys(Node currentNode, XMLTable xmlTable) {
		this.superTable = xmlTable;
		
		XMLKey key = null;
		List<Node> nodeList = getNodes(O_KEY, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				key = new XMLKey(node, this);
				add(key);
				IdCollector.put(key.getId(), key);
			}
			log.debug(INITIALLIZED_NAME, "XMLKeys");
		}
	}

	/**
	 * @param node
	 * @param xmlIndex
	 */
	public XMLKeys(Node currentNode, XMLIndex xmlIndex) {
		this.superIndex = xmlIndex;
		
		List<Node> nodeList = getNodes(O_KEY, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "XMLKeys");
		}
	}

	/**
	 * @param node
	 * @param xmlReference
	 */
	public XMLKeys(Node currentNode, XMLReference xmlReference) {
		this.superReference = xmlReference;
		
		List<Node> nodeList = getNodes(O_KEY, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				add(new XMLKey(node, this));
			}
			log.debug(INITIALLIZED_NAME, "XMLKeys");
		}
	}
	
	/**
	 * get the {@link XMLKey} by the given index.
	 */
	public XMLKey get(int index){
		initInnerList();
		return super.get(index);
	}
	
	/**
	 * get the {@link XMLKey} by the given name.
	 */
	public XMLKey get(String name){
		initInnerList();
		for (XMLKey one : getList()) {
	        if(one.getName().equals(name)){
	        	return one;
	        }
        }
		return null;
	}
	
	/**
	 * when this class has ref to some {@link XMLKey}, 
	 * if it's the first time to visit the list,
	 * the inner list will init from the id list.
	 */
	private void initInnerList(){
		if(isListNull() && idList != null){
			for (String id : idList) {
	            add((XMLKey) IdCollector.get(id));
            }
		} else if(isListNull() && idList == null){
			log.warn(WARN_NO_INNER_LIST_NAME, "XMLKeys");
		}
	}

	/*
	 * getter and setter.
	 */
	public XMLTable getSuperTable() {
		return superTable;
	}
	public void setSuperTable(XMLTable superTable) {
		this.superTable = superTable;
	}
	public XMLIndex getSuperIndex() {
		return superIndex;
	}
	public void setSuperIndex(XMLIndex superIndex) {
		this.superIndex = superIndex;
	}
	public XMLReference getSuperReference() {
		return superReference;
	}
	public void setSuperReference(XMLReference superReference) {
		this.superReference = superReference;
	}
}
