/*Every account needs to store informations that are private. Example : String name etc
The customer can deposit
can withdraw3
 */
public class Main{
    public static void main(String[] args){
        BankAccount Alice =new BankAccount("Alice",500.0F);
        BankAccount Bob =new BankAccount("Bob",100.0F);
        BankAccount abc =new BankAccount("abc",2000.0F);

        Alice.deposit(500);
        Alice.withdraw(30);
        Alice.print();


        Bob.deposit(100);
        Bob.withdraw(20);
        Bob.print();

        abc.deposit(100);
        abc.withdraw(20);
        abc.print();




    }

}