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
package bingo.pd4j.pdm.demo;

import org.dom4j.DocumentException;

import bingo.pd4j.pdm.PdmReader;
import bingo.pd4j.pdm.internal.IdCollector;
import bingo.pd4j.pdm.model.PDM;

/**
 * <code>{@link TestPdm}</code>
 *
 * Test Demo
 *
 * @author Calvin Chen
 */
public class TestPdm {
	public static void main(String[] arges){
		PDM pdm = null;
		try {
			pdm = PdmReader.read("C:/Users/Calvin Chen/Desktop/CK BookShop 20120308-1.pdm");
			System.out.println(pdm.getTable(0).getKey(0).getKeyColumns().get(0));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
