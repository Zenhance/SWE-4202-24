public class BankAccount
{
    private String name;
    private int balance;
    balance=0;
    public BankAccount(String name)
    {
        this.name=name;
    }
    public void deposit(int amount)
    {
        if(amount<=0) {
            System.out.println("Insufficient amount to deposit!");
        }
        else {
            balance+=amount;
        }
    }
    public void withdraw(int amount)
    {
        balance-=amount;
        if(balance<0) {
            System.out.println("Insufficient funds!");
        }
    }
    public void printStatement()
    {
        System.out.println("Name: "+name);
        System.out.println("Balance: "+balance);
    }


}
