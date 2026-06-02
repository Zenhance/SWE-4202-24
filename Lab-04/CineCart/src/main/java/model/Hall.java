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
            grid[r][c]=new Seat(r,c,premium);
        }
    }

    public Seat getSeat(int row,int col){
        return grid[row][col];
    }

    int count=0;
    public int countAvailable(){
        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++)
            {
                if(grid[r][c].isAvailable()==true)
                {
                    count++;
                }
            }
        return count;
    }

    public void displayLayout(){
        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++)
            {
                if(grid[r][c].isAvailable())
                {
                    System.out.println(" .");
                }
                if(!grid[r][c].isAvailable())
                {
                    System.out.println(" #");
                }
            }
        System.out.print("\n");
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

}
