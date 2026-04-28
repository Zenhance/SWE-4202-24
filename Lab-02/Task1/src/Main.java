//(a) Every account should store two info. The name of the account owner
//and the current balance of the account.
//name -> String
//balance -> float

//(b)depositMoney, withdrawMoney and checkBalance.
//depositMoney needs to know the deposit amount and it produces the new balance
//withdrawMoney need to know the withdraw amount and it produces the new balance
//gives error if the withdraw amount is more than the balance
//checkBalance just returns the account balance

//(c)The moment I need to handle 200 customers, it would be very difficult to manage all of their
//balance or add new customers of remove existing customer if I use just two different arrays to
//store the name and the balance.


//(d) I would add the transaction limit in the BankAccount class. So that the transaction
//limit to each customer would be unique to them and not affect other people's transaction limits



public class Main {

    static void main(String[] args) {
        BankAccount Fuad = new BankAccount("Fuad");
        BankAccount Rubayet = new BankAccount("Rubayet");
        BankAccount Samin = new BankAccount("Samin");

        Fuad.deposit(10000);
        Rubayet.deposit(20000);
        Samin.deposit(113);

        Fuad.withdraw(325);
        Rubayet.withdraw(124);
        Samin.withdraw(113);

        Fuad.printStatement();
        Rubayet.printStatement();
        Samin.printStatement();

    }
}

