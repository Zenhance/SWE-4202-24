package data;

import model.ConcessionItem;

public class ConcessionMenu
{
    private ConcessionItem[] items;
    private int count;
    private static final int MAX = 30;

    public ConcessionMenu()
    {
        items = new ConcessionItem[MAX];
        this.count=0;
    }

    public void add(ConcessionItem c)
    {
        if(count<MAX)
        {
            items[count]=c;
            count++;
        }
    }

    public void displayAll()
    {
        for(int i=0;i<count;i++)
        {
            System.out.println(items[i]);
        }
    }
}