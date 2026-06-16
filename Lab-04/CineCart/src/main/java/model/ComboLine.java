package model;

public class ComboLine extends LineItem{


public static final double DISCOUNT = 50.0;
private ConcessionItem item1;
private ConcessionItem item2;
public ComboLine (ConcessionItem item1, ConcessionItem item2)
{
    this.item1=item1;
    this.item2=item2;

}
public ConcessionItem getItem1 ()
{

    return item1;
}

public ConcessionItem getItem2 ()
{
    return item2;
}
@Override
    public double subtotal ()
{

    return item1.getUnitPrice()+item2.getUnitPrice()-DISCOUNT;
}

@Override
    public String describe()
{

    return item1.getName()+" "+item2.getName()+"\n BDT : "+String.format("%.2f",subtotal());
}



}
