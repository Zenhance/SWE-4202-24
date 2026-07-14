public abstract class Wallet {
    private final String id;
    private final String pin;
    private double balance;
    private boolean frozen;
    private double spentToday;

    protected Wallet(String id, double openingBalance, String pin){
        if(id==null||id.isBlank()){
            throw new IllegalArgumentException("Wallet id must not be null or blank");
        }
        if(!Double.isFinite(openingBalance)||openingBalance<0.0){
            throw new IllegalArgumentException("Opening balance must be non-negative");
        }
        if(pin==null){
            throw new IllegalArgumentException("PIN must not be null");
        }
        this.id = id;
        this.balance = openingBalance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0.0;
    }
    public final String getId(){
        return id;
    }
    public final double getBalance(){
        return balance;
    }
    public final void debit(double amount){
        throws InsufficientBalanceException{
            requirePositiveAmount(amount);
            if(amount>balance){
                throw new InsufficientBalanceException("Insufficient balance in wallet"+id);
            }
            balance-=amount;
        }
    }
    public final void credit(double amount){
        requirePositiveAmount(amount);
        balance+=amount;
    }
    public final boolean verifyPin(String offeredPin){
        return pin.equals(offeredPin);
    }
    public final boolean isFrozen(){
        return frozen;
    }
    public final void freeze(){
        frozen = true;
    }
    public final double remainingDailyLimit(){
        return Math.max(0.0,dailyLimit()-spentToday);
    }
    final void recordSent(double amount){
        requirePositiveAmount(amount);
        spentToday+=amount;
    }
    public abstract double dailyLimit();
    public abstract boolean allows(Operation operation);
    private static void requirePositiveAmount(double amount){
        if(!Double.isFinite(amount)||amount<=0.0){
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
}
