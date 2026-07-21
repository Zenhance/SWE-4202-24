public abstract class Shape {
    int i,j;
    double R;
    public Shape(int i,int j){
        this.i=i;
        this.j=j;
    }

    public Shape(double R) {
        this.R=R;
    }
    public Shape(int i){
        this.i=i;
    }

    public abstract double area();
    public abstract String describe();
    public abstract void draw(Canvas canvas) throws shapeException;
}
