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
}
