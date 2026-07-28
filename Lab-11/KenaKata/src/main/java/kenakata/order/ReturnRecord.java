package kenakata.order;
import kenakata.line.ProductLine;
public class ReturnRecord {
    private ProductLine line;
    private int returnDay;
    private long refundAmount;

    public ReturnRecord(ProductLine line,int returnDay,long refundAmount){
        this.line=line;
        this.returnDay=returnDay;
        this.refundAmount=refundAmount;
    }

    public ReturnRecord(ProductLine line,int returnDay,long refundAmount){
        this.line=line;
        this.returnDay=returnDay;
        this.refundAmount=refundAmount;
    }
    public ProductLine getLine(){
        return line;
    }
    public int getReturnDay(){
        return returnDay;
    }
    public long getRefundAmount(){
        return refundAmount;
    }
}

