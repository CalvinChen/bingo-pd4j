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
package bingo.pd4j.pdm.model.api;

import java.util.List;


/**
 * <code>{@link ListWithItemName}</code>
 *
 * @author Calvin Chen
 */
public interface ListWithItemName<E> extends List<E>{

	String[] getNames();
	
	E get(String name);
	
}
