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
package bingo.pd4j.pdm.internal;

import org.slf4j.Logger;

/**
 * <code>{@link LogUtil}</code>
 *
 * some log utils for logging.
 *
 * @author Calvin Chen
 */
public class LogUtil {
	public static final String INITIALLIZED_NAME_VALUE = "{} <{}> is initiallized.";
	public static final String INITIALLIZED_SIZE_LIST = "{} {} initiallized.";
	public static final String INITIALLIZED_NAME = "{} is initiallized.";
	public static final String LOADING_NAME_VALUE = "{} : \"{}\" is loading...";
	public static final String WARN_NO_INNER_LIST_NAME = "Warn: the object <{}> has no inner list! ";
	
	private String name;
	
	private String nameValue;
	
	private Logger log;
	
	private static LogUtil logUtil;
	
	public LogUtil thereIsA(String n){
		if(logUtil == null){
			logUtil = new LogUtil();
		}
		logUtil.name = n;
		return logUtil;
	}
	
	public static LogUtil sayTo(Logger log){
		if(logUtil == null){
			logUtil = new LogUtil();
		}
		logUtil.log = log;
		return logUtil;
	}
	
	public LogUtil called(String nameValue){
		if(logUtil == null){
			logUtil = new LogUtil();
		}
		logUtil.nameValue = nameValue;
		return logUtil;
	}
	
	public void initiallized(){
		if(logUtil == null){
			logUtil = new LogUtil();
		}
		logUtil.log.debug("{} <{}> is initiallized.", logUtil.name, logUtil.nameValue);
		nullAll();
	}

	private void nullAll() {
		logUtil = null;
	}
}
