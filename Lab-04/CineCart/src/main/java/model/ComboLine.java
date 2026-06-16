package model;

public class ComboLine extends LineItem(){
private ConcessionItem itemA;
private ConcessionItem itemB;

public Comboline(ConcessionItem itemA, ConcessionItem itemB) {
    this.itemA = itemA;
    this.itemB = itemB;
}

public String describe() {
    return qty + "x " + itemA.getName();
}

public String describe(){
    return qty + "x " + itemB.getName();
}
}