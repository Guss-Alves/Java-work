public class BankTest{
    public static void main(String[] args){

        //new accounts
        BankAccount person1 = new BankAccount( 100.0, 300.99 );

        BankAccount person2 = new BankAccount( 70.0, 325.75 );

        BankAccount person3 = new BankAccount( 150.0, 343.20 );

        BankAccount person4 = new BankAccount( 175.0, 500.20 );

        System.out.println(BankAccount.AccountCount());
        // System.out.println(person1.TotalAmount());

        //adding and withdraws
        person1.addChecking(125.0);

        person1.addSavings(400.0);
        System.out.println(person1.getCheckingBalance());

        person1.withDrawChecking(25.0);
        System.out.println(person1.getCheckingBalance());

        //total amount of users
        System.out.println(person1.TotalAmount());

        System.out.println(person2.TotalAmount());

        System.out.println(person3.TotalAmount());
        
        System.out.println(person4.TotalAmount());
    }
}