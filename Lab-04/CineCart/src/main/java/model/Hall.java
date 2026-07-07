package model;

public class Hall {
    private final int id;
    private final int rows;
    private final int cols;
    private final int premiumRows;
    private final boolean isBooked;

    private final Seat[][] grid;


    public Hall(int id,int rows,int cols,int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols=cols;
        this.premiumRows=premiumRows;
        this.isBooked=false;
        ;
        grid=new Seat[rows][cols];
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                boolean isPremium = (r<premiumRows);
                grid[r][c] = new Seat(r,c,isPremium,false);
            }
        }
}
public Seat getSeat(int row,int col){
        return grid[row][col];
}
public int getId(){
  return id;
}
   public int getRows(){
       return rows;
   }
   public int getCols(){
        return cols;
   }

    public int getPremiumRows(){
        return premiumRows;
    }


  public boolean isPremiumSeat(int row,int col){
        return row<premiumRows;
  }
}