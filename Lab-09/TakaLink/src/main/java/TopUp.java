class TopUp extends Transaction {
    public TopUp(Wallet from, Wallet to, double amount, String pin) { super(from, to, amount, pin); }

    @Override
    public double fee() { return 0.0; }
    @Override
    protected void validateSpecifics() throws OperationNotAllowedException {

    }
}