public class BankAccount {
        private String owner;
        private double balance;

        BankAccount(String owner){
            this.owner = owner;
            this.balance = 0;
        }

        public double deposit(double amount){
            balance+=amount;
            return balance;
        }

        public double withdraw(double amount){
            if(balance>=amount) {
                balance -= amount;
                return balance;
            }
            else {
                System.out.println("Insufficient funds.");
                return balance;
            }
        }

        public void printStatement(){
            System.out.println("Owner's Name: "+owner);
            System.out.println("Current Balance: "+balance);
        }


    static void main(String[] args) {

    }
}
