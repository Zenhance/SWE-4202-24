package kenakata.catalog;

import javax.xml.catalog.Catalog;
import java.awt.*;

public class WarrantyPlan implements Chargeable {
    private CatalogItem catalogItem;
    public WarrantyPlan(CatalogItem catalogItem) {
        if(catalogItem == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        this.catalogItem = catalogItem;
    }

    public long unitCharge() {
        return (long) Math.ceil(catalogItem.getUnitPrice() * 0.1);
    }

    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.15);
    }

    public String label() {
        return catalogItem.getTitle();
    }
}
