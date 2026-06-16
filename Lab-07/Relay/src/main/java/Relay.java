/**
 * Relay — the outbound message hub in action.
 *
 * This entry point wires the pieces together the way a real caller would: it
 * builds a handful of notices across every channel, audits them, then drops
 * them into a single {@link Outbox} and asks the outbox to price and send the
 * whole batch. Notice that nothing below ever asks a message "what channel are
 * you?" — every item is held as a {@link Message} and decides for itself how to
 * describe, cost, and deliver. That is the entire point of the design.
 */
public class Relay {

    public static void main(String[] args) {
        // Recipients are things a notice HAS — plain collaborators, not channels.
        Recipient ada   = new Recipient("Ada Lovelace", "ada@analytical.engine");
        Recipient alan  = new Recipient("Alan Turing",  "alan@bletchley.park");
        Recipient grace = new Recipient("Grace Hopper", "grace@navy.mil");

        // TODO: Complete the full business logic flow here
    }
}
