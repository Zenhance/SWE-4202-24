package kenakata.order;

public class PriceBreakdown {
    private final long subtotal;
    private final long discount;
    private final long vat;
    private final long delivery;
    private final long insurance;
    private final long serviceFee;
    private final long grandTotal;

    public PriceBreakdown(long subtotal,long discount, long vat,long delivery,long insurance,long serviceFee,long grandTotal){
        if(subtotal<0){
            throw new IllegalArgumentException("Subtotal cannot be negative");
        }
        if(discount<0){
            throw new IllegalArgumentException("Discount cannot be negative");
        }
        if(vat<0){
            throw new IllegalArgumentException("Vat cannot be negative");
        }
        if(delivery<0){
            throw new IllegalArgumentException("Delivery charge cannot be negative");
        }
        if(insurance<0){
            throw new IllegalArgumentException("Insurance fee cannot be negative");
        }
        if(serviceFee<0){
            throw new IllegalArgumentException("Service fee cannot be negative");
        }
        if(grandTotal<0){
            throw new IllegalArgumentException("Grand total cannot be negative");
        }
        this.subtotal=subtotal;
        this.discount=discount;
        this.vat=vat;
        this.delivery=delivery;
        this.insurance=insurance;
        this.serviceFee=serviceFee;
        this.grandTotal=grandTotal;
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
        return insurance;
    }

    public long serviceFee() {
        return serviceFee;
    }

    public long grandTotal() {
        return grandTotal;
    }
}
