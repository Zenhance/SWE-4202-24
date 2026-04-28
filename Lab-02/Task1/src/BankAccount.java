public class BankAccount {
    private String name;
    private float balance;

    public float deposit(float amount){
        balance += amount;
        return balance;
    }

    public float withdraw(float amount){
        if(amount <= balance){
            balance -= amount;
            return balance;
        }else{
            System.out.println("You don't have enough balance!");
        }
    }

    public float printStatement(){
        System.out.println(name);
    }
}
