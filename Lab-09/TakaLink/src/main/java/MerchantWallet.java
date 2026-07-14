public class MerchantWallet extends Wallet{
    private static  final double DAILY_LIMIT = 0.0;
    public MerchantWallet(String id, double openingBalance, String pin){
        super(id, openingBalance,pin);
    }

    @Override
    protected  double dailyLimit(){
        return DAILY_LIMIT;
    }
    @Override
    boolean canBePayerOf(TransactionKind kind){
        return false;
    }
    @Override
    boolean canBeRecipientOf(TransactionKind kind){
        return kind==TransactionKind.PAYMENT;
    }
}

