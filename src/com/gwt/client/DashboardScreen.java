package com.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.client.resource.Ressource;
import com.gwt.shared.Data;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldSet;

public class DashboardScreen implements IsWidget{
	
	private Ressource resource = GWT.create(Ressource.class);

	private static final DataPropertyAccess dataAccess = GWT.create(DataPropertyAccess.class); 
	
	public interface DataPropertyAccess extends PropertyAccess<Data> {
		ValueProvider<Data, Double> data1();

		ValueProvider<Data, String> name();

		@Path("id")
		ModelKeyProvider<Data> nameKey();
	}
	
	@Override
	public Widget asWidget() {

		FieldSet aboutgwt = new FieldSet();
		aboutgwt.setHeadingHtml("Overview");
		Label about = new Label("Google web toolkit is a development toolkit for building and optimizing complex browser-based applications. Its goal is to enable productive development of high-performance web applications without the developer having to be an expert in browser quirks,"+ 
				"XMLHttpRequest, and JavaScript, GWT is used by many products at Google, open source, completely free, and used by thousands of developers around the world.");
		aboutgwt.add(about);
		ContentPanel con = new ContentPanel();
		ContentPanel cp = new ContentPanel();
		cp.getElement().getStyle().setMargin(10, Unit.PX);
		cp.setCollapsible(true);
		cp.setBodyStyleName("pad-text");
		cp.setHeadingHtml("More Informations");

		VerticalLayoutContainer layoutVC = new VerticalLayoutContainer();
		FieldSet gwt = new FieldSet();
		gwt.setHeadingHtml("GWT ?");
		Label lb = new Label("You are a java developper, you hate javascript and you  want to build complex web apps ==> the solution is GWT");
		gwt.add(lb);
		
		FieldSet advice = new FieldSet();
		advice.setHeadingHtml("Advice");
		Label lb2 = new Label("If you haven't played with GWT in a while, now is the time to start paying attention");
		advice.add(lb2);
		
		FieldSet widgets = new FieldSet();
		widgets.setHeadingHtml("GWT Widget Library");
		Label lb3 = new Label("If you want more widgets, you can use one of the following libraries that are based on gwt: Sencha GXT "
		+", Smart GWT, Vaadin, GWTMaterialDesign, ...");
		widgets.add(lb3);
		
		FieldSet linkGit = new FieldSet();
		linkGit.setHeadingHtml("Source Code");
		VerticalPanel sourcePanel = new VerticalPanel();
		HTML sourceTxt = new HTML("Source code is hosted on github :");
		Anchor sourceLink = new Anchor("Click here");
		sourceLink.setHref("https://github.com/BnSalahFahmi/GWT.git");
		sourceLink.setTarget("_blank");
		sourcePanel.add(sourceTxt);
		sourcePanel.add(sourceLink);
		linkGit.add(sourcePanel);
		
		layoutVC.add(gwt);
		layoutVC.add(advice);
		layoutVC.add(widgets);
		layoutVC.add(linkGit);
		
		cp.add(layoutVC);

		HorizontalLayoutContainer centerPanel = new HorizontalLayoutContainer();
		centerPanel.add(cp, new HorizontalLayoutData(0.5, 1));
		FrameworksChart data = new FrameworksChart();
		centerPanel.add(data.asWidget(), new HorizontalLayoutData(0.5, 1));
		centerPanel.getElement().setPadding(new Padding(2));
		
		VerticalLayoutContainer horcon = new VerticalLayoutContainer();
		horcon.add(aboutgwt);
		horcon.add(centerPanel);

		return horcon;
	
	
	}

}
