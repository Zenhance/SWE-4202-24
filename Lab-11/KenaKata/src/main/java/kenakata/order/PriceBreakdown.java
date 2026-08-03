package kenakata.order;

public record PriceBreakdown(
    long subtotal,
    long discount,
    long vat,
    long delivery,
    long insurance,
    long serviceFee,
    long grandTotal
){}
