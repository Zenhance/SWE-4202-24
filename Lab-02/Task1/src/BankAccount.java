//answer a=>
// account id name=string
// balance=double
// answer b=>
// deposit money=input amount and output the money after add amount
// withdraw money= input the amount to withdraw and output the balance after withdraw money
// printstatement= output the owners name and balance
// answer c=>
//hard to manage,data inconsistency,difficult to extend
// answer d=>
// add that transaction in the BankAccount class for easier to maintain


public class BankAccount {
    private String owners_name;
   private double account_balance;
 public BankAccount(String owners_name){
     this.owners_name=owners_name;
     this.account_balance=0.0;
 }

 public void deposit(double amount){
     if(amount <=0){
         System.out.println("The amount is error!");
     }
     else {
         account_balance +=amount;
     }
 }
 public void printStatement(){
     System.out.println(this.owners_name);
     System.out.println(this.account_balance);
 }

}
