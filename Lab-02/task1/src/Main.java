public class Main {
    public static void main(String[] args) {
        // Now you can create the object inside this method
        BankAccount alice = new BankAccount("Alice");

        // Example usage
        alice.deposit(500);
        alice.printStatement();
    }
}