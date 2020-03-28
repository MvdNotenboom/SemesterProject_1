package nucleus;

import java.io.Serializable;

/**
 * Class for defining and managing a task
 * @author Group6
 * @version 2.3.3
 */
public class Task implements Serializable
{
   private Date date;
   private Analysis analysis;
   private EmployeeList employees;
   
   /**
    * Three argument constructor that sets up the date, analysis and employees
    * @param Date date
    * @param Analysis analysis
    * @param EmployeeList employees
    */
   public Task(Date date, Analysis analysis, EmployeeList employees)
   {
      this.date = date;
      this.analysis = analysis;
      this.employees = employees;
   }
   
   /**
    * Two argument constructor that sets up the date and analysis
    * @param Date date
    * @param Analysis analysis
    */
   public Task(Date date, Analysis analysis)
   {
      this.date = date;
      this.analysis = analysis;
   }
   
   /**
    * Sets up the date
    * @param Date date
    */
   public void setDate(Date date)
   {
      this.date = date;
   }
   
   /**
    * Returns the date
    * @return Date
    */
   public Date getDate()
   {
      return date;
   }
   
   /**
    * Sets up the employees
    * @param EmployeeList employees
    */
   public void setEmployee(EmployeeList employees)
   {
      this.employees = employees;
   }
   
   /**
    * Returns the employees
    * @return EmployeeList
    */
   public EmployeeList getEmployee()
   {
         return employees;
   }
   
   /**
    * Returns the analysis
    * @return Analysis
    */
   public Analysis getAnalysis()
   {
      return analysis;
   }
   
   /**
    * Checks if the given object is equal with this
    * @param Object obj Generic object
    * @return boolean True for equal/False for not equal
    */
   public boolean equal(Object obj)
   {
      if(!(obj instanceof Task))
      {
         return false;
      }
      
      Task other = (Task)obj;
      
      return date.equals(other.date) && analysis.equals(other.analysis) &&
            employees.equals(other.employees);
   }
   
   /**
    * Returns a printed version of the information
    * @return String
    */
   public String toString()
   {
      return "Date: " + date + "\n" + "Analysis: " + analysis + "\n" + "Employees: " + employees;
   }
}
