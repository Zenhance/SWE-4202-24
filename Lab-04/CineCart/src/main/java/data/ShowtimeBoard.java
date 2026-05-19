package data;

public class ShowtimeBoard
{
    private ShowtimeBoard[] shows;
    private int count;
    private static final int MAX = 30;

    public ShowtimeBoard()
    {
        shows = new ShowtimeBoard[MAX];
        this.count=0;
    }


}