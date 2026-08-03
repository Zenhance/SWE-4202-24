package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine
{
    private Chargeable item;
    private long qty;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable item, int qty)
    {
        if(item==null)
            throw new IllegalArgumentException("Item can not be null");
        if(qty<=0)
            throw new IllegalArgumentException("Quantity must be positive");
        this.item = item;
        this.qty = qty;
    }

    public Chargeable item()
    {
        return item;
    }

    public long qty()
    {
        return qty;
    }

    public boolean insured()
    {
        return insured;
    }

    public boolean returned()
    {
        return returned;
    }
}