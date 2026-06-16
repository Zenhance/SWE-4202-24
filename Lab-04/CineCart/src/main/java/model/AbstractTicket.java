package model;

public abstract class AbstractTicket extends LineItem{

    protected Showtime id;
    int row,col;

    public AbstractTicket(Showtime id,int row ,int col){
        this.col=col;
        this.id=id;
        this.row=row;

    }
    public double subtotal(){
        return 0;
    }
}
