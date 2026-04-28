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
}
