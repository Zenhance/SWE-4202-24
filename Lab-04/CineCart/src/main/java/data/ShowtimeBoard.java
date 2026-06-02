package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[]  shows;
    private int count;
    private static final int MAX=30;

    public ShowtimeBoard(){
        shows= new Showtime[MAX];
        count=0;  /* Whenever an array is called, it needs to be initialized inside a constructor.
        and also, the count/any variable that will keep the track of the size of the array
        will have to kept and initialized to 0 inside the constructor. And, then, before doing
        search on the made array, you need to first fill up the arary, like the way we used to do in C*/
    }

    public void add(Showtime s){
       if(count<MAX){
           shows[count]=s;
           count++;
       }
    }

    public Showtime findById(int id){

         for(int i=0; i<count; i++){
             if(shows[i].getId()==id){
                  return shows[i];
             }
         }

         return null;
    }


    public void displayALL(){
        String movie;
        for(int i=0; i<count; i++){
            movie=shows[i].toString();
            System.out.println(movie);

        }
    }


}
