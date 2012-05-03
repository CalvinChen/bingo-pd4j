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
import static bingo.pd4j.pdm.util.PdmNodeFinder.getNodeText;
import static bingo.pd4j.pdm.util.PdmNodeName.A_ARROW_STYLE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_CORNER_STYLE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_FONT_LIST;
import static bingo.pd4j.pdm.util.PdmNodeName.A_LINE_COLOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_LIST_OF_POINTS;
import static bingo.pd4j.pdm.util.PdmNodeName.A_RECT;
import static bingo.pd4j.pdm.util.PdmNodeName.A_SHAOW_COLOR;
import static bingo.pd4j.pdm.util.PdmNodeName.C_DESTINATION_SYMBOL;
import static bingo.pd4j.pdm.util.PdmNodeName.C_OBJECT;
import static bingo.pd4j.pdm.util.PdmNodeName.C_SOURCE_SYMBOL;
import static bingo.pd4j.pdm.util.PdmNodeName.META_ID;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLReferenceSymbol}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLReferenceSymbol implements WithId{
	
	private static final Logger log = LoggerFactory.getLogger(XMLReferenceSymbol.class);

	private String id;
	
	private String rect;
	private String ListOfPoints;
	private String CornerStyle;
	private String ArrowStyle;
	private String LineColor;
	private String ShadowColor;
	private String FontList;

	private XMLTableSymbols sourceSymbol;
	private XMLTableSymbols destinationSymbol;
	private XMLReferences object;
	
	private XMLSymbols superSymbols;
	
	/**
	 * @param node
	 * @param xmlSymbols
	 */
	public XMLReferenceSymbol(Node currentNode, XMLSymbols xmlSymbols) {
		this.superSymbols = xmlSymbols;
		
		setId(getNodeText(META_ID, currentNode));
		setRect(getNodeText(A_RECT, currentNode));
		setListOfPoints(getNodeText(A_LIST_OF_POINTS, currentNode));
		setCornerStyle(getNodeText(A_CORNER_STYLE, currentNode));
		setArrowStyle(getNodeText(A_ARROW_STYLE, currentNode));
		setLineColor(getNodeText(A_LINE_COLOR, currentNode));
		setShadowColor(getNodeText(A_SHAOW_COLOR, currentNode));
		setFontList(getNodeText(A_FONT_LIST, currentNode));
		
		Node node = getNode(C_SOURCE_SYMBOL, currentNode);
		if(node != null){
			setSourceSymbol(new XMLTableSymbols(node, this));	
		}
		
		node = getNode(C_DESTINATION_SYMBOL, currentNode);
		if(node != null){
			setDestinationSymbol(new XMLTableSymbols(node, this));	
		}
		
		node = getNode(C_OBJECT, currentNode);
		if(node != null){
			setObject(new XMLReferences(node, this));	
		}
		
		log.debug(INITIALLIZED_NAME, "XMLReferenceSymbol");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRect() {
		return rect;
	}
	public void setRect(String rect) {
		this.rect = rect;
	}
	public String getListOfPoints() {
		return ListOfPoints;
	}
	public void setListOfPoints(String listOfPoints) {
		ListOfPoints = listOfPoints;
	}
	public String getCornerStyle() {
		return CornerStyle;
	}
	public void setCornerStyle(String cornerStyle) {
		CornerStyle = cornerStyle;
	}
	public String getArrowStyle() {
		return ArrowStyle;
	}
	public void setArrowStyle(String arrowStyle) {
		ArrowStyle = arrowStyle;
	}
	public String getLineColor() {
		return LineColor;
	}
	public void setLineColor(String lineColor) {
		LineColor = lineColor;
	}
	public String getShadowColor() {
		return ShadowColor;
	}
	public void setShadowColor(String shadowColor) {
		ShadowColor = shadowColor;
	}
	public String getFontList() {
		return FontList;
	}
	public void setFontList(String fontList) {
		FontList = fontList;
	}
	public XMLTableSymbols getSourceSymbol() {
		return sourceSymbol;
	}
	public void setSourceSymbol(XMLTableSymbols sourceSymbol) {
		this.sourceSymbol = sourceSymbol;
	}
	public XMLTableSymbols getDestinationSymbol() {
		return destinationSymbol;
	}
	public void setDestinationSymbol(XMLTableSymbols destinationSymbol) {
		this.destinationSymbol = destinationSymbol;
	}
	public XMLReferences getObject() {
		return object;
	}
	public void setObject(XMLReferences object) {
		this.object = object;
	}
	public XMLSymbols getSuperSymbols() {
		return superSymbols;
	}
	public void setSuperSymbols(XMLSymbols superSymbols) {
		this.superSymbols = superSymbols;
	}


}
