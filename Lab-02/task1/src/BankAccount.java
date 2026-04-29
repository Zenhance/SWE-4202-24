//Answer:

    /* PART-(A):

(a) Every account need to store two information.
    i)Name of the account owner. --(String)
    ii)Current account balance. --(Float)

(b) 3 actions that a customer can perform are : DepositMoney,WithdrawMoney, CheckBalance.
     i)DepositMoney:
                     Needs to know(input):amount of deposit.
                     What it generate(output):total balance after deposit.

     ii)WithdrawMoney:
                      Needs to know(input):withdraw amount.
                      What it generate(output):total balance after deposit.
                              (But first checks if the balance is sufficient for withdrawal.
                              If the balance is insufficient or zero then show an error.)

     iii)CheckBalance:It will return the main account balance.

(c)When I need to handle 200 customers it will be a very difficult task as I have to manage all of their
   balance or add new customers or remove existing customer.We need to carefully match the index for each customers that will be harder.

(d)If the bank later want to add a transaction limit per day then I will add that inside the BankAccount class(not inside 'main') as
   the code will be more cleaner and easier to manage if I write code in this way.


 */


  //PART-(B):

public class Main {
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount tanbir = new BankAccount("Tanbir");

        alice.deposit(1000);
        bob.deposit(2000);
        tanbir.deposit(500);

        alice.withdraw(200);
        bob.withdraw(300);
        tanbir.withdraw(100);

        alice.printStatement();
        bob.printStatement();
        tanbir.printStatement();
    }
}

     //Part-(C):
/*
(a)BankAccount is a class.Alice and Bob is object.
(b)Alice's balance changes only.The program knows before each object has separate attributes and methods.
    When I call an object(alice),all methods used only change alice's attributes(balance).

(c)Alice:
    Name="Alice"
    Balance = 0.00

   BOB:
     Name ="Bob"
     Balance = 0.00

(d)If I wrote 'alice=bob' and then called alice.deposit(100) then it will act same as bob.deposit(100).
  Because when I declare 'alice = bob',I am allowing to refer the object 'Bob' with both 'bob' and 'alice'
  and so that the total balance will increase by 100 when either bob.deposit(100) or alice.deposit(100) works.


 */