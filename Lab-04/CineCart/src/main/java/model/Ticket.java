package model;


    public class Ticket {
        private Showtime showtime;
        private int rows;
        private int cols;
        private double pricePaid;

        public Ticket(Showtime showtime, int rows, int cols, double pricePaid) {
            this.showtime = showtime;
            this.rows = rows;
            this.cols = cols;
            this.pricePaid = pricePaid;
        }


        public int getRow() {
            return rows;
        }

        public int getCol() {
            return cols;
        }

        public double getPricePaid() {
            return pricePaid;
        }

        public Showtime getShowtime() {
            return showtime;
        }

        public String toString() {
            return String.format("T%d - R%dC%d @ BDT %.2f", showtime.getId(), rows, cols, pricePaid);


        }
    }

