public class Main{
    public static void main(String[] args){
        BankAccount customer1= new BankAccount("Efte");
       customer1.deposit(1000);
       customer1.withdraw(900);
       customer1.printStatement();
       BankAccount customer2= new BankAccount("Sabbir");
       customer2.deposit(2000);
       customer2.withdraw(47);
       customer2.printStatement();
       BankAccount customer3= new BankAccount("Bilgates");
       customer3.deposit(100000);
       customer3.withdraw(5);
       customer3.printStatement();
    }

}
