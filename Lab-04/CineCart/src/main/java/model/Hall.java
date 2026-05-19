package model;

public class Hall {
    public int id;
    public int rows;
    public int cols;
    public Seat[][]grid;
    public Hall(int id,int rows,int cols,int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
        grid=new Seat[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j]=new Seat(i,j,i<premiumRows);
            }
        }
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
    public Seat[][] getGrid(){
        return grid;
    }
    public Seat getSeat(int rows,int cols){

        return grid[rows][cols];
    }
    public int countAvailable(){
        int count =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j].isAvailable()){
                    count++;
                }
            }
        }
        return count;
    }
    public void displayLayout(){
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                Seat seat=grid[i][j];
                if(seat.isBooked()){
                    System.out.print("# ");
            }
                else if(seat.isPremium()){
                    System.out.print("* ");
                }
                else{
                    System.out.print(". ");
                }

        }
            }
        System.out.println();
    }
}
