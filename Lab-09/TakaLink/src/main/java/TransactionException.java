public abstract class TransactionException extends Exception{
    public TransactionException (){
        super();
    }
}
class InsufficientBalanceException extends TransactionException {}
class DailyLimitExceededException extends TransactionException {}
class InvalidPinException extends TransactionException {}
class FrozenAccountException extends TransactionException {}
class OperationNotAllowedException extends TransactionException {}
