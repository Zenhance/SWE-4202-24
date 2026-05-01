package task1;

public class Main {
    public static void main(String[] args){
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount Tasnova = new BankAccount("Jenny");


        alice.deposit(500);
        alice.withdraw(75);
        alice.printStatement();

        bob.deposit(100);
        bob.withdraw(75);
        bob.printStatement();

        Tasnova.deposit(200);
        Tasnova.withdraw(75);
        Tasnova.printStatement();
    }

}
