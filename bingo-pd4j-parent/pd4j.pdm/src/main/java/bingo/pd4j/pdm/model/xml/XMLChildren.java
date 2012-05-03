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


import static bingo.pd4j.pdm.internal.LogUtil.INITIALLIZED_SIZE_LIST;
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodes;
import static bingo.pd4j.pdm.util.PdmNodeName.O_MODEL;

import java.util.List;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.internal.IdCollector;
import bingo.pd4j.pdm.model.api.SimpleList;

/**
 * <code>{@link XMLChildren}</code>
 *
 * represents a XML Children.
 *
 * @author Calvin Chen
 */
public class XMLChildren extends SimpleList<XMLModel>{
	
	private static final Logger log = LoggerFactory.getLogger(XMLChildren.class);
	
	private XMLRootObject superRootObject;

	/**
	 * @param currentNode
	 * @param xmlRootObject
	 */
	public XMLChildren(Node currentNode, XMLRootObject xmlRootObject) {
		this.superRootObject = xmlRootObject;

		XMLModel model = null;
		List<Node> nodelist = getNodes(O_MODEL, currentNode);
		if(nodelist != null && nodelist.size() > 0){
			for (Node node : nodelist) {
				model = new XMLModel(node, this); 
				add(model);
				IdCollector.put(model.getId(), model);
			}
			log.debug(INITIALLIZED_SIZE_LIST, nodelist.size(), "XMLChildren");
		}
	}

	public XMLRootObject getSuperRootObject() {
		return superRootObject;
	}

	public void setSuperRootObject(XMLRootObject superRootObject) {
		this.superRootObject = superRootObject;
	}

}
