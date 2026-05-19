package model;

public class Seat {int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    public Seat(int row, int col, boolean isPremium) {
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        this.isBooked=false;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

  public void book(){
     this.isBooked=true;
  }
  public void release(){
    this.isBooked=false;
  }
  public boolean isAvailable(){
        return !isBooked;
  }
  public String toString(){
        String label="R"+row+"C"+col;
        if (isPremium){
            label+="*";
        }
        if (isBooked){
            label+="#";
        }
        return label;
}
}