public class BankAcc {
    /* PART A)
    a)info-
    Their bank account name -type string
    current balance information - type double
    last deposit information - type double
    last withdrawal money information -type double
    their recent bank statement - type string

    PART A)
    b)Three actions a customer can perform -
    1) deposit money
    input - money amount to add in bank account
    changes- bank balance increases
    2)withdrawal money
     input- the amount of money need to get out of bank account
     output- decreases amount in account

     3)check their account statement
     input- their log in information
     output-their bank statement
      part A)
     c)difficulties in matching owners name array with balance array

     part A)
     d)
     I would add that in BankAcc class because part of the account balance should be handled by class
*/
    //Part B-
    private String Ownname;
    private double  Bal;


public BankAcc(String ONN){
    this.Ownname=ONN;
    this.Bal=0;
}
public void deposit(double am){
    if(am<=0){
        System.out.println("Invalid ");
    }else Bal+=am;
}
public void wd(double am) {
    if (am > Bal) {
   System.out.println("Insufficient funds");
    }else Bal-=am;
}
public void printStatement(){
    System.out.println("Name:" + Ownname +"Balance:" +Bal);
}
public static void main(String[] args){
    BankAcc Alice= new BankAcc("Alice");
    BankAcc Bob= new BankAcc("Bob");
    BankAcc Charlie= new BankAcc("Charlie");
    Alice.deposit(500);
    Bob.deposit(834);
    Charlie.deposit(673);
    Alice.wd(20.23);
    Bob.wd(40.98);
    Charlie.wd(55.9);
    Alice.printStatement();
    Bob.printStatement();
    Charlie.printStatement();
}

//Part C
    /*a)
    BankAcc is the class and Alice and Bob are object

    b)when I call alice.deposit(500); it changes the balance of alice only
    because alice her own separate balance in memory

    c)Memory diagram -
    before deposit :
    Name : Alice
    Bal : 0

     Name : Bob
    Bal : 0

    after deposit:
     Name : Alice
     Bal : 500

     Name : Bob
     Bal : 834

     d)if I do alice=bob and call alice.deposit(100)
     Bob's balance will change , 100 will be added to his current balance

*/
}
