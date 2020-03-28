package nucleusGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
 
/**
 * Class for displaying the main frame of the software
 * @author Group6
 * @version 2.2.5
 * @extends JFrame
 */
public class MainFrame extends JFrame
{
   private JDesktopPane desktop;
   
   private ButtonListener buttonListener;
   
   private JMenuBar menuBar;
   
   private JMenu fileMenu;
   private JMenuItem openFileItem, settingsItem, exitItem;
   
   private JMenu sheetMenu;
   private JMenuItem showScheduleItem, showPreferencesItem, showStaffTimeItem, showTrainingItem;
   
   private JMenu resourcesMenu;
   private JMenuItem showEmployeeItem, showAnalysisItem;

   private JMenu aboutMenu;
   private JMenuItem aboutItem;
   
   private ImageIcon img;
   
   /**
    * No argument constructor to set up all the elements
    */
   public MainFrame() 
   {
      //Initializing all the elements
      super("Nucleus");
      
      desktop = new JDesktopPane();
      setContentPane(desktop);
      
      buttonListener = new ButtonListener();
      
      aboutItem = new JMenuItem("About");
      aboutItem.addActionListener(buttonListener);
      
      showAnalysisItem = new JMenuItem("Show Analyses");
      showAnalysisItem.addActionListener(buttonListener);
      
      showEmployeeItem = new JMenuItem("Show Employees");
      showEmployeeItem.addActionListener(buttonListener);
      
      showTrainingItem = new JMenuItem("Show Training Sheet");
      showTrainingItem.addActionListener(buttonListener);
      
      showStaffTimeItem = new JMenuItem("Show Staff Time Sheet");
      showStaffTimeItem.addActionListener(buttonListener);
      
      showPreferencesItem = new JMenuItem("Show Preferences Sheet");
      showPreferencesItem.addActionListener(buttonListener);
     
      showScheduleItem = new JMenuItem("Show Schedule");
      showScheduleItem.addActionListener(buttonListener);
      
      exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(buttonListener);
      
      openFileItem = new JMenuItem("Open File...");
      
      settingsItem = new JMenuItem("Settings");
      
      aboutMenu = new JMenu("About");
      aboutMenu.add(aboutItem);
      
      resourcesMenu = new JMenu("Resources");
      resourcesMenu.add(showEmployeeItem);
      resourcesMenu.add(showAnalysisItem);
      
      sheetMenu = new JMenu("Sheets");
      sheetMenu.add(showScheduleItem);
      sheetMenu.add(showPreferencesItem);
      sheetMenu.add(showStaffTimeItem);
      sheetMenu.add(showTrainingItem);
      
      fileMenu = new JMenu("File");
      fileMenu.add(openFileItem);
      fileMenu.add(settingsItem);
      fileMenu.add(exitItem);
      
      menuBar = new JMenuBar();
      menuBar.add(fileMenu);
      menuBar.add(resourcesMenu);
      menuBar.add(sheetMenu);
      menuBar.add(aboutMenu);
      
      setJMenuBar(menuBar);
      
      img = new ImageIcon("img/Nucleus_logo_bg_ligh_no_text.png");
      
      setIconImage(img.getImage());
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setVisible(true);
      setResizable(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
   }
   
   /**
    * Action listener for the buttons
    * @author Group6
    * @version 3.2.7
    * @implements ActionListener
    */
   private class ButtonListener implements ActionListener
   {
      /**
       * Listens to actions and performs accordingly 
       */
      public void actionPerformed(ActionEvent e)
      {         
         if(e.getSource() == showPreferencesItem)
         {
            //Implements singleton to ensure only one window of the same type is on the screen
            ShowPreferences showPreferences = ShowPreferences.getInstance(); 
            
            if(showPreferences.isVisible())
            {
               if(showPreferences.isIcon())
               {
                  try
                  {
                     showPreferences.setIcon(false);
                  }
                  catch(PropertyVetoException ex)
                  {
                     System.out.println("An error occured");
                  }
               }
            }
            else
            {
               showPreferences.setVisible(true);
               showPreferences.setSize((desktop.getWidth() / 2), ((desktop.getHeight() - 30) / 2));
               showPreferences.setLocation(0, 0);
               
               desktop.add(showPreferences);
            }
            
         }
         else if(e.getSource() == showStaffTimeItem)
         {
            //Implements singleton to ensure only one window of the same type is on the screen
            ShowStaffTime showStaffTime = ShowStaffTime.getInstance();
  
            if(showStaffTime.isVisible())
            {
               if(showStaffTime.isIcon())
               {
                  try 
                  {
                     showStaffTime.setIcon(false);
                  }
                  catch(PropertyVetoException ex)
                  {
                     System.out.println("An error occured");
                  }
               }
            }  
            else
            {
               showStaffTime.setVisible(true);
               showStaffTime.setSize((desktop.getWidth() / 2), ((desktop.getHeight() - 30) / 2));
               showStaffTime.setLocation((desktop.getWidth() - showStaffTime.getWidth()), ((desktop.getHeight() - 30) - showStaffTime.getHeight()));
               
               desktop.add(showStaffTime);
            }
            
         }
         else if(e.getSource() == showTrainingItem)
         {
            //Implements singleton to ensure only one window of the same type is on the screen
            ShowTraining showTraining = ShowTraining.getInstance();
            
            if(showTraining.isVisible())
            {
               if(showTraining.isIcon())
               {
                  try
                  {
                     showTraining.setIcon(false);
                  }
                  catch(PropertyVetoException ex)
                  {
                     System.out.println("An error occured");
                  }
               }
            }
            else
            {
               showTraining.setVisible(true);
               showTraining.setSize((desktop.getWidth() / 2), ((desktop.getHeight() - 30) / 2));
               showTraining.setLocation((desktop.getWidth() - showTraining.getWidth()), 0);
               
               desktop.add(showTraining);
            } 
         }
         else if(e.getSource() == showScheduleItem)
         {
            //Implements singleton to ensure only one window of the same type is on the screen
            ShowSchedule showSchedule = ShowSchedule.getInstance();
            
            if(showSchedule.isVisible())
            {
               if(showSchedule.isIcon())
               {
                  try
                  {
                     showSchedule.setIcon(false);
                  }
                  catch(PropertyVetoException ex)
                  {
                     System.out.println("An error occured");
                  }
               }
            }
            else
            {
               showSchedule.setVisible(true);
               showSchedule.setSize((desktop.getWidth() / 2), (int)((desktop.getHeight() - 30) / 2));
               showSchedule.setLocation(0, ((desktop.getHeight() - 30) - showSchedule.getHeight()) );
               
               desktop.add(showSchedule);
            }
         }
         else if(e.getSource() == showAnalysisItem)
         {
            //Implements singleton to ensure only one window of the same type is on the screen
            ShowAnalysis showAnalysis = ShowAnalysis.getInstance();
            
            if(showAnalysis.isVisible())
            {
               if(showAnalysis.isIcon())
               {
                  try
                  {
                     showAnalysis.setIcon(false);
                  }
                  catch(PropertyVetoException ex)
                  {
                     System.out.println("An error occured");
                  }
               }
            }
            else
            {
               showAnalysis.setVisible(true);
               showAnalysis.setSize((desktop.getWidth() / 2), (desktop.getHeight() - 30));
               showAnalysis.setLocation(0, 0);
               
               desktop.add(showAnalysis);
            }
         }
         else if(e.getSource() == showEmployeeItem)
         {
            //Implements singleton to ensure only one window of the same type is on the screen
            ShowEmployee showEmployee = ShowEmployee.getInstance();
            
            if(showEmployee.isVisible())
            {
               if(showEmployee.isIcon())
               {
                  try
                  {
                     showEmployee.setIcon(false);
                  }
                  catch(PropertyVetoException ex)
                  {
                     System.out.println("An error occured");
                  }
               }
            }
            else
            {
               showEmployee.setVisible(true);
               showEmployee.setSize((desktop.getWidth() / 2), (desktop.getHeight() - 30));
               showEmployee.setLocation((desktop.getWidth() - showEmployee.getWidth()), 0);
               
               desktop.add(showEmployee);
            }
         }
         else if (e.getSource() == exitItem)
         {
            int choice = JOptionPane.showConfirmDialog(null,
                  "Are you sure?", "Exit",
                  JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION)
            {
               System.exit(0);
            }
         }
         else if(e.getSource() == aboutItem)
         {
            JOptionPane.showMessageDialog(
                  null,
                  "Nucleus Software Development",
                  "About", JOptionPane.PLAIN_MESSAGE);
         }

      }
   }
   
   /**
    * Starts the main frame
    * @param String[] args
    */
   public static void main(String[] args)
   {
      MainFrame mainGUI = new MainFrame();
   }
}




