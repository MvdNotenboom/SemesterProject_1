package nucleusGUI;

import javax.swing.JInternalFrame;

/**
 * Class for creating an internal frame for displaying information about analyses
 * @author Group6
 * @version 2.7.2
 * @extends JInternalFrame
 */
public class ShowAnalysis extends JInternalFrame
{
   private static ShowAnalysis showAnalysis;
   private AnalysisPanel allAnalysisPanel;
   
   /**
    * Using singleton pattern to ensure that only one internal frame of the same type is displayed at a time
    * @return showAnalysis
    */
   public static ShowAnalysis getInstance()
   {
      if(showAnalysis == null)
      {
         showAnalysis = new ShowAnalysis();
      }
      return showAnalysis;
   }
   
   /**
    * No argument constructor
    */
   public ShowAnalysis() 
   {
      super("Analysis");
      
      allAnalysisPanel = new AnalysisPanel();
      
      add(allAnalysisPanel);
      
      setClosable(true);
      setMaximizable(true);
      setIconifiable(true);
      setResizable(true);
   }
}
