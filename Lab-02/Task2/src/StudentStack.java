public class StudentStack {
/*
a)The speed of push and pop does not depend on how many students are there
the speed is same on both 5 students or 50 students.
b) No , one count can not interfere another count ,
because it has given an instance variable and every object gets its own separate copy
 */

private static final int STK=50;
private String[] n;
private int []m;
private int cnt;

public StudentStack(){
    n=new String[STK];
    cnt=0;
    m=new int[STK];
}
public void push(String name, int mar){
    if(cnt==STK){
        System.out.println("ERROR");
    }else {
        n[cnt] = name;
        m[cnt] = mar;
        cnt++;
    }
}
public void pop(){
    if(cnt==0){
        return;
    }
  int tp=cnt-1;
  System.out.println(n[tp]+" "+m[tp]);
  cnt--;
}
public void display(){
    for(int i=0;i<cnt;i++){
        System.out.print(n[i]+" "+m[i]);
    }
}
}
