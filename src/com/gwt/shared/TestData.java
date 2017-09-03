package com.gwt.shared;

import java.util.ArrayList;
import java.util.List;

import com.gwt.shared.Data;

public class TestData {

	  private static final String[] monthsAbbreviated = new String[] {
	      "Spring MVC", "JSF", "Struts", "GWT", "Grails", "Vaadin", "Play", "Wicket"};

	  private static final String[] monthsFull = new String[] {
	      "Spring MVC", "JSF", "Struts", "GWT", "Grails", "Vaadin", "Play", "Wicket"};
	  private static final Double[] per = new Double[] {
		      30.0, 23.0, 17.0, 14.0, 7.0, 7.0, 8.0, 7.0};

	  public static List<Data> getData(int size, double min, double scale) {
	    List<Data> data = new ArrayList<Data>();
	    for (int i = 0; i < size; i++) {
	      data.add(new Data(monthsFull[i], per[i], per[i],
	    		  per[i], per[i], per[i],
	    		  per[i], per[i], per[i],
	    		  per[i],monthsFull[i]));
	    }
	    return data;
	  }
	  
	  public static List<Data> getPerData(int size, double min, double scale) {
		    List<Data> data = new ArrayList<Data>();
		    for (int i = 0; i < size; i++) {
		      data.add(new Data(monthsFull[i % monthsFull.length], per[i], Math.floor(Math.max(Math.random() * scale, min)),
		          Math.floor(Math.max(Math.random() * scale, min)), Math.floor(Math.max(Math.random() * scale, min)), Math.floor(Math.max(Math.random() * scale, min)),
		          Math.floor(Math.max(Math.random() * scale, min)), Math.floor(Math.max(Math.random() * scale, min)), Math.floor(Math.max(Math.random() * scale, min)),
		          Math.floor(Math.max(Math.random() * scale, min)),monthsFull[i % monthsFull.length]));
		    }
		    return data;
		  }
	  
	  public static List<Data> getDataNegative(int size, double min, double scale) {
	    List<Data> data = new ArrayList<Data>();
	    for (int i = 0; i < size; i++) {
	      data.add(new Data(monthsFull[i % size], Math.floor(Math.min(Math.random() * scale, min)), Math.floor(Math.min(Math.random() * scale, min)),
	          Math.floor(Math.min(Math.random() * scale, min)), Math.floor(Math.min(Math.random() * scale, min)), Math.floor(Math.min(Math.random() * scale, min)),
	          Math.floor(Math.min(Math.random() * scale, min)), Math.floor(Math.min(Math.random() * scale, min)), Math.floor(Math.min(Math.random() * scale, min)),
	          Math.floor(Math.min(Math.random() * scale, min)),monthsFull[i % monthsFull.length]));
	    }
	    return data;
	  }

	  public static String[] getMonths() {
	    return monthsAbbreviated;
	  }

	  public static String[] getShortMonths(int n) {
	    String[] mths = new String[n];
	    for (int c = 0; c < n; c++)
	      mths[c] = monthsAbbreviated[c];
	    return mths;
	  }
 

	}
