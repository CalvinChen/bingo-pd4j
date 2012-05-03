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
import bingo.pd4j.pdm.model.Column;
import bingo.pd4j.pdm.model.Columns;
import bingo.pd4j.pdm.model.Domain;
import bingo.pd4j.pdm.model.Domains;
import bingo.pd4j.pdm.model.Index;
import bingo.pd4j.pdm.model.Indexes;
import bingo.pd4j.pdm.model.Key;
import bingo.pd4j.pdm.model.Keys;
import bingo.pd4j.pdm.model.ListOfValues;
import bingo.pd4j.pdm.model.PDM;
import bingo.pd4j.pdm.model.Package;
import bingo.pd4j.pdm.model.Packages;
import bingo.pd4j.pdm.model.StandardChecks;
import bingo.pd4j.pdm.model.Table;
import bingo.pd4j.pdm.model.Tables;
import bingo.pd4j.pdm.model.Value;
import bingo.pd4j.pdm.model.Values;

/**
 * <code>{@link Demo}</code>
 *
 * iterate tree.
 *
 * @author Calvin Chen
 */
public class Demo {
	public static void main(String[] arge) throws DocumentException {
		
		/* load the whole pdm file */
		PDM pdm = PdmReader.read("test.pdm");
		
		/* get all packages */
		Packages packages = pdm.getPackages();
		
		/* get all package names */
		String[] packageNames = packages.getNames();
		
		/* iterate all package names */
		Package onePackage = null;
		for (String name : packageNames) {
			onePackage = (Package) packages.get(name);
			System.out.println("Name: " + onePackage.getName());
			System.out.println("Code: " + onePackage.getCode());
		}
		
		/* get all domains */
		Domains domains = pdm.getDomains();
		
		/* get all domain names */
		String[] domainNames = domains.getNames();
		
		/* iterate all domains */
		Domain oneDomain = null;
		StandardChecks standardChecks = null;
		Values values = null;
		ListOfValues listOfValues = null;
		Value value = null;
		for (String name : domainNames) {
			oneDomain = (Domain) domains.get(name);
			System.out.println("Name: " + oneDomain.getName());
			System.out.println("Code: " + oneDomain.getCode());
			System.out.println("Data Type: "+ oneDomain.getDataType());
			System.out.println("Length: " + oneDomain.getLength());
			System.out.println("Precision: " + oneDomain.getPrecision());
			
			standardChecks = oneDomain.getStandardChecks();
			values = standardChecks.getValues();
			System.out.println("Maximum: " + values.getMaximum());
			System.out.println("Minimum: " + values.getMinimum());
			System.out.println("Default: " + values.getDefaultValue());
			
			listOfValues = standardChecks.getListOfValues();
			for (int i = 0; i < listOfValues.size(); i++) {
				value = (Value) listOfValues.get(i);
				System.out.println("Value: " + value.getValue());
				System.out.println("Label: " + value.getLabel());
			}
		}
		
		/* get all tables */
		Tables tables = pdm.getTables();
		
		/* get all table names */
		String[] tableNames = tables.getNames();
		
		/* iterate all tables */
		Table table = null;
		Columns columns = null;
		String[] columnNames = null;
		Column column = null;
		Keys keys = null;
		String[] keyNames = null;
		@SuppressWarnings("unused")
		Key key = null;
		Indexes indexes = null;
		String[] indexNames = null;
		Index index = null;
		for (String name : tableNames) {
			table = (Table) tables.get(name);
			System.out.println("Name: " + table.getName());
			System.out.println("Code: " + table.getCode());
			System.out.println("Comment: " + table.getComment());
			
			/* get all columns */
			columns = table.getColumns();
			
			/* get all column names */
			columnNames = columns.getNames();
			
			/* iterate all columns */
			for (String columnName : columnNames) {
				column = (Column)columns.get(columnName);
				System.out.println("Name: " + column.getName());
				System.out.println("Code: " + column.getCode());
				System.out.println("Comment: " + column.getComment());
				System.out.println("Data Type: " + column.getDataType());
				System.out.println("Length: " + column.getLength());
				System.out.println("Precison: " + column.getPrecision());
				
				/* domain associate with the column test is omitted */
				
				/* standard checks with the column test is omitted */
			}
			
			/* get all keys */
			keys = table.getKeys();
			
			/* get all key names */
			keyNames = keys.getNames();
			
			/* iterate all keys */
			for (String keyName : keyNames) {
				key = (Key) keys.get(keyName);
				
				/* key test is omitted */
			}
			
			/* get all indexes */
			indexes = table.getIndexes();
			
			/* get all index names */
			indexNames = indexes.getNames();
			
			/* iterate all indexes */
			for (String indexName : indexNames) {
				index = (Index) indexes.get(indexName);
				System.out.println("Name: " + index.getName());
				System.out.println("Code: " + index.getCode());
				System.out.println("Comment: " + index.getComment());
				
				/* columns in the indexes are omitted */
			}
		}
		
	}
}
