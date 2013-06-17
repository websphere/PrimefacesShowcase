/*
 * Copyright 2011-2013 PrimeFaces Extensions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.primefaces.extensions.showcase.model.dynaform;

import java.io.Serializable;

/**
 * Condition
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
public class Condition implements Serializable {

	private String tableColumn;
	private int inputOffset;
	private String valueOperator;
	private String inputValue;
	private int index; // internal index in the list of all conditions

	public Condition() {
	}

	public Condition(String tableColumn, int inputOffset, String valueOperator, String inputValue, int index) {
		this.tableColumn = tableColumn;
		this.inputOffset = inputOffset;
		this.valueOperator = valueOperator;
		this.inputValue = inputValue;
		this.index = index;
	}

	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}

	public int getInputOffset() {
		return inputOffset;
	}

	public void setInputOffset(int inputOffset) {
		this.inputOffset = inputOffset;
	}

	public String getValueOperator() {
		return valueOperator;
	}

	public void setValueOperator(String valueOperator) {
		this.valueOperator = valueOperator;
	}

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Condition {"
		       + "tableColumn='" + tableColumn + '\''
		       + ", inputOffset=" + inputOffset
		       + ", valueOperator='" + valueOperator + '\''
		       + ", inputValue='" + inputValue + '\''
		       + '}';
	}
}
