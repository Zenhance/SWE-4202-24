package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.exceptions.ReturnNotAllowedException;

public class SellerPayout {
    private Seller seller;
    private long sales;
    private long payout;
    private long commission;
    private long refund;

    public long grossSales() {
        return sales;
    }

    public Seller seller() {
        return this.seller;
    }

    public long refund() {
        return refund;
    }

    public long commission() {
        return commission;
    }

    public long payout() {
        return payout;
    }

    public long sales() {
        return sales;
    }

    public long refunds() {
        return refund;
    }

}
