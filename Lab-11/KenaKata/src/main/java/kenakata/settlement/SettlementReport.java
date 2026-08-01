package kenakata.settlement;

import kenakata.catalog.Seller;
import java.util.Collections;
import java.util.Map;

public class SettlementReport {
    private final Map<Seller,SellerPayout> payoutsBySeller;
    private final int platformRevenue;

    SettlementReport(Map<Seller,SellerPayout>payoutsBySeller,int platformRevenue){
        this.payoutsBySeller=payoutsBySeller;
        this.platformRevenue=platformRevenue;
    }

    public SellerPayout forSeller(Seller seller){
        SellerPayout payout=payoutsBySeller.get(seller);
        if(payout==null){
            throw new IllegalArgumentException("No payout recorded for seller " + seller);
        }
        return payout;
    }

    public int platformRevenue(){
        return platformRevenue;
    }
}
