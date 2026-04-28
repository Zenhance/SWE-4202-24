/*
 * a.Every account needs a account holder name and balance.
 *  String name, long long balance.
 * b.Deposit- Input: Amount ; Updates balance;
 *  Withdraw-    Input: Amount ; Updates balance;
 *  Check balance-   Input: Account name; Displays account balance;
 * c.
 *
 * d. Added in Withdraw method;
 * */

class BankAccount{
    private String ownerName;
    private long balance;

    public void BankAccount(String name) {
        ownerName = name;
        balance = 0;
    }

    public void Deposit(long amount){
        balance+=amount;
    }

    public void Withdraw(long amount){
        balance-=amount;
    }

    public void CheckBalance(){
        System.out.println("Owner's name: "+ownerName);
        System.out.println("Balance: "+balance);
    }

}

