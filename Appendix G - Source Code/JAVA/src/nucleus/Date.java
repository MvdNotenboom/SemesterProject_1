package nucleus;

import java.io.Serializable;

/**
 * Class that defines and manages dates
 * @author Group6
 * @version 2.3.8
 */
public class Date implements Serializable
{
   private int day;
   private int month;
   private int year;
   
   /**
    * Three argument constructor, sets the day, month and year
    * @param Integer day
    * @param Integer month
    * @param Integer year
    */
   public Date(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }
   
   /**
    * Sets up the day, month and year
    * @param Integer day
    * @param Integer month
    * @param Integer year
    */
   public void setDate(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }
   
   /**
    * Returns a printed version of the information
    * @return String
    */
   public String toString()
   {
      String str = "";
      
      if(day < 10)
      {
         str = "0" + day + "/";
      }
      else
      {
         str = day + "/";
      }
      
      if(month < 10)
      {
         str += "0" + month + "/";
      }
      else
      {
         str += month + "/";
      }
      
      str += year; 
      
      return str; 
   }
}
