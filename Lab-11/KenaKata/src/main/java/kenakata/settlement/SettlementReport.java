package kenakata.settlement;
import kenakata.catalog.Seller;
import java.util.ArrayList;
import java.util.List;

public class SettlementReport {

    public SettlementReport() {
    }

    public SellerPayout forSeller(Seller seller) {
        return new SellerPayout(seller, 0, 0, 0, 0);
    }

    public long platformRevenue() {
        return 0;
    }

    public List<SellerPayout> payouts() {
        return new ArrayList<>();
    }
}
