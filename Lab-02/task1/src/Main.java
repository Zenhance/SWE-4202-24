public class Main {
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount raida = new BAnkAccount("RAIDA");

        alice.deposit(500);
        alice.withdraw(5);
        alice.printStatement();
    }
}