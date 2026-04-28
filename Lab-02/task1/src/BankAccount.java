public class BankAccount
{
 private String ownername;
 private double balance;
}
public BankAccount(String ownername)
{
 this.ownername = ownername;
 this.balance = 0;
}
public double deposite(double amount)
{
 balance += amount;
 return balance;
}