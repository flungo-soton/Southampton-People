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

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Document page = null;
		try {
			page = Jsoup.connect("http://www.ecs.soton.ac.uk/people/dem").get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = getName(page);
		
		System.out.println(name);
	}
	
	private static String getName(Document document) {
		Elements h2s = document.getElementsByTag("h2");
		String h2Text = null;
		int i = 0;
		for (Element h2 : h2s) {
			if (i == 3)	h2Text = h2.text();
			i++;
		}
		
		return h2Text;
	}
}
