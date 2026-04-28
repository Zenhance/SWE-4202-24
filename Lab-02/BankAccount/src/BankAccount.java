public class BankAccount {

    private String name;
    private int balance;


    BankAccount(String name) {
        this.balance = 0;
        this.name = name;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Error!!");
        }
        else {
            balance += amount;
        }
    }

}

