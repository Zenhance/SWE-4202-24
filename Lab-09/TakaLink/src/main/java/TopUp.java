public class TopUp extends Transaction {
    public TopUp(Wallet fromId, Wallet toId, double amount, String pin) {
        super(TransactionType.PAYMENT, amount, fromId, toId, pin);
    }
    @Override
    public double fee(){
        return 0;
    }
    @Override
    protected void validateSpecific()
            throws OperationNotAllowedException {

    }
    @Override
    protected void moveMoney()
            throws TransactionException {

        fromId().debit(amount());

        toId().credit(amount());
    }
    }

