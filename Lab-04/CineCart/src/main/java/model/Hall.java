package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;

        this.grid = new Seat[rows][cols];

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(r<premiumRows){
                    grid[r][c]= new Seat(r,c,true); //-->creating a single object, thats why using new
                }else{
                    grid[r][c]= new Seat(r,c,false);
                }
            }
        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getId() {
        return id;
    }

    public Seat[][] getGrid() {
        return grid;
    }



    public Seat getSeat(int row, int cols){
        return grid[row][cols];
    }

    //int count=0;
    public int countAvailable(){
        int count=0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c].isAvailable()){
                    count++;
                }
            }
        }
        return count;
    }

    void displayLayout(){
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c].isAvailable()){
                    System.out.println(grid[r][c]+".");
                }else if(grid[r][c].isBooked()){
                    System.out.println(grid[r][c]+"#");
                }else if(grid[r][c].isAvailable() && grid[r][c].isPremium()){
                    System.out.println(grid[r][c]+"*");
                }
            }
        }
    }
}
