public class DailyLimitExceededException extends TransactionException {
    public DailyLimitExceededException(String walletId,double amountRequested,double remainingLimit){
        super("Wallet "+ walletId+" would exceed its daily limit: requested "+ amountRequested + " but only "+remainingLimit+" is available" );
    }
}
