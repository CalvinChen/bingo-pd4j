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
 * <code>{@link XMLGenerationOrigins}</code>
 *
 * represents a XML Generation Origins.
 *
 * @author Calvin Chen
 */
public class XMLGenerationOrigins extends SimpleList<XMLShortcut>{

	private static final Logger log = LoggerFactory.getLogger(XMLGenerationOrigins.class);
	
	private XMLModel superModel;
	/**
	 * @param node
	 * @param xmlModel
	 */
	public XMLGenerationOrigins(Node currentNode, XMLModel xmlModel) {
		this.superModel = xmlModel;
		
		XMLShortcut shortcut = null;
		List<Node> nodeList = getNodes(O_SHORTCUT, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				shortcut = new XMLShortcut(node, this); 
				add(shortcut);
				IdCollector.put(shortcut.getId(), shortcut);
			}
			log.debug(INITIALLIZED_NAME, "XMLGenerationOrigins");
		}
	}
	public XMLModel getSuperModel() {
		return superModel;
	}
	public void setSuperModel(XMLModel superModel) {
		this.superModel = superModel;
	}

}
