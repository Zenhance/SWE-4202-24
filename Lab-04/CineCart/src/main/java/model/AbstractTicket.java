package model;


    public abstract class AbstractTicket extends LineItem {
        protected Showtime showtime;
        protected int rows;
        protected int cols;
        protected double base;

        public AbstractTicket(Showtime showtime, int rows, int cols) {
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
        protected double peakMultiplier(){
            if(showtime.isPeak()){
                return 1.20;
            }
            else{
                return 1.00;
            }
        }
        public Showtime getShowtime() {
            return showtime;
        }

        @Override
        public double subtotal(){
            return 1.00;
        }
        @Override
        public String describe(){
            return "A";
        }
    }

