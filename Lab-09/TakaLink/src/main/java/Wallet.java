public abstract class Wallet {
    private String name;
    private double balance;
    private String PIN;
    private boolean frozenStatus;
    private double sentToday;
    public Wallet(String name, double balance, String PIN) {
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("Wallet name cannot be empty");
        }else {
            this.name = name;
        }
        if(balance<0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }else{
            this.balance = balance;
        }
        if(PIN==null || PIN.isEmpty()){
        throw new IllegalArgumentException("PIN cannot be empty");
        }else {
            this.PIN = PIN;
        }
        this.frozenStatus = false;
        this.sentToday = 0;
    }
    public void debit(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Amount cannot be negative");
        } else if (amount>this.balance) {
            return;
        }
        this.balance -= amount;
    }

}
