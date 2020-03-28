package nucleus;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class for providing a cohesion between the FileIO class and the Analysis List Class
 * @author Group6
 * @version 1.2.6
 */
public class SystemAdapterAnalysis
{
   private String fileName;
   private FileIO file;
   
   /**
    * Creates the file
    * @param String fileName
    */
   public SystemAdapterAnalysis(String fileName)
   {
      file = new FileIO();
      this.fileName = fileName;
   }
   
   /**
    * Returns the list of analyses
    * @return AnalysisList
    */
   public AnalysisList getAllAnalysis()
   {
      SystemSEP system = new SystemSEP();
      AnalysisList analysisList = system.getAnalysisList(); //gets the current version
      
      try
      {
         analysisList = (AnalysisList)file.readObjectFromFile(fileName);
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
      
      return analysisList;
   }
   
   /**
    * Saves to a file the list of analyses
    * @param AnalysisList analyses
    */
   public void saveAnalysisList(AnalysisList analyses)
   {
      try
      {
         file.writeToFile(fileName, analyses);
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
