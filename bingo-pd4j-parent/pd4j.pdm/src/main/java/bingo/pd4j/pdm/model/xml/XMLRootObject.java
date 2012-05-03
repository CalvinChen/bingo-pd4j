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
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNode;
import static bingo.pd4j.pdm.util.PdmNodeName.C_CHILDREN;
import static bingo.pd4j.pdm.util.PdmNodeName.DIVIDER;
import static bingo.pd4j.pdm.util.PdmNodeName.O_ROOT_OBJECT;
import static bingo.pd4j.pdm.util.PdmNodeName.ROOT;

import org.dom4j.Document;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLRootObject}</code>
 *
 * represent a XML RootObject.
 *
 * @author Calvin Chen
 */
public class XMLRootObject implements WithId{
	
	private static final Logger log = LoggerFactory.getLogger(XMLRootObject.class);
	
	private XMLChildren children;

	private String id;

	public XMLRootObject(Document doc){
		Node node = getNode(ROOT + O_ROOT_OBJECT + DIVIDER + C_CHILDREN, doc);
		if(node != null){
			children = new XMLChildren(node, this);	
		}
		
		log.info(INITIALLIZED_NAME, "RootObject");
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public XMLChildren getChildren() {
		return children;
	}

	public void setChildren(XMLChildren children) {
		this.children = children;
	}

}
