public abstract class Wallet {

    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;


    protected Wallet(String id,double openingBalance,String pin){
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Invalid wallet id");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        if (pin == null) {
            throw new IllegalArgumentException("PIN cannot be null");
        }

        this.id = id;
        this.balance = openingBalance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0.0;
    }

}
