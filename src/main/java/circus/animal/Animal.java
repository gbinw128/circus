package circus.animal;

import circus.Asset;

public abstract class Animal implements Asset {
    protected int purchasePrice;

    public abstract String speak();

//    public int getValue() {
//        return purchasePrice;
//    }
}
