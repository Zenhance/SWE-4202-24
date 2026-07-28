package kenakata.order;

public class PriceBreakdown {
    private long subtotal;
    private long discount;
    private long delivery;
    private long insurance;
    private long serviceFee;
    private long tax;
    private long grandTotal;

    public PriceBreakdown(long subtotal,long discount,long delivery,long insurance,long serviceFee,long grandTotal,long tax){
        this.subtotal=subtotal;
        this.discount=discount;
        this.delivery=delivery;
        this.insurance=insurance;
        this.serviceFee=serviceFee;
        this.grandTotal=grandTotal;
        this.tax=tax;
    }

    public long getSubtotal(){
        return subtotal;
    }

    public long getDelivery() {
        return delivery;
    }

    public long getDiscount() {
        return discount;
    }

    public long getInsurance() {
        return insurance;
    }

    public long getServiceFee() {
        return serviceFee;
    }

    public long getGrandTotal() {
        return grandTotal;
    }

    public long getTax() {
        return tax;
    }

    @Override
    public String toString(){
        return "SubTotal: "+subtotal+"\nDiscount "+discount+"\delivery "+delivery+"\nTax "+tax+"\nInsurance "+insurance+"Service Fee "+serviceFee+"GrandTotal "+grandTotal;
    }
}

