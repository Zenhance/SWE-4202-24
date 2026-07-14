public abstract class Wallet {
    private String id;
    private String pin;
    private double balance;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id,double balance, String pin){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(balance<0){
            throw new IllegalArgumentException("Balance must be positive");
        }
        if(pin==null || pin.isBlank()){
            throw new IllegalArgumentException("Pin cannot be null");
        }
        this.id=id;
        this.balance=balance;
        this.pin=pin;
    }


}
