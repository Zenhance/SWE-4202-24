public class FrozenAccountException extends TransactionException {
    public FrozenAccountException(Wallet fromId) {
        super("Wallet " + fromId.getId() + " is frozen");
    }
}

