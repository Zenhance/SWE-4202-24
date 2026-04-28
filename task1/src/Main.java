//PART A
//a)every account needs to store the name and balance of the owner.
//the type of name is String and the type of balance is double;
//b)as per the given question,the first action is adding amount to the balance if any
//deposit happens. Either it adds the amount or shows error.
//the 2nd action is subtracting the amount of money from the balance.
//if this is less than zero than it prints insufficient funds;
//c)if I do the exact same thing written in the question then I have to
//loop a lot of times which will take memory and take a lot of time.
//it has to be maintained which is a big problem.
//d)if the bank later wants to add transaction limit per day then I would have to
//calculate the transaction limit in BankAccount.java and print it using the main.java
//b.
public class Main {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("Alice");
        BankAccount b2 = new BankAccount("Bob");
        BankAccount b3 = new BankAccount("Labiba");
        b1.deposit(500);
        b1.withdraw(300);
        b2.deposit(1000);
        b2.withdraw(200);
        b3.deposit(500);
        b3.withdraw(300);

        b1.printStatement();
        b2.printStatement();
        b3.printStatement();
    }
}
//c.
//a)the word for BankAccount is class and the word for Alice and bob are objects.
//b)only alices balance change else remains the same.
//c)
//b1's name=alice and b1's balance is 0;
//b2's name=bob and b2's balance is 0;
//b3's name=Labiba and b3's balance is 0;
//d)
//
