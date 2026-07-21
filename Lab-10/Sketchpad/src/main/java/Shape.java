

public abstract class Shape {
    double R,i,j;
    public Shape(double i,double j){
        this.i=i;
        this.j=j;
    }

    public Shape(double R) {
        this.R=R;
    }

    public abstract double area();
    public abstract String describe();
    public abstract void draw(Canvas canvas) throws shapeException;
}
