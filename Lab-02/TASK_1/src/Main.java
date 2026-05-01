class BankAccount
{
    private String name;
    private double balance;
    public BankAccount(String name)
    {
        this.name = name;
        this.balance = 0;
    }
    public void deposit(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Error!");
        }
        balance= balance + amount;
    }
    public void withdraw(double amount)
    {
        if (balance - amount <= 0)
        {
            System.out.println("Insufficient Funds");
        } else
        {
            balance = balance - amount;
        }
    }
    public void printStatement()
    {
        System.out.println("Owner : "+name);
        System.out.println("Balance : "+balance);
    }
}
public class Main
{
    public static void main(String[] args)
    {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount charlie = new BankAccount("Charlie");

        alice.printStatement();
        bob.printStatement();
        charlie.printStatement();
    }
}