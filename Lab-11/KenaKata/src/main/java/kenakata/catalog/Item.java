package kenakata.catalog;

public abstract class Item {
    protected String sku;
    protected String title;
    protected long unitPrice;
    protected int stock;
    protected Seller seller;

  public Item(String sku, String title, long unitPrice, int stock, Seller seller) {
      if (sku == null || title == null || unitPrice < 0 || stock < 0 || seller == null) {
          throw new IllegalArgumentException();
      }
      this.sku = sku;
      this.title = title;
      this.unitPrice = unitPrice;
      this.stock = stock;
      this.seller = seller;
  }
  public String getSku() {
        return sku;
    }

    public String getTitle() {
  return title;}

    public long getUnitPrice() {
      return unitPrice;
    }

    public int getStock() {
      return stock;
    }

    public Seller getSeller() {
      return seller;
    }

    public void reserve(int quantity){

    }

    public void remaining(){

    }
}
