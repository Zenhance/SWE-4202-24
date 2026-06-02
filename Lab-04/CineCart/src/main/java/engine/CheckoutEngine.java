package engine;

import model.*;
import data.*;

public class CheckoutEngine {
    // Fields (all private): ShowtimeBoard board, ConcessionMenu menu
    // Constructor: CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu)

    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

}