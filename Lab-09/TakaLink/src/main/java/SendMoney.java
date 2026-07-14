public class SendMoney extends Transaction {

    public SendMoney(
            Wallet payer,
            Wallet receiver,
            double amount,
            String offeredPin
    ) {
        super(payer, receiver, amount, offeredPin);
    }

    @Override
    public double fee() {
        return 5.0;
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