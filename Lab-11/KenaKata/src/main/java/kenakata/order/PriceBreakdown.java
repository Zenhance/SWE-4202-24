package kenakata.order;

public class PriceBreakdown {
    int subtotal,discount,insurance,servicefee,vat,delivery;
    PriceBreakdown(int subtotal,int discount,int insurance,int servicefee,int vat,int delivery) {
        this.subtotal=subtotal;
        this.discount=discount;
        this.insurance=insurance;
        this.servicefee=servicefee;
        this.vat=vat;
        this.delivery=delivery;
    }
    public int subtotal() {
        return subtotal;
    }

    public int discount() {
        return discount;
    }

    public int insurance() {
        return insurance;
    }

    public int serviceFee() {
        return servicefee;
    }

    public int grandTotal() {
        return subtotal-discount+delivery+vat+insurance+servicefee;
    }

    public int vat() {
        return vat;
    }

    public int delivery() {
        return delivery;
    }
}
