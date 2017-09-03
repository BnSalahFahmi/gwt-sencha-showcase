package com.gwt.shared;

import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore; 

public class Treednd {
	
	public static TreeStore<String> getMenuStore(){
		TreeStore<String> store = new TreeStore<String>(new ModelKeyProvider<String>() {
			@Override
			public String getKey(String item) {
				return item;
			}
		});
		store.add("Actions");
		store.add("Actions", "Buttons");
		store.add("Actions", "Icon Buttons");
		store.add("Text Entry");
		store.add("Text Entry", "Basic Text");
		store.add("Text Entry", "Rich Text");
		store.add("Grids");
		store.add("Grids","Basic Grid");
		store.add("Grids","Flexible Grid");
		store.add("Grids","Paging Grid");
		store.add("Forms");
		store.add("Forms","Combo Box");
		store.add("Forms","Date Picker");
		store.add("Forms","File Upload");
		store.add("Forms","Dual List");
		store.add("Layouts");
		store.add("Layouts","Horizontal Layout");
		store.add("Layouts","Vertical Layout");
		store.add("Layouts","Border Layout");
		store.add("Layouts","Center Layout");
		store.add("Tabs");
		store.add("Tabs","Basic Tabs");
		store.add("Tabs","Advanced Tabs");
		store.add("Tool Bar & Menu");
		store.add("Tool Bar & Menu","Tool Bar");
		store.add("Tool Bar & Menu","Menu Bar");
		store.add("Templates & Lists");
		store.add("Templates & Lists","List View");
		store.add("Templates & Lists","Template");
		store.add("Windows");
		store.add("Windows","Dialog");
		store.add("Windows","Message Box");
		store.add("Other features");
		store.add("Other features","Animations");
		return store;
		
	}
	
}
