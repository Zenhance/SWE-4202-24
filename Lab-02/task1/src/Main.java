//account needs to store: curr balance double, String name;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="Al//
//deppsit: balance;
//withdraw: amount of withdrawal money
//printstatement: print name and final amount
// if we do this code in a big array then we can miss any information to store if we need to store unlimited info, we don't know the range;
//I will add a method in the main and in the method part I will print everyday's transaction. withdraw and deposit ;
//
public class Main {
    public static void main(String [] args){
     Bankaccount s1 = new Bankaccount("Mina");
     Bankaccount s2 = new Bankaccount("Rina");
     Bankaccount s3 = new Bankaccount("Rami");
     s1.deposit(50000);
     s2.deposit(1000);
     s1.withdraw(10000);
     s2.withdraw(500);
     s1.printdetails();
     s2.printdetails();

    }
}
//by alice.deposit(2000) we mean alice will deposit 2000 tk, it will not change bob's amount. it will only work for alice, alice. leads it to alice
//alice = bob , means alice and bob's address is same, so if we make a change in any of their money both of their's will be changed

