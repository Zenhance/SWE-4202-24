class BankAccount
{
    String name;
    double balance;
    BankAccount(String name)
    {
        balance = 0;
    }
    public void deposit(double amount)
    {
        if (amount <= 0) {
            System.out.println("Error!");
        }
    }
    public void withdraw(double amount)
    {
        if (balance - amount <= 0) {
            System.out.println("Insufficient Funds");
        } else {
            balance = balance - amount;
        }
    }

}
public class Main
{
    public static void main(String[] args)
    {

    }
}
