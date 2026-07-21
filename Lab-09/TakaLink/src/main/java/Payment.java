public class Payment extends Transaction {

    public Payment(
            Wallet payer,
            Wallet receiver,
            double amount,
            String offeredPin
    ) {
        super(payer, receiver, amount, offeredPin);
    }

    @Override
    public double fee() {
        return 0.0;
    }
}