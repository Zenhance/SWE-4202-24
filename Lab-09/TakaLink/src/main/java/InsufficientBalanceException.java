public class InsufficientBalanceException extends TransactionException{
    public InsufficientBalanceException(String walletId,double amountRequested,double balanceAvailable){
        super("Wallet "+ walletId+" has insufficient balance: requested "+ amountRequested+ " but only "+balanceAvailable+" is available");
    }

}
