package com.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.shared.Data;
import com.gwt.shared.TestData;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.axis.CategoryAxis;
import com.sencha.gxt.chart.client.chart.axis.NumericAxis;
import com.sencha.gxt.chart.client.chart.series.BarSeries;
import com.sencha.gxt.chart.client.chart.series.SeriesLabelConfig;
import com.sencha.gxt.chart.client.chart.series.SeriesRenderer;
import com.sencha.gxt.chart.client.draw.Color;
import com.sencha.gxt.chart.client.draw.Gradient;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.path.PathSprite;
import com.sencha.gxt.chart.client.draw.sprite.Sprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextAnchor;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextBaseline;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.fx.client.easing.BounceOut;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class FrameworksChart implements IsWidget{
	
	public interface DataPropertyAccess extends PropertyAccess<Data> {
		ValueProvider<Data, Double> data1();

		ValueProvider<Data, String> name();

		@Path("name")
		ModelKeyProvider<Data> nameKey();
	}

    private static final DataPropertyAccess dataAccess = GWT.create(DataPropertyAccess.class);

	@Override
	public Widget asWidget() {
		final ListStore<Data> store = new ListStore<Data>(dataAccess.nameKey());
	 
	    final Chart<Data> chart = new Chart<Data>();
	    chart.setBackground(new RGB(255,255,255));
	    chart.setAnimationDuration(750);
	    chart.setAnimationEasing(new BounceOut());
	    chart.setShadowChart(true);
	 
	    chart.getElement().setClassName("chart");
	    chart.getElement().setMargins(new Margins(-150, 0, 0, 0));
	    store.addAll(TestData.getData(8, 10, 50));
	    chart.setStore(store);
	 
	    NumericAxis<Data> axis = new NumericAxis<Data>();
	    axis.setPosition(Position.LEFT);
	    axis.addField(dataAccess.data1());
	    PathSprite grid = new PathSprite();
	    grid.setStroke(RGB.BLACK);
	    axis.setGridDefaultConfig(grid);
	    TextSprite title = new TextSprite("Usage Percentage");
	    title.setFontSize(14);
	    title.setFill(RGB.BLACK);
	    axis.setTitleConfig(title);
	    axis.setDisplayGrid(true);
	    PathSprite white = new PathSprite();
	    white.setStroke(RGB.BLACK);
	    axis.setAxisConfig(white);
	    TextSprite whiteText = new TextSprite();
	    whiteText.setFill(RGB.BLACK);
	    whiteText.setTextBaseline(TextBaseline.MIDDLE);
	    axis.setLabelConfig(whiteText);
	    axis.setMinimum(0);
	    axis.setMaximum(100);
	    chart.addAxis(axis);
	 
	    CategoryAxis<Data, String> catAxis = new CategoryAxis<Data, String>();
	    catAxis.setPosition(Position.BOTTOM);
	    catAxis.setField(dataAccess.name());
	    catAxis.setAxisConfig(white);
	    whiteText = whiteText.copy();
	    whiteText.setTextAnchor(TextAnchor.MIDDLE);
	    catAxis.setLabelConfig(whiteText);
	    chart.addAxis(catAxis);
	 
	    Gradient grad1 = new Gradient("v-1", 0);
	    grad1.addStop(0, new RGB(212, 40, 40));
	    grad1.addStop(100, new RGB(117, 14, 14));
	    chart.addGradient(grad1);
	    Gradient grad2 = new Gradient("v-2", 0);
	    grad2.addStop(0, new RGB(180, 216, 42));
	    grad2.addStop(100, new RGB(94, 114, 13));
	    chart.addGradient(grad2);
	    Gradient grad3 = new Gradient("v-3", 0);
	    grad3.addStop(0, new RGB(43, 221, 115));
	    grad3.addStop(100, new RGB(14, 117, 56));
	    chart.addGradient(grad3);
	    Gradient grad4 = new Gradient("v-4", 0);
	    grad4.addStop(0, new RGB(45, 117, 226));
	    grad4.addStop(100, new RGB(14, 56, 117));
	    chart.addGradient(grad4);
	    Gradient grad5 = new Gradient("v-5", 0);
	    grad5.addStop(0, new RGB(187, 45, 222));
	    grad5.addStop(100, new RGB(85, 10, 103));
	    chart.addGradient(grad5);
	 
	    final Color[] colors = {grad1, grad2, grad3, grad4, grad5};
	 
	    final BarSeries<Data> column = new BarSeries<Data>();
	    column.setYAxisPosition(Position.LEFT);
	    column.addYField(dataAccess.data1());
	    TextSprite sprite = new TextSprite();
	    sprite.setFill(RGB.BLACK);
	    sprite.setFontSize(14);
	    sprite.setTextAnchor(TextAnchor.MIDDLE);
	    SeriesLabelConfig<Data> labelConfig = new SeriesLabelConfig<Data>();
	    labelConfig.setSpriteConfig(sprite);
	    column.setLabelConfig(labelConfig);
	    column.setColumn(true);
	    column.setHighlighting(true);
	    column.setRenderer(new SeriesRenderer<Data>() {
	      @Override
	      public void spriteRenderer(Sprite sprite, int index, ListStore<Data> store) {
	        sprite.setFill(colors[index % colors.length]);
	        sprite.redraw();
	      }
	    });

	    chart.addSeries(column);
	     
	    ContentPanel panel = new FramedPanel();
	    panel.getElement().getStyle().setMargin(10, Unit.PX);
	    panel.setCollapsible(true);
	    panel.setHeadingText("Column Renderer Chart");
	    panel.setPixelSize(320, 220);
	    panel.setBodyBorder(true);
	     
	    new Draggable(panel, panel.getHeader()).setUseProxy(false);
	 
	    VerticalLayoutContainer layout = new VerticalLayoutContainer();
	    panel.add(layout);
	
	    chart.setLayoutData(new VerticalLayoutData(1, 1));
	    layout.add(chart);
	 
	    return panel;
	}

}
