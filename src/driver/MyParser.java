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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/**
 * a web scrapper for Google Scholar pages. It read a list of 
 * Google Scholar URL’S, extract specific information and return 
 * the some information. 
 */

public class MyParser {

public static void main(String[] args) throws Exception {
    String inputFiles[] = args[0].split(",");
    String rawHTML1 = HTML.getHTML(inputFiles[0]);
    String rawHTML2 = HTML.getHTML(inputFiles[1]);
    Output out;
    //check whether the second argument is provided
    if (args.length == 2){
      String fileName = args[1]+".txt";
      out = new FileOutput();  
      String content = out.getOutput(rawHTML1, rawHTML2);
      // create a file
      String path = "../../";
      File f = new File(path,fileName);
      // write to the file
      if (!f.exists()) {
        f.createNewFile();
        }
      
      FileWriter fw = new FileWriter(f.getName(),true);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(content);
      bw.close();       
     // the second argument is not provided, send the content to console 
    }else{
       out = new ConsoleOutput();
       out.getOutput(rawHTML1, rawHTML2);
    } 
    }
   }







