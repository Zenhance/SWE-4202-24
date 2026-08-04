package kenakata.payment;


public class Wallet
{
    private long balance;

    public Wallet(long balance)
    {
        if(balance<=0)
            throw new IllegalArgumentException("Balance must be positive");
        this.balance = balance;
    }

    public void debit(long amount)
    {
        if(amount>balance)
            throw new IllegalArgumentException("Amount can not br greater than balance");
        balance=balance-amount;
    }

    public void credit(long amount)
    {
        if(amount<=0)
            throw new IllegalArgumentException("Amount must be positive");
        balance=balance+amount;
    }

    public long balance()
    {
        return balance;
    }
}