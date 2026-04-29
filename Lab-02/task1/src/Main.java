public class Main {

    public static void main(String[] args) {

        BankAccount wasif = new BankAccount("Wasif");
        BankAccount jafar = new BankAccount("Jafar");

        wasif.deposit(1000.0);
        wasif.printStatement();

        wasif.withdraw(1500.0);
        wasif.printStatement();

        wasif.withdraw(500.0);
        wasif.printStatement();

        jafar.deposit(2000.0);
        jafar.printStatement();

        jafar.withdraw(1000.0);
        jafar.printStatement();

        jafar.withdraw(200.0);
        jafar.printStatement();

        wasif = jafar;

        wasif.printStatement();
        jafar.printStatement();
    }
}