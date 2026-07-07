package model;

public class Showtime {

    private int showtimeId;
    private Movie movie;
    private Hall hall;
    private int hour;
    private String day;

    public Showtime(int showtimeId,
                    Movie movie,
                    Hall hall,
                    int hour,
                    String day) {

        this.showtimeId = showtimeId;
        this.movie = movie;
        this.hall = hall;
        this.hour = hour;
        this.day = day;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public int getHour() {
        return hour;
    }

    public String getDay() {
        return day;
    }

    // Peak show = Friday evening (matches the test)
    public boolean isPeak() {
        return day.equalsIgnoreCase("Fri") && hour >= 18;
    }

    @Override
    public String toString() {
        return movie.getTitle() + " - " + day + " " + hour + ":00";
    }
}