package nucleusGUI;

import javax.swing.JInternalFrame;

/**
 * Class for creating an internal frame for displaying information about schedule
 * @author Group6
 * @version 1.2.2
 * @extends JInternalFrame
 */
public class ShowSchedule extends JInternalFrame
{
   private static ShowSchedule showSchedule;
   
   private SchedulePanel schedulePanel;
   
   /**
    * Using singleton pattern to ensure that only one internal frame of the same type is displayed at a time
    * @return showAnalysis
    */
   public static ShowSchedule getInstance()
   {
      if(showSchedule == null)
      {
         showSchedule = new ShowSchedule();
      }
      return showSchedule;
   }
   
   /**
    * No argument constructor
    */
   public ShowSchedule() 
   {
      super("Schedule");
 
      schedulePanel = new SchedulePanel();
      
      add(schedulePanel);
      
      setClosable(true);
      setMaximizable(true);
      setIconifiable(true);
      setResizable(true);
   }
}
