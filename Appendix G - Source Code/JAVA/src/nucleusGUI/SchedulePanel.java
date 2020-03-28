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

import nucleus.SystemAdapterEmployee;
import nucleus.SystemAdapterWeek;
import nucleus.SystemSEP;
import nucleus.TaskList;

/**
 * Class for setting up the schedule panel
 * @author Group6
 * @version 0.6.4
 * @extends JPanel
 */

//-------------------------------------------NOT COMPLETED------------------------------------//
public class SchedulePanel extends JPanel
{
   private SystemAdapterWeek systemAdapterWeek; 
   private SystemAdapterEmployee systemAdapterEmployee;
   private ButtonListener buttonListener;
   
   private JButton updateButton, editButton, addButton;
   
   private JPanel buttonPanel;
   
   private JTable scheduleTable;
   private String[] columnNames;
   private DefaultTableModel dtm;
   private JScrollPane scheduleScrollPane;
   
   /**
    * No argument constructor to set up the elements
    */
   public SchedulePanel()
   {
      //Initializing the elements
      buttonListener = new ButtonListener();
      systemAdapterWeek = new SystemAdapterWeek("week");
      systemAdapterEmployee = new SystemAdapterEmployee("employee");
      
      //Setting up the table
      columnNames = new String[8];
      columnNames[0] = "Initials";
      columnNames[1] = "Name";
      columnNames[2] = "";
      columnNames[3] = "";
      columnNames[4] = "";
      columnNames[5] = "";
      columnNames[6] = "";
      columnNames[7] = "";
      
      dtm = new DefaultTableModel(columnNames,120)
      {
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      scheduleTable = new JTable(dtm);
      
      scheduleTable.getTableHeader().setReorderingAllowed(false);
      scheduleTable.getTableHeader().setResizingAllowed(false);
      
      scheduleTable.setCellSelectionEnabled(false);
      scheduleTable.setEnabled(true);
      scheduleTable.setFocusable(true);
      scheduleTable.setRowSelectionAllowed(true);
      scheduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      scheduleScrollPane = new JScrollPane(scheduleTable);
      scheduleScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scheduleScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      scheduleTable.setPreferredScrollableViewportSize(new Dimension(900, scheduleTable.getRowHeight()*23));
      
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

      editButton = new JButton("Modify tasks");
      editButton.addActionListener(buttonListener);
      
      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);
      
      addButton = new JButton("Add Week");
      addButton.addActionListener(buttonListener);
         
      buttonPanel.add(editButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(updateButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
      buttonPanel.add(addButton);
      
      //Adding to the main panel
      add(scheduleScrollPane);
      add(buttonPanel, BorderLayout.NORTH);
      
   }
   
   /**
    * Class for creating a week with a specific week number
    * @author Group6
    * @version 3.2.7
    */
   public class AddWeekNum extends JPanel
   {
      private JLabel weekNumLabel;
      private JTextField weekNumTextField;
      private JPanel mainPanel;
      
      /**
       * No argument constructor
       */
      public AddWeekNum()
      {
         mainPanel = new JPanel();
         
         mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
         
         weekNumLabel = new JLabel("Week Number: ");
         weekNumTextField = new JTextField(15);
         
         mainPanel.add(weekNumLabel);
         mainPanel.add(weekNumTextField);
         
         add(mainPanel);
         
         setVisible(true);
      }
   }
   
   /**
    * Class for updating the table based on the week number
    * @param Integer weekNum
    * @version 0.4.0
    */
   public void updateScheduleTable(int weekNum)
   {
      //Setting up the data for the table
      TaskList week = systemAdapterWeek.getAllWeeks().getTaskList(weekNum);
      
      Object[][] data = new Object[systemAdapterEmployee.getAllEmployee().getNumEmployee()][8];
      
      for(int i = 0; i < systemAdapterEmployee.getAllEmployee().getNumEmployee(); i++)
      {
         data[i][0] = systemAdapterEmployee.getAllEmployee().getEmployee(i).getID();
         data[i][1] = systemAdapterEmployee.getAllEmployee().getEmployee(i).getName();

      }
      
      columnNames[0] = "ID";
      columnNames[1] = "Name";
      
      columnNames[2] = systemAdapterWeek.getAllWeeks().getTaskList(1).getTask(0).getDate().toString();
      
      dtm = new DefaultTableModel(data, columnNames)
      {
         @Override
         
         public boolean isCellEditable(int indexRow, int indexColumn)
         {
            return false;
         }
      };
      
      //Setting up the table
      scheduleTable.setModel(dtm);
      
      scheduleTable.getTableHeader().setReorderingAllowed(false);
      scheduleTable.getTableHeader().setResizingAllowed(false);
      
      scheduleTable.setCellSelectionEnabled(false);
      scheduleTable.setEnabled(true);
      scheduleTable.setFocusable(true);
      scheduleTable.setRowSelectionAllowed(true);
      scheduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   }
   
   /**
    * Action listener for the buttons
    * @author Group6
    * @version 2.2.5
    * @implements ActionListener
    */
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == updateButton)
         {
            updateScheduleTable(1);
         }
         else if(e.getSource() == addButton)
         {
            AddWeekNum addWeekNumPanel = new AddWeekNum();
            
            JOptionPane.showConfirmDialog(null, addWeekNumPanel, "Enter the number of the week", JOptionPane.OK_CANCEL_OPTION);
         }
      }
   }
}
