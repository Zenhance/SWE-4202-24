public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name){
        this.balance=0;
        this.name=name;

    }

    public void withdraw(double amount){
        if(this.balance-amount<=0){
            System.out.println("Insufficient funds");
        }
        else{
            balance=balance-amount;
        }

    }
    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Error");
        }
        else{
            balance=balance+amount;
        }
    }
    public void printStatement(){
        System.out.println(this.name+" "+this.balance);
    }
}

   
