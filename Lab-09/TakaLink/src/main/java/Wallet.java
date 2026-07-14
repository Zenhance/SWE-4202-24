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
}
