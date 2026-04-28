public class BankAccount{
    private String name;
    private float balance = 0.00f;

    public float deposit(float amount){
        balance += amount;
        return balance;
    }

    public float withdraw(float amount){
        if(amount <= balance){
            balance -= amount;
            return balance;
        }else{
            System.out.println("Insufficient funds");
            return balance;
        }
    }

    public void printStatement(){
        System.out.println("Owner's Name: "+ name);
        System.out.println("Current Balance: "+ balance);

    }
}
