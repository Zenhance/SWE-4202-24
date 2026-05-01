public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if(amount <= 0)
            System.out.println("Error!");
        else
            balance += amount;
    }

    public void withdraw(double amount) {
        if(balance < amount)
            System.out.println("Insufficient funds.");
        else
            balance -= amount;
    }

    public void printStatement() {
        System.out.println("Owner's name : " + name);
        System.out.println("Current balance : " + balance);
    }

    public static void main (String[] args) {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount danik = new BankAccount("Danik");

        // For Alice
        alice.deposit(1200);
        alice.deposit(1000);
        alice.withdraw(1500);
        alice.printStatement();

        // For Bob
        bob.deposit(2000);
        bob.withdraw(4000);
        bob.deposit(1300);
        bob.printStatement();

        // For Danik
        danik.deposit(5000);
        danik.withdraw(2000);
        danik.withdraw(1200);
        danik.printStatement();
    }
}
