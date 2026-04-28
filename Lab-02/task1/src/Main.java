public class Main {
    //a.the ownerName variable is a String and balance is double type.

    /*b.Customers can
    Deposit:
        input:balance
        output:balance increase
     Withdraw:
        input:amount
        output:balance decrease
      Check balance:
        input:none
        output:balance

      c.When I handle 200 customers in just 2 different arrays,
         it can be very hard to maintain all the data and can face
         difficulties to update or add or remove a customer.

        d.I would not add the transaction limit in the main,but
        rather create another BankBalance class. Because by doing
        this every customer can have their unique transaction limit,
        and it will not affect other customer's account.
     */

    public static void main(String[] args) {

            BankAccount Raiyan=new BankAccount("Raiyan");
            BankAccount Sadman=new BankAccount("Sadman");
            BankAccount Fuad=new BankAccount("Fuad");

            Raiyan.deposit(10000);
            Sadman.deposit(50000);
            Fuad.deposit(30000);

            Raiyan.withdraw(1000);
            Sadman.withdraw(2000);
            Fuad.withdraw(5000);

            Raiyan.printStatement();
            Sadman.printStatement();
            Fuad.printStatement();

    }
}
/*
Part C
a. BankAccount is  class and alice and bob are objects of this class.

b. Calling alice.deposit(500) will only update alice's balance.
   By calling the alice.method,the program only change the attribute of alice object.

c. alice:
    name = "Alice"
    balance = 0.0

   bob:
     name = "Bob:
     balance = 0.0

d. It will update bob's balance.
   Because alice and bob points the same object which is object of bob.
 */

