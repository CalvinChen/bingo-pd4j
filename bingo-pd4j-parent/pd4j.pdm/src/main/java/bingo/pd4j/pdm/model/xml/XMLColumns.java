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
 * <code>{@link XMLColumns}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLColumns extends SimpleList<XMLColumn>{

	private static final Logger log = LoggerFactory.getLogger(XMLColumns.class);

	private XMLTable superTable;
	
	private XMLKey superKey;
	
	private XMLIndexColumn superIndexColumn;
	
	private XMLReferenceJoin superReferenceJoin;
	
	private SimpleList<String> idList;
	/**
	 * @param node
	 * @param xmlTable
	 */
	public XMLColumns(Node currentNode, XMLTable xmlTable) {
		this.superTable = xmlTable;
		
		XMLColumn column = null;
		List<Node> nodeList = getNodes(O_COLUMN, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				column = new XMLColumn(node, this);
				add(column);
				IdCollector.put(column.getId(), column);
			}
			log.debug(INITIALLIZED_NAME, "XMLColumns");
		}
	}
	/**
	 * @param node
	 * @param xmlKey
	 */
	public XMLColumns(Node currentNode, XMLKey xmlKey) {
		this.superKey = xmlKey;
		
		List<Node> nodeList = getNodes(O_COLUMN, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "XMLColumns");
		}
	}
	/**
	 * @param node
	 * @param xmlIndexColumn
	 */
	public XMLColumns(Node currentNode, XMLIndexColumn xmlIndexColumn) {
		this.superIndexColumn = xmlIndexColumn;
		
		List<Node> nodeList = getNodes(O_COLUMN, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "XMLColumns");
		}
	}
	/**
	 * @param node
	 * @param xmlReferenceJoin
	 */
	public XMLColumns(Node currentNode, XMLReferenceJoin xmlReferenceJoin) {
		this.superReferenceJoin = xmlReferenceJoin;
		
		List<Node> nodeList = getNodes(O_COLUMN, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "XMLColumns");
		}
	}
	
	/* (non-Javadoc)
	 * @see bingo.pd4j.pdm.model.api.SimpleList#get(int)
	 */
	@Override
	public XMLColumn get(int index) {
		if(isListNull() && idList != null){
			for (String id : idList) {
	            add((XMLColumn) IdCollector.get(id));
            }
		}
		return super.get(index);
	}
	
	public XMLTable getSuperTable() {
		return superTable;
	}
	public void setSuperTable(XMLTable superTable) {
		this.superTable = superTable;
	}
	public XMLKey getSuperKey() {
		return superKey;
	}
	public void setSuperKey(XMLKey superKey) {
		this.superKey = superKey;
	}
	public SimpleList<String> getIdList() {
		return idList;
	}
	public void setIdList(SimpleList<String> idList) {
		this.idList = idList;
	}
	public XMLIndexColumn getSuperIndexColumn() {
		return superIndexColumn;
	}
	public void setSuperIndexColumn(XMLIndexColumn superIndexColumn) {
		this.superIndexColumn = superIndexColumn;
	}
	public XMLReferenceJoin getSuperReferenceJoin() {
		return superReferenceJoin;
	}
	public void setSuperReferenceJoin(XMLReferenceJoin superReferenceJoin) {
		this.superReferenceJoin = superReferenceJoin;
	}

}
