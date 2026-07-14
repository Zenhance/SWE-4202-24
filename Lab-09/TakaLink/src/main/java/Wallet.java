public abstract class Wallet {
    private String id;
    private double balance;
    private string pin;
    private boolean status;

    public Wallet(String id, double balance, String pin){
        this.id = id;
        this.balance = balance;
        this.pin = pin;
        status = true;
    }


}
