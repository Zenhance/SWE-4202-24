// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction {
  private final Wallet payer;
  private final Wallet receiver;
  private final double amount;
  private final String offeredPin;

    protected Transaction(Wallet payer,Wallet receiver,double amount,String offeredPin) {
    if(payer == null || receiver == null){
        throw new IllegalArgumentException("Wallet references must not be null");
    }
    if(!Double.isFinite(amount)||amount<=0.0){
        throw new IllegalArgumentException("Transaction must be positive");
    }
    if(offeredPin == null){
        throw new IllegalArgumentException("Offered PIN must not be null")''
    }
    this.payer = payer;
    this.receiver = receiver;
    this.amount = amount;
    this.offeredPin = offeredPin;
    }
}
