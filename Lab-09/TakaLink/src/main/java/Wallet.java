public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet (String id, double balance, String pin){
        if(balance<0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }
        if(pin==null || pin.isBlank()){
            throw new IllegalArgumentException("Invalid pin");
        }

        this.id=id;
        this.balance=balance;
        this.pin=pin;
        this.frozen=false;
        this.spentToday=0;

    }

    public String getId() {
        return id;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public double getSpentToday() {
        return spentToday;
    }

    public double balance(){
        return balance;
    }

    public boolean verifyPin(String offeredPin){
        return pin.equals(offeredPin);
    }

    public void freeze(){
        frozen=true;
    }

    public double credit(double amount){
       if(amount<=0){
           throw  new IllegalArgumentException("Credit must be positive");
       }
       return  balance+=amount;
    }

    public void debit(double amount) throws InsufficientBalanceException{
        if(amount<=0){
            throw new IllegalArgumentException("Debit amount must be positive");
        }
        if(balance<amount){
            throw new InsufficientBalanceException();
        }
        balance-=amount;
    }

    protected void addSpentToday(double amount){
        spentToday+=amount;
    }// only coming from the transaction class and transaction class is abstract

    public double remainingLimit(){
        return  dailyLimit()-spentToday;
    }

    public abstract double dailyLimit();


}
