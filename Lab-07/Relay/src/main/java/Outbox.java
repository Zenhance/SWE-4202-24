public class Outbox {
    private Notice[] notices;
    private int count;
    public Outbox(){
        notices= new Notice[100];
        count = 0;
    }
    public void enqueue(Notice notice){
        notices[count++]=notice;
    }
}
public void enqueue(Notice notice,int repeat){
    for(int i=0;i<repeat;i++){
        notices[count++]=notice;
    }
}
public int waiting(){
    return count;
}
public double totalCost(){
    double total=0;
    for(int i=0;i<count;i++){
        total+=notices[i].cost();
    }
    return total;
}
