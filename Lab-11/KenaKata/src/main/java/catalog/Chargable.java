package catalog;

public interface Chargable {
    int unitCharge();
    int unitVat();
    int commissionOn(int kiyerinuputnojani);
    boolean returned();

}
