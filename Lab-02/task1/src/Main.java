public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Abraham");
        BankAccount a2 = new BankAccount("Tyler");
        BankAccount a3 = new BankAccount("Robin");
        a1.deposit(500);
        a1.withdraw(300);
        a2.deposit(1500);
        a2.withdraw(1000);
        a3.deposit(100);

        a1.printStatement();
        a2.printStatement();
        a3.printStatement();
    }
}

/*
Part C — Objects in memory

a. BankAccount is a class.
   a1, a2, a3 are objects.

b. Only the object on which the method is called changes.
   For example, a1.deposit(500) changes only a1.

c. Memory example:
a1  name: Abraham, balance: 500
a2  name: Tyler, balance: 1500
a3  name: Robin, balance: 100

d. If we write: a1 = a2;
   Then both refer to the same object.
   So any change using a1 will also affect a2.
*/