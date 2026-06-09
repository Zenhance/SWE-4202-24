public abstract class Notice {
    protected Recipient r;
    protected String txt;

    public Notice (r, txt){
        if(r == null || r.isBlank()){
            throw new IllegalArgumentException("No recipient");
        if(txt == null || txt.isBlank())
            throw new IllegalArgumentException("No text");
        }
        this.txt = txt;
        this.r = r;
    }

    public abstract String deliver();

    public abstract double cost();

}
