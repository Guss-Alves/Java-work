
public class BankAccount{
    
    //MEMBER VARIABLES
    public double checkingBalance = 0;
    public double savingsBalance = 0;
    public static int numberOfAccounts = 0;

    //constructor
    public BankAccount(double checkingBalanceParam, double savingsBalanceParam){
        this.checkingBalance = checkingBalanceParam;
        this.savingsBalance = savingsBalanceParam;
        numberOfAccounts++;
    }
    //get the number of accounts
    public static int AccountCount(){
        return numberOfAccounts;
    }

    //get the total amount in a account
    public String TotalAmount(){
        return "Your total amount is:"+" "+ (checkingBalance + savingsBalance);
    }

    //getter for checkings
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    //getter for the savings
    public double getSavingsBlance(){
        return this.savingsBalance;
    }

    public void addChecking(double amountParam){
        this.checkingBalance += amountParam;
    }

    public void addSavings(double amountParam){
        this.savingsBalance += amountParam;
    }

    public void withDrawChecking(double amountParam){
        if(amountParam <= this.checkingBalance){
            this.checkingBalance -= amountParam;
        }
    }


}