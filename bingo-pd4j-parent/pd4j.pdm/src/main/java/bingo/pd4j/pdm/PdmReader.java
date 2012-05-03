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
package bingo.pd4j.pdm;

import java.io.File;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bingo.pd4j.pdm.internal.LogUtil;
import bingo.pd4j.pdm.model.PDM;

/**
 * <code>{@link PdmReader}</code>
 *
 * pdm file reader.
 *
 * @author Calvin Chen
 */
public class PdmReader {
	
	private static final Logger log = LoggerFactory.getLogger(PdmReader.class);
	
	private static SAXReader saxReader;
	
	public PdmReader(){
		if(saxReader == null)
			saxReader = new SAXReader();
	}
	
	/**
	 * load pdm from a pdm file.
	 * @param .pdm file
	 * @return physics data model
	 * @throws DocumentException 
	 */
	public static PDM read(File file) throws DocumentException{
		log.info(LogUtil.LOADING_NAME_VALUE, "pdm file", file.getAbsolutePath());
		
		return new PDM(readDocument(file));
	}
	
	/**
	 * load pdm from a file name.
	 * @param fileName
	 * @return physics data model.
	 * @throws DocumentException 
	 */
	public static PDM read(String fileName) throws DocumentException{
		return read(new File(fileName));
	}
	
	/**
	 * load pdm from a input stream.
	 * @param is input stream.
	 * @return physics data model.
	 */
	public static PDM read(InputStream is){
		return new PDM(readDocument(is));
	}

	private static Document readDocument(File file){
		if(saxReader == null)
			saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid pdm file!");
		}
		return document;
	}
	
	private static Document readDocument(InputStream is){
		if(saxReader == null)
			saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(is);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid pdm file!");
		}
		return document;
	}
	
}
