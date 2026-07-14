public abstract class Transaction {

    private final Wallet payer;
    private final Wallet receiver;
    private final double amount;
    private final String enteredPin;

    public Transaction(Wallet payer, Wallet receiver, double amount, String enteredPin){

        if (payer == null) {
            throw new IllegalArgumentException(
                    "Payer wallet cannot be null.");}

        if (receiver == null) {
            throw new IllegalArgumentException(
                    "Receiver wallet cannot be null.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Transaction amount must be positive.");
        }

        if (enteredPin == null) {
            throw new IllegalArgumentException(
                    "Entered PIN cannot be null.");
        }
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
        this.enteredPin = enteredPin;
    }

    protected Wallet payer() {
        return payer;
    }

    protected Wallet receiver() {
        return receiver;
    }

    public double amount() {
        return amount;
    }

    public abstract double fee();

    protected abstract void checkOperation()
            throws OperationNotAllowedException;

    protected void checkExtraRule()
            throws OperationNotAllowedException {}
    protected abstract void moveMoney()
            throws TransactionException;
    public final void settle()
            throws TransactionException {
        if (!payer.verifyPin(enteredPin)) {
            throw new InvalidPinException(
                    "The entered PIN is incorrect.");
        }
        if (payer.isFrozen()) {
            throw new FrozenAccountException(
                    "The payer wallet is frozen.");
        }
        checkOperation();
        checkExtraRule();
        if (amount > payer.remainingLimit()) {
            throw new DailyLimitExceededException(
                    "The daily sending limit has been exceeded.");
        }
        double totalNeeded = amount + fee();

        if (payer.balance() < totalNeeded) {
            throw new InsufficientBalanceException(
                    "The payer does not have enough balance.");
        }
        moveMoney();
        payer.addSpent(amount);
    }
}