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
public float withdraw(double amount)
{
 if(amount <= balance)
 {
  balance -= amount;
  return balance;
 }
 else
 {
  System.out.println(" Insufficient funds ");
  return balance;
 }
}
