package model;

public class Cart {
 public static final int MAX_TICKETS = 20;
 public static final int MAX_ITEMS = 20;
 Customer owner;
 Ticket[] tickets;
 int ticketCount;
 ConcessionItem[] items;
 int[] qtys;
 int itemCount;

 public Cart(Customer owner) {
  this.owner = owner;
  tickets = new Ticket[MAX_TICKETS];
  this.ticketCount = 0;
  items = new ConcessionItem[MAX_ITEMS];
  this.itemCount = 0;

 }

 public void addTicket(Ticket t) {
  tickets[ticketCount] = t;
  ticketCount++;
 }

 public void addItem(ConcessionItem c, int qty) {
  items[itemCount] = c;
  qtys[itemCount] = qty;
  itemCount++;
  if (itemCount == MAX_ITEMS || qty <= 0) System.out.println("FULL");
 }

 public Customer getOwner() {
  return owner;
 }

 public Ticket[] getTickets() {
  return tickets;
 }

 public int getTicketCount() {
  return ticketCount;
 }

 public ConcessionItem[] getItems() {
  return items;
 }

 public int[] getQtys() {
  return qtys;
 }

 public int getItemCount() {
  return itemCount;
 }
 public double sumTicketsPaid(){
  double sum=0;
  for (int i=0;i<MAX_TICKETS;i++){
      sum+=tickets[i].pricePaid;

  }
  return sum;
 }

 public double sumConcessionsRaw(){
      double sum=0;
  for (int i=0;i<MAX_ITEMS;i++){
    sum+=qtys[i]+items[i].getUnitPrice();
  }
  return sum;
 }
 public boolean hasItem(String code){
     for(int i=0;i<MAX_ITEMS;i++){
         if (items[i].getCode().equals(code));
         return true;
     }
     return false;
 }
 }

