public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String name) {
        this.ownerName = name;
        this.balance = 0;
    }

    public void Deposit(double amount) {
        balance += amount;
    }

    public void Withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void PrintBalance() {
        System.out.println("Account Owner: " + ownerName);
        System.out.println("Balance: " + balance);

    }
}