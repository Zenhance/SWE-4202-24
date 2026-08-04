package kenakata.catalog;
import kenakata.settlement.Seller;
import kenakata.money.Money;

public class FreshGood extends CatalogItem implements Weighable,ColdChainRequired,Returnable,Insurable{
    private static final long COMMISSION_PER_ML=50;
    private static final long COLDCHAIN_SURCHARGE=50;
    private static final int RETURN_WINDOW=2;
    private long unitWeightGrams;

    public FreshGood(String sku,String title , long unitPrice, int stock,Seller seller,int i){
        super(sku, title, unitPrice, stock, seller);
        if (unitWeightGrams<= 0) {
            throw new IllegalArgumentException("unitWeightGrams must be positive");
        }
        this.unitWeightGrams=unitPrice;
    }

    public FreshGood(String sku, String hilsa, int unitPrice, int stock, Seller seller, int i) {
        super(sku,hilsa,unitPrice,stock,seller);
    }

    @Override
    public long unitVat(){
        return 0;
    }

    @Override
    public long unitPrice() {
        return 0;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue){
        return Money.ceilPerMl(lineValue,COMMISSION_PER_ML);
    }

    @Override
    public int remaining() {
        return 0;
    }

    @Override
    public String sku() {
        return "";
    }

    @Override
    public long unitWeight(){
        return unitWeightGrams;
    }
    @Override
    public long ColdChainSurcharge(){
        return COLDCHAIN_SURCHARGE;
    }
    @Override
    public int returnWindowDays(){
        return RETURN_WINDOW;
    }



}

