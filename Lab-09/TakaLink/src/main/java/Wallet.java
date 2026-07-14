public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String id, double balance, String pin) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Cannot be blank");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be less than zero");
        }
        if (pin == null) {
            throw new IllegalArgumentException("Pin cannot be blank");
        }


        this.id = id;
        this.pin = pin;
        this.balance = balance;
    }

    public double balance() {
        return balance;
    }

    public final void debit(double amount){
        if(amount<0)

    {
        throw new IllegalArgumentException("Debit amount must be positive");
    }
        if(balance-amount<0){
            throw new IllegalArgumentException("account doesnt have enough to be debited");
        }
        balance-=amount;
}
public final void credit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Credited amount must be positive");
        }
        balance+=amount;
}
public final boolean verifyPin(String pin2){
        return pin.equals(pin2);
}
    public final void freeze() {
        frozen = true;
    }

    public final boolean isFrozen() {
        return frozen;
    }

    public final String id() {
        return id;
    }
    public final double remainingToday(){
        return dailyLimit();
    }
    public void recordSpend(double amount){
        spentToday+=amount;
    }
    final void checkDailyLimit(double amount) throws DailyLimitExceededException {
        if(spentToday+amount>dailyLimit()){
            throw new DailyLimitExceededException("Exceeds");
        }

    }
    public abstract double dailyLimit();

    public abstract boolean canSend();

    public abstract boolean canCashOut();

    public abstract double fee();


}
