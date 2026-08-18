package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

// CheckoutEngine is the "brain" of the booking booth.
// It does NOT store tickets or items itself — those live in the customer's Cart.
// Its job is to validate requests, apply pricing rules, and calculate the final bill.
public class CheckoutEngine {

    // --- Fields ---
    private ShowtimeBoard board;  // all available showtimes
    private ConcessionMenu menu;  // all available snacks/drinks

    // --- Constructor ---
    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu  = menu;
    }

    // -------------------------------------------------------------------------
    // PART E.1 — bookTicket
    // Tries to book one seat for a customer. Returns "OK" if everything works,
    // or an error message string if something goes wrong.
    // -------------------------------------------------------------------------
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {

        // Step 1: find the showtime by ID
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null) {
            return "Showtime not found";  // no such showtime on the schedule
        }

        // Step 2: age check — is the customer old enough for this movie's rating?
        Movie movie = showtime.getMovie();
        int customerAge = cart.getOwner().getAge();
        int minAge = movie.getMinAge();

        if (customerAge < minAge) {
            // Not allowed — return message with the rating that blocked them
            return "Underage for rating " + movie.getRating();
        }

        // Step 3: check if the specific seat is still free
        Seat seat = showtime.getHall().getSeat(row, col);
        if (!seat.isAvailable()) {
            return "Seat unavailable";  // someone else already booked this seat
        }

        // Step 4: calculate the ticket price
        // Base price gets multiplied if the seat is premium and/or it's peak time
        double price = movie.getBasePrice();
        if (seat.isPremium()) price *= 1.30;   // +30% for premium seats
        if (showtime.isPeak()) price *= 1.20;  // +20% for peak evening hours

        // Step 5: mark the seat as booked, build the ticket, add to cart
        seat.book();  // seat is now taken
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

        // Step 6: report success
        return "OK";
    }

    // -------------------------------------------------------------------------
    // PART E.2 — addConcession
    // Tries to add a snack/drink to the cart. Returns "OK" or an error message.
    // -------------------------------------------------------------------------
    public String addConcession(Cart cart, String code, int qty) {

        // Step 1: find the item on the menu by its code
        ConcessionItem item = menu.findByCode(code);
        if (item == null) {
            return "Item not found";  // no such item on the menu
        }

        // Step 2: quantity must be at least 1
        if (qty <= 0) {
            return "Invalid quantity";
        }

        // Step 3: add the item and report success
        cart.addItem(item, qty);
        return "OK";
    }

    // -------------------------------------------------------------------------
    // PART F.1 — checkout
    // Runs the full pricing pipeline and returns the final amount to pay.
    // The rules must be applied in this exact order.
    // -------------------------------------------------------------------------
    public double checkout(Cart cart) {

        // 1. Total of all ticket prices
        double ticketSubtotal = cart.sumTicketsPaid();

        // 2. Total of all concession items (price x quantity)
        double concessionSubtotal = cart.sumConcessionsRaw();

        // 3. Combo deal: if the cart has both POP and SODA, customer saves BDT 50
        double combo = 0.0;
        if (cart.hasItem("POP") && cart.hasItem("SODA")) {
            combo = 50.0;
        }

        // 4. Pre-discount subtotal (tickets + snacks - combo savings)
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;

        // 5. Group discount: 10% off if 4 or more tickets in the cart
        double group = 0.0;
        if (cart.getTicketCount() >= 4) {
            group = 0.10 * preDiscount;
        }

        // 6. Loyalty tier discount (based on customer's membership level)
        double tier = cart.getOwner().getTierDiscount() * preDiscount;

        // 7. Apply both discounts
        double afterDiscounts = preDiscount - group - tier;

        // 8. Add 5% tax on the discounted amount
        double tax = 0.05 * afterDiscounts;

        // 9. Final total, rounded to 2 decimal places
        double total = afterDiscounts + tax;
        return Math.round(total * 100.0) / 100.0;
    }

    // -------------------------------------------------------------------------
    // PART F.2 — getReceipt
    // Builds a printable receipt string. The test checks that it contains:
    // "Receipt", the customer's name, "BDT", "Total", "Discount"
    // -------------------------------------------------------------------------
    public String getReceipt(Cart cart) {
        StringBuilder sb = new StringBuilder();

        // Header
        sb.append("========== Receipt ==========\n");
        sb.append("Customer : ").append(cart.getOwner().getName()).append("\n");
        sb.append("Tier     : ").append(cart.getOwner().getLoyaltyTier()).append("\n");
        sb.append("-----------------------------\n");

        // List every ticket
        sb.append("TICKETS:\n");
        for (int i = 0; i < cart.getTicketCount(); i++) {
            sb.append("  ").append(cart.getTickets()[i]).append("\n");
        }

        // List every concession item with quantity
        sb.append("CONCESSIONS:\n");
        for (int i = 0; i < cart.getItemCount(); i++) {
            ConcessionItem ci = cart.getItems()[i];
            int qty = cart.getQtys()[i];
            sb.append("  ").append(ci.getName())
                    .append(" x").append(qty)
                    .append(" = BDT ").append(String.format("%.2f", ci.getUnitPrice() * qty))
                    .append("\n");
        }

        sb.append("-----------------------------\n");

        // Show the combo discount if it applied
        if (cart.hasItem("POP") && cart.hasItem("SODA")) {
            sb.append("Combo Discount : BDT -50.00\n");
        }

        // Show loyalty tier discount info
        double tierPct = cart.getOwner().getTierDiscount() * 100;
        if (tierPct > 0) {
            sb.append("Discount (Tier ").append(cart.getOwner().getLoyaltyTier())
                    .append("): ").append((int) tierPct).append("%\n");
        } else {
            sb.append("Discount : BDT 0.00\n");  // keep word "Discount" for the test
        }

        // Group discount note
        if (cart.getTicketCount() >= 4) {
            sb.append("Group Discount : 10%\n");
        }

        // Final total
        double total = checkout(cart);
        sb.append("Total    : BDT ").append(String.format("%.2f", total)).append("\n");
        sb.append("=============================\n");

        return sb.toString();
    }
}
