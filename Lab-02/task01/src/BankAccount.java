public class BankAccount {
    private String name;
    private int balance;

    public BankAccount(String name){
        this.balance = 0;
        this.name = name;
    }

    public void deposit(int amount){
        if(amount <= 0) System.out.println("ERROR");
        else {
            balance = balance + amount;
        }
    }

    public void withdraw(int amount){
        if(this.balance - amount <= 0) System.out.println("Insufficient funds");
        else{
            balance = balance - amount;
        }
    }

    public void printStatement(){
        System.out.println(this.name + " " + this.balance);
    }
}
