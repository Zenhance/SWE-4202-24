/*
 a. Every account needs to store the following information of the account owner,
 name and balance of the account owner.
 Name can be stored in Strings and balance can be stored in double

 b. A customer can perform three actions on their account; deposit, withdraw and
 check their balance.
 Deposit - it takes the amount of money to be deposited as input and updates the balance.
 Withdraw - it takes the amount of money to be withdrawn as input and updates the balance.
 Check balance - it prints the account owner name and their balance.
 c. When handling large array of names and balances, it will increasingly become more
 difficult to keep track of indexing, matching data between both arrays each time new
 member is added to the array.
 d. I will add transaction limit per day in the BankAccount.java class, so that whenever
 a customer does any transaction, it will be updated instantly in the methods stated
 earlier.
*/

public class Main {

    public static void main(String[] args) {

        BankAccount wasif = new BankAccount("Wasif");
        BankAccount jafar = new BankAccount("Jafar");
        BankAccount rafi = new BankAccount("Rafi");

        wasif.deposit(1000.0);
        wasif.printStatement();

        wasif.withdraw(1500.0);
        wasif.printStatement();

        wasif.withdraw(500.0);
        wasif.printStatement();

        jafar.deposit(2000.0);
        jafar.printStatement();

        jafar.withdraw(1000.0);
        jafar.printStatement();

        jafar.withdraw(200.0);
        jafar.printStatement();

        wasif = jafar;

        System.out.println("This is it.");
        wasif.deposit(100.0);

        wasif.printStatement();
        jafar.printStatement();


        rafi.deposit(5000.0);
        rafi.printStatement();

        rafi.withdraw(1000.0);
        rafi.printStatement();

        rafi.withdraw(7000.0);
        rafi.printStatement();

    }
}

/*
a. BankAccount is a class and wasif,jafar and rafi are objects of BankAccount class
b. When I call wasif.deposit(500.0) wasif's balance changes since i am accessing the
 object wasif, the program knows to update wasif's balance.
c. BankAccount -
               |
               - wasif - name    - Wasif
                       - balance - 0.0
               - jafar - name    - Jafar
                       - balance - 0.0
               - rafi  - name    - Rafi
                       - balance - 0.0
 d. After I wrote wasif = jafar, every attribute of wasif object now have the same value
 jafar object.Then, when I call wasif.deposit(100.0), I am only changing wasif's balance
 but wasif now has jafar's balance and name, so jafar's balance is updating.
 */