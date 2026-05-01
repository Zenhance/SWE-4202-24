public class StudentQueue {
    /*
a)each dequeue shifts all element , if we have 50 elements , in first case , we shift 49 elements , then 48 . It goes on like this , the total shifting will be more than 1000
b)because the array is private  , the outside code can not access it, each class control how the array is used
 */
    private static final int p=50;
    private String n[];
    private int []m;
    private int cnt;

    public StudentQueue(){
        n =  new String[p];
        m = new int[p];
        cnt=0;
    }
    public void eq(String name , int mark){
        if(cnt==p){
            System.out.print("FULL");
        }else {
            n[cnt]=name;
            m[cnt]=mark;
            cnt++;
        }
    }
    public void dq(){
        if(cnt==0){
            System.out.print("Emty");
            return ;
        }else {
            System.out.println(n[0] +" " +m[0]);
         for (int i=0;i<cnt-1;i++){
             n[i]=n[i+1];
             m[i]=m[i+1];

         }
         cnt--;
        }
    }

    public void front (){
        if(cnt==0){
            return ;
        }else {
          System.out.println(n[0]+" "+m[0]) ;
        }
    }

    public  void display(){
        for (int i = 0; i < cnt; i++) {
            System.out.println(n[i] + " " + m[i]);
        }
    }

    public static void main(String[] args){
        
    }





}
