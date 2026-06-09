public class SMS extends Notice{

    public SMS(Recipent recipent ,String text){

        super(recipent,text);
    }
    public int getsegment(){
        if(text==null || text.isEmpty())
            return 0;
        return (int)  Math.ceil((double) text.length()/160);
    }
    @Override
    public String deliver(){
        return text +" sent via message in "+ getSegmentCount() + "Segments";
    }
    @Override
    public double cost() {
        return getSegmentCount() *costPerSegment;
    }}