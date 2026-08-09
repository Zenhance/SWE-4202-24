package kenakata.payment;

public class Wallet {
    private int balance;
    public Wallet(int balance) {
        if(balance<0) throw new IllegalArgumentException("balance cannot be negative");
        this.balance=balance;
    }

    public int balance() {
        return balance;
    }

    public void credit(int amount){
        if(amount<0) throw new IllegalArgumentException("amount cannot be negative");
        balance+=amount;
    }
    public void debit(int amount){
        if(amount>balance) throw new IllegalArgumentException("not enough balance");
        balance-=amount;
    }


}
