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
    private int placedDay = -1;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null || deliveryCalculator == null) {
            throw new IllegalArgumentException("Zone and delivery calculator must not be null");
        }
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        ensureMutable();
        if (item == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
            lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        ensureMutable();
        if (addOn == null) {
            throw new IllegalArgumentException("Add-on must not be null");
        }
        if (addOn instanceof CatalogItem) {
            throw new IllegalArgumentException("Use addProduct for catalogue item");
        }
        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        ensureMutable();
        if (coupon == null) {
            throw new IllegalArgumentException("Coupon must not be null");
        }
        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        ensureMutable();
        OrderLine line = lineAt(lineIndex);
        if (!(line.unit() instanceof Insurable)) {
            throw new NotInsurableException("Line " + lineIndex + " cannot be insured");
        }
        line.markInsured();
    }

    public PriceBreakdown quote(int currentDay) throws CheckoutException {
        if (currentDay < 0) {
            throw new IllegalArgumentException("Current day cannot be negative");
        }
        return calculateBreakdown(currentDay);
    }

    public void place(PaymentMethod payment, int currentDay) throws CheckoutException {
        ensureMutable();
        if (payment == null) {
            throw new IllegalArgumentException("Payment method must not be null");
        }
        PriceBreakdown breakdown = calculateBreakdown(currentDay);
        Map<CatalogItem, Integer> requiredStock = aggregateRequiredStock();
        for (Map.Entry<CatalogItem, Integer> entry : requiredStock.entrySet()) {
            CatalogItem item = entry.getKey();
            int quantity = entry.getValue();
            if (!item.canReserve(quantity)) {
                throw new OutOfStockException(item.title() + " is out of stock");
            }
        }
        payment.validate(breakdown.grandTotal());
        List<Map.Entry<CatalogItem, Integer>> reserved = new ArrayList<>();
        try {
            for (Map.Entry<CatalogItem, Integer> entry : requiredStock.entrySet()) {
                entry.getKey().reserve(entry.getValue());
                reserved.add(entry);
            }
            payment.authorise(breakdown.grandTotal());
        } catch (CheckoutException failure) {
            for (Map.Entry<CatalogItem, Integer> entry : reserved) {
                entry.getKey().release(entry.getValue());
            }
            throw failure;
        }
        placed = true;
        placedDay = currentDay;
        finalBreakdown = breakdown;
    }

    public void acceptReturn(int lineIndex, int returnDay) throws ReturnNotAllowedException {
        if (!placed) {
            throw new ReturnNotAllowedException("Only placed orders can accept returns");
        }
        if (returnDay < 0) {
            throw new IllegalArgumentException("Return day cannot be negative");
        }
        OrderLine line = lineAt(lineIndex);
        if (line.returned()) {
            throw new ReturnNotAllowedException("The line has already been returned");
        }
        if (!(line.unit() instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException("The line is not returnable");
        }
        int finalReturnDay = placedDay + returnable.returnWindowDays();
        if (returnDay > finalReturnDay) {
            throw new ReturnNotAllowedException("The return window has expired");
        }
        line.markReturned();
        if (line.unit() instanceof CatalogItem item) {
            item.release(line.quantity());
        }
    }
    public List<OrderLine> lines(){
        return Collections.unmodifiableList(lines);
    }
    public Zone zone() {
        return zone;
    }
    public boolean placed(){
        return placed;
    }
    public int placedDay(){
        return placedDay;
    }
    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }
    public Coupon coupon(){
        return coupon;
    }
    private PriceBreakdown calculateBreakdown(int currentDay) throws CheckoutException{
        long subtotal=0;
        long vat=0;
        long discountableBase= 0;
        long insurance =0;
        for(OrderLine line : lines){
           long value = line.lineValue();
           subtotal=Math.addExact(subtotal,value);
           vat=Math.addExact(vat,line.lineVat());
            if (line.unit() instanceof Discountable){
                discountableBase = Math.addExact( discountableBase,value);
            }
            if(line.insured()){
                Insurable insurable = (Insurable) line.unit();
                long insurableValue =insurable.insurableValue(line.quantity());
                long calculated =MoneyMath.ceilPercent(insurableValue,1);
                long lineInsurance =Math.max(20, calculated);
                insurance = Math.addExact(insurance,lineInsurance);
            }
        }
        long discount;
        if (coupon == null) {discount=0;}
        else{
            discount = coupon.discountFor(discountableBase,subtotal,currentDay);
        }
        long delivery =deliveryCalculator.calculate(lines,zone);
        long serviceFee =Math.min(100, MoneyMath.ceilPercent(subtotal, 1));
        long grandTotal = subtotal;
        grandTotal = Math.subtractExact(grandTotal,discount);
        grandTotal = Math.addExact(grandTotal,delivery);
        grandTotal = Math.addExact(grandTotal,vat);
        grandTotal = Math.addExact(grandTotal,insurance);
        grandTotal = Math.addExact(grandTotal,serviceFee);
        return new PriceBreakdown(subtotal,discount,delivery,vat,insurance,serviceFee,grandTotal);
    }
    private Map<CatalogItem, Integer>aggregateRequiredStock() {
        Map<CatalogItem, Integer> required = new IdentityHashMap<>();
        for (OrderLine line : lines) {
            if (line.unit() instanceof CatalogItem item) {
                required.merge(item, line.quantity(), Math::addExact);
            }
        }
        return required;
    }
    private OrderLine lineAt(int index) {
        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException("Invalid line index: " + index);
        }
        return lines.get(index);
    }
    private void ensureMutable() {
        if (placed) {
            throw new IllegalStateException("A placed order can no longer be modified or placed again");
        }
    }
}
