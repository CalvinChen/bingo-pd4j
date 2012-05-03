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
import static bingo.pd4j.pdm.util.PdmNodeName.A_BRUSH_STYLE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_FILL_COLOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_FONT_LIST;
import static bingo.pd4j.pdm.util.PdmNodeName.A_GRADIENT_END_COLOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_GRADIENT_FILL_MODE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_ICON_MODE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_LINE_COLOR;
import static bingo.pd4j.pdm.util.PdmNodeName.A_MODIFICATION_DATE;
import static bingo.pd4j.pdm.util.PdmNodeName.A_RECT;
import static bingo.pd4j.pdm.util.PdmNodeName.A_SHAOW_COLOR;
import static bingo.pd4j.pdm.util.PdmNodeName.C_OBJECT;

import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.model.api.WithId;
/**
 * <code>{@link XMLPackageSymbol}</code>
 *
 * TODO : document me
 *
 * @author Calvin Chen
 */
public class XMLPackageSymbol implements WithId {
	
	private static final Logger log = LoggerFactory.getLogger(XMLPackageSymbol.class);
	
	private String id;

	private String modificationDate;
	private String iconMode;
	private String rect;
	private String lineColor;
	private String fillColor;
	private String shadowColor;
	private String fontList;
	private String brushStyle;
	private String gradientFillMode;
	private String gradientEndColor;

	private XMLPackages object;
	
	private XMLSymbols superSymbols;

	/**
	 * @param node
	 * @param xmlSymbols
	 */
	public XMLPackageSymbol(Node currentNode, XMLSymbols xmlSymbols) {
		this.superSymbols = xmlSymbols;
		
		setModificationDate(getNodeText(A_MODIFICATION_DATE, currentNode));
		setIconMode(getNodeText(A_ICON_MODE, currentNode));
		setRect(getNodeText(A_RECT, currentNode));
		setLineColor(getNodeText(A_LINE_COLOR, currentNode));
		setFillColor(getNodeText(A_FILL_COLOR, currentNode));
		setShadowColor(getNodeText(A_SHAOW_COLOR, currentNode));
		setFontList(getNodeText(A_FONT_LIST, currentNode));
		setBrushStyle(getNodeText(A_BRUSH_STYLE, currentNode));
		setGradientFillMode(getNodeText(A_GRADIENT_FILL_MODE, currentNode));
		setGradientEndColor(getNodeText(A_GRADIENT_END_COLOR, currentNode));
		
		Node node = getNode(C_OBJECT, currentNode);
		if(node != null){
			setObject(new XMLPackages(node, this));	
		}
		
		log.debug(INITIALLIZED_NAME, "XMLPackageSymbol");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getIconMode() {
		return iconMode;
	}

	public void setIconMode(String iconMode) {
		this.iconMode = iconMode;
	}

	public String getRect() {
		return rect;
	}

	public void setRect(String rect) {
		this.rect = rect;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public String getShadowColor() {
		return shadowColor;
	}

	public void setShadowColor(String shadowColor) {
		this.shadowColor = shadowColor;
	}

	public String getFontList() {
		return fontList;
	}

	public void setFontList(String fontList) {
		this.fontList = fontList;
	}

	public String getBrushStyle() {
		return brushStyle;
	}

	public void setBrushStyle(String brushStyle) {
		this.brushStyle = brushStyle;
	}

	public String getGradientFillMode() {
		return gradientFillMode;
	}

	public void setGradientFillMode(String gradientFillMode) {
		this.gradientFillMode = gradientFillMode;
	}

	public String getGradientEndColor() {
		return gradientEndColor;
	}

	public void setGradientEndColor(String gradientEndColor) {
		this.gradientEndColor = gradientEndColor;
	}

	public XMLPackages getObject() {
		return object;
	}

	public void setObject(XMLPackages object) {
		this.object = object;
	}

	public XMLSymbols getSuperSymbols() {
		return superSymbols;
	}

	public void setSuperSymbols(XMLSymbols superSymbols) {
		this.superSymbols = superSymbols;
	}


}
