package model;

public abstract class AbstractTicket extends LineItem{

    protected Showtime id;
    protected int row,col;

    public AbstractTicket(Showtime id,int row ,int col){
        this.col=col;
        this.id=id;
        this.row=row;

    }
}
