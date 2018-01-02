//**********************************************************
//Assignment3:
//CDF user_name:c4zengzh
//
//Author:zengzhu
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//*********************************************************
package driver;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * HTML reads raw HTML directly from the give URL 
 */

public class HTML {
  /**
  read the raw HTLM content from given URL
   */ 
  public static String getHTML(String urlString) throws Exception {
    StringBuilder html = new StringBuilder();
    URL url = new File(urlString).toURI().toURL();
    BufferedReader htmlbr =
        new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    while ((line = htmlbr.readLine()) != null) {
      html.append(line);
    }
    htmlbr.close();
    return html.toString();
   }
  }
  
  


