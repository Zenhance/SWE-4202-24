public class BankAccount {
    private String name;
    private float balance;

    Public BackAccount(string name){
        this.balance = 0;
        this.name = name;
    }
    public float deposit(float amount){
        balance = balance + amount;
        return balance;
    }
    public float withdraw(float amount){
        if( amount =>balance){
            System.out.println("Error\n");
            return balance;
        }
        else{
            balance=balance-amount;}
    }
    public float CheckBalance(String name){
        System.out.println("Your Balance is :"+balance);
    }
}