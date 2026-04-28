public class Main {
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice");
        BankAccount charlie = new BankAccount("Charlie");
        BankAccount bob = new BankAccount("Bob");

        alice.deposit(500);
        alice.withdraw(100);

        bob.deposit(400);
        bob.withdraw(300);

        charlie.deposit(1000);
        charlie.withdraw(600);


        alice.printStatement();
        bob.printStatement();
        charlie.printStatement();
    }
}