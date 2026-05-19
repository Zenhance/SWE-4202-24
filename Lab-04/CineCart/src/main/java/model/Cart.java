package model;

public class Cart {
    public Customer owner;
    public Ticket[] tickets;
    public int ticketCount;
    public ConcessionItem[] items;
    public int[] qtys;
    public int itemCount;
}
