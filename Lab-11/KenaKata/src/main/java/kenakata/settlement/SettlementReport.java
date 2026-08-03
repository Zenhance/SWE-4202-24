package kenakata.settlement;
import kenakata.catalog.Seller;
import java.util.Collection;
import java.util.Map;
public class SettlementReport{
    private final Map<Seller, SellerPayout> payouts;
    private final long platformRevenue;
    public SettlementReport(Map<Seller, SellerPayout> payouts, long platformRevenue){
        this.payouts = payouts;
        this.platformRevenue = platformRevenue;
    }
    public SellerPayout forSeller(Seller seller){
        return payouts.getOrDefault(seller, new SellerPayout(seller));
    }
    public Collection<SellerPayout> payouts(){
        return payouts.values();
    }
    public long platformRevenue(){
        return platformRevenue;
    }
}
