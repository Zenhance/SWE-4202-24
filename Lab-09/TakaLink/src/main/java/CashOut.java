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

    @Override
    protected boolean payerIsAllowed() {
        return false;
    }

    @Override
    protected String operationName() {
        return "";
    }

    @Override
    protected void moveMoney() throws TransactionException {

    }
}