public class PriorityEmailMessage extends Message{
    public Recipient r;
    public String body;
    public PriorityEmailMessage(Recipient r,String body){
        super(r,body);
    }
    double cost=0.0;
    public String deliver(){
        return super.deliver();
    }
    public double cost() {
        return super.cost();
    }
}
