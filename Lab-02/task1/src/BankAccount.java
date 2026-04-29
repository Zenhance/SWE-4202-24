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
        balance = balance+amount;
    }

    // withdraw() function created
    public void withdraw(int amount) {
        if(amount<0) System.out.println("Cannot ");
        if(balance<amount) {
            System.out.println("Insufficient funds");
        }

        else {
            balance = balance - amount;
        }
    }

    // printStatement() function created
    public void printStatement() {
        System.out.println("Account owner name: " + name);
        System.out.println("Current balance: " + balance);
    }

}
