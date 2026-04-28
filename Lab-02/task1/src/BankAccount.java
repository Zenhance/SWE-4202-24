public class BankAccount {
    private String name;
    private double balance;

    BankAccount(String n){
        name = n;
        balance = 0;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public  void withdraw(double amount){
        balance-=amount;
    }
    public void printStatement(){
        System.out.println("Owner's name: "+name);
        System.out.println("Balance: "+balance+" Taka");

    }
    //test test test
}
