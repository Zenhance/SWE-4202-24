package model;

public class Cart {
    public static final int MAX_LINES=50;

    private final Customer owner;
    private final LineItem[] lines;

    private int count;

    public Cart(Customer owner){
        this.owner=owner;
        lines= new LineItem[MAX_LINES];
        count=0;
    }

    public Customer getOwner(){
        return owner;
    }

    public boolean add(LineItem line){
        if(count>=MAX_LINES){
            return false;
        }
        lines[count]=line;
        count++;

        return true;
    }

    public boolean add(ConcessionItem item,int qty){
        return add(new ConcessionLine(item,1));
    }

    public LineItem[] getLines(){
        LineItem[] copy = new LineItem[count];
        for(int i=0;i<count;i++){
            copy[i]=lines[i];
        }
        return copy;
    }
     public int getCount(){
        return count;
     }

     public double grandSubtotal(){
        double sum=0;
        for(int i=0;i<count;i++){
            sum+=lines[i].subtotal();
        }
        return sum;
     }

     public int ticketCount(){
        int total=0;
        for(int i=0;i<count;i++){
            if(lines[i].isTicket()){
                total++;
            }
        }
        return total;
     }

     public boolean hasCode(String code){
        for(int i=0;i<count;i++){
            if(lines[i].hasCode(code)){
                return true;
            }
        }
        return false;
     }
}
