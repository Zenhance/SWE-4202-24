package data;

import model.Showtime;

import java.security.PublicKey;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX=30;
}

public ShowtimeBoard(){
    shows = new Showtime[MAX];
    count=0;
}