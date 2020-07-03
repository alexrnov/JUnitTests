package postoffice;

/**
 * Класс для упаковки посылки
 */
public class Packing {
    private Goods goods;
    private Dimension dimension;
    private String typeOfPacking;

    public Packing(Goods goods) {
        this.goods = goods;
    }

    public Packing() {
    }

    public void spotTypeOfPacking() { //определить тип посылки
        dimension = goods.getDimension();
        if (dimension.size() == 0) {
            typeOfPacking = "Envelope";
        } else if (dimension.size() < 10_000){
            typeOfPacking = "Parcel";
        } else {
            typeOfPacking = "Container";
        }
    }

    public String getTypeOfPacking() { //определить тип упаковки
        if (goods.isFragile()) {
            return typeOfPacking + ". Strong pack";
        } else {
            return typeOfPacking + ". Standard pack";
        }
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String labelOfSender(int departureType) { //этикетка отправитель
        return goods.getSender() + ", " + goods.departure(departureType);
    }

}
