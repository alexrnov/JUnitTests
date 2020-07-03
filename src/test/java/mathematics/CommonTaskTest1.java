package mathematics;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тест компонентов (математических методов)
 */
public class CommonTaskTest1 {
    private CommonTask commonTask;
    //минимальное значение(минимальная разница вещественных чисел)
    private static final double DELTA = 1e-15;
    private double numerator;
    private double denominator;

    /*
    Устанавливется перед тестом. Так мы гарантируем, что каждый тест
    работает с известными значениями, а не с промежуточными, изменившимися
    в результате одного из предыдущих тестов.
     */
    @Before
    public void setUp() throws Exception {
        commonTask = new CommonTask();
        numerator = 10;
        denominator = 3;
    }

    /*
    Возврат тестовых параметров после прохождения теста. Это нужно, чтобы
    значения можно было утилизировать при сборке мусора
     */
    @After
    public void tearDown() throws Exception {
        commonTask = null;
        numerator = 0;
        denominator = 0;
    }

    /*
    Выполнение теста. Проверить, правильно ли работает метод для
    вычисления гипотенузы, с различными параметрами округления.
    Так как тестируемый метод возвращает значение вещественного типа,
    необходимо использовать параметр DELTA, показывающий допустимую разницу чисел:
    DELTA = expected value - actual value.
     */

    @Test
    public void hypotenuse() throws Exception {
        double a = 2.0;
        double b = 3.0;
        assertEquals(3.6, commonTask.hypotenuse(a, b, 1), DELTA);
        assertEquals(3.61, commonTask.hypotenuse(a, b, 2), DELTA);
        assertEquals(3.606, commonTask.hypotenuse(a, b, 3), DELTA);
        assertEquals(3.6, commonTask.hypotenuse(a, b, 4), DELTA);
    }

    /*
    Выполнение теста. Проверяет, правильно ли работает метод для определения
    типа числа (простое - непростое). Так как тестируемый метод возвращает
    логическое значение, используются утверждения assertTrue() и assertFalse()
     */
    @Test
    public void isSimpleNumber() throws Exception {
        //простые числа
        assertTrue(commonTask.isPrimeNumber(2));
        assertTrue(commonTask.isPrimeNumber(3));
        assertTrue(commonTask.isPrimeNumber(5));
        //непростые числа
        assertFalse(commonTask.isPrimeNumber(-1));
        assertFalse(commonTask.isPrimeNumber(0));
        assertFalse(commonTask.isPrimeNumber(1));
        assertFalse(commonTask.isPrimeNumber(4));
    }

    @Test
    public void divide() throws Exception {
        assertEquals(3.3, commonTask.divide(numerator, denominator, 1), DELTA);
        assertEquals(3.33, commonTask.divide(numerator, denominator, 2), DELTA);
        assertEquals(3.333, commonTask.divide(numerator, denominator, 3), DELTA);
    }

    /*
    Обработка ожидаемого исключения неверного входного параметра(деление на ноль).
    Для этого к аннотации @Test добавляется опциональный параметр expected
     */
    @Test(expected = IllegalArgumentException.class)
    public void divideWithZeroDenominator() throws Exception {
        denominator = 0;
        commonTask.divide(numerator, denominator,1);
        commonTask.divide(numerator, denominator, 2);
        commonTask.divide(numerator, denominator, 3);
    }

    @Ignore //Игнорировать неуспешный тест
    /*
    Если тест проходит медленее, чем 10 миллисекунд, он считается неуспешным.
    Но этот неуспешный тест будет игнорироваться, т.к. он помечен аннотацией @Ignore
     */
    @Test(timeout = 10)
    public void sumNumbers() throws Exception {
        commonTask.longestCalculation();
    }

    /*
    Тестируется побочный эффект от применения void-метода.
    Т.е. сначала вызывается void-метод changeParameter(),
    затем проверяется на соответсвие значение ParameterForChange,
    которое должен был изменить этот void-метод
     */
    @Test
    public void changeParameter() throws Exception {
        commonTask.changeParameter(10);
        assertEquals(50, commonTask.getParameterForChange());
    }

}