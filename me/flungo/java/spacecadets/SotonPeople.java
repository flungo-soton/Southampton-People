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
public class SotonPeople {
	
	public static void main(String[] args) {
		Person person = new Person("dem");
		
		String name = person.getName();
		
		System.out.println(name);
	}
}
