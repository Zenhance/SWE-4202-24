public class StudentStack {
    private String[] name=new String[50];
    private double[] mark=new double[50];
    private int count;

    StudentStack (String name,double mark){
        this.name=name;
        this.mark=mark;
        this.count =0;
    }

}
