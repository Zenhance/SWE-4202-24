package model;

public class Cart{

    public static final int MAX_TICKETS=20;
    public static final int MAX_ITEMS=20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;

    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.owner=owner;

        tickets=new Ticket[MAX_TICKETS];
        ticketCount=0;

        items=new ConcessionItem[MAX_ITEMS];
        qtys=new int[MAX_ITEMS];
        itemCount=0;
    }
