public class Outbox {
    private Message[] notices;
    private int count;
    public Outbox(){
        notices= new Message[100];
        count = 0;
    }
    public void enqueue(Message notice){
        notices[count++]=notice;
    }
public void enqueue(Message notice, int repeat){
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
public String flush(){
    String result = "";
for (int i=0;i<count;i++){
    result += notices[i].deliver()+"\n";
}
count = 0;
return result;
}
    public int size(){
        return count;
    }
}
