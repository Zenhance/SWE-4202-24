package kenakata.order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Discountable;
import kenakata.catalog.Insurable;
import kenakata.catalog.MoneyMath;
import kenakata.catalog.Returnable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.OutOfStockException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

public final class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean placed;
    private int placedDay=-1;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator){
        if(zone == null || deliveryCalculator == null){
            throw new IllegalArgumentException("Zone and delivery calculator must not be null");
        }
        this.zone = zone;
        this.deliveryCalculator=deliveryCalculator;
    }
    public void addProduct(CatalogItem,int quantity){
        ensureMutable();
        if(item == null){
            throw new IllegalArgumentException("Product must not be null");

 lines.add(new OrderLine(item,quantity));        }
    }
    public void addAddOn(Chargeable addOn){
        ensureMutable();
        if(addOn == null){
            throw new IllegalArgumentException("Add-on must not be null");
        }
        if(addOn instanceof CatalogItem){
            throw new IllegalArgumentException("Use addProduct for catalogue item");
        }
        lines.add(new OrderLine(addOn,1));
    }
    public void applyCoupon(Coupon coupon) {
        ensureMutable();
        if (coupon == null) {
            throw new IllegalArgumentException("Coupon must not be null");
        }
        this.coupon = coupon;
    }
}
