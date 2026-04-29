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

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid balance");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough");
        } else {
            balance -= amount;
        }
    }

    public void printStatement() {
        System.out.println(name);
        System.out.println(balance);
    }

        public static void main(String[] args) {
            BankAccount b1 = new BankAccount("Alice");
            b1.deposit(7150);
            b1.withdraw(715);
            b1.printStatement();

            BankAccount b2 = new BankAccount("Bob");
            b2.deposit(8000);
            b2.withdraw(768);
            b2.printStatement();

            BankAccount b3 = new BankAccount("Yami");
            b3.deposit(7654);
            b3.withdraw(987);
            b3.printStatement();
        }
    }

