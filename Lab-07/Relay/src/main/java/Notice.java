public abstract class Notice {
    Recipient r;
    String txt;

    public Notice (r, txt){
        if(r == null || r.isBlank()){
            throw new IllegalArgumentException("No recipient");
        if(txt == null || txt.isBlank())
            throw new IllegalArgumentException("No text");
        }
        this.txt = txt;
        this.r = r;
    }
}
