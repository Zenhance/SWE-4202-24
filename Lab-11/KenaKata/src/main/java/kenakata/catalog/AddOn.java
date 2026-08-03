package kenakata.catalog;

public abstract class AddOn implements Chargable{
    protected long charge;
    protected long VAT;
    protected String receiptLabel;

    abstract long getCharge();
    abstract long getVAT();
    abstract String getReceiptLabel();
}
