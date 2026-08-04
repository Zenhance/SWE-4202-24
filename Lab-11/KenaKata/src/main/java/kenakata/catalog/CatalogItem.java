package kenakata.catalog;

public abstract class CatalogItem extends AbstractItem {
    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }
}
