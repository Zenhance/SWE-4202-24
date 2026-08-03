package kenakata.settlement;

import kenakata.catalog.Addable;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.PriceBreakdown;

import java.util.ArrayList;

public class SettlementReport {

    //public ArrayList<Integer> count = new ArrayList<>();
    public ArrayList<Seller> sellers = new ArrayList<>();
    public ArrayList<Order> orders = new ArrayList<>();

    //public ArrayList<Chargeable> items = new ArrayList<>();
    //ArrayList<SellerPayout> payouts = new ArrayList<>();
    //public SellerPayout[] payouts() {


    public Order order;
    public long grand;

    public int platformRevenue() {
        int total = 0;
        for(int i=0; i< orders.size(); i++) {
            Order o = orders.get(i);
            for(int j=0; j<o.items.size(); j++){
                Chargeable c = orders.get(i).items.get(j);
                if(c instanceof CatalogItem){
                    CatalogItem c2 = (CatalogItem) c;
                        int commission = c2.commissionOn(c2.unitCharge())*o.count.get(j);
                        total += commission;
                }
                if(c instanceof Addable){
                    total += c.unitCharge();
                }
            }
            PriceBreakdown p = o.getPb();
            total += p.delivery() + p.vat() + p.serviceFee() - p.discount();
        }
        return total;
    }

    public SellerPayout forSeller(Seller a) {
        SellerPayout sp = new SellerPayout();
        sp.s = a;

        for(int i=0; i< orders.size(); i++) {
            for(int j=0; j<orders.get(i).items.size(); j++){
                Chargeable c = orders.get(i).items.get(j);
                if(c instanceof CatalogItem){
                    CatalogItem c2 = (CatalogItem) c;
                    if(c2.getS() == a){
                        sp.items.add(c2);
                        sp.count.add(orders.get(i).count.get(j));
                    }
                }
            }
        }

        return sp;
    }

    public long grandTotal() {
        return grand;
    }
}
