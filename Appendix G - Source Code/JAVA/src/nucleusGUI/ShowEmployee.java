package nucleusGUI;

import java.awt.BorderLayout;
import javax.swing.JInternalFrame;

/**
 * Class for creating an internal frame for displaying information about employee
 * @author Group6
 * @version 3.5.2
 * @extends JInternalFrame
 */
public class ShowEmployee extends JInternalFrame
{
   private static ShowEmployee showEmployee;
   private EmployeePanel allEmployeePanel;
   
   /**
    * Using singleton pattern to ensure that only one internal frame of the same type is displayed at a time
    * @return showAnalysis
    */
   public static ShowEmployee getInstance()
   {
      if(showEmployee == null)
      {
         showEmployee = new ShowEmployee();
      }
      return showEmployee;
   }
   
   /**
    * No argument constructor
    */
   public ShowEmployee() 
   {
      super("Employee");
      
      allEmployeePanel = new EmployeePanel();
      add(allEmployeePanel, BorderLayout.CENTER);
 
      setClosable(true);
      setMaximizable(true);
      setIconifiable(true);
      setResizable(true);
   }
}

