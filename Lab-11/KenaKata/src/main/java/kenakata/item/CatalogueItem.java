package kenakata.item;

public abstract class CatalogueItem {
    protected String name;
    protected int price;
    protected int stock;


    public CatalogueItem(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void reserve(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
        } else {
            throw new RuntimeException("Not enough stock");
        }
    }
    public void release(int quantity){
        stock+=quantity;
    }
    public abstract int getVat();
    public abstract boolean isDiscountable();
    }
}