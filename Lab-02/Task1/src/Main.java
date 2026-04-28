//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
         A.Every account needs to store: Current Balance

         B.Three actions one can perform from their account:
            1.Deposit:It will take a float value and deposit
            2.Withdraw
            3.Check Balance
         C.Storing all account balances in one big array in the main with a seperate array of
           owner names will cause problems because editing these informations will be difficult and inputting the
           balances in each index of the array will also be painful.
         D.
         */
        Bankaccount b1=new Bankaccount("Bob",12345.00);
        Bankaccount b2=new Bankaccount("Sam",3459.22);
        Bankaccount b3=new Bankaccount("Sydney",24411.39);
        b1.printstatement();
        b1.deposit(235.4);
        b1.printstatement();
        b2.printstatement();
        b2.withdraw(300.5);
        b2.printstatement();
        b3.printstatement();
        b3.deposit(22222);
        b3.printstatement();
        }
    }
/* a.Bankaccount is class. alice and bob ar objects.
   b.Alices balance changes as the alice object has its own address which has the
 */
