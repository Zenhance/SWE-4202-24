public class StudentQueue {
    private String[] name = new String[50];
    private int[] mark = new int[50];
    private int count = 0;

    public void enqueue(String name,int mark){
             this.name[count]=name;
             this.mark[count]=mark;
    }

}