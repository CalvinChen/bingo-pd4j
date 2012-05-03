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
 * <code>{@link XMLPackages}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLPackages extends SimpleList<XMLPackage>{

	private static final Logger log = LoggerFactory.getLogger(XMLPackages.class);
	
	private List<String> idList;

	private XMLPackageSymbol superPackageSymbol;
	
	private XMLModel superModel;
	
	/**
	 * @param node
	 * @param xmlPackageSymbol
	 */
	public XMLPackages(Node currentNode, XMLPackageSymbol xmlPackageSymbol) {
		this.superPackageSymbol = xmlPackageSymbol;
		
		List<Node> nodeList = getNodes(O_PACKAGE, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "XMLPackages");
		}
	}

	/**
	 * @param node
	 * @param xmlModel
	 */
	public XMLPackages(Node currentNode, XMLModel xmlModel) {
		this.superModel = xmlModel;
		
		XMLPackage xmlPackage = null;
		List<Node> nodeList = getNodes(O_PACKAGE, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				xmlPackage = new XMLPackage(node, this);
				add(xmlPackage);
				IdCollector.put(xmlPackage.getId(), xmlPackage);
			}
			log.debug(INITIALLIZED_NAME, "XMLPackages");
		}
	}
	
	/**
	 * get the {@link Package} by the given index.
	 */
	public XMLPackage get(int index){
		initInnerList();
		return super.get(index);
	}
	
	/**
	 * get the {@link Package} by the given name.
	 */
	public XMLPackage get(String name){
		initInnerList();
		for (XMLPackage package1 : getList()) {
	        if(package1.getName().equals(name)){
	        	return package1;
	        }
        }
		return null;
	}
	
	/**
	 * when this class has ref to {@link Package}, 
	 * if it's the first time to visit the list,
	 * the inner list will init from the id list.
	 */
	private void initInnerList(){
		if(isListNull() && idList != null){
			for (String id : idList) {
	            add((XMLPackage) IdCollector.get(id));
            }
		} else if(isListNull() && idList == null){
			log.warn(WARN_NO_INNER_LIST_NAME, "XMLPackages");
		}
	}
	
	/* getter and setter */

	public XMLPackageSymbol getSuperPackageSymbol() {
		return superPackageSymbol;
	}

	public void setSuperPackageSymbol(XMLPackageSymbol superPackageSymbol) {
		this.superPackageSymbol = superPackageSymbol;
	}

	public XMLModel getSuperModel() {
		return superModel;
	}

	public void setSuperModel(XMLModel superModel) {
		this.superModel = superModel;
	}

}
