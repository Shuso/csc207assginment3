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

 /**FileOutput class collaborate with the Formatter class and  write the 
  * contents on the file. 
  */
public class FileOutput implements Output{
  /**
   * writes the formatted contents to the file 
   */
  public String getOutput(String rawHTML1,String rawHTML2){
    String dash = OutputFormatter.dash();
    String GeneralInfo = OutputFormatter.formatGeneralInfo(rawHTML2) + 
        dash +"\n" + OutputFormatter.formatGeneralInfo(rawHTML1) ;  
    String coAuthorLst = 
        OutputFormatter.formatCoAuthor(rawHTML1, rawHTML2);
    return dash + "\n" + GeneralInfo + "\n" + dash +"\n"+ coAuthorLst;
    }
  }
