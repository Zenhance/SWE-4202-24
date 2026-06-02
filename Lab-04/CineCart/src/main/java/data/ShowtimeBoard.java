package data;

import model.Showtime;

public class ShowtimeBoard {
    Showtime[] shows;
    int count=0;
    static final int MAX=30;
    public ShowtimeBoard(){
        shows=new Showtime[MAX];
    }
   public void add(Showtime s){
          shows= new Showtime[MAX];
          if(count<MAX){
              count++;
          }
   }

  public Showtime findById(int id){
       for(int i=0;i<count;i++){
           if(shows[i].getId()==id){
               return shows[i];
           }
       }return null;
   }
   public void displayAll(){
       for(int i=0;i<count;i++){
           System.out.println(shows[i].toString());
       }
   }
}
