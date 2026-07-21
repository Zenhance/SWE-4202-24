public abstract class Shape{
    public abstract double area();
    public String describe(){
        return getClass().getSimpleName()+ "(Area= "+area()+")";
    }
public abstract void draw(Canvas canvas) throws ShapeDrawException;
}