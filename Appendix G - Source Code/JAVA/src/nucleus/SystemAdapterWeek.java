package nucleus;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class for providing a cohesion between the FileIO class and the Week List Class
 * @author Group6
 * @version 1.2.6
 */
public class SystemAdapterWeek
{
   private String fileName;
   private FileIO file;
   
   /**
    * Creates the file
    * @param String fileName
    */
   public SystemAdapterWeek(String fileName)
   {
      file = new FileIO();
      this.fileName = fileName;
   }
   
   /**
    * Returns the list of employees
    * @return EmployeeList
    */
   public WeekList getAllWeeks()
   {
      SystemSEP system = new SystemSEP();
      WeekList weekList = system.getWeekList();
      
      try
      {
         weekList = (WeekList)file.readObjectFromFile(fileName);
      }
      catch(FileNotFoundException e)
      {
         System.out.println("FileNotFound");
      }
      catch(IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch(ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      
      return weekList;
   }
   
   /**
    * Saves to a file the list of employee
    * @param EmployeeList employees
    */
   public void saveWeekList(WeekList weekList)
   {
      try
      {
         file.writeToFile(fileName, weekList);
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch(IOException e)
      {
         e.printStackTrace();
         System.out.println("IO Error writing to file");
      }
   }
}

