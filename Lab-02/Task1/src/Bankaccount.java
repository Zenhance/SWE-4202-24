public class Bankaccount {
       private String name;
       private double balance=0;
     Bankaccount(String name,Double balance) {
         this.name = name;
         this.balance = balance;
     }
     public void deposit(double amount){
         this.balance=amount+balance;
         if (amount<=0){
             System.out.println("Error");
         }
     }
     public void withdraw(double amount){
         this.balance= balance-amount;
         if(amount>balance){
             System.out.println("Insufficient Balance");
         }
     }
     public void printstatement(){
         System.out.println(this.name+" "+this.balance);
     }
}

