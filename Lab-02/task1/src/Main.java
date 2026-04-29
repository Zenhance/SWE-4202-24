
/*
a.informations may be-account name(string),current balance(double),account number(int),
 etc.

b.the three actions are-deposit money, withdraw money and check their balance.
 1.for deposited money it will take
   input-the amount of money user wants to deposit,
   & output- will change the balance (add /increase balance)
 2.for withdraw it will take input-the amount of money user wants to withdraw,
   & output-will change the balance (deduct from it/decrease balance)
 3.for checking the balance will take certain input-such as name and account password
   & output-the current balance of the user

c.management difficulty
 managing information of 200 customers will become difficult,adding or modifying the whole structure will
 be difficult,messy,indexes and datas will be mixed up easily,etc.

d.in the account class,not in main,there a variable will track of the transaction and check if it hits limit or not,
the reason it should be kept in account class is that this transcation limit is related to each individual
account.,keeping it in class will make it organized and easy to manage later,but keeping it main will be
problematic and hard to maintain.
*/
public class Main {
    public static void main(String[] args) {



        BankAccount Jamil=new BankAccount("Jamil");
        BankAccount Hasan=new BankAccount("Hasan");
        BankAccount Riju=new BankAccount("Riju");

        Jamil.deposit(400);
        Jamil.withdraw(300);

        Hasan.deposit(5000);
        Hasan.withdraw(6000);
        Hasan.deposit(700);

        Riju.deposit(600);
        Riju.withdraw(300);
        Riju.deposit(6500);


        Jamil.printStatement();
        Hasan.printStatement();
        Riju.printStatement();

    }
}