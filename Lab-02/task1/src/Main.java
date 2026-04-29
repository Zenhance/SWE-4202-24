
/*
* 1) the information I need to colledt
*       User Name
*       Account ID
*       Current Balance
*       Password
*
* 2)Actions they can perform
*       Check balance
*           => To check balance, we have to know the current balance of the account and then             we will show the current balance as output.
*       Add Money
*           => To do this thing we have to know nothing. Added money will be added to the               current balance.
*       Withdraw Money
*           =>To withdraw money, we have to check the current balance. and my must validate             the withdraw amount should not be larger the the current balance.
*
* 3) It will be very hard to change anything or add or remove customer. And it will be Error prone.
*
* 4) I would add the transition limit in the Account class.
* */
public class Main {
    public static void main(String[] args) {

        BankAccount musaddik = new BankAccount("Musaddik");
        BankAccount mustakim = new BankAccount("Mustakim");

        musaddik.deposit(10000000);
        musaddik.withdraw(2000);

        mustakim.deposit(202943);
        mustakim.withdraw(3424);

        musaddik.printStatement();
        mustakim.printStatement();


    }
}

/*
* a) Bank Account is a class. Alice and Bob is object.
*
* b)Alice's balance changes. Because, we objects has own memory location. One object is not connected with other.
* so when we chane mentioning alice, it changes alice's balance
*
* c)             Object: Alice       Object: Bob
*
*                Name: Alice         Name: Bob
*                balance: 0          balance:0
*
* d) I think nothing will happen to Bob's balance.
* */