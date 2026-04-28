public class BankAccount {
    private String name;
    private double balance;
    public BankAccount(String name){
        this.name=name;
        this.balance=0;
    }

    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Error");
            return;
        }
        balance+=amount;
    }
    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Insufficient funds");
            return;
        }
        balance-=amount;
    }
    public void printStatement(){
        System.out.println("Owner's name: "+name);
        System.out.println("Owner's balance: "+balance);
    }
}
