public class MerchantWallet extends Wallet {
    private double balance;
    private String type;
    private String pin;
    private final double dailySendingLimit = 0.00;

    public MerchantWallet(String type, String pin, double balance) {
        super(type, pin, balance);
    }

    @Override
    public boolean sendMoney() {
        return false;
    }

    @Override
    public boolean receiveMoney() {
        return false;
    }

    @Override
    public boolean cashOut() {
        return false;
    }
}
