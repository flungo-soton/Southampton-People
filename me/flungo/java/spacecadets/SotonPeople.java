/*
 * Developer: Fabrizio Lungo <fab@lungo.co.uk>
 * Copyright: All rights reserved by Fabrizio Lungo.
 */
package me.flungo.java.spacecadets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Fabrizio
 */
public class SotonPeople {
		
	protected static Person person;
	
	public static void main(String[] args) {
		System.out.print("Enter the id of the person you are searching for: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String id = null;
		
		try {
		   id = br.readLine();
		   
			try {
				person = new Person(id);
				SotonPeople sp = new SotonPeople();
				sp.menu();
			} catch (NullPointerException e) {
				System.out.println("Could not find anyone with the user id " + id + ". Please try again");
				main(args);
			}
			
		} catch (IOException ioe) {
		   System.out.println("Error trying to read the id you entered");
		   System.exit(1);
		}
	}
	
	private void menu() {
		System.out.println("\n\nWhat would you like to know: \n"
				+ "1: Name\n"
				+ "2: Organisational Unit (Department)\n");
		
		System.out.print("Enter the number of your choice: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = null;
		
		try {
			input = br.readLine();
			try {
				int cmd = Integer.parseInt(input);
				switch (cmd) {
					case 1:
						getName();
						break;
					case 2:
						getOU();
						break;
					case 9:
						exit();
						break;
					default:
						System.out.println("That number is not an acceptable choice");
						break;
				}
			} catch (NumberFormatException e) {
				System.out.println("That isn't a valid number");
			}
		} catch (IOException ioe) {
			System.out.println("IO error reading your entry");
		}
		backToMenu();
	}
	
	protected void backToMenu() {
		System.out.println("Would you like to return to the menu? (Y/N)");
		menu();
	}
	
	protected void getName() {
		String name = person.getName();
		
		System.out.println(name);
	}
	
	protected void getOU() {
		String OU = person.getOU();
		
		System.out.println(OU);
	}
	
	protected void exit() {
		System.out.println("Thank you for using Soton People");
		System.exit(0);
	}
}
