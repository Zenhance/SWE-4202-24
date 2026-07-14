public class FrozenAccountException extends TransactionException {
    private final String walletId;

    public FrozenAccountException(String walletId) {
        super("");
        this.walletId = walletId;
    }

    public String getWalletId() { return walletId; }
}
