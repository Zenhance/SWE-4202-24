public abstract class Slot {
    private boolean isavailable;
    private int firstaHourFee;
    private int laterFee;
    private int surcharge;

    public Slot(){
        this.isavailable = true;
    }

        public void setFirstaHourFee(int firstaHourFee){
            this.firstaHourFee = firstaHourFee;
        }

        public void setSurcharge(int surcharge){
            this.surcharge = surcharge;
        }
        public void setLaterFee(int laterFee){
            this.laterFee = laterFee;
        }

        public int getFirstaHourFee() {return firstaHourFee;}
        public int getSurcharge() {return surcharge;}
        public int getLaterFee() {return laterFee;}

        public int totalCharge(){
            return getFirstaHourFee() + getLaterFee() + getSurcharge();
        }


}
