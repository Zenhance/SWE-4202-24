public class BankAccount {
        private String owner;
        private double balance;

        BankAccount(String owner){
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

        void printStatement(){
            System.out.println("Owner's Name: "+owner);
            System.out.println("Current Balance: "+balance);
        }


    static void main(String[] args) {

    }
}
