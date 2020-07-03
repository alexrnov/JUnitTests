package garden;

/**
 * Класс для деревьев
 */
public class Tree {
    private int amountOak;

    public void oak(int old) throws IllegalArgumentException {
        amountOak = 0;
        if (old <= 0) {
            throw new IllegalArgumentException();
        }
        System.out.println("oak " + old + " years");
        amountOak = 1;
    }

    public int getAmountOak() {
        return amountOak;
    }
}
