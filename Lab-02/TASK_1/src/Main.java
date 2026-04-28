import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
}
public class Main
{
    public static void main(String[] args)
    {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        }
    }
}