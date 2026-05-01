/*
a. What information does every account need to store? List each piece and the type
you would use.




*/
public class Main {
    public static void main(String[] args) {

        BankAccount tahsin = new BankAccount("Tahsin");
        BankAccount moin = new BankAccount("Moin");
        BankAccount arnob= new BankAccount("Arnob");


        tahsin.deposit(1000000);
        tahsin.withdraw(50000);

        moin.deposit(12433333);
        moin.withdraw(3333);

        arnob.deposit(500000);
        arnob.withdraw(4000);

        tahsin.printStatement();
        moin.printStatement();
        arnob.printStatement();


    }
}