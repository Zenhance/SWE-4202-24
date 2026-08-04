package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;

public class Order {
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;

    private ArrayList<OrderLine> lines;
    private ArrayList<Chargeable> addOns;

    private Coupon coupon;

    private ArrayList<Integer> insuredLines;

    private boolean placed;

    private PriceBreakdown finalBreakdown;

    private int placeDay;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator){
        if(zone== null){
            throw new IllegalArgumentException("Zone cannot be null");
        }
        if(deliveryCalculator==null){
            throw new IllegalArgumentException("Calculator cannot be null");
        }
        this.zone=zone;
        this.deliveryCalculator=deliveryCalculator;


        lines= new ArrayList<>();
        addOns= new ArrayList<>();
        insuredLines= new ArrayList<>();

        placed=false;
        coupon=null;
        finalBreakdown=null;
    }

    public ArrayList<Chargeable> addOns(){
        return addOns;
    }

    public void addProduct(CatalogItem product, int quantity){
        OrderLine line = new OrderLine(product,quantity );
        lines.add(line);

    }

    public void addAddOn(Chargeable addOn){
        if(addOn==null){
            throw new IllegalArgumentException("Add-on cannot be null");
        }

        addOns.add(addOn);
    }

    public void applyCoupon(Coupon coupon){
        this.coupon=coupon;
    }

    public ArrayList<OrderLine> lines(){
        return lines;
    } // working as a getter. will return  the selected products like lamp, hilsha

    public boolean placed(){
        return placed;
    }

    public PriceBreakdown finalBreakdown(){
        return finalBreakdown;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        OrderLine line = lines.get(lineIndex);

        if(!(line.product() instanceof Insurable)){
            throw new NotInsurableException("Item is not insurable");
        }

        insuredLines.add(lineIndex);
    }

   public PriceBreakdown quote(int today) throws CouponRejectedException {
       long subtotal=0;
       long discountableSubtotal=0;
       long discount=0;
       long vat=0;
       long delivery=0;
       long insurance=0;
       long serviceFee=0;
       long grandTotal=0;

       for(OrderLine line: lines){
           CatalogItem item= line.product();
           int quantity=line.quantity();

           long lineTotal=item.unitCharge()*quantity;

           subtotal+=lineTotal;

           if(item instanceof StockedGood){
               discountableSubtotal+=lineTotal;
           }
       }

       for(Chargeable addOn: addOns){
            subtotal+=addOn.unitCharge();
       }


       for(OrderLine line: lines){
           CatalogItem item = line.product();
           int quantity=line.quantity();
           vat+= item.unitVat()*quantity;
       }

       for(Chargeable addOn: addOns){
           vat+=addOn.unitVat();
       }

       if(coupon!=null){
           if(today>coupon.validUntil()){
               throw new CouponRejectedException("Invalid Expiry date");
           }
           if(discountableSubtotal<coupon.minimumSpend()){
               throw new CouponRejectedException("Minimum spend not valid");
           }

          long calculatedDiscount=(long)Math.ceil(discountableSubtotal*coupon.percent()/100.0);
           discount=Math.min(calculatedDiscount, coupon.maxDiscount());
       }

       delivery= deliveryCalculator.calculate(lines,zone);

       for(int index: insuredLines){
           OrderLine line = lines.get(index);
           long lineValue=line.product().unitCharge()*line.quantity();
           long fee=(long)Math.ceil(lineValue*0.01);
           fee= Math.max(fee,20);

           insurance+=fee;
       }

       serviceFee=(long)Math.ceil(subtotal*0.01);
       serviceFee=Math.min(serviceFee,100);


       grandTotal=subtotal-discount+vat+delivery+insurance+serviceFee;


       PriceBreakdown breakdown=new PriceBreakdown(subtotal,discount,vat,delivery,insurance,serviceFee,grandTotal);

       return breakdown;


   }


    public void place(PaymentMethod payment, int today)
            throws CouponRejectedException,
            OutOfStockException,
            PaymentDeclinedException {


        PriceBreakdown breakdown = quote(today);


        for (OrderLine line : lines) {
            if (line.product().remaining() < line.quantity()) {
                throw new OutOfStockException("Only " + line.product().remaining() + " items remaining.");
            }
        }


        payment.authorise(breakdown.grandTotal());


        for (OrderLine line : lines) {
            line.product().reserve(line.quantity());
        }


        placed = true;
        finalBreakdown = breakdown;
        placeDay = today;
    }

    public void acceptReturn(int lineIndex, int today)
            throws ReturnNotAllowedException {

        OrderLine line = lines.get(lineIndex);

        if (!(line.product() instanceof Returnable item)) {
            throw new ReturnNotAllowedException("Item is not returnable");
        }

        if (line.returned()) {
            throw new ReturnNotAllowedException("Already returned");
        }

        if (today > placeDay + item.returnWindowDays()) {
            throw new ReturnNotAllowedException("Return window expired");
        }

        line.markReturned();
    }


    public Coupon coupon() {
        return coupon;
    }

    public Zone zone() {
        return zone;
    }

    public int placeDay() {
        return placeDay;
    }

    public ArrayList<Integer> insuredLines() {
        return insuredLines;
    }



}
