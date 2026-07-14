public abstract class Wallet {
    private String id;
    private int balance;
    private int pin;
    private boolean status;

    public Wallet(String id, int balance, int pin){
        this.id = id;
        this.balance = balance;
        this.pin = pin;
        status = true;
    }


}
