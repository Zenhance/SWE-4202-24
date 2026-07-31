package kenakata.payment;

public class Wallet{

    private double balance;

    public Wallet(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double debit(double amount) throws {
        return balance - amount;
    }
}
