public class Wallet {
    private String id;
    private double balance;
    private String pin;
    private double spentToday;
    private String frozen;

    public Wallet(String id, double balance, String pin) {
        if(id==null) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        if(balance<0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if(pin==null) {
            throw new IllegalArgumentException("PIN cannot be empty");
        }
    }
}
