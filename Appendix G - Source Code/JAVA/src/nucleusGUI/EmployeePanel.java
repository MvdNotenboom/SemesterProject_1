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
import nucleus.Employee;
import nucleus.EmployeeList;
import nucleus.SystemAdapterAnalysis;
import nucleus.SystemAdapterEmployee;
import nucleus.SystemSEP;

import java.lang.ArrayIndexOutOfBoundsException;

/**
 * Class that sets up a panel that displays information about the employees, used by ShowEmployee class
 * @author Group6
 * @version 12.1.2
 * @extends JPanel
 */
public class EmployeePanel extends JPanel
{
   private SystemSEP system;
   private SystemAdapterEmployee systemAdapterEmployee; 
   private SystemAdapterAnalysis systemAdapterAnalysis;
   
   private ButtonListener buttonListener;
   
   private JTable allEmployeeTable;
   private String[] columnNames;
   private DefaultTableModel dtm;
   private JScrollPane allEmployeeScrollPane;
   
   private JPanel buttonPanel;
   
   private JButton createButton, deleteButton, updateButton, editButton;
   
   /**
    * No argument constructor that sets everything up
    */
   public EmployeePanel()
   {
     
      systemAdapterEmployee = new SystemAdapterEmployee("employee"); //Initializing the system adapter for the employees
      systemAdapterAnalysis = new SystemAdapterAnalysis("analysis"); //Initializing the system adapter for the analyses
      system = new SystemSEP(); //Initializing the system class
      
      buttonListener = new ButtonListener(); 
      
      //Setting up the columns of the table
      columnNames = new String[3];
      columnNames[0] = "ID";
      columnNames[1] = "Name";
      columnNames[2] = "e-mail";
      
      //Creating the default table model with the columns made before, overriding the isCellEditable method so it is always false
      dtm = new DefaultTableModel(columnNames,120)
      {
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      //Initializing the table with the default table model
      allEmployeeTable = new JTable(dtm);
      
      //Setting up the table columns' characteristics
      allEmployeeTable.getTableHeader().setReorderingAllowed(false);
      allEmployeeTable.getTableHeader().setResizingAllowed(false);
      
      //Setting up table's characteristics
      allEmployeeTable.setCellSelectionEnabled(false);
      allEmployeeTable.setEnabled(true);
      allEmployeeTable.setFocusable(true);
      allEmployeeTable.setRowSelectionAllowed(true);
      allEmployeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      //Setting up the scroll panel for the table
      allEmployeeScrollPane = new JScrollPane(allEmployeeTable);
      
      //Setting up the scroll panel's characteristics 
      allEmployeeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      allEmployeeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      allEmployeeTable.setPreferredScrollableViewportSize(new Dimension(900, allEmployeeTable.getRowHeight()*50));
      
      //Initializing the panel for button and buttons
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
      
      createButton = new JButton("Add Employee");
      createButton.addActionListener(buttonListener);
      
      deleteButton = new JButton("Delete Employee");
      deleteButton.addActionListener(buttonListener);
      
      editButton = new JButton("Edit Employee");
      editButton.addActionListener(buttonListener);
      
      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);
      
      buttonPanel.add(createButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(deleteButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));
      buttonPanel.add(editButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(updateButton);
      
      //Adding elements to the main panel
      add(allEmployeeScrollPane);
      add(buttonPanel, BorderLayout.NORTH);
   }
   
   /**
    * Class for setting up the panel for adding new employees
    * @author Group6
    * @version 7.2.5
    * @extends JPanel
    */
   private class CreateNewEmployee extends JPanel
   {
      private JTextField nameField, idField, emailField;
      
      private JLabel nameLabel, idLabel, emailLabel;
      
      private JPanel labelPanel, fieldPanel;
      
      /**
       * No argument constructor for initializing the elements
       */
      public CreateNewEmployee()
      {  
         //Initializing the panel, labels and text fields
         labelPanel = new JPanel();
         
         nameLabel = new JLabel("Name: ");
         idLabel = new JLabel("ID: ");
         emailLabel = new JLabel("e-mail: ");
         
         labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
         
         labelPanel.add(nameLabel);
         labelPanel.add(idLabel);
         labelPanel.add(emailLabel);
         
         fieldPanel = new JPanel();
         
         nameField = new JTextField(15);
         idField = new JTextField(15);
         emailField = new JTextField(15);
         
         fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
         
         fieldPanel.add(nameField);
         fieldPanel.add(idField);
         fieldPanel.add(emailField);
         
         //Adding elements to the main panel
         add(labelPanel, BorderLayout.WEST);
         add(fieldPanel, BorderLayout.EAST);
         
         setVisible(true);
      }
   }
   
   /**
    * Class for setting up the panel for deleting employees
    * @author Group6
    * @version 4.5.1
    * @extends JPanel
    */
   private class DeleteEmployee extends JPanel
   {
      private JTextField nameField, idField;

      private JLabel nameLabel, idLabel;
      
      private JPanel labelPanel, fieldPanel;
      
      /**
       * No argument constructor to initialize the elements
       */
      public DeleteEmployee()
      {
         //Setting up the panel, labels and text fields
         labelPanel = new JPanel();
         
         nameLabel = new JLabel("Name: ");
         idLabel = new JLabel("ID: ");
         
         labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
         
         labelPanel.add(nameLabel);
         labelPanel.add(idLabel);
         
         fieldPanel = new JPanel();
         
         nameField = new JTextField(15);
         idField = new JTextField(15);
         
         fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
         
         fieldPanel.add(nameField);
         fieldPanel.add(idField);
         
         //Adding elements to the main panel
         add(labelPanel, BorderLayout.WEST);
         add(fieldPanel, BorderLayout.EAST);

         setVisible(true);
      }
   }
   
   /**
    * Class for setting up the panel for editing employees
    * @author Group6
    * @version 7.4.1
    * @extends JPanel
    */
   private class EditEmployee extends JPanel
   {
      private JTextField nameField, idField, emailField;
      
      private JLabel nameLabel, idLabel, emailLabel;
      
      private JPanel labelPanel, fieldPanel;
      
      /**
       * No argument constructor for setting up the elemnts
       */
      public EditEmployee()
      {  
         //Initializing the panel, labels and text fields
         labelPanel = new JPanel();
         
         nameLabel = new JLabel("Name: ");
         idLabel = new JLabel("ID: ");
         emailLabel = new JLabel("e-mail: ");
         
         labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
         
         labelPanel.add(nameLabel);
         labelPanel.add(idLabel);
         labelPanel.add(emailLabel);
         
         fieldPanel = new JPanel();
         
         nameField = new JTextField(15);
         idField = new JTextField(15);
         emailField = new JTextField(15);
         
         fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
         
         fieldPanel.add(nameField);
         fieldPanel.add(idField);
         fieldPanel.add(emailField);
         
         //Adding elements to the main panel
         add(labelPanel, BorderLayout.WEST);
         add(fieldPanel, BorderLayout.EAST);
         
         setVisible(true);
      }
   }
   
   /**
    * Updates the table with the most recent information
    */
   public void updateEmployeeTable()
   {
      EmployeeList employees = systemAdapterEmployee.getAllEmployee();//Gets data from the bin file
      
    //Initializes the table's data
      Object[][] data = new Object[employees.getNumEmployee()][3];
      
      for(int i = 0; i < employees.getNumEmployee(); i++)
      {
         data[i][0] = employees.getEmployee(i).getID();
         data[i][1] = employees.getEmployee(i).getName();
         data[i][2] = employees.getEmployee(i).getEmail();
      }
      
      //Sets up the default table model with the initialized data and column names
      dtm = new DefaultTableModel(data, columnNames)
      {
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      //Sets up the table with the default table model
      allEmployeeTable.setModel(dtm);
      
      //Sets up the table header's characteristics
      allEmployeeTable.getTableHeader().setReorderingAllowed(false);
      allEmployeeTable.getTableHeader().setResizingAllowed(false);
     
      //Sets up the table's characteristics
      allEmployeeTable.setCellSelectionEnabled(false);
      allEmployeeTable.setEnabled(true);
      allEmployeeTable.setFocusable(true);
      allEmployeeTable.setRowSelectionAllowed(true);
      allEmployeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   }  
   
   /**
    * Action listener for the buttons
    * @author Group6
    * @version 3.7.5
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
            CreateNewEmployee newEmployeePanel = new CreateNewEmployee(); //Initializing the panel for adding employees
            
            int n = JOptionPane.showConfirmDialog(null, newEmployeePanel, "Enter data about the new employee", JOptionPane.OK_CANCEL_OPTION); //Displaying the panel
            
            //Checking for the okay option
            if(n == JOptionPane.OK_OPTION)
            {
               String name = newEmployeePanel.nameField.getText();  //Retrieves the name from the field
               String id = newEmployeePanel.idField.getText();      //Retrieves the ID from the field
               String email = newEmployeePanel.emailField.getText();//Retrieves the email from the field
               
               //Checks for null input to avoid null exceptions
               if(name == null)
               {
                  name = " ";
               }
               else if(id == null)
               {
                  id = " ";
               }
               else if(email == null)
               { 
                  email = " ";
               }
               else
               {
                  Employee newEmployee = new Employee(name, email, id); //Creates new employee with the retrieved data
                  
                  system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Gets the analysis list from the bin
                  AnalysisList analyses = system.getAnalysisList(); //Initiates the analysis list
                  newEmployee.setTraining(analyses); //Sets the default training for the analyses 
                  
                  system.setEmployeeList(systemAdapterEmployee.getAllEmployee()); //Gets the employee list from the bin
                  system.getEmployeeList().addEmployee(newEmployee); //Adds the new employee to the list
                  systemAdapterEmployee.saveEmployeeList(system.getEmployeeList()); //Saves the list
                  
                  //Updates the table
                  updateEmployeeTable();
               }
            }
         }
         else if(e.getSource() == deleteButton)
         {
            DeleteEmployee employeePanel = new DeleteEmployee(); //Initializing panel for deleting employees
            
            int row = allEmployeeTable.getSelectedRow(); //Retrieves the selected row
            
            //Initializing the data to default
            String valueID = " ";
            String valueName = " ";
            
            //Tries to retries data from the selected row
            try
            {
               valueID = allEmployeeTable.getModel().getValueAt(row, 0).toString();
               valueName = allEmployeeTable.getModel().getValueAt(row, 1).toString();
            }
            
            //Catches the error in case no row selected 
            catch(ArrayIndexOutOfBoundsException ex)
            {
               JOptionPane.showInternalMessageDialog(allEmployeeTable, "Employee not selected!");
            }
            
            //Sets the nameField and idField to the retrieved data
            employeePanel.idField.setText(valueID);
            employeePanel.nameField.setText(valueName);
            
            int n = JOptionPane.showConfirmDialog(null, employeePanel, "Enter the name and id of the employee", JOptionPane.OK_CANCEL_OPTION); //Displays the delete panel
            
            //Checks if the option okay
            if(n == JOptionPane.OK_OPTION)
            {
               String name = employeePanel.nameField.getText(); //Retrieves name from nameField
               String id = employeePanel.idField.getText(); //Retrieves id from idField
               
               //Checks for null
               if(name == null)
               {
                  name = " ";
               }
               else if(id == null)
               {
                  id = " ";
               }
               else
               {
                  Employee employee = new Employee(name, id); //Creates employee to be deleted
                  
                  system.setEmployeeList(systemAdapterEmployee.getAllEmployee()); //Gets the employee list from the bin
                  system.getEmployeeList().removeEmployee(employee);              //Deletes the employee from the list
                  systemAdapterEmployee.saveEmployeeList(system.getEmployeeList());//Saves the list
                  
                  updateEmployeeTable(); //updates the table
               }
            }
         }
         else if(e.getSource() == editButton)
         {
            EditEmployee editEmployeePanel = new EditEmployee(); //Creates a new employee to be edited
            
            int row = allEmployeeTable.getSelectedRow(); //Retrieves the selected row
            
            //Initiates the default data
            String valueID = " ";
            String valueName = " ";
            String valueEmail = " ";
            
            //Tries to retrieve data from the selected row
            try
            {
               valueID = allEmployeeTable.getModel().getValueAt(row, 0).toString();
               valueName = allEmployeeTable.getModel().getValueAt(row, 1).toString();
               valueEmail = allEmployeeTable.getModel().getValueAt(row, 2).toString();
            }
            
            //Catches exception in case of no selected row
            catch(ArrayIndexOutOfBoundsException ex)
            {
               JOptionPane.showMessageDialog(allEmployeeTable, "Employee not selected!");
            }
            
            //Sets the id, name and email to the retrieved data
            editEmployeePanel.idField.setText(valueID);
            editEmployeePanel.nameField.setText(valueName);
            editEmployeePanel.emailField.setText(valueEmail);
            
            int n = JOptionPane.showConfirmDialog(null, editEmployeePanel, "Enter data about the new employee", JOptionPane.OK_CANCEL_OPTION); //Displays the edit panel
            
            //Checks for okay option
            if(n == JOptionPane.OK_OPTION)
            {
               //Retrieves data from the name, id and email field
               String name = editEmployeePanel.nameField.getText();
               String id = editEmployeePanel.idField.getText();
               String email = editEmployeePanel.emailField.getText();
               
               
               Employee employeeToBeEdited = new Employee(valueName, valueEmail, valueID); //Creates employee to be edited
               
               system.setEmployeeList(systemAdapterEmployee.getAllEmployee()); //Gets the current employee list 
               String tempPreferences = system.getEmployeeList().getEmployee(valueName, valueID).getPreferences(); //Temporarily saves the employee's preferences
               //Needs also to be done for training!!!
               system.getEmployeeList().removeEmployee(employeeToBeEdited);//Removes the employee to be edited
               
               //Checks for null
               if(name == null)
               {
                  name = " ";
               }
               else if(id == null)
               {
                  id = " ";
               }
               else if(email == null)
               { 
                  email = " ";
               }
               else
               {
                  Employee editedEmployee = new Employee(name, email, id); //Creates edited employee
                  
                  system.setAnalaysisList(systemAdapterAnalysis.getAllAnalysis()); //Gets the analysis list from bin
                 
                  AnalysisList analyses = system.getAnalysisList(); //Creates a list with analyses
                 
                  editedEmployee.setTraining(analyses);                                //Initiates the training to default
                  editedEmployee.setPreferences(tempPreferences);                      //Sets preferences to the temporarily saved preferences
                  system.getEmployeeList().addEmployee(editedEmployee);                //Adds employee to the list
                  systemAdapterEmployee.saveEmployeeList(system.getEmployeeList());    //Saves the list
                  
                  //Updates the table
                  updateEmployeeTable();
               }
            }
         }
         else if(e.getSource() == updateButton)
         {
            //Updates the table
            updateEmployeeTable();
         }
      }
   }
}
