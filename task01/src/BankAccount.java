public class BankAccount {
    private String name;
    private float balance;

    public BankAccount(String name) {        
        this.balance = 0;
        this.name = name;                    
    }

    public float deposit(float amount) {
        balance = balance + amount;
        return balance;
    }

    public float withdraw(float amount) {
        if (amount >= balance) {             
            System.out.println("Error\n");
            return balance;
        } else {
            balance = balance - amount;
            return balance;                 
        }
    }

    public void checkBalance() {             
        System.out.println("Your Balance is: " + balance);
    }
}
