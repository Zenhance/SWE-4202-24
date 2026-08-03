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
        this.grandtotal = subtotal-discount+delivery+vat+insurance+serviceFee;
    }

    public long subtotal() {

        return subtotal;
    }

    public long discount() {
        return discount;
    }


    public long insurance() {
        return insurance;
    }

    public long vat() {
        return vat;
    }

    public long delivery(){
        return delivery;
    }

    public long serviceFee(){return serviceFee;
    }

    public long  grandTotal(){
        return grandtotal;
    }


}







