package kenakata.settlement;
import java.util.Collections;
import java.util.List;
import kenakata.catalog.Seller;

public final class SettlementReport {
    private final List<SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport(List<SellerPayout> payouts, long platformRevenue){
        if(payouts == null){
            throw new IllegalArgumentException("Payout list must not be null");
        }
        this.payouts = List.copyOf(payouts);
        this.platformRevenue = platformRevenue;
    }
public List<SellerPayout> payouts(){
        return Collections.unmodifiableList(payouts);
}

}
