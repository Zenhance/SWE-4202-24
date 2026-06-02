package model;

public class Hall {
    int id;
    int rows;
    int cols;
    Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;

        grid=new Seat[rows][cols];

        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++)
        {
            boolean premium=(r<premiumRows);
            grid[r][c]=Seat(r,c,premium);
        }
    }

    Seat getSeat(int row,int col){
        return
    }

    int count=0;
    int countAvailable(){
        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++)
            {
                if(grid[r][c].isAvailable()==true)
                {
                    count++;
                }
            }
    }
}
