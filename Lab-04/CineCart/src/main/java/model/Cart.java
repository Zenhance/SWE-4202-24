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
  qtys = new int[MAX_ITEMS];

 }

 public boolean addTicket(Ticket t) {
  boolean res = false;
  if (ticketCount < MAX_TICKETS) {
   tickets[ticketCount] = t;
   ticketCount++;
   res = true;
  }
  return res;
 }

 public boolean addItem(ConcessionItem c, int qty) {
  boolean state = false;
  if (itemCount < MAX_ITEMS) {
   ;
   items[itemCount] = c;
   qtys[itemCount] = qty;
   itemCount++;
   state = true;
  }
  return state;
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

 public double sumTicketsPaid() {
  double sum = 0;
  for (int i = 0; i < ticketCount; i++) {
   sum += tickets[i].pricePaid;

  }
  return sum;
 }

 public double sumConcessionsRaw() {
  double sum = 0;
  for (int i = 0; i < itemCount; i++) {
   sum += qtys[i] * items[i].getUnitPrice();
  }
  return sum;
 }

 public boolean hasItem(String code) {
  boolean found = false;
  for (int i = 0; i < MAX_ITEMS; i++) {
   if (code.equals(items[i].getCode())) {
    found = true;
    break;
   }
  }
  return found;
 }

 public void add(StandardTicket standardTicket) {
 }

 public double grandSubtotal() {
  return 0.00;
 }

 public void add(ConcessionItem pop, int i) {

 }

 public void add(PremiumTicket premiumTicket) {
 }

 public boolean hasCode(String pop) {
  return false;
 }

 public void add(VIPTicket vipTicket) {
 }

 public Object getLines() {
  return null;
 }

}





