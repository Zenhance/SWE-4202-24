package kenakata.catalog;

public class GiftWrap extends AddOn{
    @Override
    public String label(){
        return "Gift Wrapping";
    }
    @Override
    public long charge(){
        return 50;
    }
    @Override
    public long vat(){
        return (long)Math.ceil(50*0.075);
    }
}
