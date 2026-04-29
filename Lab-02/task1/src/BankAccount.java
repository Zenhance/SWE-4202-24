public class BankAccount {
    String name;
    double balance;
    public BankAccount(String name){
        this.name=name;
        this.balance=0.0;
    }
    public void printStatement() {
        System.out.println("The owner name " + name);
        System.out.println("The Balance is " + balance);
    }
    public void deposit(double amount){
        if(amount<=0){
            System.out.println("error");
        }else{
            balance+=amount;
        }
    }
    public void withdraw(double amount)
    {
        balance-=amount ;
    }
}
