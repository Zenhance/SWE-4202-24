/*

    Part A

    a) Every account needs to store 2 information-
       i) Owner's name as string.
       ii) Owner's balance as integer.

    b) The three actions customer can perform on their
    account-
       i) deposit(amount)-
            -inputs: amount,
            -output: adds the amount to current balance.
       ii) withdraw(amount)-
            -inputs: amount
            -output: substracts the amount if enough balace
                     present.
      iii) printStatement()-
            -inputs: dont take any input
            -output: prints owner's name and balance

      c) It will be very tough and complex to store and
       retrieve the data from the array of 200 customers.

      d) It should added in BankAccount. Because each account
      will have its own transaction limit

 */



public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(String owner){
        this.owner = owner;
        this.balance = 0;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid Amount");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance - amount < 0){
            System.out.println("Invalid Amount");
            return;
        }
        balance -= amount;
    }

    public void printStatement(){
        System.out.println("Name: " + owner);
        System.out.println("Balance: " + balance);
    }

}


/*

Part C-

a) BankAccount is a class and alice and bob are
objects.

b) Only Alice's balance changes, program will
know from the particular object of Alice

c)alice-
       ownerName = "Alice";
       balance = 0;

  bob-
        ownerName = "bob";
        balance = 0;

d)Both will be refering same object. Bob's balance will
increse because both will be on same object.

*/