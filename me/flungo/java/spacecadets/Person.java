/*
 * Developer: Fabrizio Lungo <fab@lungo.co.uk>
 * Copyright: All rights reserved by Fabrizio Lungo.
 */
package me.flungo.java.spacecadets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Fabrizio
 */
public class Person {
	
	Document page;
	
	Element content;
	
	String name;
	String OU;
	
	Person(String id) throws NullPointerException {
		try {
			page = Jsoup.connect("http://www.ecs.soton.ac.uk/people/" + id).get();
			content = page.getElementById("node-78");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (content.getElementsByTag("p").text().startsWith("This page either does not exist or you are not able to view it.")) {
			throw new NullPointerException();
		}
	}
		
	public String getName() throws NullPointerException {
		if (name.isEmpty()) {
			Elements h2 = content.getElementsByTag("h2");
			return h2.text();
		} else {
			return name;
		}
	}
	
	public String getOU() throws NullPointerException {
		if (OU.isEmpty()) {
			Elements h2 = content.getElementsByClass("organization-unit");
			return h2.text();
		} else {
			return OU;
		}
	}
}
