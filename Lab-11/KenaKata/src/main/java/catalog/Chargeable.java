package kenakata.catalog;

/**
 * Anything that can sit on an order as its own priced line -- a catalogue item or an add-on
 * alike -- states its own per-unit charge, per-unit VAT, and a short receipt label. This is the
 * one shared shape that lets {@code Order} hold every kind of line (products and add-ons) under
 * a single type and price them uniformly, without ever asking "what kind are you?".
 */
public interface Chargeable {

    /** The charge for one unit of this line, before VAT. */
    long unitCharge();

    /** The VAT owed on one unit of this line, already rounded up to the next whole Taka. */
    long unitVat();

    /** A short label suitable for a receipt line. */
    String label();
}
