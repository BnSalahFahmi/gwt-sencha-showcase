package com.gwt.client;

import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.client.resource.Ressource;
import com.gwt.shared.Treednd;
import com.sencha.gxt.cell.core.client.SimpleSafeHtmlCell;
import com.sencha.gxt.core.client.ToStringValueProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.dnd.core.client.TreeDragSource;
import com.sencha.gxt.dnd.core.client.TreeDropTarget;
import com.sencha.gxt.dnd.core.client.DND.Feedback;
import com.sencha.gxt.dnd.core.client.DND.Operation;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.BlurEvent;
import com.sencha.gxt.widget.core.client.event.BlurEvent.BlurHandler;
import com.sencha.gxt.widget.core.client.event.CheckChangeEvent;
import com.sencha.gxt.widget.core.client.event.CheckChangeEvent.CheckChangeHandler;
import com.sencha.gxt.widget.core.client.form.StoreFilterField;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.tree.Tree;

public class SideBarMenuScreen implements IsWidget{
	
	private static Ressource resource = GWT.create(Ressource.class);

	@Override
	public Widget asWidget() {
		TreeStore<String> store = Treednd.getMenuStore();
		StoreFilterField<String> filter = new StoreFilterField<String>() {
			protected boolean doSelect(com.sencha.gxt.data.shared.Store<String> store, String parent, String item,
					String filter) {
				if(item.toLowerCase().contains(filter.toLowerCase())){
					return true;
				}
				return false;

			};
		};
		filter.bind(store);
		filter.getElement().setClassName("menuFilter");
		filter.setWidth(250);
		Tree<String, String> tree = new Tree<String, String>(store, new ToStringValueProvider<String>());
		tree.getElement().setClassName("menuTree");
		tree.getElement().setPropertyString("overflow", "hidden");
		SimpleSafeHtmlCell<String> cell = new SimpleSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance(), "click","touchend"){
			@Override
			public void onBrowserEvent(com.google.gwt.cell.client.Cell.Context context, Element parent, String value,
					NativeEvent event, ValueUpdater<String> valueUpdater) {
				if("touchend".equals(event.getType())||"click".equals(event.getType())){
					openAppropriatedScreen(value);				
				}
			}

			private void openAppropriatedScreen(String value) {
				switch (value) {
				case "Buttons":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Icon Buttons":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Pie Chart":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Line Chart":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Column Chart":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Radar Chart":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Basic Grid":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Paging Grid":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Filter Grid":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Combo Box":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Date Picker":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "File Upload":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Dual List":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "List to List":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Grid to Grid":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Horizontal Layout":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Vertical Layout":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Border Layout":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Center Layout":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Css Float Layout":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Logos":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Basic Tabs":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Advanced Tabs":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Tool Bar":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Menu Bar":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "List View":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Template":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Dialog":
					Info.display("Implementation", "Not implemented yet !");
					break;
				case "Message Box":
					Info.display("Implementation", "Not implemented yet !");
					break;
				}
			}
		};
		tree.setCell(cell);
		tree.getStyle().setLeafIcon(resource.listItem());
//		TreeDragSource<String> source = new TreeDragSource<String>(tree);
//		TreeDropTarget<String> target = new TreeDropTarget<String>(tree);
//		target.setAllowSelfAsSource(true);
//		target.setFeedback(Feedback.BOTH);
//		target.setOperation(Operation.MOVE);
		tree.setShadow(true);
		
		ButtonBar searchArea = new ButtonBar();
		filter.setEmptyText("Filter ...");
		searchArea.add(filter);
		searchArea.getElement().setClassName("searchArea");
		searchArea.setLayoutData(new MarginData(4));
		tree.getElement().getStyle().setOverflow(Overflow.HIDDEN);
		VerticalLayoutContainer vc = new VerticalLayoutContainer();
		vc.add(searchArea);
		vc.add(tree);
		return vc;
	}

}
