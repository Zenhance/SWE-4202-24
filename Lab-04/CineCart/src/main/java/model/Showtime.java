package model;

public class Showtime {
    private final int id;
    private final Movie movie;
    private final Hall hall;
    private final int startHour;
    private final String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        if (startHour<0 || startHour>23)
            throw new IllegalArgumentException("Invalid startHour");
        this.startHour = startHour;
        this.dateTag = dateTag;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public int getStartHour() {
        return startHour;
    }

    public String getDateTag() {
        return dateTag;
    }

    public boolean isPeak() {
        if (startHour>=18 && startHour<=21) return true;
        return false;
    }

    public String toString() {
        String string = String.format("[T%d] %s @ Hall %d - %d:00 (%s)", id,
                getMovie().getTitle(), getHall().getId(), startHour, dateTag);

        return string;
    }

}