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
 * <code>{@link XMLTables}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLTables extends SimpleList<XMLTable>{
	
	private static final Logger log = LoggerFactory.getLogger(XMLTables.class);
		
	/**
	 * when this object is called as a ref by tableSymbol.
	 */
	private XMLTableSymbol superTableSymbol;
	
	private List<String> idList;
	
	private XMLModel superModel;
	
	private XMLReference superReference;

	/**
	 * init a {@link XMLTables} by a {@link XMLTableSymbol}.
	 * @param node
	 * @param xmlTableSymbol
	 */
	public XMLTables(Node currentNode, XMLTableSymbol xmlTableSymbol) {
		this.superTableSymbol = xmlTableSymbol;
		
		List<Node> nodeList = getNodes(O_TABLE, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
		}
	}

	/**
	 * init a {@link XMLTables} by a {@link XMLModel}.
	 * @param node
	 * @param xmlModel
	 */
	public XMLTables(Node currentNode, XMLModel xmlModel) {
		this.superModel = xmlModel;
		
		XMLTable table = null;
		List<Node> nodeList = getNodes(O_TABLE, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				table = new XMLTable(node, this);
				add(table);
				IdCollector.put(table.getId(), table);
			}
			log.debug(INITIALLIZED_NAME, "XMLTables");
		}
	}

	/**
	 * init a {@link XMLTables} by a {@link XMLReference}.
	 * @param node
	 * @param xmlReference
	 */
	public XMLTables(Node currentNode, XMLReference xmlReference) {
		this.superReference = xmlReference;
		
		List<Node> nodeList = getNodes(O_TABLE, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
		}
	}
	
	/**
	 * get the table by the given index.
	 */
	public XMLTable get(int index){
		initInnerList();
		return super.get(index);
	}
	
	/**
	 * get the table by the given name.
	 */
	public XMLTable get(String name){
		initInnerList();
		for (XMLTable table : getList()) {
	        if(table.getName().equals(name)){
	        	return table;
	        }
        }
		return null;
	}
	
	/**
	 * when this class has ref to tables, 
	 * if it's the first time to visit the list,
	 * the inner list will init from the id list.
	 */
	private void initInnerList(){
		if(isListNull() && idList != null){
			for (String id : idList) {
	            add((XMLTable) IdCollector.get(id));
            }
		} else if(isListNull() && idList == null){
			log.warn(WARN_NO_INNER_LIST_NAME, "XMLTables");
		}
	}
	
	/* 
	 * getter and setter 
	 */
	public XMLReference getSuperReference() {
		return superReference;
	}
	public void setSuperReference(XMLReference superReference) {
		this.superReference = superReference;
	}
	public XMLTableSymbol getSuperTableSymbol() {
		return superTableSymbol;
	}
	public void setSuperTableSymbol(XMLTableSymbol superTableSymbol) {
		this.superTableSymbol = superTableSymbol;
	}
	public XMLModel getSuperModel() {
		return superModel;
	}
	public void setSuperModel(XMLModel superModel) {
		this.superModel = superModel;
	}
}
