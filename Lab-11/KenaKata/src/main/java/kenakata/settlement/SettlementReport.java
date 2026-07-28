package kenakata.settlement;
import java.util.ArrayList;
import java.util.List;
public class SettlementReport {
    private final List<SellerPayout> payouts;
    private final long plateformRevenue;
    public SettlementReport(List<SellerPayout> payouts,long platformRevenue){
        this.payouts=payouts;
        this.platformRevenue=platformRevenue;
    }
    public SellerPayout forSeller(Seller seller){
        for(SellerPayout payout:payouts){
        }
    }
}
