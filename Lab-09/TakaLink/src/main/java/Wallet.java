public abstract class Wallet {
    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;
    protected Wallet(String id, double balance, String pin){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("The Id can't be blank.")
        }
        if(balance <0){
            throw new IllegalArgumentException("The initial deposit can't be negative")
        }
        if(pin==null || pin.isBlank()){
            throw new IllegalArgumentException(("The pin can't be emplty"))
        }
        this.id=id;
        this.balance=balance;
        this.pin=pin;
    }
}