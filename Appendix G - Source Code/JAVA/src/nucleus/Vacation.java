package nucleus;

/**
 * A class that sets up the Vacation for an Employee
 * @author Group6
 * @version 1.2.3
 */
public class Vacation
{
   private Date startDate;
   private Date endDate;
   private boolean approved; 
   
   /**
    * Three argument constructor that takes start date, end date and the approval status
    * @param Date startDate
    * @param Date endDate
    * @param boolean approved
    */
   public Vacation(Date startDate, Date endDate, boolean approved)
   {
      this.startDate = startDate;
      this.endDate = endDate;
      this.approved = approved; 
   }
   
   /**
    * Two argument constructor that takes only the start and end date, approval is set to false (not approved)
    * @param Date startDate
    * @param Date endDate
    */
   public Vacation(Date startDate, Date endDate)
   {
      this.startDate = startDate;
      this.endDate = endDate;
      this.approved = false;
   }
   
   /**
    * Sets the start date
    * @param Date startDate
    */
   public void setStartDate(Date startDate)
   {
      this.startDate = startDate;
   }
   
   /**
    * Returns the start date
    * @return Date startDate
    */
   public Date getStartDate()
   {
      return startDate;
   }
   
   /**
    * Sets the end date
    * @param Date endDate
    */
   public void setEndDate(Date endDate)
   {
      this.endDate = endDate;
   }
   
   /**
    * Returns the end date
    * @return Date endDate
    */
   public Date getEndDate()
   {
      return endDate;
   }
   
   /**
    * Sets the approval for vacation
    * @param boolean approved
    */
   public void setApproved(boolean approved)
   {
      this.approved = approved;
   }
   
   /**
    * Returns the status of approval
    * @return boolean approved
    */
   public boolean getApproved()
   {
      return this.approved;
   }
   
   /**
    * Returns a printed version of the information 
    * @return String 
    */
   public String toString()
   {
      if(approved)
      {
         return "Vacation periode: " + startDate + " - " + endDate + " - approved"; 
      }
      else
      {
         return "Vacation periode: " + startDate + " - " + endDate + " - pending approval"; 

      }
   }
}
