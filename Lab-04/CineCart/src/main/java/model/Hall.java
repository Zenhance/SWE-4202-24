package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;
    public Hall(int id,int rows,int cols,int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
        grid=new Seat[rows][cols];
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                boolean premium=r<premiumRows;
                grid[r][c]=new Seat(r,c,premium);
            }
        }
    }

    public int getId() {
        return id;
    }
    public int getRows(){
        return rows;
    }
    public int getcols(){
        return cols;
    }
    public Seat[][]getGrid(){
        return grid;
    }
    public Seat getSeat(int rows,int cols){
        return grid[rows][cols];
    }
   public int countAvailable() {
       int count = 0;
       for (int r = 0; r < rows; r++) {
           for(int c=0;c<cols;c++){
               if (grid[r][c].isAvailable()) {
                   count++;
               }
           }

       }
       return count;
   }
   public void displayLayout(){
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                Seat s=grid[r][c];
                if(s.isBooked()){
                    System.out.println("# ");;
                    }
                else if(s.isPremium()){
                    System.out.println("* ");
                }
                else{
                    System.out.println(". ");
                }
            }
            System.out.println();
        }
   }
}

