package kenakata.settlement;
import kenakata.catalog.Seller;
import java.util.ArrayList;
import java.util.List;


public class SettlementReport {
    private final List<SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport() {
        this.payouts = new ArrayList<>();
        this.platformRevenue = 0;
    }


    public List<SellerPayout> payouts() {
        return payouts;
    }

    public long platformRevenue() {
        return platformRevenue;
    }


    public SellerPayout forSeller(Seller seller){
        for(SellerPayout payout : payouts){
            if(payout.seller().equals(seller)){
                return payout;
            }
        }
        return new SellerPayout(seller, 0, 0, 0);
    }

}
