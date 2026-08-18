public enum Slot {BIKE(10,5,0),
    REGULAR(30,20,15),
    LARGE(50,40,25);
   private int firsthour;
    private int furtherhours;
  private   int surcharge;
    Slot(int firsthour, int furtherhours, int surcharge) {
        this.firsthour = firsthour;
        this.furtherhours = furtherhours;
        this.surcharge = surcharge;
    }

    public int getFirsthour() {
        return firsthour;
    }

    public int getFurtherhours() {
        return furtherhours;
    }

    public int getSurcharge() {
        return surcharge;
    }
}
