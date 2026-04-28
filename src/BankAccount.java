public class BankAccount {
    String name;
    double balance = 0;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error");
        } else {
            balance += amount;
        }

    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient");
        } else {
            balance -= amount;

        }

    }
    void print(String name,double balance){
        System.out.println(name);
    }

}