public class Main {
    public static void main(String[] args) {

        BankAccount s1 = new BankAccount("Alice");
        BankAccount s2 = new BankAccount("Bob");

        s1.deposit(1000);
        s1.withdraw(500);

        s2.deposit(2000);
        s2.withdraw(1000);

        s1.printStatement();
        s2.printStatement();
    }
}
