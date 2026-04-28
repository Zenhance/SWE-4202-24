public class BankAccount {
    // variable created for owner's name and balance

    private String name;
    private double balance;

    // constructor created
    BankAccount(String name){
        this.name = name;
        this.balance = 0;
    }

    //  function deposit() created
    public void deposit(int amount) {
        if(amount<0) System.out.println("Cannot deposit negative amount");
        BankAccount.balance = balance+amount;
    }

    // withdraw() function created
    public void withdraw(int amount) {
        if(amount<0) System.out.println("Cannot ");
        if(BankAccount.balance<amount) {
            System.out.println("Insufficient funds");
        }

        else {
            BankAccount.balance = balance - amount;
        }
    }

    // printStatement() function created
    public void printStatement() {
        System.out.println("Account owner name: " + BankAccount.name);
        System.out.println("Current balance: " + BankAccount.balance);
    }
}
