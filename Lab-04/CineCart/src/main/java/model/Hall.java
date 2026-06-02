package model;

public class Hall {

    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;
}

public Hall(int id, int rows, int cols, int premiumRows){

    this.id=id;
    this.rows=rows;
    this.cols=cols;
    Seat[][] grid=new Seat[rows][cols];

    for (int r=0;r<rows;r++){
        for(int c=0;c<column;c++){
            if (r<premiumRows) grid[r][c] = new Seat()(r, c, true);

            else grid[r][c] = new Seat()(r,c,false);
        }
    } this.grid=grid;
}

public Seat getSeat(int row,int col){
    return grid[row][col];
}


public int countAvailable(){
    int count=0;
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){

            if(grid)
        }
    }



}

public void displayLayout(){


}
