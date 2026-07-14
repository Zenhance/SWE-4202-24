public abstract class Transaction {

    private final Wallet payer;
    private final Wallet receiver;
    private final double amount;
    private final String offeredPin;

    protected Transaction(Wallet payer, Wallet receiver, double amount, String offeredPin
    ) {
        if (payer == null || receiver == null) {
            throw new IllegalArgumentException("Wallet cannot be null");
        }

        if (amount < 0.0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        if (offeredPin == null) {
            throw new IllegalArgumentException("PIN cannot be null");
        }

        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
        this.offeredPin = offeredPin;
    }

    public final Wallet payer() {
        return payer;
    }

    public final Wallet receiver() {
        return receiver;
    }

    public final double amount() {
        return amount;
    }

    public abstract double fee();

    protected abstract boolean payerIsAllowed();

    protected abstract String operationName();

    protected void validateParties()
            throws OperationNotAllowedException {}

    protected abstract void moveMoney()
            throws TransactionException;

    public final void settle()
            throws TransactionException {

        if (!payer.verifyPin(offeredPin)) {
            throw new InvalidPinException("Invalid PIN for wallet " + payer.id());
        }
        if (payer.isFrozen()) {
            throw new FrozenAccountException("Wallet " + payer.id() + " is frozen");
        }
        validateParties();

        if (amount > payer.remainingDailyLimit()) {
            throw new DailyLimitExceededException("Daily limit exceeded for wallet " + payer.id());
        }

        double requiredBalance = amount + fee();

        if (payer.balance() < requiredBalance) {
            throw new InsufficientBalanceException("Wallet " + payer.id() + " requires " + requiredBalance + " but has " + payer.balance());
        }
        moveMoney();

        payer.recordSpend(amount);
    }

    protected final void debitPayer(double value)
            throws InsufficientBalanceException {

        payer.debit(value);
    }

    protected final void creditReceiver(double value) {
        receiver.credit(value);
    }
}