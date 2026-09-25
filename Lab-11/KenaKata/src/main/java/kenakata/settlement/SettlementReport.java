package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.Collections;
import java.util.List;

public class SettlementReport {
    public List<SellerPayout>payouts(){
        return Collections.emptyList();
    }
    public long platformRevenue(){
        return 0;
    }
    public SellerPayout forSeller(Seller seller){
        return null;
    }
}
