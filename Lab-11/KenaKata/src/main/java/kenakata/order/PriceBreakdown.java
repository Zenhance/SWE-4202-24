package kenakata.order;



public record PriceBreakdown(long subtotal, long discount, long delivery, long vat, long insurance, long serviceFee, long grandTotal
) {
}


















/*public class PriceBreakdown {
    public final long subtotal;
    public final long discount;
    public final long vat;
    public final long delivery;
    public final long insurance;
    public final long serviceFee;

    public PriceBreakdown(long subtotal, long discount, long vat, long delivery, long insurance, long serviceFee) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.vat = vat;
        this.delivery = delivery;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
    }

    public long Subtotal() {
        return subtotal;
    }

    public long Discount() {
        return discount;
    }

    public long Delivery() {
        return delivery;
    }

    public long Vat() {
        return vat;
    }

    public long Insurance() {
        return insurance;
    }

    public long ServiceFee() {
        return serviceFee;
    }
}*/

