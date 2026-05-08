public class Main {
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount charlie = new BankAccount("Charlie");

        alice.deposit(500.0);
        alice.withdraw(200.0);


        bob.deposit(1000.0);
        bob.withdraw(300.0);
        bob.withdraw(800.0);

        charlie.deposit(250.0);
        charlie.withdraw(50.0);

        System.out.println("\n=== Final Statements ===");
        alice.printStatement();
        bob.printStatement();
        charlie.printStatement();
    }
    /*
a. BankAccount is the CLASS (blueprint/template). Alice and Bob are the
OBJECTS (instances)—the actual things created from that class.
b. When you call alice.deposit(500), ONLY Alice’s balance changes.
The program uses the ‘alice’ reference to understand which specific object's method to call.
 Inside the method, the this keyword points to that specific object.
c. Memory diagram (ASCII):

alice ---> [ ownerName: "Alice", balance: 0.0 ]
bob   ---> [ ownerName: "Bob",   balance: 0.0 ]

d. If you do alice = bob;, then both alice and bob will point to the same object.
After that, if you call alice.deposit(100), Bob’s balance will also change
(because they are now sharing the exact same memory location).

*/
}