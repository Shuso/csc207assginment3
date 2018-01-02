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
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
OutputFormatter produce output that is a well-formatted string 
 */

public class OutputFormatter {

  /**
    produce formated general formation (1 -- 6)
   */
  public static String formatGeneralInfo(String rawHTML){   
    String name = Scrapper.extractAuthorsName(rawHTML);
    String allCitation = Scrapper.extractAllCitation(rawHTML);
    String i10 = Scrapper.extractIndexAfter2009(rawHTML);
    int totalCitationFive = Scrapper.extractTotalCitationFive(rawHTML);
    int totalCoAuthor = Scrapper.extractNameCoAuthors(rawHTML).size();
    String Line1 = "1. Name of Author:\n\t" +name+"\n";
    String Line2 = "2. Number of All Citations:\n\t" +allCitation+"\n";
    String Line3 = "3. Number of i10-index after 2009:\n\t" + i10+"\n";
    String Line4 = "4. Title of the first 3 publications:\n"+
                              helperLine4(rawHTML);
    String Line5 = "5. Total paper citation (first 5 papers):\n\t"+
                              totalCitationFive+"\n";
    String Line6 = "6. Total Co-Authors:\n\t"+totalCoAuthor+"\n";
    return Line1+Line2+Line3+Line4+Line5+Line6;    
  }
  

  /**
  produce formated Co-Author list (item 7)
  */
  public static String formatCoAuthor(String rawHTML1,String rawHTML2){
    ArrayList<String> coAuthor1 = Scrapper.extractNameCoAuthors(rawHTML1);
    ArrayList<String> coAuthor2 = Scrapper.extractNameCoAuthors(rawHTML2);
    Set<String> setCoAuthors = new TreeSet<String>();
    String result = "";
    for (String item : coAuthor1){
      setCoAuthors.add(item);
    }
    for (String item : coAuthor2){
      setCoAuthors.add(item);    
    }
    for (String element:setCoAuthors){
      result += element + "\n";
      }    
    int total = setCoAuthors.size();
    String title = 
        String.format("7. Co-Author list sorted (Total: %d):",total);
    return  title + "\n" + result;    
  }
 
  
  /**
  helper method that helps format Line4 (first three publication)
  */
  public static String helperLine4(String url){
    ArrayList<String> h = Scrapper.extractThreePublication(url);
    String result = "";
      for (int i = 0; i < h.size(); i++){
        String temp = String.format("\t%d-   %s\n", i+1,h.get(i));
        result +=temp;
        }
      return result;
  }
  
  
  /**
  draw dash
  */
  public static String dash(){
    String s = "-";
    int counter = 0;
    while (counter<70){
      s+="-";
      counter+=1;}
    return s;
    }
}

