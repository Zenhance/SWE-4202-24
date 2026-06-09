public abstract class Notice {
    protected  Recipient r;
    protected  String msg;
    public Notice(Recipient r,String msg){
        if ( msg == null || msg.isBlank () )
            throw new IllegalArgumentException (" Message is required .") ;
        this.msg=msg;
        this.r=r;
    }
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
