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

// Part==> B
public class BankAccount {

        String Name;
        double balance;

        public BankAccount(String Name){

            this.Name=Name;
            this.balance=0.0;
        }

        public void printStatement() {
            System.out.println("The owner's name " + Name);
            System.out.println("The Balance: " + balance);
        }

        public void deposit(double amount){
            if(amount<=0){
                System.out.println("error");
            }else{
                balance+=amount;
            }
        }
        public void withdraw(double amount)
        {
            balance-=amount;
        }
}

// Part ==> C

// Question - a,
//        Bank account is the class.
//        Alice and Bob are Objects.

// Question - b,
//            only Alice's balance changes.
//            The program knows because Each object is independent. when I use Alice's name
//            the program looks at the specefic memory location where alice's data is stored.

// Question - c,
//                Object: Alice       Object: Bob
//
//                Name: "Alice"       Name: "Bob"
//                balance: 0          balance:0

//Question - d,
//            The prediction would be that Bob's balance will increase by 100.
//            Because (=) this is an assignment operator. when alice=Bob is written
//            the data of Bob is assigned to alice.
