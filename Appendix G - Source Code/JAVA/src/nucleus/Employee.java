package nucleus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that defines and manages an employee
 * @author Group6
 * @version 7.9.3
 */
public class Employee implements Serializable
{
  private String name;
  private String email;
  private String id;
  private String preferences;
  private String comments;
  private ArrayList<Training> trainings;
  
  /**
   * Three argument constructor
   * @param String name
   * @param String email
   * @param String id
   */
  public Employee(String name, String email, String id)
  {
     this.name = name;
     this.email = email; 
     this.id = id.toUpperCase(); //ID is always upper case
     
     //Setting up preferences and comments to their default " ", and initiating the training list
     this.preferences = " ";
     this.comments = " ";
     trainings = new ArrayList<Training>();
  }
  
  /**
   * Two argument constructor
   * @param String name
   * @param String id
   */
  public Employee(String name, String id)
  {
     this.name = name;
     this.id = id.toUpperCase();
     
   //Setting up preferences, comments and email to their default " ", and initiating the training list
     this.email = " ";
     this.preferences = " ";
     this.comments = " ";
     trainings = new ArrayList<Training>();
  }
  
  /**
   * Sets up the name of the employee
   * @param String name
   */
  public void setName(String name)
  {
     this.name = name;
  }
  
  /**
   * Returns the name of the employee
   * @return String
   */
  public String getName()
  {
     return name;
  }
  
  /**
   * Returns the ID of the employee
   * @return
   */
  public String getID()
  {
     return id;
  }
  
  /**
   * Sets up the email of the employee
   * @param String email
   */
  public void setEmail(String email)
  {
     this.email = email;
  }
  
  /**
   * Returns the email of the employee
   * @return String 
   */
  public String getEmail()
  {
     return email;
  }
  
  /**
   * Sets up the preferences of the employee
   * @param String preferences
   */
  public void setPreferences(String preferences)
  {
     this.preferences = preferences;
  }
  
  /**
   * Returns the preferences of the employee
   * @return String 
   */
  public String getPreferences()
  {
     return preferences;
  }
  
  /**
   * Sets up the comments of the employee
   * @param String comments
   */
  public void setComments(String comments)
  {
     this.comments = comments;
  }
  
  /**
   * Returns the comments of the employee
   * @return String 
   */
  public String getComments()
  {
     return comments;
  }
  
  /**
   * Sets up the training of an employee
   * @param String analysis
   * @param String status
   */
  public void setTraining(String analysis, String status)
  {  
     for(int i = 0; i < trainings.size(); i++)
     {
        if(trainings.get(i).getAnalysis().getName().equals(analysis))
        {
           trainings.get(i).setStatus(status);
        }
     }
  }
  
  
  /**
   * Initiates the training list to a default "Not Trained" 
   * @param AnalysisList analyses
   */
  public void setTraining(AnalysisList analyses)
  {  
     for(int i = 0; i < analyses.getNumAnalysis(); i++)
     {
        Training training = new Training("Not Trained", analyses.getAnalysis(i));
        trainings.add(training);
     }
  }
  
  /**
   * Returns the training status for an analysis of the employee
   * @param String analysis
   * @return Training training status 
   */
  public Training getTraining(String analysis)
  {
     int temp = 0;
     
     for(int i = 0; i < trainings.size(); i++)
     {
        if(trainings.get(i).getAnalysis().getName().equals(analysis))
        {
           temp = i;
        }
     }

     return trainings.get(temp);
  }
  
  /**
   * Returns all the training statuses of the employee
   * @return ArrayList<Training>
   */
  public ArrayList<Training> getAllTraining()
  {
     return trainings;
  }
  
  /**
   * Checks if the given object is equal with this
   * @param Object obj Generic object
   * @return boolean True for equal/False for not equal
   */
  public boolean equals(Object obj)
  {
     if(!(obj instanceof Employee))
     {
        return false;
     }
     
     Employee other = (Employee)obj;
     
     return this.id.equals(other.id) && this.name.equals(other.name); 
  }
  

  /**
   * Returns a printed version of the information
   * @return String
   */
  public String toString()
  {
     String str = "ID: " + id + "\n" + "Name: " + name + "\n" +
  "e-mail: " + email + "\n" + "Preferences: " + preferences + "\n" + 
           "Comments: " + comments + "\n" + trainings;
     
     for(int i = 0; i < trainings.size(); i++)
     {
        str += trainings.get(i);
     }
     
     return str;
  }
}
