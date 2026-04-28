public class BankAccount {
        private String owner;
        private double balance;

        BankAccount(String owner,double balance){
            this.owner = owner;
            this.balance = 0;
        }

        double deposit(double amount){
            balance+=amount;
            return balance;
        }

        double withdraw(double amount){
            if(balance>=amount) {
                balance -= amount;
                return balance;
            }
            else {
                System.out.println("Insufficient funds.");
                return balance;
            }
        }


    static void main(String[] args) {

    }
}
