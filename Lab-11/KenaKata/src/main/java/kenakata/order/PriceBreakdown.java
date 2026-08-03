package kenakata.order;

public class PriceBreakdown {

    private long subtotal;
    private long discount;
    private long grandtotal;
    private long delivery;
    private long vat;
    private long serviceFee;
    private long insurance;

    public PriceBreakdown(long subtotal, long discount, long vat, long delivery, long insurance, long serviceFee, long grandTotal) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.vat = vat;
        this.delivery = delivery;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
        this.grandtotal = grandTotal;
    }

    public int subtotal() {

        return 0;
    }

    public long discount() {
        return 0;
    }


    public long insurance() {
        return 0;
    }

    public long vat() {
        return 0;
    }

    public long delivery(){
        return 0;
    }

    public long serviceFee(){
        return 0;
    }

    public long  grandTotal(){
        return 0;
    }


}







