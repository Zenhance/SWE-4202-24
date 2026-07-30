package kenakata.order;

public record PriceBreakdown(int subtotal,int discount,int delivery,int vat,int insurance,int serviceFee,int grandTotal) {

}
