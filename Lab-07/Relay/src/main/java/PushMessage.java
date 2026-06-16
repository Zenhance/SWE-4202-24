public class PushMessage extends Message {

public PushMessage(Recipient r,String body){
    super(r,body);
}
    public String deliver(){
        return super.deliver();
    }
    public double cost() {
        return super.cost();
    }

}
