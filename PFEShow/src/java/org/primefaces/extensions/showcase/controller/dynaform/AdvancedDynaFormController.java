/*
 * Copyright 2011-2012 PrimeFaces Extensions.
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
 *
 * $Id$
 */

package org.primefaces.extensions.showcase.controller.dynaform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.primefaces.extensions.showcase.model.dynaform.InventoryProperty;

/**
 * AdvancedDynaFormController
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class AdvancedDynaFormController implements Serializable {

	private static final long serialVersionUID = 20120423L;

	private DynaFormModel model;

	@PostConstruct
	protected void initialize() {
		model = new DynaFormModel();

		// add rows, labels and editable controls
		// set relationship between label and editable controls to support outputLabel with "for" attribute

		// 1. regular row
		DynaFormRow row = model.createRegularRow();

		DynaFormLabel label11 = row.addLabel("Ref. No. 1", 1, 1);
		DynaFormControl control12 = row.addControl(new InventoryProperty("(1,2)", false), "input", 1, 1);
		label11.setForControl(control12);

		DynaFormLabel label13 = row.addLabel("Ref. No. 2", 1, 1);
		DynaFormControl control14 = row.addControl(new InventoryProperty("(1,4)", false), "input", 1, 1);
		label13.setForControl(control14);

		DynaFormLabel label15 = row.addLabel("Ref. No. 3", 1, 1);
		DynaFormControl control16 = row.addControl(new InventoryProperty("(1,6)", false), "input", 1, 1);
		label15.setForControl(control16);

		// 2. regular row
		row = model.createRegularRow();

		DynaFormLabel label21 = row.addLabel("Ref. No. 4", 1, 1);
		DynaFormControl control22 = row.addControl(new InventoryProperty("(2,2)", false), "input", 1, 1);
		label21.setForControl(control22);

		DynaFormLabel label23 = row.addLabel("Ref. No. 5 (this field requires any not empty input)", 3, 1);
		DynaFormControl control24 = row.addControl(new InventoryProperty("(2,4)", "555-555", true), "input", 1, 1);
		label23.setForControl(control24);

		// 3. regular row
		row = model.createRegularRow();

		DynaFormLabel label31 = row.addLabel("Date from", 1, 1);
		DynaFormControl control32 = row.addControl(new InventoryProperty("(3,2)", false), "date", 1, 1);
		label31.setForControl(control32);

		DynaFormLabel label33 = row.addLabel("Date till", 1, 1);
		DynaFormControl control34 = row.addControl(new InventoryProperty("(3,4)", false), "date", 1, 1);
		label33.setForControl(control34);

		DynaFormLabel label35 = row.addLabel("Expiry", 1, 1);
		DynaFormControl control36 = row.addControl(new InventoryProperty("(3,6)", new Date(), true), "date", 1, 1);
		label35.setForControl(control36);

		// 1. extended row
		row = model.createExtendedRow();

		row.addControl("Ref. No. 6", 1, 1);
		row.addControl(new InventoryProperty("(4,2)", false), "input", 1, 1);

		row.addControl("Ref. No. 7", 1, 1);
		row.addControl(new InventoryProperty("(4,4)", false), "input", 1, 1);

		row.addControl("Ref. No. 8", 1, 1);
		row.addControl(new InventoryProperty("(4,6)", false), "input", 1, 1);

		// 2. extended row
		row = model.createExtendedRow();

		row.addControl("Advanced inventory description", 2, 1);
		row.addControl(new InventoryProperty("(5,2)", false), "desc", 4, 1);
	}

	public DynaFormModel getModel() {
		return model;
	}

	public List<InventoryProperty> getInventoryProperties() {
		if (model == null) {
			return null;
		}

		List<InventoryProperty> inventoryProperties = new ArrayList<InventoryProperty>();
		for (DynaFormControl dynaFormControl : model.getControls()) {
			if (dynaFormControl.getData() instanceof InventoryProperty) {
				inventoryProperties.add((InventoryProperty) dynaFormControl.getData());
			}
		}

		return inventoryProperties;
	}

	public String submitForm() {
		FacesMessage.Severity sev = FacesContext.getCurrentInstance().getMaximumSeverity();
		boolean hasErrors = (sev != null && (FacesMessage.SEVERITY_ERROR.compareTo(sev) >= 0));

		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.addCallbackParam("isValid", !hasErrors);

		return null;
	}
}
