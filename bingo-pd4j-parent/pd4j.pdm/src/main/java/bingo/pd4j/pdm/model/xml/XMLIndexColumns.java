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
 * <code>{@link XMLIndexColumns}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLIndexColumns extends SimpleList<XMLIndexColumn>{

	private static final Logger log = LoggerFactory.getLogger(XMLIndexColumns.class);

	private XMLIndex superIndex;
	/**
	 * @param node
	 * @param xmlIndex
	 */
	public XMLIndexColumns(Node currentNode, XMLIndex xmlIndex) {
		this.superIndex = xmlIndex;
		
		XMLIndexColumn indexColumn = null;
		List<Node> nodeList = getNodes(O_INDEX_COLUMN, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				indexColumn = new XMLIndexColumn(node, this); 
				add(indexColumn);
				IdCollector.put(indexColumn.getId(), indexColumn);
			}
			log.debug(INITIALLIZED_NAME, "XMLIndexColumns");
		}
	}
	public XMLIndex getSuperIndex() {
		return superIndex;
	}
	public void setSuperIndex(XMLIndex superIndex) {
		this.superIndex = superIndex;
	}
}
