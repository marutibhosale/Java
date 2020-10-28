
// *****************************************  Welcome  ***************************************//


public class  EmpWageMultipleCompanyDay22 {
      public static final int IS_PART_TIME = 1;
      public static final int IS_FULL_TIME = 2;

      public static int computeEmpWage(int empRatePerHour,int  numOfWorkingDays,int maxHrsInMonth){
            // Variables
             int empHrs = 0;
             int totalWorkingDays = 0;
             int totalEmpHrs = 0;
            // Computation

            while (totalEmpHrs <= maxHrsInMonth && totalWorkingDays < numOfWorkingDays){
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
           int totalEmpWage = totalEmpHrs * empRatePerHour;
           return totalEmpWage;
     }
     public static void main(String[] args){

             System.out.println("Total Employee wage for Company1: " + computeEmpWage(20,20,100));

             System.out.println("Total Employee wage for Company2: " + computeEmpWage(30,30,150));
     }

}
