package nucleusGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import nucleus.AnalysisList;
import nucleus.EmployeeList;
import nucleus.SystemAdapterAnalysis;
import nucleus.SystemAdapterEmployee;
import nucleus.SystemSEP;

/**
 * Class that sets up a panel that displays information about the training, used by ShowTraining class
 * @author Group6
 * @version 2.8.1
 * @extends JPanel
 */
public class TrainingPanel extends JPanel
{
   private SystemAdapterAnalysis systemAdapterAnalysis; 
   private SystemAdapterEmployee systemAdapterEmployee;
   private ButtonListener buttonListener;
   private SystemSEP system;
   
   private JButton editButton, updateButton;
   private JPanel buttonPanel;
   
   private JTable trainingTable;
   private String[] columnName;
   private DefaultTableModel dtm;
   private JScrollPane trainingScrollPane;
   
   /**
    * No argument constructor that sets elements
    */
   public TrainingPanel()
   {
      //Initiates the elements
      systemAdapterAnalysis = new SystemAdapterAnalysis("analysis");
      systemAdapterEmployee = new SystemAdapterEmployee("employee");
      system = new SystemSEP();
      
      buttonListener = new ButtonListener();
      
      //Initiates the header of the table
      columnName = new String[systemAdapterAnalysis.getAllAnalysis().getNumAnalysis() + 2];
      
      columnName[0] = "ID";
      columnName[1] = "Name";
      
      for(int i = 0; i < systemAdapterAnalysis.getAllAnalysis().getNumAnalysis(); i++)
      {
         columnName[i + 2] = systemAdapterAnalysis.getAllAnalysis().getAnalysis(i).getName();
      }
      
      //Initiates the table and scroll pane
      dtm = new DefaultTableModel(columnName,120)
      {
         
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      trainingTable = new JTable(dtm);
      
      trainingTable.getColumnModel().getColumn(0).setMaxWidth(50); 
      for(int i = 1; i < columnName.length; i++)
      {
         trainingTable.getColumnModel().getColumn(i).setMinWidth(125);
      }
      
      trainingTable.getTableHeader().setReorderingAllowed(false);
      trainingTable.getTableHeader().setResizingAllowed(false);
      
      trainingTable.setCellSelectionEnabled(false);
      trainingTable.setEnabled(true);
      trainingTable.setFocusable(true);
      trainingTable.setRowSelectionAllowed(true);
      trainingTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      trainingTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      
      trainingScrollPane = new JScrollPane(trainingTable);
      trainingScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      trainingScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      trainingTable.setPreferredScrollableViewportSize(new Dimension(900, trainingTable.getRowHeight()*23));

      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

      editButton = new JButton("Change Training");
      editButton.addActionListener(buttonListener);
      
      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);
   
      buttonPanel.add(editButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(updateButton);
      
      //Adding elements to the main panel
      add(trainingScrollPane);
      add(buttonPanel, BorderLayout.NORTH);
   }
   
   /**
    * Class setting up the panel for changing the training status
    * @author Group6
    * @version 2.6.5
    * @extends JPanel
    */
   private class ChangeTraining extends JPanel
   {
      private JComboBox<String> comboBox;
      
      private JLabel nameLabel;
      
      private JPanel panel;
      
      /**
       * No argument constructor that sets elements
       */
      public ChangeTraining()
      {
         panel = new JPanel();
         
         String[] trainingStatus = {"Trained", "Under Training", "Not Trained"};
         
         comboBox = new JComboBox<String>(trainingStatus);
         
         nameLabel = new JLabel("Status");
         
         panel.add(nameLabel);
         panel.add(comboBox);
         
         add(panel);
         
         setVisible(true);
      }
   }
   
   /**
    * Updates the table with the most recent information
    */
   public void updateTrainingTable()
   {
      //Initiates the list and the data for the table
      EmployeeList employees = systemAdapterEmployee.getAllEmployee();
      AnalysisList analyses = systemAdapterAnalysis.getAllAnalysis();
      
      Object[][] data = new Object[employees.getNumEmployee()][systemAdapterAnalysis.getAllAnalysis().getNumAnalysis() + 2];
      
      for(int i = 0; i < employees.getNumEmployee(); i++)
      {
         data[i][0] = employees.getEmployee(i).getID();
         data[i][1] = employees.getEmployee(i).getName();
         
         for(int j = 0; j < analyses.getNumAnalysis(); j++)
         {
            data[i][j + 2] = employees.getEmployee(i).getTraining(analyses.getAnalysis(j).getName()).getStatus();
         }
      }
      
      //Sets up the table
      columnName = new String[systemAdapterAnalysis.getAllAnalysis().getNumAnalysis() + 2];
      
      columnName[0] = "ID";
      columnName[1] = "Name";
      
      for(int i = 0; i < systemAdapterAnalysis.getAllAnalysis().getNumAnalysis(); i++)
      {
         columnName[i + 2] = systemAdapterAnalysis.getAllAnalysis().getAnalysis(i).getName();
      }

      
      dtm = new DefaultTableModel(data, columnName)
      {
         
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      trainingTable.setModel(dtm);
      
      trainingTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      trainingTable.getColumnModel().getColumn(0).setMaxWidth(50); 
      for(int i = 1; i < columnName.length; i++)
      {
         trainingTable.getColumnModel().getColumn(i).setMinWidth(125);
      }
      
      trainingTable.getTableHeader().setReorderingAllowed(false);
      trainingTable.getTableHeader().setResizingAllowed(false);
      
      trainingTable.setCellSelectionEnabled(false);
      trainingTable.setEnabled(true);
      trainingTable.setFocusable(true);
      trainingTable.setRowSelectionAllowed(true);
      trainingTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   
   }
   
   /**
    * Action listener for the buttons
    * @author Group6
    * @version 4.1.9
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
            //updates the table
            updateTrainingTable();
         }
         else if(e.getSource() == editButton)
         {
            //Retrieves the selected row and column
            int row = trainingTable.getSelectedRow();
            int column = trainingTable.getSelectedColumn();
            
            //Initiates the training panel
            ChangeTraining trainingPanel = new ChangeTraining();
           
            //Sets default values
            String valueName = " ";
            String valueID = " ";
            String valueAnalysis = " ";
            
            //Tries to retrieve data from the selected cell
            try
            {
               valueName = trainingTable.getModel().getValueAt(row, 1).toString();
               valueID = trainingTable.getModel().getValueAt(row, 0).toString();
               valueAnalysis = trainingTable.getModel().getColumnName(column);
            }
            catch(ArrayIndexOutOfBoundsException ex)
            {
               JOptionPane.showMessageDialog(trainingTable, "Training Not Selected");
            }
            
            //Displays the training panel
            int n = JOptionPane.showConfirmDialog(null, trainingPanel, "Change Training", JOptionPane.OK_CANCEL_OPTION);
            
            //Checks for okay option
            if(n == JOptionPane.OK_OPTION)
            {
               String valueTraining = (String)trainingPanel.comboBox.getSelectedItem(); //Retrieves data from the combo box
               
               //Gets the list, sets the training, saves the data, updates the table
               system.setEmployeeList(systemAdapterEmployee.getAllEmployee());
               system.getEmployeeList().getEmployee(valueName, valueID).setTraining(valueAnalysis, valueTraining);
               systemAdapterEmployee.saveEmployeeList(system.getEmployeeList()); 
               updateTrainingTable();
            }
         }
      }
   }
}
