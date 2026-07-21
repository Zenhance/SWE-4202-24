public abstract class Shape {

    protected double height;
    protected double width;
    public Shape(double height, double width){
        if(height <= 0.0 || width  <= 0.0)
            throw new ShapeException("Invalid size!");
        this.height = height;
        this.width = width;
    }

    public abstract int area();

    public String describe(){
        return "Area: "+area();
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}

/*
    1. Which class is abstract, and why nobody may construct it.
    Ans: Shape is an abstract class. Nobody may not construct is because a shape as itself,
         as an indefinite entity does not make sense in real life, we must specify WHAT exact
         shape it might be.

    2. Which parent class you left concrete, and why.
    Ans: We left Rectangle (parent class of Square) concrete because Rectangle itself can be
         an independent shape on its own, if we make it abstract... we won't be able to
         construct it.

    3. One method you overrode even though the parent implemented it, and why.
    4. One method you deliberately did not override, and why.
*/
