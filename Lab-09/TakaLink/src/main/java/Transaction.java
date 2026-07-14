// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {

    private final Wallet pay;
    private final Wallet recieve;
    private final double amount;
    private final String pin;

    public Transaction(Wallet pay, Wallet recieve, double amount, String pin) {
        if(pay==null){
            throw new IllegalArgumentException("Invalid");
        }
        if(recieve==null){
            throw new IllegalArgumentException("Invalid");
        }
        if(amount<0.0){
            throw new IllegalArgumentException("Invalid");
        }
        if(pin==null || pin.isBlank())
            throw new IllegalArgumentException("Invalid");

        this.pay = pay;
        this.recieve = recieve;
        this.amount = amount;
        this.pin = pin;
    }
    public abstract double fee();
    public double debitAmoubt(){
        return amount+fee();
    }
    protected void validateOperation() throws OperationNotAllowedException{}
    protected void validateLimit() throws DailyLimitExceededException{}
    protected void onsettled(){}

    public final void settle()throws TransactionException{
        validateOperation();
        if(pay.isFrozen()){
            throw new FrozenAccountException("Frozen");
        }
        if(!pay.verifyPin(pin)){
            throw new InvalidPinException("invalid");
        }
        validateLimit();
        double debit = debitAmount();
        if(debit> pay.getBalance()){
            throw new InsufficientBalanceException("Insuffiecient");
        }


    }

    protected abstract double debitAmount();


}
