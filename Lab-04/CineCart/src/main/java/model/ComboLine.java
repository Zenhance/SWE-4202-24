package model;

public class ComboLine extends LineItem(){
private ConcessionItem itemA;
private ConcessionItem itemB;

public Comboline(ConcessionItem itemA, ConcessionItem itemB) {
    this.itemA = itemA;
    this.itemB = itemB;
}

public String describe() {
    return qty + "x " + item.getName();
}

public String describe() {
    return itemA.getName() + " + " + itemB.getName() + " Combo";
}

public String describe() {
    return itemA.getName() + " + " + itemB.getName() + " Combo";
}
        }