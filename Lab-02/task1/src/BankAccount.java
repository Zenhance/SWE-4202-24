/*
* a.for every account you need these information:
    1.Account holder name-string
    2.Current balance-int or double
    3.account number-int
*
* b.A customer can perform these 3 actions.
*   1.deposit money-input account number,amount.Changes current balance, outputs current balance after being updated
*   2.withdraw money-input account number, account holder name,amount.Changes current balance, outputs current balance after being updated,error if insufficient balance
*   3.check balance-input account number,account holder name.outputs current balance.
*
* c.in this implementation, we have to keep track which customer is which element of the array. if we have to edit any details(owner name,balance), we then have to find that
*   element and change, which is annoying. moreover, anyone, intentionally or not, can change any values of the array and cause problems.
*
* d.for a transaction limit, I'd put in bank account class.If I put it in main(), it won't track transaction of each user separately.
*   but in my way, each user's transaction will be tracked separately.  */
public class BankAccount {
   private String name;
    private double balance;
    BankAccount(String name)
    {
        this.name=name;
        this.balance=0.0;
    }
    public  void deposit(double amount)
    {
        if(amount<=0) System.out.println("Error");
        else balance+=amount;
    }
    public void withdraw(double amount)
    {
        if(amount>balance) System.out.println("Error");
        else balance-=amount;}
   public void  printStatement(){
        System.out.println(name+" "+balance);
    }
}
