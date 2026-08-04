package kenakata.catalog;

public abstract class AbstractCatalogItem implements CatalogItem{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private final Seller seller;
    private int stock;

}
