package kenakata.delivery;
import java.util.List;
import kenakata.line.OrderLine;
import kenakata.line.ProductLine;

public class DeliverCalculator {
    public static final int INSIDE_DHAKA_FEE = 60;
    public static final int OUTSIDE_DHAKA_FEE = 120;

    public DeliverCalculator() {
    }

    public long calculate(List<OrderLine> lines, DeliveryZone zone) {
        long total = 0;
        for (OrderLine line : lines) {
            if (line instanceof ProductLine) {
                ProductLine product = (ProductLine) line;
                if (zone == DeliveryZone.INSIDE_DHAKA) {
                    total += product.getQuantity() * INSIDE_DHAKA_FEE;
                } else {
                    total += product.getQuantity() * OUTSIDE_DHAKA_FEE;
                }
            }
        }
        return total;
    }
}