public class Wallet {
    private final String identity;
    private double balance;
    private final String pin;
    private boolean active;


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
}
