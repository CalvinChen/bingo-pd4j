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
package bingo.pd4j.pdm.util;

import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>{@link PdmNodeFinder}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class PdmNodeFinder {

	private static final Logger log = LoggerFactory.getLogger(PdmNodeFinder.class);
	
	/**
	 * @param 
	 * @return
	 */
	public static String getNodeText(String nodeName, Node currentNode) {
		Node tempNode = currentNode.selectSingleNode(nodeName);
		if(tempNode != null){
			return tempNode.getText();
		} 
		return null;
	}
	
	public static Integer getNodeInteger(String NodeName, Element element) {
		Node tempNode = element.selectSingleNode(NodeName);
		if(tempNode != null){
			try{
				Integer i = Integer.parseInt(tempNode.getText());
				return i;
			} catch (NumberFormatException e) {
				log.warn("the text of the node <{}> is not a number! Ignored.", NodeName);
				return null;
			}
		}
		return null;
	}

	public static Node getNode(String nodeName, Node currentNode){
		return currentNode.selectSingleNode(nodeName);
	}
	
	public static Boolean hasNode(String nodeName, Node currentNode){
		if(currentNode.selectSingleNode(nodeName) != null){
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Node> getNodes(String nodeName, Node currentNode){
		return currentNode.selectNodes(nodeName);
	}
}
