public class Main {
    public static void main(String[] args)
    {
        BankAccount acc1 = new BankAccount("Alex");
        BankAccount acc2 = new BankAccount("blue");
        Deposit d=new Deposit();
        Withdraw w=new Withdraw();
        Statement s=new Statement();
        d.Deposit(acc1,1000);
        w.Withdraw(acc1,200);
        s.Print(acc1);
        d.Deposit(acc2,500);
        w.Withdraw(acc2,700);
        s.Print(acc2);
    }
}