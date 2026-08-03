package kenakata.payment;
import kenakata.exceptions.EmptyWalletException;
public final class Wallet {

    private long balance;

    public Wallet(long openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                    "Opening balance cannot be negative"
            );
        }

        this.balance = openingBalance;
    }

    public long balance() {
        return balance;
    }

    public void debit(long amount)
            throws EmptyWalletException {

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Debit amount cannot be negative"
            );
        }

        if (amount > balance) {
            throw new EmptyWalletException(
                    "Wallet balance Tk " + balance
                            + " is below required Tk " + amount
            );
        }

        balance -= amount;
    }

    public void credit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Credit amount must be positive"
            );
        }

        balance = Math.addExact(balance, amount);
    }
}