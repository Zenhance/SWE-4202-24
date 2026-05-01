public class BankAccount {
    private String name;
    private int balance;

    public BankAccount(String name){
        this.balance=0;
        this.name=name;

    }

    public void withdraw(int amount){
        if(this.balance-amount<=0){
            System.out.println("Insufficient");
        }
        else{
            balance=balance-amount;
        }

    }
    public void deposit(int amount){
        if(amount<=0){
            System.out.println("Error");
        }
        else{
            balance=balance+amount;
        }
    }
    public void printing(){
        System.out.println(this.name+" "+this.balance);
    }
}

   
