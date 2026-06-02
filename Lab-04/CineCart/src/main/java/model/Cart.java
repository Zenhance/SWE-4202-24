package model;

public class Cart {
    Customer owner;
    Ticket[] tickets;
    int ticketCount;
    ConcessionItem[] items;
    int[] qtys;
    int itemCount;

    Cart(Customer owner) {
        this.owner=owner;
        tickets= new Ticket[];
    }
}