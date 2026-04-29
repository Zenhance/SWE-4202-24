//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args){
        BankAccount acc1= new BankAccount("Alif");
        BankAccount acc2= new BankAccount("Kabir");
        BankAccount acc3= new BankAccount("Rahim");

        acc1.DepositAmount(500.0);
        acc1.WithdrawAmount(200.0);

        acc2.DepositAmount(1000.0);
        acc2.WithdrawAmount(800.0);

        acc3.DepositAmount(1500.0);
        acc3.WithdrawAmount(2000.0);

        acc1.PrintStatement();
        acc2.PrintStatement();
        acc3.PrintStatement();
    }
}