package kenakata.order;

import kenakata.catalog.ColdChain;
import kenakata.catalog.weighable;
import kenakata.catalog.CatalogueItem;

import java.util.List;

public class DeliveryCalculator {
private static final int dhaka=60;
private static final int dhaka_kg=20;
private static final int outside= 120;
private static final int outside_kg=35;

public long delivery(List<OrderLine>lines ,Zone zone) {
    long totalgrams = 0;
    long Coldchaintotal = 0;

    for (OrderLine line : lines) {
        if (!(line.isproduct())) {
            continue;
        }
        CatalogueItem item = line.product();
        if (item instanceof weighable weighable) {
            totalgrams += weighable.unitWeightGrams() * line.getQuantity();
        }
        if (item instanceof ColdChain coldchain) {
            Coldchaintotal += coldchain.ColdChainSurcharge();
        }
    }

    if (totalgrams == 0)
        return 0;
    long billedkg=(long)Math.ceil(totalgrams/1000.00);
    long shipping= (zone == zone.DHAKA) ?
            dhaka + billedkg * dhaka_kg : outside + billedkg * outside_kg;
    return shipping +Coldchaintotal;
}

}




