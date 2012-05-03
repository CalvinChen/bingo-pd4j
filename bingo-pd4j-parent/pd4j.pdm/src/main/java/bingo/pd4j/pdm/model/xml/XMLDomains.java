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
 * <code>{@link XMLDomains}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLDomains extends SimpleList<XMLPhysicalDomain>{

	private static final Logger log = LoggerFactory.getLogger(XMLDomains.class);
	
	private XMLModel superModel;
	
	private SimpleList<String> idList;
	
	private XMLColumn superColumn;
	
	/**
	 * @param node
	 * @param xmlModel
	 */
	public XMLDomains(Node currentNode, XMLModel xmlModel) {
		this.superModel = xmlModel;
		
		XMLPhysicalDomain physicalDomain = null;
		List<Node> nodeList = getNodes(O_PHYSICAL_DOMAIN, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			for (Node node : nodeList) {
				physicalDomain = new XMLPhysicalDomain(node, this);
				add(physicalDomain);
				IdCollector.put(physicalDomain.getId(), physicalDomain);
			}
			log.debug(INITIALLIZED_NAME, "XMLDomains");
		}
	}

	/**
	 * @param node
	 * @param xmlColumn
	 */
	public XMLDomains(Node currentNode, XMLColumn xmlColumn) {
		this.superColumn = xmlColumn;
		
		List<Node> nodeList = getNodes(O_PHYSICAL_DOMAIN, currentNode);
		if(ListUtil.isNotEmpty(nodeList)){
			idList = new SimpleList<String>();
			for (Node node : nodeList) {
				idList.add(getNodeText(META_REF, node));
			}
			log.debug(INITIALLIZED_NAME, "XMLDomains");
		}
	}
	
	/**
	 * get the {@link XMLPhysicalDomain} by the given index.
	 */
	public XMLPhysicalDomain get(int index){
		initInnerList();
		return super.get(index);
	}
	
	/**
	 * get the {@link XMLPhysicalDomain} by the given name.
	 */
	public XMLPhysicalDomain get(String name){
		initInnerList();
		for (XMLPhysicalDomain domain : getList()) {
	        if(domain.getName().equals(name)){
	        	return domain;
	        }
        }
		return null;
	}
	
	/**
	 * when this class has ref to some {@link XMLPhysicalDomain}, 
	 * if it's the first time to visit the list,
	 * the inner list will init from the id list.
	 */
	private void initInnerList(){
		if(isListNull() && idList != null){
			for (String id : idList) {
	            add((XMLPhysicalDomain) IdCollector.get(id));
            }
		} else if(isListNull() && idList == null){
			log.warn(WARN_NO_INNER_LIST_NAME, "XMLDomains");
		}
	}

	public XMLModel getSuperModel() {
		return superModel;
	}

	public void setSuperModel(XMLModel superModel) {
		this.superModel = superModel;
	}

	public SimpleList<String> getIdList() {
		return idList;
	}

	public void setIdList(SimpleList<String> idList) {
		this.idList = idList;
	}

	public XMLColumn getSuperColumn() {
		return superColumn;
	}

	public void setSuperColumn(XMLColumn superColumn) {
		this.superColumn = superColumn;
	}

}
