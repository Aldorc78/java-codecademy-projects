/*
    This program calculates the monthly payment that a user has to pay calculated based on the car he is gonna get,
    how much is the car loan, interest rate, for how long is the carloan and the down payment.
*/
public class CarLoan 
{
    //Creating object attributes 
    int carLoan;
    int loanLenght;
    int interestRate;
    int downPayment;

  //Constructor
  public CarLoan(int carLoan, int loanLenght, int interestRate, int downPayment)
    {
      this.carLoan = carLoan; 
      this.loanLenght = loanLenght;
      this.interestRate = interestRate; 
      this.downPayment = downPayment;

        if(loanLenght<=0||interestRate<=0)
        {
            System.out.println("Error! You must take out a valid car loan");
        }
        else if(downPayment>=carLoan)
        {
            System.out.println("The car can be paid in full");
        }
        else
        {
                
            int remainingBalance = carLoan - downPayment;
            int months =loanLenght*12;
            int monthlyBalance = remainingBalance/months;
            int interest = monthlyBalance*interestRate/100;
            int monthlyPayment = monthlyBalance + interest; 
            System.out.println(monthlyPayment);
              
        }
            
 
  }

	public static void main(String[] args) 
   {
         /*
            int carLoan = 10000;
            int loanLenght = 3; //3Years
            int interestRate = 5;//5%
            nt downPayment = 2000;
        */
        //Creating a Mustang carloan object
        CarLoan Mustang = new CarLoan(10000, 3 , 5, 2000);

        //Creating a Panamera carloan object
        CarLoan Panamera = new CarLoan(30000, 6 , 4, 20000);
    } 


}