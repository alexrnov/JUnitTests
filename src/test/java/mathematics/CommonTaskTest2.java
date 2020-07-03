package mathematics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) //параметризированный тест компонена
public class CommonTaskTest2 {
    //минимальное значение(минимальная разница вещественных чисел)
    private static final double DELTA = 1e-15;
    CommonTask commonTask;
    private double expectedResult;
    private double number;
    private double percents;

    //через конструктор загружаются параметры тесты
    public CommonTaskTest2(double expectedResult, double number, double percents) {
        this.expectedResult = expectedResult;
        this.number = number;
        this.percents = percents;
    }

    @Before
    public void setUp() throws Exception {
        commonTask = new CommonTask();
    }

    @After
    public void tearDown() throws Exception {
        commonTask = null;
    }

    /*
    Набор входных параметров. Тест будет прогоняться пять раз (т.к. в списке
    параметров пять элементов). Тестируется метод по вычислению процентов от
    числа percentsFromNumber(number, percents). Возьмем третий элемент массива параметров:
    Здесь параметры обозначают следующее: 13.0 % от 80 бутет 10.4.
    Все параметры загружаются в тест через конструктор.
    */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Double[][] {{50.0, 100.0, 50.0}, {25.0, 50.0, 50.0},
                {10.4, 80.0, 13.0}, {3038.49, 4823.0, 63.0}, {3.15, 50.0, 6.3}});
    }

    /*
    Пять раз тестируется метод percentsFromNumber(). Каждое тестирование
    происходит с новыми параметрами
     */
    @Test
    public void percents() {
        assertEquals(expectedResult, commonTask.percentsFromNumber(number, percents), DELTA);
    }
}