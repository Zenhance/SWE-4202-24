private class Meter{

    private int opening;
    private int closing;

    public Meter(int opening,int closing){

        if(opening<0)
            throw new IllegalArgumentException("Illegal value for opening reading");
        if(closing<opening)
            throw new IllegalArgumentException("Illegal value for closing reading");
        this.opening=opening;
        this.closing=closing;

    }

    public int getUnitsConsumed(){
        return closing-opening;


    }



}