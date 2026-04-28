/* Question Answer
(a) Every account need to store two information. The name of the account owner
and the current balance of the account.
Name => String
Balance => float

(b)Three actions that a customer can perform on their account are- DepositMoney, WithdrawMoney and CheckBalance.
DepositMoney => It needs to know the deposit amount and it generates the new balance.
WithdrawMoney => It needs to know the withdraw amount and it generates the new balance also it will
give error if the Withdraw amount is more than the balance.
CheckBalance => It returns the main account balance.

(c)The moment when I need to handle 200 customers is going to a very difficult task as I have to manage all of their
balance or add new customers of remove existing customer. If I can use two different arrays to
store the name and the balance.


(d) I would add the transaction limit in the BankAccount class so that the transaction
limit to each customer would be unique to them and not affect other people's transaction limits at all..

 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Code is working");
    }
}