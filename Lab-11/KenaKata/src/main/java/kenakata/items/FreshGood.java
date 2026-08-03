package kenakata.items;
import kenakata.util.Money;

public class FreshGood extends Item implements Weighable,ColdChainRequired,Returnable,Insurable{
    private static final long COMMISSION_PER_ML=50;
    private static final long COLDCHAIN_SURCHARGE=50;
    private static final int RETURN_WINDOW=2;
    private final long unitWeightGrams;

    public FreshGood(String sku,String title , long unitPrice, int stock,Seller seller){
        super(sku, title, unitPrice, stock, seller);
        if (unitWeightGrams<= 0) {
            throw new IllegalArgumentException("unitWeightGrams must be positive");
        }
        this.unitWeightGrams=unitPrice;
    }
    @Override
    public long unitVat(){
        return 0;
    }
    @Override
    public long commissionOn(long lineValue){
        return Money.ceilPerMl(lineValue,COMMISSION_PER_ML);
    }
    @Override
    public long unitWeightGrams(){
        return unitWeightGrams;
    }
    @Override
    public long ColdchainSurcharge(){
        return COLDCHAIN_SURCHARGE;
    }
    @Override
    public int returnWindowDays(){
        return RETURN_WINDOW;
    }
    }

