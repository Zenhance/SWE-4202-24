package kenakata.settlement;
import java.util.ArrayList;
import java.util.List;


public class SettlementReport {
    private final List<SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport() {
        this.payouts = new ArrayList<>();
        this.platformRevenue = 0;
    }


    public List<SellerPayout> getPayouts() {
        return payouts;
    }

    public long platformRevenue() {
        return platformRevenue;
    }

}
