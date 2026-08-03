package kenakata.order;

public record PriceBreakdown(
    long subtotal,
    long discount,
    long delivery,
    long vat,
    long insurance,
    long serviceFee,
    long grandTotal
){}

