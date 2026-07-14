public class OperationNotAllowedException extends TransactionException {
    private final String walletId;
    private final TransactionKind kind;
    private final String role;

    public OperationNotAllowedException(String walletId, TransactionKind kind, String role) {
        super("");
        this.walletId = walletId;
        this.kind = kind;
        this.role = role;
    }

    public String getWalletId() { return walletId; }
    public TransactionKind getKind() { return kind; }
    public String getRole() { return role; }
}
