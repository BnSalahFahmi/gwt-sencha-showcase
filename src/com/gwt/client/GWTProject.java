package com.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel.AnimationType;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.client.resource.Ressource;
import com.sencha.gxt.core.client.Style.Side;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTProject implements EntryPoint {
	
	public interface ImageXTemplate extends XTemplates {
	    @XTemplate("<img style=\"border: 2px solid red; width: 25px;\" src=\"{url}\">")
	    SafeHtml createImage(String url);
	  }

	private Ressource resource = GWT.create(Ressource.class);
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private static final int COLUMN_FORM_WIDTH = 700;
	
	protected static final int MIN_HEIGHT = 480;
	protected static final int MIN_WIDTH = 640;
	
	private VerticalPanel vp;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		InitComponents();
	}

	private void InitComponents() {
		Widget con = asWidget();
		Viewport viewport = new Viewport();
		viewport.add(con);
		RootPanel.get().setHeight(Window.getClientHeight()+"px");
		RootPanel.get().setWidth(Window.getClientWidth()+"px");
		RootPanel.get().add(viewport);
	}

	public Widget asWidget() {
		// Build the app's principal widget
		final ContentPanel panel = new ContentPanel();
		final ContentPanel center = new ContentPanel();
		ContentPanel north = new ContentPanel();
		ContentPanel west = new ContentPanel();
		
		//Build the north content
		Image img = new Image(resource.logoApp());
		img.addStyleName("imgLogo");
		north.setHeaderVisible(false);
		HorizontalPanel hp = new HorizontalPanel();
		Label gwtDescription= new Label("Pronounced \"gwit\"");
		gwtDescription.getElement().setClassName("gwtDescription");
		Label usrAcc= new HTML("<b>fahmii.bensalah@gmail.com</b>");
		HTML text= new HTML("&nbsp;|&nbsp;");
		usrAcc.setStyleName("usrAcc");
		Anchor githubLink = new Anchor();
		githubLink.setTarget("_blank");
		githubLink.setHTML("<img src='images/git.png' style='cursor: pointer;width: 25px;'/>");
		githubLink.setHref("https://github.com/BnSalahFahmi/GWT.git");
		githubLink.setStyleName("githubLink");
		hp.add(usrAcc);
		hp.add(text);
		hp.add(githubLink);
		ContentPanel chp = new ContentPanel();
		chp.setHeaderVisible(false);
		chp.setBodyBorder(false);
		chp.add(hp);
		chp.setStyleName("northDataContainer");
		ToolTipConfig config = new ToolTipConfig();
		config.setTitleHtml("Information");
		config.setBodyHtml("hey contact me for any information :)");
		config.setAnchor(Side.TOP);
		chp.setToolTipConfig(config);
		HorizontalPanel northPanel = new HorizontalPanel();
		northPanel.add(img);
		northPanel.add(gwtDescription);
		northPanel.add(chp);
		north.add(northPanel);

		//Build the west content
		FlowPanel westFP = new FlowPanel();
		SideBarMenuScreen menu = new SideBarMenuScreen();
		westFP.add(menu);
		west.setHeadingHtml("GWT UI Widgets");
		west.getHeader().addStyleName("centerHeader");
		west.add(westFP);
		//Build the center content
		center.setHeaderVisible(false);
		center.getHeader().addStyleName("centerHeader");
		ToolBar toolBar= new ToolBar();
		TextButton dashboard = new TextButton();
		dashboard.setIcon(resource.home());
		dashboard.setText("Dashboard");
		
		TextButton GXTDoc = new TextButton();
		GXTDoc.setIcon(resource.doc());
		GXTDoc.setText("GWT Documentation");
		
		TextButton useLinks = new TextButton();
		useLinks.setIcon(resource.link());
		useLinks.setText("Usefal Links");
		
		TextButton graph = new TextButton();
		graph.setIcon(resource.stat());
		graph.setText("GWT vs Others");
		
		TextButton about = new TextButton();
		about.setIcon(resource.about());
		about.setText("About GWT");
		
		TextButton frameworks = new TextButton();
		frameworks.setIcon(resource.framework());
		frameworks.setText("Frameworks based on GWT");
		
		TextButton help = new TextButton();
		help.setIcon(resource.help());
		help.setText("About This App");
		help.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				final DialogBox dialog=new DialogBox();
				dialog.setGlassEnabled(true);
				dialog.setAnimationEnabled(true);
				dialog.setTitle("Help - About This App");
				dialog.setText("Help - About This App");
				dialog.setSize("600", "300");
				dialog.center();
				VerticalPanel vp = new VerticalPanel();
				HTML msg = new HTML(
						"<b>Technologies used to build this application are</b> :              <br> <ul><li>Google web toolkit</li><li>Sencha GXT</li><li>Google DataStore</li><li>Objectify</li></ul>");
			    DockPanel dock = new DockPanel();
			    dock.setSpacing(4);
			    TextButton btnOk = new TextButton("Ok");
			    btnOk.setWidth(100);
			    dock.add(btnOk, DockPanel.SOUTH);
			    dock.add(msg, DockPanel.NORTH);
			    dock.setCellHorizontalAlignment(btnOk, DockPanel.ALIGN_RIGHT);
			    dock.setWidth("100%");
				
				btnOk.setStyleName("btnOk");
				btnOk.addSelectHandler(new SelectHandler() {
					
					@Override
					public void onSelect(SelectEvent event) {
						dialog.hide();					
					}
				});
				dialog.setAnimationType(AnimationType.ONE_WAY_CORNER);
				dialog.add(dock);
				dialog.show();
			}
		});
		
		toolBar.add(dashboard);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(about);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(GXTDoc);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(graph);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(frameworks);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(useLinks);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(help);
		
		final VerticalLayoutContainer vc = new VerticalLayoutContainer();
		final ContentPanel centerLC = new ContentPanel();
		//centerLC.setHeadingText("Top 4 Java Web Frameworks Revealed");
		centerLC.setLayoutData(new VerticalLayoutData(1, 1));
		vc.add(toolBar);
		DashboardScreen screenDash = new DashboardScreen();
		centerLC.add(screenDash.asWidget());
		vc.add(centerLC);
		center.add(vc);
		final BorderLayoutContainer con = new BorderLayoutContainer();
		BorderLayoutData northData = new BorderLayoutData(90);
		northData.setMargins(new Margins(5));
		northData.setCollapsible(true);
		northData.setSplit(true);
		// toolBar Items events
		dashboard.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				centerLC.clear();
				DashboardScreen screenDash = new DashboardScreen();
				centerLC.add(screenDash.asWidget());
				
			}
		});

		GXTDoc.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				
			}
		});
		
		useLinks.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				
			}
		});
		
		graph.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				
				
			}
		});

	about.addSelectHandler(new SelectHandler() {
	
	@Override
	public void onSelect(SelectEvent event) {
		
		
	}
	});

		BorderLayoutData westData = new BorderLayoutData(250);
		westData.setCollapsible(true);
		westData.setCollapseMini(true);
		westData.setMargins(new Margins(0, 5, 0, 5));
		con.setId("pcontainer");
	
		MarginData centerData = new MarginData();

		con.setNorthWidget(north, northData);
		con.setWestWidget(west, westData);
		con.setCenterWidget(center, centerData);
		
		SimpleContainer simple = new SimpleContainer();
		simple.add(con, new MarginData(0, 20, 20, 0));
		
		return simple;
	}
	
}
