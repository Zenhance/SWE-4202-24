public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double balance,String pin){
        if(id==null || id.isBlank()){
            throw new IllegalArgumentException("Invalid ID");
        }
        if(pin==null){
            throw new IllegalArgumentException("PIN cannot be null");
        }
        if(balance<0){
            throw new IllegalArgumentException("Negative balance");
        }
        this.id=id;
        this.balance = balance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0;
    }
}
