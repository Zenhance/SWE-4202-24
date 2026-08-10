package kenakata.settlement;
import kenakata.catalog.Seller;
import java.util.ArrayList;
import java.util.List;

public class Marketplace{
    private final List<Seller> sellers = new ArrayList<>();
    public void register(Seller seller){
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        sellers.add(seller);
    }
}