package kenakata.catalog;

public interface CatalogItem extends Chargeable{
    String sku();
    String title();
    long unitPrice();
    Seller seller();
    int remaining();

    void reserve(int quantity)throws OutOfStockException;

    long commisionOn(long lineValue);

    @Override
    default long unitCharge(){
        return unitPrice();
    }
    @Override

    default String label(){
        return title();
    }

}
