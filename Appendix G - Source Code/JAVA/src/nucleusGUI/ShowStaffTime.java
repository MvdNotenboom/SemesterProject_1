package nucleusGUI;

import javax.swing.JInternalFrame;

/**
 * Class for creating an internal frame for displaying information about schedule
 * @author Group6
 * @version 2.2.2
 * @extends JInternalFrame
 */
public class ShowStaffTime extends JInternalFrame
{  
   private static ShowStaffTime showStaffTime;
   private StaffTimePanel staffTimePanel;
   
   /**
    * Using singleton pattern to ensure that only one internal frame of the same type is displayed at a time
    * @return showAnalysis
    */
   public static ShowStaffTime getInstance()
   {
      if(showStaffTime == null)
      {
         showStaffTime = new ShowStaffTime();
      }
      return showStaffTime;
   }
   
   /**
    * No argument constructor
    */
   public ShowStaffTime() 
   {
      super("Staff Time");
      
      staffTimePanel = new StaffTimePanel();
      
      add(staffTimePanel);
      
      setClosable(true);
      setMaximizable(true);
      setIconifiable(true);
      setResizable(true);
   }
}
