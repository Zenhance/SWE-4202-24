package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.util.ArrayList;

public class Marketplace {

    ArrayList<Seller> sellers = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    public void register(Seller s){
        sellers.add(s);
    }

    public void record(Order o){
        orders.add(o);
    }

    public SettlementReport settle() {
        SettlementReport report = new SettlementReport();
        report.sellers = this.sellers;
        report.orders = this.orders;
        return report;
    }
}
