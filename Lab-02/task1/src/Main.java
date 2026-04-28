public class Main {
    public static void main(String[] args) {
        BankAccount a = new BankAccount("ayiham");
        BankAccount b = new BankAccount("mahiya");
        BankAccount c = new BankAccount("mahi");

        a.deposit(10000);
        a.withdraw(4000);
        a.printStatement();

        b.deposit(1000);
        b.withdraw(7000);
        b.printStatement();

        c.deposit(12300);
        c.withdraw(50.55);
        c.printStatement();

        //test test test

    }
}
