// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */

public abstract class Transaction{
    private Wallet payerWallet;
    private Wallet receiverWallet;
    private double amount;
    private String pin;

    public Transaction(Wallet payerWallet, Wallet receiverWallet, double amount, String pin){
         if(payerWallet==null ){
             throw new IllegalArgumentException("Payer wallet cannot be blank");
         }
         if(receiverWallet==null  ){
             throw new IllegalArgumentException("Receiver wallet cannot be blank");
         }
         if(pin==null || pin.isBlank()){
             throw new IllegalArgumentException("Invalid pin");
         }
         if(amount<=0){
             throw new IllegalArgumentException("Amount cannot be negative");
         }

         this.payerWallet=payerWallet;
         this.receiverWallet=receiverWallet;
         this.amount=amount;
         this.pin=pin;

    }

    public Wallet getPayerWallet() {
        return payerWallet;
    }

    public Wallet getReceiverWallet() {
        return receiverWallet;
    }

    public double getAmount() {
        return amount;
    }

    public String getPin(){
        return pin;
    }

    protected abstract double fee();
    protected abstract void movement()
        throws TransactionException;



    public abstract void settle() throws TransactionException;


}