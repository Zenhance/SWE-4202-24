public class Main {
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount raida = new BAnkAccount("RAIDA");

        alice.deposit(500);
        alice.withdraw(5);
        alice.printStatement();

        bob.deposit(100);
        bob.withdraw(100);
        bob.printStatement();

        raida.deposit(100000);
        raida.withdraw(00);
        raida.printStatement();
    }
}