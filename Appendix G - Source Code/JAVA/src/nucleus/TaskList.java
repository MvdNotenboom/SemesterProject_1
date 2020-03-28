package nucleus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for managing the tasks
 * @author  Group6
 * @version 2.3.9
 */
public class TaskList implements Serializable
{
   private int weekNum;
   private ArrayList<Task> tasks;
   private Date[] dates;
   
   public TaskList(int weekNum)
   {
      this.weekNum = weekNum;
      tasks = new ArrayList<Task>();
   }
   
   /**
    * Returns the all the dates of the task (date for Monday, date for Tuesday, ... , date for Saturday)
    * @return Date[]
    */
   public Date[] getDates()
   {
      return dates;
   }
   
   /**
    * Returns date of a specific task/week day based on the index (0 - Monday - first date, ... , 5 - Saturday - last date)
    * @param Integer index
    * @return Date
    */
   public Date getDate(int index)
   {
      if(index < dates.length)
      {
         return dates[index];
      }
      
      return dates[0];
   }
   
   /**
    * Adds a task to the task list
    * @param Task task
    */
   public void addTask(Task task)
   {
      tasks.add(task);
   }
   
   /**
    * Removes a task from the task list based on the index
    * @param Integer index
    */
   public void removeTask(int index)
   {
      tasks.remove(index);
   }
   
   /**
    * Returns a task from the task list based on index
    * @param Integer index
    * @return Task
    */
   public Task getTask(int index)
   {
      return tasks.get(index);
   }
   
   /**
    * Returns the index of a task
    * @param Task task
    * @return Integer
    */
   public int getIndex(Task task)
   {
      int temp = -1; //if not task found returns -1
      
      for(int i = 0; i < tasks.size(); i++)
      {
         if(tasks.get(i).equal(task))
         {
            temp = i;
         }
      } 
      return temp;
   }
   
   /**
    * Returns the number of tasks in the task list
    * @return Integer
    */
   public int getNumOfTasks()
   {
      return tasks.size();
   }
   
   /**
    * Returns the number of the week
    * @return Integer
    */
   public int getWeekNum()
   {
      return weekNum;
   }
   
   /**
    * Returns a printed version of the information
    * @return String
    */
   public String toString()
   {
      String str = "";
      
      for(int i = 0; i < tasks.size(); i++)
      {
         str += "Task Date: " + tasks.get(i).getDate() + "\n" 
               + "Analysis: " + tasks.get(i).getAnalysis() + "\n"
               + "Performed by: \n" + tasks.get(i).getEmployee() + "\n";
      }
      return str;
   }
}
