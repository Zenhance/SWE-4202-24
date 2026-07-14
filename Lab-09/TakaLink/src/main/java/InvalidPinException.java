public class InvalidPinException extends TransactionException {
    private final String walletId;

    public InvalidPinException(String walletId) {
        super("");
        this.walletId = walletId;
    }

    public String getWalletId() {
        return walletId;
    }
}
