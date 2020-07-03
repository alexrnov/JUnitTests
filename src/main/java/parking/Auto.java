package parking;

import java.util.Random;

public class Auto implements Transport {
    private String number;
    private Random r = new Random(System.currentTimeMillis());

    /**
     * Возвращает случайный автомобильный номер
     * @return автомобильный номер
     */
    @Override
    public String getNumber() {
        char c1 = (char)(r.nextInt(26) + 'A');
        char c2 = (char)(r.nextInt(26) + 'A');
        char c3 = (char)(r.nextInt(26) + 'A');
        int n1 = /*min value + */ (int)(Math.random() * 10);
        int n2 = /*min value + */ (int)(Math.random() * 10);
        int n3 = /*min value + */ (int)(Math.random() * 10);
        return "" + c1 + c2 + n1 + n2 + n3 + c3;
    }
}
