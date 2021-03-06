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

import static bingo.pd4j.pdm.internal.LogUtil.*;
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodeText;
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodes;
import static bingo.pd4j.pdm.util.PdmNodeName.META_REF;
import static bingo.pd4j.pdm.util.PdmNodeName.O_TABLE_SYMBOL;

import java.util.List;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.internal.IdCollector;
import bingo.pd4j.pdm.model.api.SimpleList;
import bingo.pd4j.pdm.util.ListUtil;

/**
 * <code>{@link XMLTableSymbols}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLTableSymbols extends SimpleList<XMLTableSymbol>{
	
	private static final Logger log = LoggerFactory.getLogger(XMLTableSymbols.class);
	
	private SimpleList<String> idList;;

	private XMLReferenceSymbol superReferenceSymbol;
	/**
	 * @param node
	 * @param xmlReferenceSymbol
	 */
	public XMLTableSymbols(Node currentNode, XMLReferenceSymbol xmlReferenceSymbol) {
		this.superReferenceSymbol = xmlReferenceSymbol;
		
		List<Node> nodeList = getNodes(O_TABLE_SYMBOL, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "TableSymbol");
		}
	}
	
	/**
	 * get the {@link XMLTableSymbol} by the given index.
	 */
	public XMLTableSymbol get(int index){
		initInnerList();
		return super.get(index);
	}
	
	/**
	 * when this class has ref to some {@link XMLTableSymbol}, 
	 * if it's the first time to visit the list,
	 * the inner list will init from the id list.
	 */
	private void initInnerList(){
		if(isListNull() && idList != null){
			for (String id : idList) {
	            add((XMLTableSymbol) IdCollector.get(id));
            }
		} else if(isListNull() && idList == null){
			log.warn(WARN_NO_INNER_LIST_NAME, "0000");
		}
	}

	/*
	 * getter and setter.
	 */
	public XMLReferenceSymbol getSuperReferenceSymbol() {
		return superReferenceSymbol;
	}
	public void setSuperReferenceSymbol(XMLReferenceSymbol superReferenceSymbol) {
		this.superReferenceSymbol = superReferenceSymbol;
	}

}
