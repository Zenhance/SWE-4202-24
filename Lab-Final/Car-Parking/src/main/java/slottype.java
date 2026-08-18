import java.util.ArrayList;
import java.util.List;

public class slottype {

    private int bsc;
    private int lsc;
    private int rsc;
    private vehicles v;
    private String type;
    public void setBsc(int bc) {
        this.bsc = bc;
    }

    public int getBsc() {
        return this.bsc;
    }
    public void setLsc(int tc) {
        this.lsc = tc;
    }

    public int getLsc() {
        return this.lsc;
    }
   public String popcorn(String ow){
        if(v.check(ow)==9){
            if(bsc!=0){
                bsc--;
                type="BIKE";
            }else if(bsc==0 && rsc!=0){
                rsc--;
                type="REGULAR";
            }else{
                lsc--;
                type="LARGE";
            }
        }if(v.check(ow)==99){

            if( rsc!=0){
               rsc--;
               type="REGULAR";
           }else{
               lsc--;
               type="LARGE";
           }}else{
            lsc--;
            type="LARGE";
       }
        return type;

   }public void setRsc(int mc) {
        this.rsc = mc;
    }

    public int getRsc() {
        return this.rsc;
    }

}
