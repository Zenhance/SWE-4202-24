public class BankAccount{
    String name;
    double balance=0;

    BankAccount(String name,double balance){
         this.name=name;
         this.balance=balance;
    }
    void deposit(double amount){
        balance += amount;
        if(amount<=0){
            System.out.println("Error");
        }
    }



}
