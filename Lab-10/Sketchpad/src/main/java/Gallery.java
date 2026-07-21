public class Gallery {
    Canvas c;

    Gallery(Canvas c){
        this.c=c;
    }

    public void add(Shape s){
        if(s.getWidth() > c.width() || s.getHeight() > c.height())
            throw new ShapeTooLarge("Shape too large!");

        if(s.area() > c.capacity())
            throw new ShapeTooSmall("Shape too small");
    }

    public String waiting(){return "idk";}

    public void render(){}
}
