package kenakata.payment;

import kenakata.exceptions.PaymentDeclinedException;

public class Wallet  {
    private long balance;
    public Wallet(long balance){
        if(balance<0)
            throw new IllegalArgumentException("Invalid");
        this.balance=balance;
    }

    public long getBalance() {
        return this.balance;
    }
  public void debit(int amount){
        if(amount>balance)
            throw new IllegalArgumentException("Invalid");
        balance-=amount;
  }
    public void crebit(int amount){
        if(amount<=0)
            throw new IllegalArgumentException("Invalid");
        balance+=amount;
    }

}
