package nucleus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that manages all analysis in an ArrayList
 * @author Group6
 * @version 4.2.1
 */
public class AnalysisList implements Serializable
{
   private ArrayList<Analysis> analyses;
   
   /**
    * No-argument constructor that initializing AnalysisList
    */
   public AnalysisList()
   {
      this.analyses = new ArrayList<Analysis>();
   }
   
   /**
    * Adds an Analysis to the list, checks if the analysis already exists
    * @param Analysis analysis
    */
   public void addAnalysis(Analysis analysis)
   {
      boolean flag = false; 
      
      for(int i = 0; i < analyses.size(); i++)
      {
        if(analyses.get(i).equals(analysis))
        {
           flag = true;
        }
      } 

      if(!flag)
      {
         analyses.add(analysis);
      }
      else
      {
         System.out.println("Already Exists");
      }
   }
   
   /**
    * Removes an analysis based on the Analysis
    * @param Analysis analysis
    */
   public void removeAnalysis(Analysis analysis)
   {
      boolean flag = false; 
      
      for(int i = 0; i < analyses.size(); i++)
      {
        if(analyses.get(i).equals(analysis))
        {
           flag = true;
        }
      } 

      if(flag)
      {
         analyses.remove(analysis);
      }
   }
   
   /**
    * Returns an analysis based on the name
    * @param name
    * @return Analysis
    */
   public Analysis getAnalysis(String name)
   {
      int temp = 0;
      
      for(int i = 0; i < analyses.size(); i++)
      {
         if(analyses.get(i).getName().equals(name))
         {
            temp = i;
         }
      } 
      return analyses.get(temp);
   }
   
   /**
    * Returns an analysis based on index
    * @param Integer index
    * @return Analysis
    */
   public Analysis getAnalysis(int index)
   {
      return analyses.get(index);
   }
   
   /**
    * Returns the number of analysis in the list
    * @return Integer
    */
   public int getNumAnalysis()
   {
      return analyses.size();
   }
   
   /**
    * Returns a printed version of the information
    * @return String
    */
   public String toString()
   {
      String str = "";
      
      for(int i = 0; i < analyses.size(); i++)
      {
         str += analyses.get(i).toString() + "\n";
      }
      return str;
   }
   
 
}
