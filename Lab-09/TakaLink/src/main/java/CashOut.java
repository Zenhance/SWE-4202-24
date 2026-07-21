public class CashOut extends Transaction {

    public CashOut(
            Wallet payer,
            Wallet receiver,
            double amount,
            String offeredPin
    ) {
        super(payer, receiver, amount, offeredPin);
    }

    @Override
    public double fee() {
        return amount() * 0.0185;
    }
}