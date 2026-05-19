package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;


    public int getId(){
        return this.id;
    }
    public int getRows(){
        return this.rows;
    }
    public int getCols(){return this.cols;}
    public Seat[][] getGrid(){return grid;}

    public int cols(){
        return this.cols;
    }
    public Seat getSeat(int row, int col){
        return grid[row][col];
    }
    public Hall(int id, int rows, int cols, int premiumRows){
         grid = new Seat[rows][cols];
         for(int r =0; r<rows; r++){
             for(int c=0; c<cols; c++){
                 boolean premium = r<premiumRows;
                 grid[r][c] = new Seat(r,c,premium);
             }
         }
    }

    public int countAvailable(){
        int count = 0;
        for(int r=0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(grid[r][c].isAvailable()){
                    count++;
                }
            }
        }
        return count;
    }
    void displayLayout() {
          for(int r = 0; r<rows; r++){
              for(int c = 0;c<cols; c++){
                  Seat s = grid[r][c];
                  if(!s.isAvailable()){
                      System.out.print("# ");
                  }
                  else if(s.isPremium()){
                      System.out.print("* ");
                  }
                  else{
                      System.out.print(". ");
                  }
              }
              System.out.println();
          }
    }

}
