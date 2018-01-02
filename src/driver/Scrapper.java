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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Scrapper extract raw information such as author, number of citation
 * from the given URL.
 */

public class Scrapper {
  
  /** extract Author's Name
   */
  public static String extractAuthorsName(String rawHTMLString) {    
      String reForAuthorExtraction =
          "<span id=\"cit-name-display\" "
              + "class=\"cit-in-place-nohover\">(.*?)</span>";
      Pattern patternObject = Pattern.compile(reForAuthorExtraction);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      matcherObject.find();
      String name  = matcherObject.group(1);
      return name;
      }
  

  /** extract Name of the Author.
   */
  public static String extractAllCitation(String rawHTMLString ){
    String totalNumCitationsExtraction = 
       "<td class=\"cit-borderleft cit-data\">(.*?)</td>";
    Pattern patternObject = Pattern.compile(totalNumCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    matcherObject.find();
    String result = matcherObject.group(1);
    return result;

  }
  
  /** extract the title of the first THREE publications.
   */
  public static ArrayList<String> extractThreePublication (String HTML){
    ArrayList<String> lstTitle = new ArrayList<String>();
    String ThreePublication = "class=\"cit-dark-large-link\">(.*?)</a>";
    Pattern patternObject = Pattern.compile(ThreePublication);
    Matcher matcherObject = patternObject.matcher(HTML);
    // find the first 3 publication
    int count = 0;
    while (count <3 ) {
      matcherObject.find();
      lstTitle.add(matcherObject.group(1));
      count +=1;
      }
    return lstTitle;
  }
 
 
  /**extract the Number of i10-index after 2009.
   */
  public static String extractIndexAfter2009(String rawHTMLString){
    String i10indexAfter2009Extraction =
        "<td class=\"cit-borderleft cit-data\">(.*?)</td>";
    Pattern patternObject = Pattern.compile(i10indexAfter2009Extraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    int  count = 0;
    String result = "";
    // find the 6th item in the table
    while (count<6){
      matcherObject.find();
      result = matcherObject.group(1);
      count += 1;}
    return result;    
  }
  
  
  /**The total number of citations of the first FIVE publications.
   */
  public static int extractTotalCitationFive(String rawHTMLString){
    String totalFiveCitation ="<td id=\"col-citedby\">"
        + "<a class=\"cit-dark-link\" href=(.*?)>(.*?)</a>";
    Pattern patternObject = Pattern.compile(totalFiveCitation);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    int total = 0;
    int count = 0;
    while (count<5){
      matcherObject.find();
      count+=1;
      total+= Integer.parseInt(matcherObject.group(2));}
    return total;
  }
 
  
  /**extract the names of all co-authors.
   */
  public static ArrayList<String> extractNameCoAuthors(String rawHTML){
    // store the authors in a list (we will sort it later)
    ArrayList<String> lstCoAuthors = new ArrayList<String>();
    //First find the SECTION that contains all co-authors for convenience
    String coAuthorSection =
        "<div style=\"padding:.5em; border:.3em solid #9FD9A7\">(.*?)"
        + "View all co-authors</a></div></div>";
    Pattern section = Pattern.compile(coAuthorSection);  
    Matcher m = section.matcher(rawHTML);
    if (m.find()){
    String s = m.group(1); 
    // now find the co-authors name from that section
    String coAuthors = 
        "<a class=\"cit-dark-link\""
        + " href=\"http://scholar.google.ca/citations(.*?)"
        + "title=(.*?)>(.*?)</a><br>";
    Pattern patternObject = Pattern.compile(coAuthors);
    Matcher matcherObject = patternObject.matcher(s);
    while (matcherObject.find()){
      lstCoAuthors.add(matcherObject.group(3));
      }
    }
    return lstCoAuthors;
    }
  
}
    

 


