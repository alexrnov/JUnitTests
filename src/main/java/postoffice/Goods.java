package postoffice;

/**
 * интерфейс для груза
 */
public abstract class Goods {
    private Dimension dimension;
    private boolean isFragile;
    private String sender;

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = "Sender:" + sender;
    }

    public String departure(int departureType) {
        if (departureType == 0) {
            return "standard departure";
        } else {
            return "quickly departure";
        }
    }

}
