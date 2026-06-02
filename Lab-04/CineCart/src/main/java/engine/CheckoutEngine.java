/*
Part E — CheckoutEngine: Booking Flow [3 marks]
CheckoutEngine is the brain of the booth. It does not store any tickets or items itself — those
belong to the customer’s Cart. Instead it holds references to the read-only data layer (ShowtimeBoard,
ConcessionMenu) and orchestrates the booking and pricing rules.
Fields (all private): ShowtimeBoard board, ConcessionMenu menu.
Constructor: CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu).
E.1 bookTicket
Signature: String bookTicket(Cart cart, int showtimeId, int row, int col).
The method must perform these checks in order and must produce the side effects described:
1. Look up the showtime via board.findById(showtimeId). If it does not exist, return the string
"Showtime not found" and change nothing.
2. Compare cart.getOwner().getAge() against showtime.getMovie().getMinAge(). If the customer
is too young, return the string "Underage for rating <X>" (where <X> is the movie’s rating) and
change nothing – in particular, the seat must not be booked.
3. Look up the seat via showtime.getHall().getSeat(row, col). If the seat is already booked, return
"Seat unavailable" and change nothing.
4. Compute the ticket price as
price = movie.basePrice × (seat.isPremium ? 1.30 ∶ 1.00) × (showtime.isPeak() ? 1.20 ∶ 1.00).
5. Mark the seat booked, build a Ticket with the computed price, and add it to the cart.
6. Return the string "OK".

E.2 addConcession
Signature: String addConcession(Cart cart, String code, int qty).
1. Look up the item via menu.findByCode(code). If null, return "Item not found".
2. If qty <= 0, return "Invalid quantity".
3. Otherwise add the item to the cart and return "OK".

F.1 checkout
Signature: double checkout(Cart cart).
Apply every rule below in this order; the method must return the final amount rounded to two
decimal places.
1. ticketSubtotal = cart.sumTicketsPaid().
2. concessionSubtotal = cart.sumConcessionsRaw().
3. Combo deal: if the cart contains both POP and SODA, set combo = 50.0, otherwise combo = 0.0.
4. preDiscount = ticketSubtotal + concessionSubtotal − combo.
5. Group discount: if the cart contains four or more tickets, group = 0.10 × preDiscount, otherwise
0.
6. Tier discount: tier = cart.getOwner().getTierDiscount() × preDiscount.
7. afterDiscounts = preDiscount − group − tier.
8. tax = 0.05 × afterDiscounts.
9. Return round2(afterDiscounts + tax).

F.2 getReceipt
Signature: String getReceipt(Cart cart).
Return a multi-line string. The exact wording is up to you, but the test will check that the string contains all the following substrings: "Receipt", the customer’s name, "BDT", "Total", and "Discount".
Listing each ticket and each concession line is recommended.

⊳ Notice
You may notice that checkout and bookTicket are getting long. That is fine for this lab —
focus on getting the rules right and the tests passing. Resist the urge to introduce inheritance,
interfaces, or design patterns; you have not been taught those yet, and this lab does not need
them.
*/

package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null) {
            return "Showtime not found";
        }

        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()) {
            return String.format("Underage for rating %s", showtime.getMovie().getRating());
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if (seat.isBooked()) {
            return "Seat unavailable";
        }

        double price = showtime.getMovie().getBasePrice();

        price *= (seat.isPremium() ? 1.30 : 1.00) * (showtime.isPeak() ? 1.20 : 1.00);

        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

        return "OK";
    }

    public String addConcession(Cart cart, String code, int qty) {
        ConcessionItem item = menu.findByCode(code);

        if (item == null) {
            return "Item not found";
        }

        if (qty <= 0) {
            return "Invalid quantity";
        }

        cart.addItem(item, qty);
        return "OK";
    }

    public double checkout(Cart cart) {
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();

        double combo;

        if (cart.hasItem("POP") & cart.hasItem("SODA")) {
            combo = 50.0;
        } else {
            combo = 0.0;
        }

        double preDiscount = ticketSubtotal + concessionSubtotal - combo;

        double group;

        if (cart.getTicketCount() >= 4) {
            group = 0.10 * preDiscount;
        } else {
            group = 0.0;
        }

        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - group - tier;
        double tax = 0.05 * afterDiscounts;

        return round2(afterDiscounts + tax);
    }

    private double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    public String getReceipt(Cart cart) {
        return "";
    }
}