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
 * <code>{@link XMLReferences}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLReferences extends SimpleList<XMLReference>{
	
	private static final Logger log = LoggerFactory.getLogger(XMLReferences.class);
	
	private XMLReferenceSymbol superReferenceSymbol;
	
	private List<String> idList;
	
	private XMLModel superModel;

	/**
	 * @param node
	 * @param xmlReferenceSymbol
	 */
	public XMLReferences(Node currentNode, XMLReferenceSymbol xmlReferenceSymbol) {
		this.superReferenceSymbol = xmlReferenceSymbol;
		
		List<Node> nodeList = getNodes(O_REFERENCE, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "XMLReferences");
		}
	}

	/**
	 * @param node
	 * @param xmlModel
	 */
	public XMLReferences(Node currentNode, XMLModel xmlModel) {
		this.superModel = xmlModel;
		
		XMLReference reference = null;
		List<Node> nodeList = getNodes(O_REFERENCE, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				reference = new XMLReference(node, this);
				add(reference);
				IdCollector.put(reference.getId(), reference);
			}
			log.debug(INITIALLIZED_NAME, "XMLReferences");
		}
	}

	/**
	 * get the {@link XMLReference} by the given index.
	 */
	public XMLReference get(int index){
		initInnerList();
		return super.get(index);
	}
	
	/**
	 * get the {@link XMLReference} by the given name.
	 */
	public XMLReference get(String name){
		initInnerList();
		for (XMLReference reference : getList()) {
	        if(reference.getName().equals(name)){
	        	return reference;
	        }
        }
		return null;
	}
	
	/**
	 * when this class has ref to {@link XMLReference}, 
	 * if it's the first time to visit the list,
	 * the inner list will init from the id list.
	 */
	private void initInnerList(){
		if(isListNull() && idList != null){
			for (String id : idList) {
	            add((XMLReference) IdCollector.get(id));
            }
		} else if(isListNull() && idList == null){
			log.warn(WARN_NO_INNER_LIST_NAME, "XMLReferences");
		}
	}
	
	/* getter and setter */
	
	public XMLReferenceSymbol getSuperReferenceSymbol() {
		return superReferenceSymbol;
	}

	public void setSuperReferenceSymbol(XMLReferenceSymbol superReferenceSymbol) {
		this.superReferenceSymbol = superReferenceSymbol;
	}

	public XMLModel getSuperModel() {
		return superModel;
	}

	public void setSuperModel(XMLModel superModel) {
		this.superModel = superModel;
	}
	
}
