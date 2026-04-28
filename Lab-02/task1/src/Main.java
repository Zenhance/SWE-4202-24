
public class Main {
    public static void main(String[] args) {

        BankAccount jahin = new BankAccount("jahin");
        BankAccount hasib = new BankAccount("hasib");
        BankAccount samin = new BankAccount("samin");

        jahin.deposit(1200);
        jahin.withdraw(1000);
        jahin.printStatement();

        hasib.deposit(1000);
        hasib.withdraw(1500);
        hasib.printStatement();

        samin.deposit(500);
        samin.withdraw(-60);
        samin.printStatement();

    }

}