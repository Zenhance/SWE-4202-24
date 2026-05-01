/*
      a.
        every account needs to store:
              (1)ownername-string
              (2)balance-double
       b.
        customer can:
               (1)deposite-how much amount add and return new amount
               (2)withdraw-how much amount takeout and return new amount,if takeout amount more than
                           amount it creats error

       c.
        It is very difficult to 200 customers:
                (1)all time need to keep the index perfectly
                (2)if one array will delete ,it creates bug
                (3)two separate arrays force to search
                   both manually and keep indexes, one mistake
                   the wrong name to the wrong balance.

 */
package task1;

public class Main
{
    public static void main(String[] args)
    {
        BankAccount Rakib = new BankAccount("Rakib");
        BankAccount Alice = new BankAccount("Alice");
        BankAccount Bob = new BankAccount("Bob");
        Rakib.deposit(50000);
        Alice.deposit(20000);
        Bob.deposit(5000);
        Rakib.withdraw(2000);
        Alice.withdraw(1000);
        Bob.withdraw(500);
        Rakib.printStatement();
        Alice.printStatement();
        Bob.printStatement();

    }
}
/*
       a.
          BankAccount is a class and alice and bob is an object of the BankAccount class.

       b.
          only changes Alice's balance because of when we will do alice.method, it knows that the
          method should only change the attributes of the Alice object.

       c.
          alice:
              name = "Alice"
              balance = 0

          bob:
              name = "Bob:
              balance = 0

       d.
             it would update bob's balance because of alice now the object bob.




 */