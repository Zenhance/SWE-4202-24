package kenakata.order;
import java.util.List;


public final class PriceBreakdown {

    private final long subtotal;
    private final long discount;
    private final long delivery;
    private final long vat;
    private final long insurance;
    private final long serviceFee;
    private final long grandTotal;
    private final List<OrderLine> lines;

    PriceBreakdown(long subtotal, long discount, long delivery, long vat, long insurance,
                   long serviceFee, long grandTotal, List<OrderLine> lines) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.delivery = delivery;
        this.vat = vat;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
        this.grandTotal = grandTotal;
        this.lines = lines;
    }

}
