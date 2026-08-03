package kenakata.order;

import java.util.List;

public class DeliveryCalculator {
    public static final long DHAKA_BASE=60;
    public static final long DHAKA_PER_KG=20;
    public static final long OUTSIDE_BASE=120;
    public static final long OUTSIDE_PER_KG=35;

    public long deliveryFor(List<Order> lines, Zone zone){
        return (long) 0.00;
    }
}
