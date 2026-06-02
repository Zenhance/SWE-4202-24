import model.ConcessionItem;
import model.Customer;
import model.Ticket;

public class Cart {

    //constants
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    //fields
    public Customer owner;
    public Ticket[] tickets;
    public int ticketcount;
    public ConcessionItem[] items;

    public int[] qtys;
    public int itemCount;




}