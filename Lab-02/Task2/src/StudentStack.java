public class StudentStack {
/*
a)The speed of push and pop does not depend on how many students are there
the speed is same on both 5 students or 50 students.
b) No , one count can not interfere another count ,
because it has given an instance variable and every object gets its own separate copy
 */

private static final int MAX=50;
private String[] n;
private int []m;
private int cnt;

public StudentStack(){
    n=new String[MAX];
    cnt=0;
    m=new int[MAX];
}
public void push(String name, int mar){
    n[cnt]=name;
    m[cnt]=mar;
    cnt++;
}


}
