package model;

public class Hall {

    //fields
    private int id;
    private int rows;
    private int cols;
    private int[][] Seat;


    //constructors
    public Hall(int id, int rows, int cols, int premiumRows) {

        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.Seat = new Seat [rows][cols];

        for (int r = 0; r < rows; r++)
        {
            boolean isPremium = (r < premiumRows);

            for (int c = 0; c < cols; c++) {


            }
        }



    }

    //methods
    public Seat getSeat(int row, int col) {



    }

    public int countAvailable() {

        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++)
            {

            }
        }

    }

    public void displayLayout() {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++)
            {


                if (seat.isBooked) {
                    System.out.println("#");
                } else if (seat.isPremium)
                    System.out.println("*");
                else {
                    System.out.println(".");
                }

            }

            System.out.println( );

        }

    }
}