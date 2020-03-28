package nucleusGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import nucleus.Analysis;
import nucleus.AnalysisList;
import nucleus.SystemAdapterAnalysis;
import nucleus.SystemSEP;

/**
 * Class that sets up a panel that displays information about the analyses, used by ShowAnalysis class
 * @author Group6
 * @version 9.2.3
 * @extends JPanel
 */
public class AnalysisPanel extends JPanel
{
   private SystemAdapterAnalysis systemAdapterAnalysis; 
   private SystemSEP system;
   
   private ButtonListener buttonListener;
   
   private JTable allAnalysisTable;
   private String[] columnNames;
   private DefaultTableModel dtm;
   private JScrollPane allAnalysisScrollPane;
   
   private JPanel buttonPanel;
   
   private JButton createButton, deleteButton, updateButton, editButton;
   
   /**
    * No argument constructor that sets elements
    */
   public AnalysisPanel()
   {
      systemAdapterAnalysis = new SystemAdapterAnalysis("analysis"); //Initializing the system adapter for the analyses
      system = new SystemSEP(); //Initializing the system class
      
      buttonListener = new ButtonListener();
      
      //Setting up the columns of the table
      columnNames = new String[3];
      columnNames[0] = "Name";
      columnNames[1] = "Type";
      columnNames[2] = "Number of Employees";
      
      //Creating the default table model with the columns made before, overriding the isCellEditable so it is always false
      dtm = new DefaultTableModel(columnNames,120)
      {
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn) 
         {
            return false;
         }
      };
      
      //Initializing the table with the default table model
      allAnalysisTable = new JTable(dtm);
      
      //Setting up the columns' characteristics 
      allAnalysisTable.getTableHeader().setReorderingAllowed(false);
      allAnalysisTable.getTableHeader().setResizingAllowed(false);
      
      //Setting up the table's characteristics
      allAnalysisTable.setEnabled(true);
      allAnalysisTable.setFocusable(true);
      allAnalysisTable.setRowSelectionAllowed(true);
      allAnalysisTable.setColumnSelectionAllowed(false);
      allAnalysisTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      //Setting up the scroll panel for the table
      allAnalysisScrollPane = new JScrollPane(allAnalysisTable);
      
      //Setting up the scroll panel's characteristics 
      allAnalysisScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      allAnalysisScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      allAnalysisTable.setPreferredScrollableViewportSize(new Dimension(900, allAnalysisTable.getRowHeight()*50));
     
      //Initializing the panel for button and buttons
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
      
      createButton = new JButton("Add Analysis");
      createButton.addActionListener(buttonListener);
      
      deleteButton = new JButton("Delete Analysis");
      deleteButton.addActionListener(buttonListener);
      
      editButton = new JButton("Edit Analysis");
      editButton.addActionListener(buttonListener);
      
      updateButton = new JButton("Update Table");
      updateButton.addActionListener(buttonListener);
      
      buttonPanel.add(createButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0))); //Space between buttons
      buttonPanel.add(deleteButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(editButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(updateButton);
      
      //Adding elements to the main panel
      add(allAnalysisScrollPane);
      add(buttonPanel, BorderLayout.NORTH);
   }
   
   /**
    * Class for setting up the panel for adding new analyses
    * @author Group6
    * @version 6.2.3
    * @extends JPanel
    */
   private class CreateNewAnalysis extends JPanel
   {
      
      private JRadioButton smallButton, largeButton;
      private ButtonGroup radioGroup;
      
      private JLabel nameLabel;
      private JTextField nameField;
    
      private JPanel typePanel, namePanel;
      
      /**
       * No argument constructor for initializing the elements
       */
      public CreateNewAnalysis()
      {
         //Initializing the panel, labels, text fields and radio group
         namePanel = new JPanel();
         
         nameLabel = new JLabel("Name: ");
         nameField = new JTextField(15);
         
         namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
         
         namePanel.add(nameLabel);
         namePanel.add(nameField);
         
         radioGroup = new ButtonGroup();
         typePanel = new JPanel();
         
         smallButton = new JRadioButton("Small Week");
         largeButton = new JRadioButton("Large Week");
        
         radioGroup.add(smallButton);
         radioGroup.add(largeButton);
         
         typePanel.add(smallButton);
         typePanel.add(largeButton);
         
         //Adding elements to the main panel
         add(namePanel, BorderLayout.SOUTH);
         add(typePanel, BorderLayout.NORTH);
         
         setVisible(true);
      }
   }
   
   /**
    * Class for setting up the panel for deleting analyses
    * @author Group6
    * @version 4.3.1
    * @extends JPanel
    */
   private class DeleteAnalysis extends JPanel
   {
      private JRadioButton smallButton, largeButton;
      private ButtonGroup radioGroup;
      
      private JLabel nameLabel;
      private JTextField nameField;
      
      private JPanel typePanel, namePanel;
      
      /**
       * No argument constructor to initialize the elements
       */
      public DeleteAnalysis()
      {
         //Setting up the panel, labels and text fields
         namePanel = new JPanel();
         
         nameLabel = new JLabel("Name: ");
         nameField = new JTextField(15);
         
         namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
         
         namePanel.add(nameLabel);
         namePanel.add(nameField);
         
         typePanel = new JPanel();
         radioGroup = new ButtonGroup();
         
         smallButton = new JRadioButton("Small Week");
         largeButton = new JRadioButton("Large Week");
         
         radioGroup.add(smallButton);
         radioGroup.add(largeButton);

         typePanel.add(smallButton);
         typePanel.add(largeButton);
         
         //Adding the elements to the main panel
         add(namePanel, BorderLayout.SOUTH);
         add(typePanel, BorderLayout.NORTH);
         
         setVisible(true);
      }
   }
   
   /**
    * Class for setting up the panel for editing analyses
    * @author Group6
    * @version 5.3.9
    * @extends JPanel
    */
   private class EditAnalysis extends JPanel
   {
      private JRadioButton smallButton, largeButton;
      private ButtonGroup radioGroup;
      
      private JLabel nameLabel;
      private JTextField nameField;
      
      private JPanel typePanel, namePanel;
      
      /**
       * No argument constructor for setting up the elements
       */
      public EditAnalysis()
      {
         //Initializing the panel, labels, text fields and radio group
         namePanel = new JPanel();
         
         nameLabel = new JLabel("Name: ");
         nameField = new JTextField(15);
         
         namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
         
         namePanel.add(nameLabel);
         namePanel.add(nameField);
         
         typePanel = new JPanel();
         radioGroup = new ButtonGroup();
         
         smallButton = new JRadioButton("Small Week");
         largeButton = new JRadioButton("Large Week");
         
         radioGroup.add(smallButton);
         radioGroup.add(largeButton);

         typePanel.add(smallButton);
         typePanel.add(largeButton);
         
         //Adding up elements to the main panel
         add(namePanel, BorderLayout.SOUTH);
         add(typePanel, BorderLayout.NORTH);
         
         setVisible(true);
      }
   }
   
   /**
    * Updates the table with the most recent information
    */
   public void updateAnalysisTable()
   {
      AnalysisList analyses = systemAdapterAnalysis.getAllAnalysis(); //Gets data from the bin file
      
      //Initializes the table's data
      Object[][] data = new Object[analyses.getNumAnalysis()][3];
      
      for(int i = 0; i < analyses.getNumAnalysis(); i++)
      {
         data[i][0] = analyses.getAnalysis(i).getName();
         data[i][1] = analyses.getAnalysis(i).getStringType();
         data[i][2] = analyses.getAnalysis(i).getNumEmployee();
      }
      
      //Sets up the default table model with the initialized data and column names
      dtm = new DefaultTableModel(data, columnNames)
      {
         
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn) //Override the isCellEditable method to false
         {
            return false;
         }
      };
      
      //Sets up the table with the default table model
      allAnalysisTable.setModel(dtm);
      
      
      //Sets up the table header's characteristics
      allAnalysisTable.getTableHeader().setReorderingAllowed(false);
      allAnalysisTable.getTableHeader().setResizingAllowed(false);
      
      
      //Sets up the table's characteristics
      allAnalysisTable.setCellSelectionEnabled(false);
      allAnalysisTable.setEnabled(true);
      allAnalysisTable.setFocusable(true);
      allAnalysisTable.setRowSelectionAllowed(true);
      allAnalysisTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
         if(e.getSource() == createButton)
         {
           CreateNewAnalysis newAnalysis = new CreateNewAnalysis(); //Initializing panel for adding analyses
           
           int n = JOptionPane.showConfirmDialog(null, newAnalysis, "Enter date about the analysis", JOptionPane.OK_CANCEL_OPTION); //Displaying the initialized panel
           
           if (n == JOptionPane.OK_OPTION) //Checking the okay option
           {
              String name = newAnalysis.nameField.getText(); //Retrieves the name from the nameField
              
              //Checking for null input to avoid Null Exceptions
              if(name == null)
              {
                 name = "";
              }
              
              //Checks selected type of the week
              if(newAnalysis.smallButton.isSelected())
              {
                 Analysis analysis = new Analysis(name, true); //Creates a new analysis with the specified data
                 
                 system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Gets the current list of analyses
                 system.getAnalysisList().addAnalysis(analysis);                  //Adds the new analysis to the list
                 systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList());//Saves the new list to the bin file  
                 
                 updateAnalysisTable(); //Updates the table
              }
              else if(newAnalysis.largeButton.isSelected())
              {
                 Analysis analysis = new Analysis(name, false);
   
                 system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Gets the current list of analyses
                 system.getAnalysisList().addAnalysis(analysis);                  //Adds the new analysis to the list
                 systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList());//Saves the new list to the bin file  
                 
                 updateAnalysisTable(); //Updates the table
              }
              else
              {
                 Analysis analysis = new Analysis(name, true); //Creates a new analysis with the specified data
        
                 system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Gets the current list of analyses
                 system.getAnalysisList().addAnalysis(analysis);          //Adds the new analysis to the list
                 systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList());//Saves the new list to the bin file   
                 
                 updateAnalysisTable(); //Updates the table
              }
           }
         }
         
         else if(e.getSource() == deleteButton)
         {
            DeleteAnalysis deleteAnalysis = new DeleteAnalysis(); //Initializing panel for deleting analyses
            
            int row = allAnalysisTable.getSelectedRow(); //Retrieves the selected row
            
            //Initializing the data to default
            String valueName = " ";
            boolean valueType = false;
            
            //Tries to retrieve data from the selected row 
            try
            {
               valueName = allAnalysisTable.getModel().getValueAt(row, 0).toString(); //Retrieving the name
               
               //Retrieving the type
               if(allAnalysisTable.getModel().getValueAt(row, 1).toString().equals("Small"))
               {
                  valueType = true;
               }
               else
               {
                  valueType = false;
               }   
            }
            
            //Catches the error in case no row selected
            catch(ArrayIndexOutOfBoundsException ex)
            {
               JOptionPane.showInternalMessageDialog(allAnalysisTable, "Analysis not selected!");
            }
            
            //Sets the nameField to the retrieved data
            deleteAnalysis.nameField.setText(valueName);
            
            //Sets the radio button to the retrieved data
            if(valueType)
            {
               deleteAnalysis.smallButton.setSelected(true);
            }
            else
            {
               deleteAnalysis.largeButton.setSelected(true);
            }
            
            int n = JOptionPane.showConfirmDialog(null, deleteAnalysis, "Delete Analysis", JOptionPane.OK_CANCEL_OPTION); //Shows the delete panel
            
            //Checks if the option is okay
            if(n == JOptionPane.OK_OPTION)
            {
               String name = deleteAnalysis.nameField.getText(); //Retrieves the data from the nameField
               
               //Checks for null
               if(name == null)
               {
                  name = "";
               }
               
               //Checks for type
               if(deleteAnalysis.smallButton.isSelected())
               {
                  Analysis analysis = new Analysis(name, true); //Creates new analysis with the retrieved data
       
                  system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Retrieves the current version of the analysis list
                  system.getAnalysisList().removeAnalysis(analysis);               //Deletes the selected analysis
                  systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList());//Saves the new list 
                  
                  updateAnalysisTable(); //updates the table
               }
               else if(deleteAnalysis.largeButton.isSelected()) 
               {
                  Analysis analysis = new Analysis(name, false); //Creates new analysis with the retrieved data
   
                  system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Retrieves the current version of the analysis list
                  system.getAnalysisList().removeAnalysis(analysis);               //Deletes the selected analysis
                  systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList());//Saves the new list  
                  
                  updateAnalysisTable(); //updates the table
               }
               else
               {
                  Analysis analysis = new Analysis(name, true); //Creates new analysis with the retrieved data
   
                  system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Retrieves the current version of the analysis list
                  system.getAnalysisList().removeAnalysis(analysis);               //Deletes the selected analysis
                  systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList());//Saves the new list   
                  
                  updateAnalysisTable(); //updates the table
               }
            }
         }
         else if(e.getSource() == editButton)
         {
            EditAnalysis editAnalysis = new EditAnalysis(); //Initializing the panel for editing analyses
            
            int row = allAnalysisTable.getSelectedRow(); //Retrieves selected row
            
            //Initializing the data to default
            String valueName = " ";
            boolean valueType = false;
            
            //Tries to retrieve data from the selected row 
            try
            {
               valueName = allAnalysisTable.getModel().getValueAt(row, 0).toString(); //Retrieving the name
               
               //Retrieving the type
               if(allAnalysisTable.getModel().getValueAt(row, 1).toString().equals("Small"))
               {
                  valueType = true;
               }
               else
               {
                  valueType = false;
               }   
            }
            
            //Catches the error in case no row selected
            catch(ArrayIndexOutOfBoundsException ex)
            {
               JOptionPane.showInternalMessageDialog(allAnalysisTable, "Analysis not selected!");
            }
            
            //Sets the nameField to the retrieved data
            editAnalysis.nameField.setText(valueName);
            
            //Sets the radio button to the retrieved data
            if(valueType)
            {
               editAnalysis.smallButton.setSelected(true);
            }
            else
            {
               editAnalysis.largeButton.setSelected(true);
            }

            int n = JOptionPane.showConfirmDialog(null, editAnalysis, "Edit Analysis", JOptionPane.OK_CANCEL_OPTION); //Shows the delete panel
      
            Analysis analysisToBeEdited = new Analysis(valueName, valueType); //Creates an analysis that will be deleted from the bin file
                    
            system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Gets the current version of the analysis list
            system.getAnalysisList().removeAnalysis(analysisToBeEdited); //Deletes analysis to be edited
            
            //Checks for okay option
            if(n == JOptionPane.OK_OPTION)
            {  
               String newName = editAnalysis.nameField.getText(); //Retrieves the data from the nameField      
               
               //Checks for null
               if(newName == null)
               {
                  newName = " ";
               }
               
             //Checks for type
               if(editAnalysis.smallButton.isSelected())
               {
                  Analysis analysisEdited = new Analysis(newName, true);//Creates the edited analysis with the retrieved data
      
                  system.getAnalysisList().addAnalysis(analysisEdited); //Adds analysis to the list
                  systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList()); //Saves the list
                  
                  //Updates the table
                  updateAnalysisTable();
               }
               else if(editAnalysis.largeButton.isSelected())
               {
                  Analysis analysisEdited = new Analysis(newName, false); //Creates the edited analysis with the retrieved data
    
                  system.getAnalysisList().addAnalysis(analysisEdited); //Adds analysis to the list
                  systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList()); //Saves the list
                  
                  //Updates the table
                  updateAnalysisTable();
               }
               else
               {
                  Analysis analysisEdited = new Analysis(newName, true); //Creates the edited analysis with the retrieved data
   
                  system.getAnalysisList().addAnalysis(analysisEdited); //Adds analysis to the list
                  systemAdapterAnalysis.saveAnalysisList(system.getAnalysisList());  //Saves the list
                  
                  //Updates the table
                  updateAnalysisTable();
               }
            }
         }
         else if(e.getSource() == updateButton)
         {
            //Updates the table
            updateAnalysisTable();
         }
      }
   }
}
