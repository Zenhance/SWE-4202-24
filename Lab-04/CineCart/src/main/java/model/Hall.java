package model;

public class Hall {
    int id;
    int rows;
    int cols;
    Seat[][] s;
    int premiumRows;

    public Hall(int id, int rows, int cols, int premiumRows) {
        this.id=id;
        this.rows=rows;
        this.cols=cols;
        this.premiumRows=premiumRows;
        Seat[][] s = new Seat[rows][cols];
        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++)
                s[r][c]=new Seat(r,c,r<premiumRows);

    }

    public int getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Seat getSeat(int row, int col){
        return s[row][col];
    }
public int countAvailable(){
        int count=0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
            if (s[i][j].isAvailable())count++;
            }
        }
        return count;
}
    public Seat[][] getGrid() {
        return s;
    }

public void displayLayout(){
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (s[i][j].isAvailable()) System.out.println(".");
                else if (s[i][j].isBooked) {
                    System.out.println("#");
                    
                } else if (s[i][j].isPremium()&&s[i][j].isAvailable()) {
                    System.out.println("*");
                    
                }
            }
        }
}
}
