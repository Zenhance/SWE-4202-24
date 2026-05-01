public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Error");
        }
        balance += amount;
    }

    public void withdraw(double amount) {

        if (amount > balance) {
            System.out.println("Error");
            return;
        }
        balance -= amount;
    }

    public void printstatement() {
        System.out.println(name + " " + balance);
    }
}
