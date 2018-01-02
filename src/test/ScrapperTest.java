package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import driver.HTML;
import driver.Scrapper;

public class ScrapperTest {
  String s1;
  String s2;
  String s3;  
  ArrayList<String> t = new ArrayList<String>();
  @Before
  public void setUp() throws Exception {
    s1 = HTML.getHTML("sample1.html");
    s2 = HTML.getHTML("sample2.html");
    s3 = HTML.getHTML("rs.html"); 
    t.add("Face-tracking as an augmented input "
        + "in video games: enhancing presence, "
        + "role-playing and control");
    t.add("Art of defense: a collaborative handheld "
        + "augmented reality board game");
    t.add("Sociable killers: understanding social relationships in an"
        + " online first-person shooter game");
    
  }
     
  @Test
  public void testAuthorName() {
    assertEquals("Ola Spjuth", Scrapper.extractAuthorsName(s1));
    assertEquals("Yan Xu", Scrapper.extractAuthorsName(s2));
    assertEquals("rahul sawhney", Scrapper.extractAuthorsName(s3));
  }
  @Test
  public void testAllCitations() {    
    assertEquals("437", Scrapper.extractAllCitation(s1));
    assertEquals("263", Scrapper.extractAllCitation(s2));
    assertEquals("33", Scrapper.extractAllCitation(s3));    
  }
  @Test
  public void testExtractCoAuthor() {
   //instead of see if the whole expected result equals to actual result
  // we will only use the 10th co-author'name as expected reuslt for 
  // convenience p.s the names are not sorted yet
    assertEquals("Adam Ameur", Scrapper.extractNameCoAuthors(s1).get(9));
    assertEquals("John Stasko", Scrapper.extractNameCoAuthors(s2).get(9));    
  }
  
  @Test 
  public void testExtractTotalCoAuthor() {
    assertEquals(15, Scrapper.extractNameCoAuthors(s1).size());
    assertEquals(14, Scrapper.extractNameCoAuthors(s2).size()); 
     //test when there is no co-author
    assertEquals(0, Scrapper.extractNameCoAuthors(s3).size()); 

}
  @Test   
  public void testExtractThreePublication() {
    assertEquals(t, Scrapper.extractThreePublication(s2));
    }
  @Test   
  public void testExtractNumCitationFive() {
    assertEquals(239, Scrapper.extractTotalCitationFive(s1));
    assertEquals(158, Scrapper.extractTotalCitationFive(s2));
    assertEquals(33, Scrapper.extractTotalCitationFive(s3));
    }
  
  @Test
  public void testExtracti10IndexAfter2009(){
    assertEquals("12",Scrapper.extractIndexAfter2009(s1));
    assertEquals("9", Scrapper.extractIndexAfter2009(s2));
    assertEquals("1", Scrapper.extractIndexAfter2009(s3));
  }
    
  }
