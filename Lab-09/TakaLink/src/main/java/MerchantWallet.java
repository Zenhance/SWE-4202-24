public final class MerchantWallet extends Wallet {
    private static final double DAILY_LIMIT=25000.00;
    public MerchantWallet(String id,double openingBalance,String pin) {
        super(id,openingBalance,pin);
    }

    @override
    public double dailyLimit() {
        return DAILY_LIMIT;
    }

    @override
    public boolean allows(Operation operation) {
        return operation == Operation.PAYMENT || operation == Operation.TOP_UP;
    }

}