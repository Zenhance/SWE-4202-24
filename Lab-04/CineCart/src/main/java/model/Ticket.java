package model;


    public abstract class Ticket {
        private Showtime showtime;
        private int rows;
        private int cols;
        private double base;

        public Ticket(Showtime showtime, int rows, int cols) {
            this.showtime = showtime;
            this.rows = rows;
            this.cols = cols;
            this.base=showtime.getMovie().getBasePrice();
        }


        public int getRow() {
            return rows;
        }

        public int getCol() {
            return cols;
        }

        /*public double getPricePaid() {
            return pricePaid;
        }*/

        public Showtime getShowtime() {
            return showtime;
        }

        public String toString() {
            return String.format("T%d - R%dC%d @ BDT %.2f", showtime.getId(), rows, cols, pricePaid);


        }
    }

