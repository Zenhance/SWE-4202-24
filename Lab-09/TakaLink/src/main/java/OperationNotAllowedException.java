public class OperationNotAllowedException extends TransactionException{

    public OperationNotAllowedException(String walletId,String operation){
        super("Operation not ALlowed");
    }
}
