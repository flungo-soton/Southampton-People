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
	
	String Name;
	String OU;
	String ON;
	String Adr;
	String Role;
	String Tel;
	String Email;
	
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
		if (Name.isEmpty()) {
			Elements h2 = content.getElementsByTag("h2");
			Name = h2.text();
			return Name;
		} else {
			return Name;
		}
	}
	
	public String getOU() throws NullPointerException {
		if (OU.isEmpty()) {
			Elements h2 = content.getElementsByClass("organization-unit");
			OU = h2.text();
			return OU;
		} else {
			return OU;
		}
	}
	
	public String getON() throws NullPointerException {
		if (ON.isEmpty()) {
			Elements h2 = content.getElementsByClass("organization-name");
			ON = h2.text();
			return ON;
		} else {
			return ON;
		}
	}
	
	public String getAdr() throws NullPointerException {
		if (Adr.isEmpty()) {
			Elements h2 = content.getElementsByClass("adr");
			Adr = h2.text();
			return Adr;
		} else {
			return Adr;
		}
	}
	
	public String getRole() throws NullPointerException {
		if (Role.isEmpty()) {
			Elements h2 = content.getElementsByClass("role");
			Role = h2.text();
			return Role;
		} else {
			return Role;
		}
	}
	
	public String getTel() throws NullPointerException {
		if (Tel.isEmpty()) {
			Elements h2 = content.getElementsByClass("tel");
			Tel = h2.text();
			return Tel;
		} else {
			return Tel;
		}
	}
	
	public String getEmail() throws NullPointerException {
		if (Email.isEmpty()) {
			Elements h2 = content.getElementsByClass("email");
			Email = h2.text();
			return Email;
		} else {
			return Email;
		}
	}
}
