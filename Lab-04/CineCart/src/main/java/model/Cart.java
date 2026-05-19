package model;

public class Cart
{
    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;


}