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
                boolean isPremium=(i<premiumRows);
                grid[i][j];
            }
        }
    }
    public Seat getSeat(int rows,int cols){
        return grid[rows][cols]
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
    }
}
