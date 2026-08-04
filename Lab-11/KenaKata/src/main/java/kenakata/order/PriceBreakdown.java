package kenakata.order;

public record PriceBreakdown(long subtotal,double discount,double vat,long delivery,double insurance,double serviceFee,long grandTotal) {
}
