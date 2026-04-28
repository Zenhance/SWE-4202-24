public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName) {

        this.ownerName = ownerName;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error : The deposit amount must be positive");
        }
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: The amount must be positive");
        }
        if (balance - amount < 0) {
            System.out.println("Insufficient Funds");
        }
        balance = balance - amount;
    }

    public void printStatement() {
        System.out.println("The Owner's Name " +ownerName);
        System.out.println("The remaining Balance " +balance);
    }
}