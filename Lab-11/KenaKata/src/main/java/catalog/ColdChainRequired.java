package kenakata.catalog;

/** A line that is perishable and needs refrigerated handling, adding a flat surcharge per line. */
public interface ColdChainRequired {

    /** The flat cold-chain surcharge charged once for this line. */
    long coldChainSurcharge();
}
