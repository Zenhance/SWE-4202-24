/*information to store
  1.String owner name
  2.double account balance
 */

/*actions perform
  1.Deposit
    input - account balance
    output - balance increase
    change-
  2. Withdraw
     input - account balance
     output - balance decrease
     change -
  3. Check balance
 */

/* the code will be difficult to understand and maintain. it will become messy.
Handling 200 customers and their information using array will make it hard to find and enter data.
 */

/* I will add the transaction limit in the main.
 */
class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name){
        this.name=name;
        this.balance=0;
    }

    public void deposit(double balance){
        if(balance<=0)
            System.out.println("Invalid balance");
    }

    public void withdraw(double balance){
        if(balance<=0)
            System.out.println("Not enough");
    }
}
