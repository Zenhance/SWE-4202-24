public class BankAccount {
    private String name;
    private double balance;
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
        if (amount <= 0) {
            System.out.println("Error");
        }
    }
    public void withdraw(double amount) {
        balance -= amount;
        if (amount > balance) {
            System.out.println("Error");
        }
    }
    public void printstatement () {
        System.out.println(name + " " + balance);
    }
}
