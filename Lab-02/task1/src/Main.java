//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args){
        BankAccount acc1= new BankAccount("Alif");
        BankAccount acc2= new BankAccount("Kabir");
        BankAccount acc3= new BankAccount("Rahim");

        acc1.DepositAmount(500.0);
        acc1.WithdrawAmount(200.0);

        acc2.DepositAmount(1000.0);
        acc2.WithdrawAmount(800.0);

        acc3.DepositAmount(1500.0);
        acc3.WithdrawAmount(2000.0);

        acc1.PrintStatement();
        acc2.PrintStatement();
        acc3.PrintStatement();
    }
}




/* **** Answer to the question part C****

  a. Bank account is the constructor that we have made in the BankAccount class
     that would point to the ownerName and then set their balance to 0. So, in the
     main function, Alice(Alif) and Bob(Kabir) are the two ownerNames and after their
     names are passed into the constructor, their balance has been set to 0. after that,
     in the main function, their deposited amount and withdrawn amount has been taken as
     input and finally, their balance will be shown as output in the PrintStatement.


  b. So, when i call Alice.deposit(500), only the balance of Alice will change. The programe
     knows what to change because of the cosntructor that we made. in the constructor, it has
     been specified by 'this' pointer which will point to any particular name that will be passed
     into the constructor as parameter. so, when alice has been passed as the parameter, it will only
     take the information/balance of the alice.


  c. alice:
        ownerName: "Alice";
        Balance:0;

     bob:
        ownerName: "Bob";
        Balance:0;




   d. Then the balance of bob would be 100 because, then the pointer would point to the balance
      of the alice and then copy it to the pointer of bob.
 */