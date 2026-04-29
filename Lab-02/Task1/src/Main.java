public class Main {
    public static void main (String[] args) {
        BankAccount bankAccount1 = new BankAccount("John");
        BankAccount bankAccount2 = new BankAccount("Don");
        BankAccount bankAccount3 = new BankAccount("Rose");

        bankAccount1.deposit(100000);
        bankAccount1.withdraw(40000);
        bankAccount1.deposit(5000);
        bankAccount1.printStatement();

        bankAccount2.deposit(1000);
        bankAccount2.withdraw(400);
        bankAccount2.deposit(5000);
        bankAccount2.printStatement();

        bankAccount3.deposit(5000000);
        bankAccount3.withdraw(400500);
        bankAccount3.deposit(5000);
        bankAccount3.printStatement();

    }

    /*
    Part C - Objects in Memory

    a.  BankAccount is a Class. It is like a blueprint.
        alice and bob are Objects. They are created from that blueprint.

    b.  Only Alice's balance changes.
        When we write alice.deposit(500), Java looks at what alice is
        pointing to in memory and updates that specific object's balance.
        bob is a completely separate object so it is not touched at all.

    c.
        alice                          bob
        +------------------+           +------------------+
        | name: "Alice"    |           | name: "Bob"      |
        | balance: 0.0     |           | balance: 0.0     |
        +------------------+           +------------------+

    d.  Bob's balance will also increase by 100.
        Because when we write alice = bob, alice stops pointing to its
        own object and starts pointing to the same object that bob is
        pointing to. So now both alice and bob point to the same object
        in memory. When we call alice.deposit(100), we are actually
        changing bob's object. Both alice and bob will show the same
        balance after this.
*/


}