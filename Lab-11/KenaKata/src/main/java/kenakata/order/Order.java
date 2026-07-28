package kenakata.order;

public class Order {
    private Zone zone;
    private DeliveryCalculator calculator;

    public Order(Zone zone, DeliveryCalculator calculator) {
        this.zone = zone;
        this.calculator = calculator;
    }
}
