package nucleus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that manages task lists (6 task lists for 6 working days)
 * @author Group6
 * @version 2.4.6
 *
 */
public class WeekList implements Serializable
{
   private ArrayList<TaskList> week;
   
   /**
    * No argument constructor initializes the array list
    */
   public WeekList()
   {
      week = new ArrayList<TaskList>();
   }
   
   /**
    * Adds a new task list to the week list
    * @param TaskList taskList
    */
   public void addTaskList(TaskList taskList)
   {
      week.add(taskList);
   }
   
   /**
    * Returns the task list based on the week number
    * @param Integer weekNum
    * @return  TaskList
    */
   public TaskList getTaskList(int weekNum)
   {
      TaskList taskListByWeekNum = new TaskList(weekNum);
      
      for(int i = 0; i < week.size(); i++)
      {
         if(week.get(i).getWeekNum() == weekNum)
         {
            taskListByWeekNum = week.get(i);
         }
      }
      
      return taskListByWeekNum;
   }
   
   /**
    * Returns the number of weeks
    * @return Integer
    */
   public int getNumOfWeeks()
   {
      return week.size();
   }
   
   /**
    * Returns a printed version of the information
    * @return String 
    */
   public String toString()
   {
      String str = "";
      
      for(int i = 0; i < week.size(); i++)
      {
         str += week.get(i);
      }
      
      return str;
   }
}
