public class Main{
    public static void main(String[] args){
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount jenny = new BankAccount("Jenny");


        alice.deposit(500);
        alice.withdraw(75);
        alice.printStatement();

        bob.deposit(100);
        bob.withdraw(75);
        bob.printStatement();

        jenny.deposit(200);
        jenny.withdraw(75);
        jenny.printStatement();
    }
}
