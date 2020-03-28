package nucleus;

import java.io.Serializable;

/**
 * The class Analysis contains all the information for defining an analysis for the system 
 * @author Group6
 * @version 3.2.5
 */
public class Analysis implements Serializable
{
   private String name;
   private boolean type;
   private int numEmployeeSmall;
   private int numEmployeeLarge;
   private int[] numOfEmployeeWeekDay;
   
   /**
    * Two argument constructor sets the name and type of the analysis and the standard number of needed employees
    * @param String name
    * @param type boolean False for Large/True for small
    */
   public Analysis(String name, boolean type)
   {
      this.name = name;
      this.type = type;
      
      //Sets up the default number of needed employees per day (for Staff Time Sheet) as 0;
      
      numOfEmployeeWeekDay = new int[7];
      for(int i = 0; i < numOfEmployeeWeekDay.length; i++)
      {
         numOfEmployeeWeekDay[i] = 0; 
      }
      
      //Sets up the default total number of needed employees for the analysis based on the type of week (small/large)
      
      if(type)
      {
         setNumEmployee(4);  
      }
      else
      {
         setNumEmployee(8);
      }
   }
   
   /**
    * Sets the name of the analysis
    * @param String name
    */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
    * Sets the number of employees needed for the specified weekday ( 0 - Monday, 1 - Tuesday, ... , 5 - Saturday) for the Staff Time Sheet
    * @param Integer numOfEmployee
    * @param Integer weekday
    */
   public void setNumOfEmployeeWeekDay(int numOfEmployee, int weekday)
   {
      numOfEmployeeWeekDay[weekday] = numOfEmployee;
   }
   
   /**
    * Returns the number of employees needed for the specified weekday ( 0 - Monday, 1 - Tuesday, ... , 5 - Saturday) for the Staff Time Sheet
    * @param weekday
    * @return Integer number of employees for a specific weekday; 
    */
   public int getNumOfEmployee(int weekday)
   {
      return numOfEmployeeWeekDay[weekday];
   }
   
   /**
    * Returns the name of the analysis
    * @return String
    */ 
   public String getName()
   {
      return name;
   }
   
   
   /**
    * Sets the type of the analysis 
    * @param boolean type False for Large/True for small
    */
   public void setType(boolean type)
   {
      this.type = type;
   }
   
   /**
    * Returns the type of the analysis 
    * @return boolean False for Large/True for small
    */
   public boolean getType()
   {
      return type;
   }
   
   /**
    * Returns the type of the analysis in a String form
    * @return String 
    */
   public String getStringType()
   {
      if(type)
      {
         return "Small";
      }
      else
      {
         return "Large";
      }
   }
   
   /**
    * Sets the number of employees needed for the analysis depending on the type
    * @param integer numEmployees
    */
   public void setNumEmployee(int numEmployees)
   {
      if(type)
      {
         this.numEmployeeSmall = numEmployees;
      }
      else
      {
         this.numEmployeeLarge = numEmployees; 
      }
   }
   
   /**
    * Returns the number of employees depending on the type of the week
    * @return integer
    */
   public int getNumEmployee()
   {
      if(type)
      {
         return numEmployeeSmall;
      }
      else
      {
         return numEmployeeLarge; 
      }
   }
   
   /**
    * Checks if the given object is equal with this
    * @param Object obj Generic object
    * @return boolean True for equal/False for not equal
    */
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Analysis))
      {
         return false;
      }
      
      Analysis other = (Analysis)obj;
      
      return this.name.equals(other.name) && this.type == other.type;
   }
   
   
   /**
    * Returns a printed version of the information
    * @return String
    */
   public String toString()
   {
      
      String typeString; 
      int numEmployees;
      
      if(type)
      {
         typeString = "Small";
         numEmployees = numEmployeeSmall;
      }
      else
      {
         typeString = "Large";
         numEmployees = numEmployeeLarge;
      }
      
      return "Analysis: " + name + "\nType: " + typeString + "\nNumber of Employees: " + numEmployees + "\n";  
   }
}
