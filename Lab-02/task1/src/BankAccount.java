/*

 Problem 1 : BankAccount


  PART A — Design questions

  a) What information does every account need to store?
     - ownerName  : String  because it refres to the full name of the account holder
     - balance    : double because it refers to the current amount of money in the account

 b) What are the three actions a customer can perform?
  1. deposit(amount)
      - Input  : a positive double (the amount to add)
      - Output : balance increases by that amount
                 (error printed if amount is less than or equal to 0, nothing changes)
   2. withdraw(amount)
       - Input  : a positive double (the amount to take out)
    - Output : balance decreases by that amount
               (error printed if it would go below 0, nothing changes)
  3. printStatement()
      - Input  : none
      - Output : prints the owner name and current balance to the screen

  c) Why is one big array in main a bad idea for 200 customers?
     With parallel arrays (names[], balances[]) you have to keep
     two arrays perfectly in sync at all times. If you insert or
     delete at position i in one array and forget to do the same
    in the other, the data becomes mismatched — Alice's name ends
     up paired with Bob's balance. With 200 customers this becomes
     almost impossible to manage safely. A class keeps name and
     balance together inside ONE object so they can never get out of sync.

  d) Where would a "transaction limit per day" feature go?
     Inside the BankAccount class — not in main.
     The class is the right place because it owns the account data.
    We would add a private field (e.g. dailyWithdrawals) and update
    the withdraw() method to check it. main should not know HOW an
     account enforces its rules — it just calls the method and trusts
     the class to do the right thing. This is the principle of encapsulation.

 */
public class BankAccount {

    // --- Private fields ---

    // private = only code INSIDE this class can read or change these.
    private String ownerName;
    private double balance;


    // --- Constructor ---
    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance   = 0.0;      // every new account starts empty
    }

    // --- deposit ---
    // Adds money to the balance.
    // We reject zero or negative amounts because they make no sense.
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error [" + ownerName + "]: deposit amount must be positive.");
            return;   // stop here, do NOT change the balance
        }
        balance += amount;
        System.out.println("[" + ownerName + "] Deposited: " + amount
                + " | New balance: " + balance);
    }

    // --- withdraw ---
    // Subtracts money from the balance.
    // We refuse if it would push the balance below zero (no overdraft allowed).
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error [" + ownerName + "]: withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds [" + ownerName + "]: tried "
                    + amount + " but balance is only " + balance);
            return;   // stop here, balance stays the same
        }
        balance -= amount;
        System.out.println("[" + ownerName + "] Withdrew : " + amount
                + " | New balance: " + balance);
    }

    // --- printStatement ---
    // Shows the current state of this account.
    public void printStatement() {

        System.out.println("Owner  : " + ownerName);
        System.out.println("Balance: " + balance);




    // MAIN METHOD — creates 3 accounts and tests everything

    public static void main(String[] args) {

        // Create three completely independent BankAccount objects.
        // Each object has its OWN ownerName and balance stored inside it.
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob   = new BankAccount("Bob");
        BankAccount carol = new BankAccount("Carol");

        // --- Alice's operations ---
        System.out.println("\n--- Alice ---");
        alice.deposit(1000);
        alice.deposit(500);
        alice.withdraw(200);
        alice.withdraw(2000);   // should print "Insufficient funds"
        alice.printStatement();

        // --- Bob's operations ---
        System.out.println("\n--- Bob ---");
        bob.deposit(300);
        bob.withdraw(300);
        bob.withdraw(50);       // should print "Insufficient funds"
        bob.deposit(-100);      // should print error (negative amount)
        bob.printStatement();

        // --- Carol's operations ---
        System.out.println("\n--- Carol ---");
        carol.deposit(5000);
        carol.withdraw(1200);
        carol.withdraw(800);
        carol.printStatement();
    }

    /*
      PART C — Objects in memory (answered after writing main)


     a) What is BankAccount, and what are alice and bob?
        BankAccount is a CLASS  — it is a blueprint/template written once.
        alice and bob are OBJECTS (also called instances) — they are two
         separate things built from that blueprint at runtime.

      b) When you call alice.deposit(500), which balance changes?
       Only Alice's balance changes. Java knows which one because every
      object lives at its own memory address. When you call alice.deposit(),
        Java passes a hidden reference ("this") pointing to Alice's object.
       The method reads and updates the balance inside THAT specific object.
      Bob's object is at a different address and is never touched.

     c) Memory box diagram after:
           BankAccount alice = new BankAccount("Alice");
            BankAccount bob   = new BankAccount("Bob");


       alice and bob are REFERENCES (pointers) to two separate objects.

      d) What happens if you write alice = bob; then alice.deposit(100)?
         alice = bob makes alice point to Bob's object. Now BOTH variables
         (alice and bob) point to the SAME object in memory. Alice's original
         object is now unreachable (lost). Calling alice.deposit(100) will
         add 100 to BOB's balance, because that is the object alice now
            references. Bob's balance increases by 100. The original Alice
        object is gone forever (garbage collected eventually).

}
