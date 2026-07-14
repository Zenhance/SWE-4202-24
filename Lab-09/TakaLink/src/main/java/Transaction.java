public abstract class Transaction {
    protected final Wallet from;
    protected final Wallet to;
    protected final double amount;
    protected final String offeredPin;

    protected Transaction(Wallet from, Wallet to, double amount, String offeredPin) {
        if (from == null || to == null) throw new IllegalArgumentException("Wallets must not be null");
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (offeredPin == null) throw new IllegalArgumentException("PIN must not be null");
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.offeredPin = offeredPin;
    }

    public abstract double fee();

    public final void settle() throws TransactionException {
        if (!from.verifyPin(offeredPin)) throw new InvalidPinException(from.id());

        if (from.isFrozen()) throw new FrozenAccountException(from.id());

        if (!operationAllowed()) throw new OperationNotAllowedException(from.id());

        if (!from.canSpendAmount(amount)) throw new DailyLimitExceededException(from.id());

        double totalDebit = amount + fee();
        if (from.balance() - totalDebit < 0) throw new InsufficientBalanceException(from.id());

        performTransfer(totalDebit);
    }

    protected abstract boolean operationAllowed();

    protected abstract void performTransfer(double totalDebit) throws TransactionException;
}

