public class Main{
    public static void main(String[] args){
        BankAccount customer1= new BankAccount("Efte");
       customer1.deposit(1000);
       customer1.withdraw(900);
       customer1.printStatement();
    }

}
