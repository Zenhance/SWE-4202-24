public abstract class Wallet {

    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;


    protected Wallet(String id,double openingBalance,String pin){
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid wallet id");
        }
        if (openingBalance < 0){
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        if (pin == null){
            throw new IllegalArgumentException("PIN cannot be null");
        }

        this.id = id;
        this.balance = openingBalance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0.0;
    }
    public double balance(){
        return balance;
    }
    public void debit(double amount)
        throws InsufficientBalanceException{
            if (amount <= 0) {

                throw new IllegalArgumentException("debit shuld be positive");
            }



        if (amount > balance){
            throw new InsufficientBalanceException(
                    "Insufficient balance"
            );
        }

        balance -= amount;
    }

    public void credit(double amount){

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Credit amount must be positive"
            );
        }

        balance += amount;
    }

    public boolean verifyPin(String offeredPin){
        return pin.equals(offeredPin);
    }

    public boolean isFrozen(){
        return frozen;
    }

    public void freeze(){
        frozen = true;
    }

    public double remainingDailyLimit(){
        return dailyLimit() - spentToday;
    }

    public void recordSpend(double amount){
        spentToday += amount;
    }
    public abstract double dailyLimit();

    public abstract boolean canPerform(String operation);

}



