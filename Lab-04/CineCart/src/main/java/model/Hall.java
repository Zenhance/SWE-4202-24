package model;

public class Hall {
    private final int id;
    private final int rows;
    private final int cols;
    private final int premiumRows;


    public Hall(int id,int rows,int cols,int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols=cols;
        this.premiumRows=premiumRows;

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