package model;

public class Cart{
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private Ticket[] tickets;
    private ConcessionItem[] items;
    private int ticketCount;
    private int[] qtys;
    private int itemCount;

}