public class Main {
    public static void main(String[] args) {

        BankAccount sadeed = new BankAccount("Sadeed");
        BankAccount anwar = new BankAccount("Anwar");
        BankAccount saad = new BankAccount("Saad");

        sadeed.deposit(1000);
        sadeed.withdraw(500);
        sadeed.printBalance();

        anwar.withdraw(6500);
        anwar.printBalance();


        saad.printBalance();

        // Checking the provided problem statement.
        sadeed = saad;

        saad.printBalance();

        saad.withdraw(140);

        saad.printBalance();

    }
}