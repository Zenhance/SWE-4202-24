
public class Main {
    public static void main(String[] args) {

        BankAccount alice = new BankAccount("Alice");
        BankAccount baba= new BankAccount("baba");
        BankAccount cee= new BankAccount("cee");
        alice.deposit(500);
        alice.withdraw(300);
        alice.withdraw(300);
        alice.deposit(0);
        alice.printStatement();

        baba.deposit(5000);
        baba.withdraw(300);
        baba.withdraw(3000);
        baba.deposit(10);
        baba.printStatement();

        cee.deposit(50);
        cee.withdraw(30);
        cee.withdraw(0);
        cee.deposit(1000);
        cee.printStatement();
    }
}