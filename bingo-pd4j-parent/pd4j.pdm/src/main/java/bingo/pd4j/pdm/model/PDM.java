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
package bingo.pd4j.pdm.model;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;

import bingo.pd4j.pdm.model.xml.XMLDomains;
import bingo.pd4j.pdm.model.xml.XMLPackage;
import bingo.pd4j.pdm.model.xml.XMLPackages;
import bingo.pd4j.pdm.model.xml.XMLPhysicalDomain;
import bingo.pd4j.pdm.model.xml.XMLReference;
import bingo.pd4j.pdm.model.xml.XMLReferences;
import bingo.pd4j.pdm.model.xml.XMLRootObject;
import bingo.pd4j.pdm.model.xml.XMLTable;
import bingo.pd4j.pdm.model.xml.XMLTables;



/**
 * <code>{@link PDM}</code>
 *
 * represents a simple pdm file.
 *
 * @author Calvin Chen
 */
public class PDM {
	/**
	 * 
	 */
	private static final int DEFAULT_ZERO_BY_POWERDESIGNER = 0;

	private Document document;

	private XMLRootObject xmlRootObject;
	
	private XMLTables xmlTables;
	
	private XMLReferences xmlReferences;
	
	private XMLDomains xmlDomains;
	
	private XMLPackages xmlPackages;
	
	/**
	 * init a pdm model by using a xml document.
	 */
	public PDM(Document document) {
		this.document = document;
		this.xmlRootObject = new XMLRootObject(document);
	}
	
	/**
	 * get a {@link Table} by the given index.
	 */
	public Table getTable(int index){
		return getXmlTables().get(index);
	}
	
	/**
	 * get a {@link Table} by the given name.
	 */
	public Table getTable(String name){
		return getXmlTables().get(name);
	}
	
	/**
	 * get a table name list of all {@link Table}.
	 */
	public List<String> getTableNameList(){
		List<String> nameList = new ArrayList<String>();
		for (XMLTable table : getXmlTables()) {
	        nameList.add(table.getName());
        }
		if(nameList.size() == 0){
			return null;
		}
		return nameList;
	}
	
	/**
	 * list all {@link XMLTable}.
	 */
	public List<XMLTable> listTables(){
		return getXmlTables();
	}
	
	/**
	 * get a {@link Domain} by the given index.
	 */
	public Domain getDomain(int index){
		return getXmlDomains().get(index);
	}
	
	/**
	 * get a {@link Domain} by the given name.
	 */
	public Domain getDomain(String name){
		return getXmlDomains().get(name);
	}
	
	/**
	 * get a Domain name list of all {@link Domain}.
	 */
	public List<String> getDomainNameList(){
		List<String> nameList = new ArrayList<String>();
		for (XMLPhysicalDomain domain : getXmlDomains()) {
	        nameList.add(domain.getName());
        }
		if(nameList.size() == 0){
			return null;
		}
		return nameList;
	}
	
	/**
	 * list all {@link XMLPhysicalDomain}.
	 */
	public List<XMLPhysicalDomain> listDomains(){
		return getXmlDomains();
	}
	
	/**
	 * get a {@link Reference} by the given index.
	 */
	public Reference getReference(int index){
		return getXmlReferences().get(index);
	}
	
	/**
	 * get a {@link Reference} by the given name.
	 */
	public Reference getReference(String name){
		return getXmlReferences().get(name);
	}
	
	/**
	 * get a Reference name list of all {@link Reference}.
	 */
	public List<String> getReferenceNameList(){
		List<String> nameList = new ArrayList<String>();
		for (XMLReference reference : getXmlReferences()) {
	        nameList.add(reference.getName());
        }
		if(nameList.size() == 0){
			return null;
		}
		return nameList;
	}
	
	/**
	 * list all {@link XMLReference}.
	 */
	public List<XMLReference> listReferences(){
		return getXmlReferences();
	}
	
	/**
	 * get a {@link Package} by the given index.
	 */
	public Package getPackage(int index){
		return getXmlPackages().get(index);
	}

	/**
	 * get a {@link Package} by the given name.
	 */
	public Package getPackage(String name){
		return getXmlPackages().get(name);
	}
	
	/**
	 * get a Package name list of all {@link Package}.
	 */
	public List<String> getPackageNameList(){
		List<String> nameList = new ArrayList<String>();
		for (XMLPackage package1 : getXmlPackages()) {
	        nameList.add(package1.getName());
        }
		if(nameList.size() == 0){
			return null;
		}
		return nameList;
	}
	
	/**
	 * list all {@link XMLPackage}.
	 */
	public List<XMLPackage> listPackages(){
		return getXmlPackages();
	}
	
	/**
	 * get all xml tables for private use.
	 */
	private XMLTables getXmlTables() {
		if(xmlTables == null){
			xmlTables = xmlRootObject
						.getChildren().get(DEFAULT_ZERO_BY_POWERDESIGNER)
						.getTables();
		}
    	return xmlTables;
    }

	/**
	 * get all xml references for private use.
	 */
	private XMLReferences getXmlReferences() {
		if(xmlReferences == null){
			xmlReferences = xmlRootObject
							.getChildren().get(DEFAULT_ZERO_BY_POWERDESIGNER)
							.getReferences();
		}
    	return xmlReferences;
    }

	/**
	 * get all xml domains for private use.
	 */
	private XMLDomains getXmlDomains() {
		if(xmlDomains == null){
			xmlDomains = xmlRootObject.getChildren().get(DEFAULT_ZERO_BY_POWERDESIGNER)
						 .getDomains();
		}
    	return xmlDomains;
    }

	/**
	 * get {@link XMLPackages} for private use.
	 */
	private XMLPackages getXmlPackages() {
		if(xmlPackages == null){
			xmlPackages = xmlRootObject.getChildren().get(DEFAULT_ZERO_BY_POWERDESIGNER)
						  .getPackages();
		}
    	return xmlPackages;
    }

}
