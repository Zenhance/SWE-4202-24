package Model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = "BASIC";
    }

    public Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = tier;
    }

    public int getId() {
        return id;
    }
  public String getName(){
        return name;
  }
  public int getAge(){
        return age;
  }

  public String getLoyaltyTier(){
        return loyaltyTier;
  }

  public double getTierDiscount(){
        if(loyaltyTier.equals("GOLD")){
            return 0.15;
        } else if (loyaltyTier.equals("SILVER")) {
            return 0.08;
        }else {
            return 0.00;
        }
  }

  public String toString(){
          return name + " (" + age + ") - " + loyaltyTier;
      }

  }



}

private int col;
private double pricePaid;

public Ticket(Showtime showtime, int row, int col, double pricePaid) {
    this.showtime = showtime;
    this.row = row;
    this.col = col;
    this.pricePaid = pricePaid;
}

public Showtime getShowtime() {
    return showtime;
}

public int getRow() {
    return row;
}

public int getCol() {
    return col;
}

public double getPricePaid() {
    return pricePaid;
}

public String toString() {
    return "T" + showtime.getId() + " - R" + row + "C" + col
            + " @ BDT " + String.format("%.2f", pricePaid);
}
}

