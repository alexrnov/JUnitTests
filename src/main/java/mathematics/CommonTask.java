package mathematics;



public class CommonTask {

    private int parameterForChange = 5;

    /**
     * Вычисляет гипотенузу прямоугольного треугольника
     * @param a первый катет
     * @param b второй катет
     * @param rounding округление - количество знаков после запятой
     * @return гипотенуза
     */
    public double hypotenuse(double a, double b, int rounding) {
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        double r = 10;
        if (rounding == 2) {
            r = 100;
        } else if (rounding == 3) {
            r = 1000;
        }
        return Math.round(c * r) / r;
    }

    /**
     * Определяет, является ли число простым
     * @param number число
     * @return <code>true</code> если число является простым,
     * <code>false</code> - в обратном случае
     */
    public boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= number-1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Выполняет деление числителя(numerator) на знаменатель(denominator)
     * @param numerator числитель
     * @param denominator знаменатель
     * @param rounding округление - количество знаков после запятой
     * @return результат деления
     * @throws IllegalArgumentException
     */
    public double divide(double numerator, double denominator, int rounding)
            throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        double d = numerator/denominator;
        double r = 10;
        if (rounding == 2) {
            r = 100;
        } else if (rounding == 3) {
            r = 1000;
        }
        return Math.round(d * r) / r;
    }

    /**
     * Этот метод демонстрирует пример долгих вычислений.
     */
    public void longestCalculation() {
        long startTime = System.currentTimeMillis();
        double sum = 0;
        for (int i = 0; i < 10000000; i ++) {
            sum = sum + i;
            sum = Math.sqrt(sum);
            sum = Math.pow(sum,2);
        }
        System.out.println("sum = " + sum);
        long spentTime = System.currentTimeMillis() - startTime;
        System.out.println(spentTime);
    }

    /**
     * Метод просто умножает закрытую переменную экземпляра
     * parameterForChange на число i
     * @param i //множитель
     */
    public void changeParameter(int i) {
        parameterForChange *= i;
    }

    public int getParameterForChange() {
        return parameterForChange;
    }

    public double percentsFromNumber(double number, double percents) {
        double p = (number * percents) / 100.0;
        return p;
    }
}
