package nucleusGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import nucleus.AnalysisList;
import nucleus.SystemAdapterAnalysis;
import nucleus.SystemSEP;

/**
 * Class that sets up a panel that displays information about the Staff Time, used by ShowStaffTime class
 * @author Group6
 * @version 5.6.3
 * @extends JPanel
 */
public class StaffTimePanel extends JPanel
{
   private SystemAdapterAnalysis systemAdapterAnalysis; 
   private SystemSEP system;
   private ButtonListener buttonListener;
   
   private JButton updateButton, editButton;
   
   private JPanel buttonPanel;
   
   private JTable staffTimeTable;
   private String[] columnName;
   private DefaultTableModel dtm;
   private JScrollPane staffTimeScrollPane;
   
   /**
    * No argument constructor that sets elements
    */
   public StaffTimePanel()
   {
      //Initializing the elements
      systemAdapterAnalysis = new SystemAdapterAnalysis("analysis");
      system = new SystemSEP();
      
      buttonListener = new ButtonListener();
      
      //Setting up the columns of the table
      columnName = new String[8];
      columnName[0] = "Analysis";
      columnName[1] = "Type";
      columnName[2] = "Monday";
      columnName[3] = "Tuesday";
      columnName[4] = "Wednesday";
      columnName[5] = "Thorsday";
      columnName[6] = "Friday";
      columnName[7] = "Saturday";

      //Setting up the table
      dtm = new DefaultTableModel(columnName,120)
      {
         
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      staffTimeTable = new JTable(dtm);
      
      staffTimeTable.getTableHeader().setReorderingAllowed(false);
      staffTimeTable.getTableHeader().setResizingAllowed(false);
      
      staffTimeTable.setCellSelectionEnabled(false);
      staffTimeTable.setEnabled(true);
      staffTimeTable.setFocusable(true);
      staffTimeTable.setRowSelectionAllowed(true);
      staffTimeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      staffTimeScrollPane = new JScrollPane(staffTimeTable);
      staffTimeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      staffTimeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      staffTimeTable.setPreferredScrollableViewportSize(new Dimension(900, staffTimeTable.getRowHeight()*23));
      
      //Setting up other elements
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

      editButton = new JButton("Change Staff Time");
      editButton.addActionListener(buttonListener);
      
      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);
   
      buttonPanel.add(editButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(updateButton);
      
      //Adding everything to the main panel
      add(staffTimeScrollPane);
      add(buttonPanel, BorderLayout.NORTH);
   }
   
   /**
    * Updates the staff time table
    */
   public void updateStaffTimeTable()
   {
      //Setting up data for the tab;e
      AnalysisList analyses = systemAdapterAnalysis.getAllAnalysis();
      
      Object[][] data = new Object[analyses.getNumAnalysis()][8];
      
      for(int i = 0; i < analyses.getNumAnalysis(); i++)
      {
         data[i][0] = analyses.getAnalysis(i).getName();
         data[i][1] = analyses.getAnalysis(i).getStringType();
         
         for(int j = 0; j < 6; j++)
         {
            data[i][j + 2] = analyses.getAnalysis(i).getNumOfEmployee(j);
         }
      }
      
      //Setting up table with the data
      columnName = new String[8];
      columnName[0] = "Analysis";
      columnName[1] = "Type";
      columnName[2] = "Monday";
      columnName[3] = "Tuesday";
      columnName[4] = "Wednesday";
      columnName[5] = "Thorsday";
      columnName[6] = "Friday";
      columnName[7] = "Saturday";
      
      dtm = new DefaultTableModel(data,columnName)
      {
         
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      staffTimeTable.setModel(dtm);
      
      staffTimeTable.getTableHeader().setReorderingAllowed(false);
      staffTimeTable.getTableHeader().setResizingAllowed(false);
      
      staffTimeTable.setCellSelectionEnabled(false);
      staffTimeTable.setEnabled(true);
      staffTimeTable.setFocusable(true);
      staffTimeTable.setRowSelectionAllowed(true);
      staffTimeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   }
   
   /**
    * Class for defining the panel for changing the staff time
    * @author Group6
    * @version 3.4.1
    * @extends JPanel
    */
   public class ChangeStaffTime extends JPanel
   {
      private JLabel mondayLabel, tuesdayLabel, wednsdayLabel, thorsdayLabel, fridayLabel, saturdayLabel;
      private JTextField mondayTextField, tuesdayTextField, wednsdayTextField, thorsdayTextField, fridayTextField, saturdayTextField;
      private JPanel labelPanel, fieldPanel;
      
      public ChangeStaffTime()
      {
         //Initializing the elements
         labelPanel = new JPanel();
         labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
         
         mondayLabel = new JLabel("Monday: ");
         mondayLabel.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
         tuesdayLabel = new JLabel("Tuesday: ");
         tuesdayLabel.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
         wednsdayLabel = new JLabel("Wednsday: ");
         wednsdayLabel.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
         thorsdayLabel = new JLabel("Thorsday: ");
         thorsdayLabel.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
         fridayLabel = new JLabel("Friday: ");
         fridayLabel.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
         saturdayLabel = new JLabel("Saturday: ");
         saturdayLabel.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
         
         labelPanel.add(mondayLabel);
         labelPanel.add(Box.createRigidArea(new Dimension(0, 4)));
         labelPanel.add(tuesdayLabel);
         labelPanel.add(Box.createRigidArea(new Dimension(0, 4)));
         labelPanel.add(wednsdayLabel);
         labelPanel.add(Box.createRigidArea(new Dimension(0, 4)));
         labelPanel.add(thorsdayLabel);
         labelPanel.add(Box.createRigidArea(new Dimension(0, 4)));
         labelPanel.add(fridayLabel);
         labelPanel.add(Box.createRigidArea(new Dimension(0, 4)));
         labelPanel.add(saturdayLabel);
         
         fieldPanel = new JPanel();
         fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
         
         mondayTextField = new JTextField(15);
         tuesdayTextField = new JTextField(15);
         wednsdayTextField = new JTextField(15);
         thorsdayTextField = new JTextField(15);
         fridayTextField = new JTextField(15);
         saturdayTextField = new JTextField(15);
         
         fieldPanel.add(mondayTextField);
         fieldPanel.add(tuesdayTextField);
         fieldPanel.add(wednsdayTextField);
         fieldPanel.add(thorsdayTextField);
         fieldPanel.add(fridayTextField);
         fieldPanel.add(saturdayTextField);
         
         //Adding elements to the main panel
         add(labelPanel);
         add(fieldPanel);
         
         setVisible(true);
      }
   
   }
   
   /**
    * Action listener for the buttons
    * @author Group6
    * @version 2.1.8
    * @implements ActionListener
    */
   private class ButtonListener implements ActionListener
   {
      /**
       * Listens to the actions and acts accordingly
       */
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == updateButton)
         {
            //updates staff time table
            updateStaffTimeTable();
         }
         else if(e.getSource() == editButton)
         {
            //Retrieving selected row
            int row = staffTimeTable.getSelectedRow();
            
            //Setting up the default values
            ChangeStaffTime changeStaffTimePanel = new ChangeStaffTime();
            
            String valueName = " ";
            String valueMonday = "0";
            String valueTuesday = "0";
            String valueWednsday = "0";
            String valueThorsday = "0";
            String valueFriday = "0";
            String valueSaturday = "0";
            
            //Tries to retrieve data from the table
            try
            {
               valueName = staffTimeTable.getModel().getValueAt(row, 0).toString();
               valueMonday = staffTimeTable.getModel().getValueAt(row, 2).toString();
               valueTuesday = staffTimeTable.getModel().getValueAt(row, 3).toString();
               valueWednsday = staffTimeTable.getModel().getValueAt(row, 4).toString();
               valueThorsday = staffTimeTable.getModel().getValueAt(row, 5).toString();
               valueFriday = staffTimeTable.getModel().getValueAt(row, 6).toString();
               valueSaturday = staffTimeTable.getModel().getValueAt(row, 7).toString();
            }
            catch(ArrayIndexOutOfBoundsException ex)
            {
               JOptionPane.showMessageDialog(staffTimeTable, "Data not selected");
            }
            
            //Sets data to the retrieved data
            changeStaffTimePanel.mondayTextField.setText(valueMonday);
            changeStaffTimePanel.tuesdayTextField.setText(valueTuesday);
            changeStaffTimePanel.wednsdayTextField.setText(valueWednsday);
            changeStaffTimePanel.thorsdayTextField.setText(valueThorsday);
            changeStaffTimePanel.fridayTextField.setText(valueFriday);
            changeStaffTimePanel.saturdayTextField.setText(valueSaturday);
            
            int n = JOptionPane.showConfirmDialog(null, changeStaffTimePanel, "Please enter the number of needed employees", JOptionPane.OK_CANCEL_OPTION); //Displays the panel
            
            //Checks for the okay option
            if(n == JOptionPane.OK_OPTION)
            {
               //Retrieves data from the fields
               String newValueMonday = changeStaffTimePanel.mondayTextField.getText();
               String newValueTuesday = changeStaffTimePanel.tuesdayTextField.getText();
               String newValueWednsday = changeStaffTimePanel.wednsdayTextField.getText();
               String newValueThorsday = changeStaffTimePanel.thorsdayTextField.getText();
               String newValueFriday = changeStaffTimePanel.fridayTextField.getText();
               String newValueSaturday = changeStaffTimePanel.saturdayTextField.getText();
               
               //Checks for null, "", " "
               if(newValueMonday == null || newValueMonday == " " || newValueMonday == "")
               {
                  newValueMonday = "0";
               }
               else if(newValueTuesday == null || newValueTuesday == " " || newValueTuesday == "")
               {
                  newValueTuesday = "0";
               }
               else if(newValueWednsday == null || newValueWednsday == " " || newValueWednsday == "")
               {
                  newValueWednsday = "0";
               }
               else if(newValueThorsday == null || newValueThorsday == " " || newValueThorsday == "")
               {
                  newValueThorsday = "0";
               }
               else if(newValueFriday == null || newValueFriday == " " || newValueFriday == "")
               {
                  newValueFriday = "0";
               }
               else if(newValueSaturday == null || newValueSaturday == " " || newValueSaturday == "")
               {
                  newValueSaturday = "0";
               }
               
               //Sets the data to the retrieved data
               system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis());
               system.getAnalysisList().getAnalysis(valueName).setNumOfEmployeeWeekDay(Integer.parseInt(newValueMonday), 0);
               system.getAnalysisList().getAnalysis(valueName).setNumOfEmployeeWeekDay(Integer.parseInt(newValueTuesday), 1);
               system.getAnalysisList().getAnalysis(valueName).setNumOfEmployeeWeekDay(Integer.parseInt(newValueWednsday), 2);
               system.getAnalysisList().getAnalysis(valueName).setNumOfEmployeeWeekDay(Integer.parseInt(newValueThorsday), 3);
               system.getAnalysisList().getAnalysis(valueName).setNumOfEmployeeWeekDay(Integer.parseInt(newValueFriday), 4);
               system.getAnalysisList().getAnalysis(valueName).setNumOfEmployeeWeekDay(Integer.parseInt(newValueSaturday), 5);
               systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList());
               
               //Updates the table
               updateStaffTimeTable();
            }
         }
      }
   }
}
