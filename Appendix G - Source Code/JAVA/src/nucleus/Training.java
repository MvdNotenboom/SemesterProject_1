package nucleus;

import java.io.Serializable;

/**
 * A class that manages an employee's training
 * @author Group6
 *@version 2.3.4
 */
public class Training implements Serializable
{
   private Date date;
   private Analysis analysis; 
   private String status;
   
   /**
    * Three argument constructor
    * @param String status
    * @param Analysis analysis
    * @param Date date
    */
   public Training(String status, Analysis analysis, Date date)
   {
      this.date = date;
      this.status = status; 
      this.analysis = analysis;
   }
   
   /**
    * Two argument constructor
    * @param String status
    * @param Analysis analysis
    */
   public Training(String status, Analysis analysis)
   {
      this.status = status;
      this.analysis = analysis;
   }
   
   /** 
    * Sets the status of employee's training (Trained, Under Training, Not Trained)
    * @param String status
    */
   public void setStatus(String status)
   {
      this.status = status;
   }
   
   /**
    * Returns the status of employee's training
    * @return String
    */
   public String getStatus()
   {
      return status;
   }
   
   /**
    * Returns the type of analysis 
    * @return Analysis analysis
    */
   public Analysis getAnalysis()
   {
      return analysis;
   }
   
   /**
    * Sets the date when the training was done
    * @param Date date
    */
   public void setDate(Date date)
   {
      this.date = date;
   }
   
   /**
    * Returns the date when the training was done
    * @return Date
    */
   public Date getDate()
   {
      return date;
   }
   
   /**
    * Returns a printed version of the information
    * @return String
    */
   public String toString()
   {
      return "Training Analysis:" + "\n" + analysis + "Training status: " + status; 
   }
   
}
