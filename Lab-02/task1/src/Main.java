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

public class Main
{
    static void main(String[] args)
    {
        BankAccount Rakib = new BankAccount(" Rakib ");
        BankAccount Alice = new BankAccount(" Alice ");
        BankAccount Bob = new BankAccount(" Bob ");
    }
}