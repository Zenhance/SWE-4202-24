public class CashOut extends Transaction {
    public CashOut(Transaction fromId, Transaction toId, double amount, String pin) {
        super(fromId.toString(), toId.toString(), amount, pin);
    }

    @Override
    public double fee() {
        return amount * 0.0185;
    }

}
