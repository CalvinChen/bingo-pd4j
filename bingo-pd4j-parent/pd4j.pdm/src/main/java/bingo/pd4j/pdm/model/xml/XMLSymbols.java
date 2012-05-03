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

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.internal.IdCollector;
import bingo.pd4j.pdm.util.ListUtil;
import static bingo.pd4j.pdm.internal.LogUtil.*;
import static bingo.pd4j.pdm.util.PdmNodeFinder.*;
import static bingo.pd4j.pdm.util.PdmNodeName.*;
/**
 * <code>{@link XMLSymbols}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLSymbols {
	
	private static final Logger log = LoggerFactory.getLogger(XMLSymbols.class);

	private List<XMLReferenceSymbol> referenceSymbols;
	private List<XMLTableSymbol> tableSymbols;
	private List<XMLPackageSymbol> packageSymbols;
	
	private XMLPhysicalDiagram superPhysicalDiagram;
	/**
	 * @param node
	 * @param xmlPhysicalDiagram
	 */
	public XMLSymbols(Node currentNode, XMLPhysicalDiagram xmlPhysicalDiagram) {
		this.superPhysicalDiagram = xmlPhysicalDiagram;
		
		List<Node> nodeList = null;
		nodeList = getNodes(O_REFERENCE_SYMBOL, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			referenceSymbols = new ArrayList<XMLReferenceSymbol>();
			for (Node node : nodeList) {
				XMLReferenceSymbol referenceSymbol = new XMLReferenceSymbol(node, this);
				referenceSymbols.add(referenceSymbol);
				IdCollector.put(referenceSymbol.getId(), referenceSymbol);
			}
			log.debug(INITIALLIZED_NAME, "referenceSymbols");
		}
		nodeList = getNodes(O_TABLE_SYMBOL, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			tableSymbols = new ArrayList<XMLTableSymbol>();
			for (Node node : nodeList) {
				XMLTableSymbol tableSymbol = new XMLTableSymbol(node, this);
				tableSymbols.add(tableSymbol);
				IdCollector.put(tableSymbol.getId(), tableSymbol);
			}
			log.debug(INITIALLIZED_NAME, "tableSymbols");
		}
		nodeList = getNodes(O_PACKAGE_SYMBOL, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			packageSymbols = new ArrayList<XMLPackageSymbol>();
			for (Node node : nodeList) {
				XMLPackageSymbol packageSymbol = new XMLPackageSymbol(node, this);
				packageSymbols.add(packageSymbol);
				IdCollector.put(packageSymbol.getId(), packageSymbol);
			}
			log.debug(INITIALLIZED_NAME, "packageSymbols");
		}
		
		log.debug(INITIALLIZED_NAME, "XMLSymbols");
	}
	public List<XMLReferenceSymbol> getReferenceSymbols() {
		return referenceSymbols;
	}
	public void setReferenceSymbols(List<XMLReferenceSymbol> referenceSymbols) {
		this.referenceSymbols = referenceSymbols;
	}
	public List<XMLTableSymbol> getTableSymbols() {
		return tableSymbols;
	}
	public void setTableSymbols(List<XMLTableSymbol> tableSymbols) {
		this.tableSymbols = tableSymbols;
	}
	public List<XMLPackageSymbol> getPackageSymbols() {
		return packageSymbols;
	}
	public void setPackageSymbols(List<XMLPackageSymbol> packageSymbols) {
		this.packageSymbols = packageSymbols;
	}
	public XMLPhysicalDiagram getSuperPhysicalDiagram() {
		return superPhysicalDiagram;
	}
	public void setSuperPhysicalDiagram(XMLPhysicalDiagram superPhysicalDiagram) {
		this.superPhysicalDiagram = superPhysicalDiagram;
	}

}
