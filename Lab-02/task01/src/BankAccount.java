public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name) {
        this.balance = 0;
        this.name= name;
    }
    public void deposit(double amount){
    if(amount<=0){
        System.out.println("ERROR");
    }
    else{
        balance=balance+amount;
    }


    }
}