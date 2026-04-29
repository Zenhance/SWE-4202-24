public class main2_1 {
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
    }
}

/*
Part C

a. BankAccount is CLASS
   Alice and Bob are OBJECTS or INSTANCES of the class BankAccount

b. When we call alice.deposit(500), only Alice's balance changes. The program understands because
   we have instantiated Alice differently from Bob

c.
    BankAccount alice
----------------------------
    String name = "Alice"
    double balance = 0.0

    BankAccount bob
----------------------------
    String name = "Bob"
    double balance = 0.0

after alice.deposit(500)

    BankAccount alice
----------------------------
    String name = "Alice"
    double balance = 500.0


d. Bob’s balance will remain unchanged, because we are putting Bob's attributes to Alice's
   not vice versa. So his balance is still 0

 */