package nucleus;

/**
 * Class for providing a unity for the week, analysis and employee lists
 * @author Group6
 * @version 5.2.3
 */
public class SystemSEP
{
   private AnalysisList analysisList;
   private EmployeeList employeeList;
   private WeekList weekList;
   
   /**
    * No-argument constructor that initiates the list (WeekList, AnalysisList and EmployeeList) classes
    */
   public SystemSEP()
   {
      analysisList = new AnalysisList();
      employeeList = new EmployeeList();
      weekList = new WeekList();
   }
   
   /**
    * Sets the AnalysisList 
    * @param AnalysisList analysisList
    */
   public void setAnalaysisList(AnalysisList analysisList)
   {
      this.analysisList = analysisList;
   }
  
   /**
    * Returns the AnalysisList
    * @return AnalysisList
    */
   public AnalysisList getAnalysisList()
   {
      return analysisList;
   }
   
   /**
    * Sets the EmployeeList
    * @param EmployeeList employeeList
    */
   public void setEmployeeList(EmployeeList employeeList)
   {
      this.employeeList = employeeList;
   }
  
   /**
    * Returns the EmployeeList
    * @return EmployeeList
    */
   public EmployeeList getEmployeeList()
   {
      return employeeList;
   }
   
   /**
    * Sets the WeekList
    * @param WeekList weekList
    */
   public void setWeekList(WeekList weekList)
   {
      this.weekList = weekList;
   }
   
   /**
    * Returns the WeekList
    * @return WeekList
    */
   public WeekList getWeekList()
   {
      return weekList;
   }
}
