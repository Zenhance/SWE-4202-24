package model;

public class ConcessionLine extends LineItem
{
    private ConcessionItem item;
    private int qty;

    public ConcessionLine(ConcessionItem item, int qty)
    {
        this.item = item;
        this.qty = qty;
    }

    public ConcessionItem getItem()
    {
        return item;
    }

    public int getQty()
    {
        return qty;
    }

    @Override
    public double subtotal()
    {
        return item.getUnitPrice()*qty;
    }

    @Override
    public String describe()
    {
        return String.format(item.toString()+" x "+qty+"\n BDT : "+subtotal());
    }

    @Override
    public boolean hasCode(String code)
    {
        return false;
    }
}