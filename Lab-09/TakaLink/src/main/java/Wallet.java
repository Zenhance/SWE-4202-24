public abstract class Wallet {

    private final String id;
    private double balance;
    private final String pin;
    private boolean frozen;
    private double spentToday;

    protected Wallet(
            String id,
            double openingBalance,
            String pin
    ) {
        if (id == null  || id.isBlank()) {
            throw new IllegalArgumentException(
                    "Wallet ID can't be null or blank"
            );
        }

        if (openingBalance < 0.0) {
            throw new IllegalArgumentException(
                    "Opening balance can't be negative"
            );
        }

        if (pin == null) {
            throw new IllegalArgumentException(
                    "PIN can't be null"
            );
        }

        this.id = id;
        this.balance = openingBalance;
        this.pin = pin;
        this.frozen = false;
        this.spentToday = 0.0;
    }

    public final String id() {
        return id;
    }

    public final double balance() {
        return balance;
    }

    public final void debit(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0.0) {
            throw new IllegalArgumentException(
                    "Debit amount must be positive"
            );
        }

        if (balance < amount) {
            throw new InsufficientBalanceException(
                    "Insufficient balance in wallet " + id
            );
        }

        balance -= amount;
    }

    public final void credit(double amount) {

        if (amount <= 0.0) {
            throw new IllegalArgumentException(
                    "Credit amount must be positive"
            );
        }

        balance += amount;
    }

}

