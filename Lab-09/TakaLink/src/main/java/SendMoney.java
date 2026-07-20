class SendMoney extends Transaction {
    public SendMoney(Wallet from, Wallet to, double amount, String pin) { super(from, to, amount, pin); }

    @Override
    public double fee() { return 5.0; }

    @Override
    protected void validateSpecifics() throws OperationNotAllowedException {

    }
}




