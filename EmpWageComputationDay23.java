
// *****************************************  Welcome  ***************************************//

import java.util.ArrayList;
import java.util.HashMap;

interface IComputeEmpWage {
    public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays,
                                     int maxHoursPerMonth);
    public void computeEmpWage();
    public int getTotalWage(String company);

}

public class  EmpWageComputationDay23 implements IComputeEmpWage {
      public static final int IS_PART_TIME = 1;
      public static final int IS_FULL_TIME = 2;

      private ArrayList<CompanyEmpWage> companyEmpWageList;
      private HashMap<String, CompanyEmpWage> companyToEmpWageMap;


     public EmpWageComputationDay23(){
           companyEmpWageList = new ArrayList<>();
           companyToEmpWageMap = new HashMap<>();
     }


     public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays,
                                     int maxHoursPerMonth){

            CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour,
                                                                    numOfWorkingDays, maxHoursPerMonth);
            companyEmpWageList.add(companyEmpWage);
            companyToEmpWageMap.put(company, companyEmpWage);
     }

     public void computeEmpWage(){
         for (int i=0; i< companyEmpWageList.size(); i++){
              CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
              companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
              System.out.println(companyEmpWage);
         }
     }
     private int computeEmpWage(CompanyEmpWage companyEmpWage){

            // Variables
             int empHrs = 0;
             int totalWorkingDays = 0;
             int totalEmpHrs = 0;
            // Computation

            while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays){
               totalWorkingDays++;
               int empCheck = (int) Math.floor(Math.random() * 10) % 3;
               switch (empCheck) {
               case IS_PART_TIME:
                  empHrs = 4;
                  break;
               case IS_FULL_TIME:
                  empHrs = 8;
                  break;
               default:
                  empHrs = 0;

              }
              totalEmpHrs += empHrs;
              System.out.println("Days: " + totalWorkingDays + " Emp Hr: " + empHrs);
           }
           return totalEmpHrs * companyEmpWage.empRatePerHour;

     }

     
     public int getTotalWage(String company){
            return companyToEmpWageMap.get(company).totalEmpWage;

     }

     public static void main(String[] args){

             IComputeEmpWage empWageComputation = new EmpWageComputationDay23();
             empWageComputation.addCompanyEmpWage("DMart",20,20,100);
             empWageComputation.addCompanyEmpWage("Reliance",10,10,100);
             empWageComputation.computeEmpWage();
             System.out.println("Total Wage for DMart Company: " + empWageComputation.getTotalWage("DMart"));
     }

}
