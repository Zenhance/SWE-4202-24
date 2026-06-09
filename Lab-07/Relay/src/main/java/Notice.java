public abstract class Notice{
    protected final Recipent recipent;
    protected final String text;

    protected Notice (Recipent recipent , String text){
        this.recipent=recipent;
        this.text=text;
    }
    public abstract String deliver;
    public abstract double price();
    public abstract String describe();
}