package nucleusGUI;

import javax.swing.JInternalFrame;

/**
 * Class for creating an internal frame for displaying information about schedule
 * @author Group6
 * @version 1.1.3
 * @extends JInternalFrame
 */
public class ShowTraining extends JInternalFrame
{
   private static ShowTraining showTraining;
   private TrainingPanel trainingPanel;
   
   /**
    * Using singleton pattern to ensure that only one internal frame of the same type is displayed at a time
    * @return showAnalysis
    */
   public static ShowTraining getInstance()
   {
      if(showTraining == null)
      {
         showTraining = new ShowTraining();
      }
      return showTraining;
   }
   
   /**
    * No argument constructor
    */
   public ShowTraining() 
   {
      super("Training");
      
      trainingPanel = new TrainingPanel();
      add(trainingPanel);
      
      setClosable(true);
      setMaximizable(true);
      setIconifiable(true);
      setResizable(true); 
   }
}
