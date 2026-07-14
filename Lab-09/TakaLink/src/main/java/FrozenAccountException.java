public class FrozenAccountException extends TransactionException {
    public FrozenAccountException(String id) { super("Account frozen: " + id); }
}