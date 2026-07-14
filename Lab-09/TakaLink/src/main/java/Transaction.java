// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public abstract class Transaction
{
    public double amount;
    public String fromId;
    public String toId;
    public String pin;

    public Transaction(String fromId, String toId, double amount, String pin)
    {
        if(fromId==null || fromId.isBlank())
            throw new IllegalArgumentException("Id can not be null");
        if(toId==null || toId.isBlank())
            throw new IllegalArgumentException("Id can not be null");
        if(amount<=0)
            throw new IllegalArgumentException("Amount has to be positive");
        if(pin==null || pin.isBlank())
            throw new IllegalArgumentException("Pin can not be null");
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.pin = pin;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getFromId()
    {
        return fromId;
    }

    public String getToId()
    {
        return toId;
    }

    public String getPin()
    {
        return pin;
    }

    public abstract double fee();

    public void settle()
    {

    }
}
