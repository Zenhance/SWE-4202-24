public class Main {
    public static void main(String[] args) {
        BankAccount Tasauf = new BankAccount("Tasauf");
        BankAccount Abdullah = new BankAccount("Abdullah");
        BankAccount Sifat = new BankAccount("Sifat");


        Tasauf.deposit(1000);
        Tasauf.withdraw(200);
        Tasauf.withdraw(900);


        Abdullah.deposit(1000);
        Abdullah.withdraw(500);
        Abdullah.withdraw(1);

        Sifat.deposit(500);
        Sifat.withdraw(200);
        Sifat.withdraw(300);


        Tasauf.printStatement();
        Abdullah.printStatement();
        Sifat.printStatement();
    }
}
