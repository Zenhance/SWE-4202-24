package model;

public abstract  class Ticket  extends  LineItem{
    protected Showtime showtime;  //--> showtime will contain everything of the class "Showtime";
    protected int row;
    protected int col;
    protected double basePrice;

    public Ticket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.basePrice = showtime.getMovie().getBasePrice();
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


}
