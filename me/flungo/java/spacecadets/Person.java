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
	
	Person(String id) {
		try {
			page = Jsoup.connect("http://www.ecs.soton.ac.uk/people/" + id).get();
			content = page.getElementById("node-78");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public String getName() throws NullPointerException {
		Elements h2 = content.getElementsByTag("h2");
		
		return h2.text();
	}
}
