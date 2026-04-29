public class BankAccount {
    /* PART A
    a. Info to store: 1) ownerName - String 2) balance - double
    b. 3 sections:
    1)deposit(amount)
    *input: double amount
    *output: increases balance
    **amount>0
    2)withdraw(amount)
    *input: double amount
    *output: decreases balance
    **balance !< 0
    3)printStatement()
    *input: none
    *output: owner name and current balance
    c. using separate arrays for name and balance-> can't match ownerName[i] to balance[i] with too many customers
    d. in BankAccount class. part of the account behaviour, should be handled by the class
     */
    //Part B
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName){
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Invalid Deposit Amount!!!");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount){
        if (amount > balance){
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
    }

    public void printStatement(){
        System.out.println("Owner: " + ownerName + ", Account Balance: " + balance);
    }
    public static void main(String[] args){
        BankAccount Alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount charlie = new BankAccount("Charlie");
        Alice.deposit(500);
        Alice.deposit(200);
        bob.deposit(1000);
        bob.withdraw(1200);
        charlie.deposit(300);
        charlie.withdraw(100);
        Alice.printStatement();
        bob.printStatement();
        charlie.printStatement();
    }
}






























}
