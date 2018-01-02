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
/**
 * ConsoleOutput class collaborate with the Formatter class and  print
 * the contents on the console.
 */

public class ConsoleOutput implements Output{ 
  
  /**
   * writes the formatted contents to the console 
   */
  public String getOutput(String rawHTML1,String rawHTML2){
    Output temp = new FileOutput();
    String m = temp.getOutput(rawHTML1,rawHTML2);
    System.out.println(m);
    return "";
  }
}


