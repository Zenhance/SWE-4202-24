package model;

public class Hall {
    int id;
    int rows;
    int cols;
    Seat[][]grid;
    public Hall( int id,int rows,int cols,int premiumRows){
this.id=id;
this.rows=rows;
this.cols=cols;
grid=new Seat[rows][cols];
for(int r=0;r<rows;r++){
 for(int c=0;c<cols;c++){
     boolean isPremium= r<premiumRows;
     grid[r][c]=new Seat(r,c,premiumRows);
 }
}
    }
    public Seat getSeat(int row, int col){
return grid[row][col];
    }
    public int countAvailable(){int count=0;
    for(int r=0;r<rows;r++){
        for(int c=0;c<cols;c++){
            if(grid[r][c].isAvailable()){
                count++;
            }
        }
    } return count;}

    public void displayLayout(){
    for(int r=0; r<rows;r++) {
        for (int c = 0; c < cols; c++) {
            Seat s = grid[r][c];
            if (s.isBooked()) {
                System.out.println("# ");
            } else if (s.isPremium()) {
                System.out.println("* ");
            } else {
                System.out.println(". ");
            }
        }
        System.out.println();
    }
    }}

