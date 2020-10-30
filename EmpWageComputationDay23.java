
// *****************************************  Welcome  ***************************************//



interface IComputeEmpWage {
    public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays,
                                     int maxHoursPerMonth);
    public void computeEmpWage();

}

public class  EmpWageComputationDay23 implements IComputeEmpWage {
      public static final int IS_PART_TIME = 1;
      public static final int IS_FULL_TIME = 2;

      private int numOfCompany = 0;
      private CompanyEmpWage[] companyEmpWageArray;


     public EmpWageComputationDay23(){
           companyEmpWageArray = new CompanyEmpWage[5];
     }


     public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays,
                                     int maxHoursPerMonth){

            companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour,
                                                                    numOfWorkingDays, maxHoursPerMonth);
            numOfCompany++;
     }

     public void computeEmpWage(){
         for (int i=0; i< numOfCompany; i++){
              companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
              System.out.println(companyEmpWageArray[i]);
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

     public static void main(String[] args){

             EmpWageComputationDay23 empWageComputation = new EmpWageComputationDay23();
             empWageComputation.addCompanyEmpWage("DMart",20,20,100);
             empWageComputation.addCompanyEmpWage("Reliance",10,10,100);
             empWageComputation.computeEmpWage();
     }

}
