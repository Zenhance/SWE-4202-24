//Question No.1 ==> Every account should store
//                   1. Owner name in String;
//                   2. Balance in double;
//                   3. Account ID in String;



//Question No (b) ==> Three actions a customer can perform
//                    1. Deposit
//                        input: amount (double)
//                        output: balance increase
//                    2. Withdraw
//                        input: amount (double)
//                        output: Balance decrease
//                    3. check balance
//                        input: None
//                        output: current balance

//Question (c)==> The problems would be,
//                1. Data inconsistency
//                2. Hard to manage.
//                3. It is costly
//                4. Difficult to extend

//Question (d)==> I would add it inside the BankAccount class. Not inside main
//                because ,
//                1. The limit is a property of each account.
//                2. Easier to maintain
//                3. Avoids the reuse of code
public class BankAccount {

        String Name;
        double balance;

        public BankAccount(String Name,double balance){

            this.Name=Name;
            this.balance=balance;
        }

        void printStatement() {
            System.out.println("The owner's name " + Name);
            System.out.println("The Balance: " + balance);


        }

    public static void main(String[] args){

        BankAccount s1=new BankAccount("M", 1000);
        s1.printStatement();


}



}
