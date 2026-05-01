
public class Main {
    public static void main(String[] args) {

        BankAccount tahsin = new BankAccount("Tahsin");
        BankAccount moin = new BankAccount("Moin");
        BankAccount arnob= new BankAccount("Arnob");

        tahsin.withdraw(690);
        moin.withdraw(650);
        arnob.withdraw(666);

        tahsin.deposit(500);
        moin.deposit(250);
        arnob.deposit(333);

        arnob.printing();


    }
}