package nucleusGUI;

import javax.swing.JInternalFrame;

/**
 * Class for creating an internal frame for displaying information about preferences
 * @author Group6
 * @version 3.5.2
 * @extends JInternalFrame
 */
public class ShowPreferences extends JInternalFrame
{
   private static ShowPreferences showPreferences;
   private PreferencesPanel preferencesPanel;
   
   /**
    * Using singleton pattern to ensure that only one internal frame of the same type is displayed at a time
    * @return showAnalysis
    */
   public static ShowPreferences getInstance()
   {
      if(showPreferences == null)
      {
         showPreferences = new ShowPreferences();
      }
      return showPreferences;
   }
   
   /**
    * No argument constructor
    */
   public ShowPreferences() 
   {
      super("Preferences");
      
      preferencesPanel = new PreferencesPanel();
      
      add(preferencesPanel);
      
      setClosable(true);
      setMaximizable(true);
      setIconifiable(true);
      setResizable(true);
   }
}
