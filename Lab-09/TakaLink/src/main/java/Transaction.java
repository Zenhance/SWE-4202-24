public abstract class Transaction {
    private final Wallet payer;
    private final Wallet receiver;
    private final double amount;
    private final String enteredPin;

    public Transaction(Wallet payer,Wallet receiver,double amount,String enteredPin){
        if (payer == null) {
            throw new IllegalArgumentException(
                    "Payer wallet cannot be null.");
        }
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
    }
}
