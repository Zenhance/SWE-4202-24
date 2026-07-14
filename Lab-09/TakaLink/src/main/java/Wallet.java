public abstract class Wallet {
    private final String id;
    private final String pin;
    private double balance;
    private boolean frozen;
    private double spentToday;
}
