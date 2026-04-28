/*
a)name and current balance
b)deposit money: input is deposit amount(int), output is new balance(int),success or error message(char)
  withdraw money: input is withdraw amount(int), output is new balance(int),success or error message(char)
  check balance: no value input, output is new balance(int)
c)it would be difficult to add and/or delete new entries. it would also be difficult to search specific individual.
d)for a new function transaction limit per day, I would add to BankAccount class
 */
public class Main {
    public static void main(String[] args) {
        BankAccount Inan=new BankAccount("Inan");
        BankAccount Jaki=new BankAccount("Jaki");
        BankAccount Sajid=new BankAccount("Sajid");

        Inan.deposit(100);
        Jaki.deposit(200);
        Sajid.deposit(50);

        Inan.withdraw(200);
        Jaki.withdraw(30);
        Sajid.withdraw(50);

        Inan.printStatement();
        Jaki.printStatement();
        Sajid.printStatement();
    }
}