public abstract class Transaction {
    // "SEND", "CASHOUT", "PAYMENT", "TOPUP"
    public double amount;
    public Wallet from;
    public Wallet to;
    public String pin;

    public Transaction(Wallet from, Wallet to, double amount, String pin) {
        if(from == null || to == null || pin == null || pin.isEmpty()|| amount <=0)
            throw new IllegalArgumentException();

        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;
    }

    public Wallet payer(){
        return from;
    }
    public Wallet recipient(){
        return to;
    }
    public double getAmount(){
        return amount;
    }

    public abstract double fee();
    public abstract Operation operation();

    public void settle() throws TransactionException {
        double transactionFee = fee();
        double totalAmount = amount + transactionFee;

        if(from.isFrozen()) throw new FrozenAccountException("Account is frozen");
        if(from.verifyPin(pin)) throw new InvalidPinException("Invalid pin");
        if(to.isFrozen()) throw new FrozenAccountException("Account is frozen");

        if(from.remainingDailyLimit()==0) throw new DailyLimitExceededException("Daily limit exceeded.");
        if(totalAmount <= 0 || from.balance() < totalAmount) throw new InsufficientBalanceException("Insufficient balance.");

        if(!from.allowedOperations(operation())) throw new OperationNotAllowedException("Operation not allowed");

        from.debit(totalAmount);
        to.credit(amount);
        from.setSpentToday(amount);
    }
}
