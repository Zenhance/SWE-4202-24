public class Withdraw
{
    void Withdraw(BankAccount acc,double amount)
    {
        if (amount>acc.balance)
        {
            System.out.println(acc.owner + ":Insufficient funds");
        }
        else
        {
            acc.balance-=amount;
        }
    }
}