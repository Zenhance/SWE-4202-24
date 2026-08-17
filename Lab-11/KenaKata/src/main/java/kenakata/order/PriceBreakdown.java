package kenakata.order;

public class PriceBreakdown {
    long subtotal, discount, vat, delivery, insurance, serviceFee;
    PriceBreakdown(long subtotal, long discount, long vat, long delivery, long insurance, long serviceFee) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.vat = vat;
        this.delivery = delivery;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
    }
    public long subtotal() {
        return subtotal;
    }

    public long discount() {
        return discount;
    }

    public long vat() {
        return vat;
    }

    public long delivery() {
        return delivery;
    }

    public long insurance() {
        if(insurance < 20 && insurance != 0){
           this.insurance = 20;
        }
        return insurance;
    }

    public long serviceFee() {
        if(serviceFee >= 100){
            this.serviceFee = 100;
        }
        return serviceFee;
    }

    public long grandTotal() {
        return subtotal - discount + vat + delivery + insurance + serviceFee;
    }
}
