package main.java;

public class DailyLimitExceedException extends TransactionException{
    public DailyLimitExceedException(){
        super("Daily limit exceed");
    }
}
