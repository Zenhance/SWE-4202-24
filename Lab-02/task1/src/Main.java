public class Main{
    public static void main(String[] args){

        BankAccount hasib = new BankAccount("Hasib");
        BankAccount samin = new BankAccount("Samin");
        BankAccount jahin = new BankAccount("Jahin");


        samin.deposit(14000);
        samin.withdraw(1000);
        samin.printstatement();

        jahin.deposit(20000);
        jahin.withdraw(21000);
        jahin.printstatement();

        hasib.deposit(23000);
        hasib.withdraw(-1000);
        hasib.printstatement();
    }
}