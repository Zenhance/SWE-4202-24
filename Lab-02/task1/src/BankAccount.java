public class BankAccount {
    private String name;
    private float balance = 0.00f;

    public BankAccount(String accountName){
        this.name = accountName;
    }
    public float deposit(float amount){
        balance = balance + amount;
        return balance;
    }
    public float withdraw(float amount){
        if (amount<=balance){
            balance = balance - amount;
            return balance;}
        else {
        System.out.println("Insufficient funds");
        return balance;}
    }
    public void printstatement(){
        System.out.println("Account Name - " + name);
        System.out.println("Balance -  " + balance);
    }
}
