public class BankAccount {
    String name;
    double balance = 0;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error");
        } else {
            balance += amount;
        }

    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient");
        } else {
            balance -= amount;

        }

    }
    void print(){
        System.out.println(name);
        System.out.println(balance);
    }
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