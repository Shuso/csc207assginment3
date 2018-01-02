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
 *  Output contains abstract methods that the FileOutput class
 *  and ConsoleOutput class will implement from.
 */
public interface Output {
  public String getOutput(String rawHTML1,String rawHTML2);
}
