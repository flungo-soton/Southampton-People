/*
 * Developer: Fabrizio Lungo <fab@lungo.co.uk>
 * Copyright: All rights reserved by Fabrizio Lungo.
 */
package me.flungo.java.spacecadets;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Node;

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
		URL url = null;
		try {
			url = new URL("http://www.ecs.soton.ac.uk/people/dem");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String page = null;
		try {
			page = readPage(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = getName(page);
		
		System.out.println(name);
	}
	
	private static String getName(String in) {
		Document document = Jsoup.parse(in);
		Elements h2s = document.getElementsByTag("h2");
		String h2Text = null;
		int i = 0;
		for (Element h2 : h2s) {
			if (i == 3)	h2Text = h2.text();
			i++;
		}
		
		return h2Text;
	}
	
	private static String readPage(URL url) throws Exception {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url.toURI());
        HttpResponse response = client.execute(request);

        Reader reader = null;
        try {
            reader = new InputStreamReader(response.getEntity().getContent());

            StringBuilder sb = new StringBuilder();
            {
                int read;
                char[] cbuf = new char[1024];
                while ((read = reader.read(cbuf)) != -1) {
                    sb.append(cbuf, 0, read);
				}
            }

            return sb.toString();

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
