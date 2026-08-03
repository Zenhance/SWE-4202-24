package kenakata.payment;

public class Wallet {
    private long balance;
    public Wallet(long balance){
        if(balance < 0) {
            throw new IllegalArgumentException("Balance can't be negative");
        }
        this.balance = balance;
        }
        public long balance(){
        return balance;
    }
    public void credit(long amount){
        if(amount<= 0)
            throw new IllegalArgumentException("Invalid Amount");
            balance += amount;
    }
    public void debit(long amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Invalid Amount");
        }
        if(amount > balance){
            throw new IllegalArgumentException("Insufficient Balance");
        }
        balance -= amount;
    }

}
