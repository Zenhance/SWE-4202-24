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
}