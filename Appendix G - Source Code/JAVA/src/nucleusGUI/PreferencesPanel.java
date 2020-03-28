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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import nucleus.EmployeeList;
import nucleus.SystemAdapterEmployee;
import nucleus.SystemSEP;

/**
 * Class that sets up a panel that displays information about the employee's preferences
 * @author Group6
 * @version 4.8.1
 * @extends JPanel
 */
public class PreferencesPanel extends JPanel
{
   private SystemAdapterEmployee systemAdapter; 
   private ButtonListener buttonListener;
   private SystemSEP system;
   
   private JButton editButton, updateButton;
   
   private JPanel buttonPanel;

   private JTable preferencesTable;
   private String[] columnNames;
   private DefaultTableModel dtm;
   private JScrollPane preferencesScrollPane;
   
   /**
    * No argument constructor to set up all the elements
    */
   public PreferencesPanel()
   {
      //Initializing the elements
      systemAdapter = new SystemAdapterEmployee("employee");
      system = new SystemSEP();
      
      buttonListener = new ButtonListener();
      
      //Setting up columns of the table
      columnNames = new String[3];
      columnNames[0] = "ID";
      columnNames[1] = "Name";
      columnNames[2] = "Preferences";
      
      //Creating the default table model
      dtm = new DefaultTableModel(columnNames,120)
      {
         
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      //Initializing table and scroll panel elements
      preferencesTable = new JTable(dtm);
      
      preferencesTable.getTableHeader().setReorderingAllowed(false);
      preferencesTable.getTableHeader().setResizingAllowed(false);
      
      preferencesTable.setCellSelectionEnabled(false);
      preferencesTable.setEnabled(true);
      preferencesTable.setFocusable(true);
      preferencesTable.setRowSelectionAllowed(true);
      preferencesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      preferencesScrollPane = new JScrollPane(preferencesTable);
      
      preferencesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      preferencesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      preferencesTable.setPreferredScrollableViewportSize(new Dimension(900, preferencesTable.getRowHeight()*23));
      
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

      editButton = new JButton("Edit Preferences");
      editButton.addActionListener(buttonListener);
      
      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);
   
      buttonPanel.add(editButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(updateButton);
      
      //Adding elements to the panel
      add(preferencesScrollPane);
      add(buttonPanel, BorderLayout.NORTH);
   }
   
   /**
    * Class for setting up the panel for editing preferences
    * @author Group6
    * @version 2.3.5
    */
   public class EditPreferences extends JPanel
   {
      private JTextField nameField, idField; 
      
      private JLabel nameLabel, idLabel, preferencesLabel;
      
      private JTextArea preferencesField;
      
      private JPanel namePanel, idPanel, preferencesPanel; 
      
      /**
       * No argument constructor for setting up the elements
       */
      public EditPreferences()
      {
         //Initializing the elements 
         namePanel = new JPanel();
         
         nameLabel = new JLabel("Name: ");
         nameLabel.setPreferredSize(new Dimension(85, 20));
         nameField = new JTextField(15);
        
         namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
         
         namePanel.add(nameLabel);
         namePanel.add(nameField);

         idPanel = new JPanel();
         
         idLabel = new JLabel("ID: ");
         idLabel.setPreferredSize(new Dimension(85, 20));
         idField = new JTextField(15);
         
         idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
         
         idPanel.add(idLabel);
         idPanel.add(idField);
         
         preferencesPanel = new JPanel();
         
         preferencesLabel = new JLabel("Preferences: ");
         preferencesLabel.setPreferredSize(new Dimension(85, 20));
         preferencesField = new JTextArea(5, 15);
         preferencesField.setLineWrap(true);
         preferencesField.setWrapStyleWord(true);
         
         preferencesPanel.setLayout(new BoxLayout(preferencesPanel, BoxLayout.X_AXIS));
         
         preferencesPanel.add(preferencesLabel);
         preferencesPanel.add(preferencesField);
         
         //Adding elements to the main panel
         add(namePanel);
         add(idPanel);
         add(preferencesPanel);
         
         setVisible(true);
      }
   }
   
   /**
    * Updates the preferences table
    */
   public void updatePreferencesTable()
   {
      //Setting up the data in the table
      EmployeeList employees = systemAdapter.getAllEmployee(); 
      Object[][] data = new Object[employees.getNumEmployee()][3];
      
      for(int i = 0; i < employees.getNumEmployee(); i++)
      {
         data[i][0] = employees.getEmployee(i).getID();
         data[i][1] = employees.getEmployee(i).getName();
         data[i][2] = employees.getEmployee(i).getPreferences();
      }
      
      //Setting up the table with the prepared data
      dtm = new DefaultTableModel(data, columnNames)
      {
         
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
 
      preferencesTable.setModel(dtm);
      
      preferencesTable.getTableHeader().setReorderingAllowed(false);
      preferencesTable.getTableHeader().setResizingAllowed(false);
      
      preferencesTable.setCellSelectionEnabled(false);
      preferencesTable.setEnabled(true);
      preferencesTable.setFocusable(true);
      preferencesTable.setRowSelectionAllowed(true);
      preferencesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   }
   
   /**
    * Action listener for the buttons
    * @author Group6
    * @version 1.5.9
    * @implements ActionListener
    */
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == editButton)
         {
            EditPreferences preferencesPanel = new EditPreferences(); //Initializing the panel
            
            int row = preferencesTable.getSelectedRow(); //Retrieving the selected row
            
            //Initializing data to default
            String valueID = " ";
            String valueName = " ";
            String valuePreferences = " ";
            
            //Tries to retrieve data from the selected row
            try
            {
               valueID = preferencesTable.getModel().getValueAt(row, 0).toString();
               valueName = preferencesTable.getModel().getValueAt(row, 1).toString();
               valuePreferences = preferencesTable.getModel().getValueAt(row, 2).toString();
            }
            catch(ArrayIndexOutOfBoundsException ex)
            {
               JOptionPane.showMessageDialog(preferencesTable, "Employee not selected!");
            }
            
            //Sets fields to the retrieved data
            preferencesPanel.idField.setText(valueID);
            preferencesPanel.nameField.setText(valueName);
            preferencesPanel.preferencesField.setText(valuePreferences);
            
            preferencesPanel.setLayout(new BoxLayout(preferencesPanel, BoxLayout.Y_AXIS));
            
            int n = JOptionPane.showConfirmDialog(null, preferencesPanel, "Enter Preferences", JOptionPane.OK_CANCEL_OPTION); //Displays the panel
            
            //Checks for okay option
            if(n == JOptionPane.OK_OPTION)
            {
               //Retrieves data from the fields
               String name = preferencesPanel.nameField.getText();
               String id = preferencesPanel.idField.getText();
               String preferences = preferencesPanel.preferencesField.getText();
               
               system.setEmployeeList(systemAdapter.getAllEmployee()); //Gets the employee list from bin
               
               //Checks for null
               if(name == null)
               {
                  name = " ";
               }
               else if(id == null)
               {
                  id = " ";
               }
               else if(preferences == null)
               {
                  preferences = " ";
               }
               else
               {
                  //Gets the employee list from bin, sets the preferences, saves the list, updates the table
                  system.setEmployeeList(systemAdapter.getAllEmployee());
                  system.getEmployeeList().getEmployee(valueName, valueID).setPreferences(preferences);
                  systemAdapter.saveEmployeeList(system.getEmployeeList());
                  
                  updatePreferencesTable();
               }
            }
         }
         else if(e.getSource() == updateButton)
         {
            //Updates the table
            updatePreferencesTable();
         }
         
      }
   }
}
