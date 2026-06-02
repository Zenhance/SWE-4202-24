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
*/

package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Ticket;
import model.Showtime;
import model.Seat;
import model.ConcessionItem;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }
}