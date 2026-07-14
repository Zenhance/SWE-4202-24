public class InvalidPinException extends TransactionException {
    public InvalidPinException(String walletId){
        super("Wrong pin entered for wallet "+ walletId);
    }
}
