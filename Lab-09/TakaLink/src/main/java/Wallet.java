public abstract class Wallet {
    private final String id;
    private final String pin;
    private double balance;
    private boolean frozen;
    private double spentToday;

protected Wallet(String id,double openingBalance,String pin) {
    if(id==null||id.isBlank()) {
        throw new IllegalArgumentException("Wallet id cannot be null or blank");
    }
    if(!Double.isFinite(openingBalance)||openingBalance<0.0) {
        throw new IllegalArgumentException("Opening balance must be a non negative finite number");
    }
    if(pin==null){
        throw new IllegalArgumentException("pin must not be null");
    }
    this.id=id;
    this.pin=pin;
    this.balance=openingBalance;
}
public final String id(){
    return id;
}
public final double balance() {
    return balance;
}
public final void debit(double amount) throws InsufficientBalanceException {
    if(amount>balance) {
        throw new InsufficientBalanceException("Wallet " +
                "id " +"has insufficient balance for debit" + amount);
    }
    balance -= amount;
}


}
