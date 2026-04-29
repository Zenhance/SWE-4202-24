




public class BankAccount {
    private String name;
    private float balance;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0.0f;
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            System.out.println("Error\n");
        } else {
            balance = amount + balance;
        }


    }

    public void withdraw(float amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance\n");
        } else {
            balance = balance - amount;
        }
    }

    public void printStatement() {
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}





