package nucleus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for managing the employees in a list
 * @author Group6
 * @version 8.3.4
 */
public class EmployeeList implements Serializable
{
   private ArrayList<Employee> employees;
   
   /**
    * No-argument constructor, initiates the array list
    */
   public EmployeeList()
   {
      employees = new ArrayList<Employee>();
   }
   
   /**
    * Adds an employee to the list if the employee does not already exists
    * @param Employee employee
    */
   public void addEmployee(Employee employee)
   {
      boolean flag = false; 
      
      for(int i = 0; i < employees.size(); i++)
      {
        if(employees.get(i).equals(employee))
        {
           flag = true;
        }
      } 

      if(!flag)
      {
         employees.add(employee);
      }
      else
      {
         System.out.println("Already Exists");
      }
   }
   
   /**
    * Removes an existing employee from the list
    * @param Employee employee
    */
   public void removeEmployee(Employee employee)
   {
      boolean flag = false; 
      
      for(int i = 0; i < employees.size(); i++)
      {
        if(employees.get(i).equals(employee))
        {
           flag = true;
        }
      } 

      if(flag)
      {
         employees.remove(employee);
      }
   }
   
   /**
    * Returns an employee based on the name and id
    * @param String name
    * @param String id
    * @return Employee
    */
   public Employee getEmployee(String name, String id)
   {
      int temp = 0;
      
      for(int i = 0; i < employees.size(); i++)
      {
         if(employees.get(i).getName().equals(name) && employees.get(i).getID().equals(id))
         {
            temp = i;
         }
      } 
      return employees.get(temp);
   }
   
   /**
    * Returns an employee based on his index position in the list
    * @param Integer index
    * @return Employee
    * 
    */
   public Employee getEmployee(int index)
   {
      return employees.get(index);
   }
   
   /**
    * Returns the number of employees in the list
    * @return Integer
    */
   public int getNumEmployee()
   {
      return employees.size();
   }
   
   /**
    * Returns a printed version of the information
    * @return String
    */
   public String toString()
   {
      String str = "";
      
      for(int i = 0; i < employees.size(); i++)
      {
         str += employees.get(i).toString() + "\n";
      }
      return str;
   }
}
