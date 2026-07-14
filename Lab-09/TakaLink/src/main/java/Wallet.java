public abstract class Wallet {
    private final String identity;
    private double balance;
    private final String pin;
    private boolean active;
    private double sendingLimit;
    private double sentToday;


    public Wallet(String identity, double balance, String pin) {
        if(identity == null || identity.length() == 0){
            throw new IllegalArgumentException("identity cannot be null or empty");
        }
        if(balance < 0){
            throw new IllegalArgumentException("balance cannot be negative");
        }
        if(pin == null || pin.length() == 0){
            throw new IllegalArgumentException("pin cannot be null or empty");
        }
        this.identity = identity;
        this.balance = balance;
        this.pin = pin;
    }

    public double balance() {
        return balance;
    }

    private String getPin() {
        return pin;
    }
    public boolean isFrozen(){
        return !active;
    }


    public void debit(double amount) throws InsufficientBalanceException {
        if(amount < 0){
            throw new IllegalArgumentException("debit amount cannot be negative");
        }
        if(amount > balance){
            throw new InsufficientBalanceException( amount, balance);
        }
        balance -= amount;
    }

    public boolean verifyPin(String pin)  {
        if(pin == null || pin.length() == 0){
            throw new IllegalArgumentException("pin cannot be null or empty");
        }
        if(pin.equals(getPin())){
            return true;
        }else{
            return false;
        }
    }

    public void credit(double amount)  {
        if(amount < 0){
            throw new IllegalArgumentException("credit amount cannot be negative");
        }
        balance += amount;
    }

    public double canSend(){
        return sendingLimit - sentToday;
    }

    public void freeze(){
        active = false;
    }


}
