public class vehicles {
   private final String meow;
   private final String chocolate;
   private int h;;

    public vehicles(String meow, String chocolate) {
        this.meow = meow;
        this.chocolate = chocolate;
        this.h=0;
    }
    public int check(String ow){
        if(ow.equals("BIKE")){
            return 9;
        }
        if(ow.equals("CAR")){
            return 99;
        }
       else
        return 999;
    }

    public String getMeow() {
        return this.meow;
    }

    public String getChocolate() {
        return this.chocolate;
    }

    public void addh(int hh){
        this.h+=hh;
    }
    public int discount(int bill){
        if(chocolate.equals("NONE")){
            return bill;
        }
        if(chocolate.equals("STUDENT")){
            return bill-((20*bill)/100);
        }
       else
            return Math.max(0,bill-10);

    }

}
