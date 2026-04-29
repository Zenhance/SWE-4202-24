
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


/*
a.Here BankAccount is called class(blueprint) and alice and bob are called objects,
these are instances from the blueprint.

b.When I call alice.deposit(500),only the balance of Alice changes,
the program knows which to update because each object has its own memory location,
when alice.deposit(500) or the method is called,the program uses the
reference of alice and it finds alice object's location in memory and changes it.

c.alice:
     name:"Alice"
     balance:0

   bob:
     name:"Bob"
     balance:0

 d.bob's balance will change and it will be incremented by 100 because alice and bob
 now refer to the same object.When alice=bob,both variables point to the same memory location,
 so any change through alice will also affect bob.











 */