/*
 * Copyright 2011 PrimeFaces Extensions.
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

package org.primefaces.extensions.showcase.controller.layout;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.extensions.model.layout.LayoutOptions;

/**
 * LayoutController
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class ElementLayoutController implements Serializable {

	private static final long serialVersionUID = 20120925L;

	private String stateOne;
	private String stateTwo;
	private boolean layoutOneShown = true;

	private LayoutOptions layoutOptionsOne;
	private LayoutOptions layoutOptionsTwo;

	@PostConstruct
	protected void initialize() {
		// 1. set options for first layout
		layoutOptionsOne = new LayoutOptions();

		// options for all panes (center and west)
		LayoutOptions panes = new LayoutOptions();
		panes.addOption("slidable", false);
		panes.addOption("resizeWhileDragging", true);
		layoutOptionsOne.setPanesOptions(panes);

		// options for west pane
		LayoutOptions west = new LayoutOptions();
		west.addOption("size", 150);
		west.addOption("minSize", 40);
		west.addOption("maxSize", 300);
		layoutOptionsOne.setWestOptions(west);

		// 2. set options for second layout
		layoutOptionsTwo = new LayoutOptions();

		// options for all panes
		panes = new LayoutOptions();
		panes.addOption("slidable", false);
		panes.addOption("resizeWhileDragging", true);
		layoutOptionsTwo.setPanesOptions(panes);

		// options for east pane
		LayoutOptions east = new LayoutOptions();
		panes.addOption("resizable", false);
		panes.addOption("closable", false);
		east.addOption("size", "50%");
		layoutOptionsTwo.setEastOptions(east);

		// options for nested east layout
		LayoutOptions childEastOptions = new LayoutOptions();
		east.setChildOptions(childEastOptions);

		// options for east-south pane
		LayoutOptions eastSouth = new LayoutOptions();
		eastSouth.addOption("size", "50%");
		childEastOptions.setSouthOptions(eastSouth);
	}

	public String getStateOne() {
		return stateOne;
	}

	public void setStateOne(String stateOne) {
		this.stateOne = stateOne;
	}

	public String getStateTwo() {
		return stateTwo;
	}

	public void setStateTwo(String stateTwo) {
		this.stateTwo = stateTwo;
	}

	public void toogleLayout(ActionEvent event) {
		layoutOneShown = !layoutOneShown;
	}

	public boolean isLayoutOneShown() {
		return layoutOneShown;
	}

	public LayoutOptions getLayoutOptionsOne() {
		return layoutOptionsOne;
	}

	public LayoutOptions getLayoutOptionsTwo() {
		return layoutOptionsTwo;
	}
}
