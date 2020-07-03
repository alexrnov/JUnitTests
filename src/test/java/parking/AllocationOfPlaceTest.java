package parking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * При тестировании используется три типа тестовых двойников:
 * пустой объект (пустышка)
 * объект-заглушка
 * mock-объект (подставной)
 *
 * Не используется только поддельный объект. Поддельный объект можно
 * считать улучшенной заглушкой, которая работает практически так же,
 * как и ваш готовый код, но кое-где упрощает функционал, чтобы
 * соответствовать тестовым требованиям. Поддельные объекты особенно
 * удобны в тех случаях, когда вы хотите протестировать код по отношению
 * к какой-то программе, очень напоминающей реальную стороннюю подсистему
 * или зависимость, которую придется задействовать в реальном продукте.
 */
public class AllocationOfPlaceTest {
    private AllocationOfPlace allocation;

    @Before
    public void setUp() throws Exception {
        /*
        здесть применяется объект-пустышка new EmptySchedule(),
        поскольку этот объект на данной позиции не используется
         */
        allocation = new AllocationOfPlace(new EmptySchedule());
    }

    @After
    public void tearDown() throws Exception {
        allocation = null;
    }

    @Test
    public void amountFreePlaces() throws Exception {
        //проверить количество свободных мест
        assertEquals(allocation.amountPlaces, allocation.amountFreePlaces());

        //после добавления машины, проверить количество свободных мест
        //в данном случае, неважно какой номер, поэтому используется класс-заглушка
        Transport auto1 = new StubAuto();//класс-заглушка
        allocation.registration(auto1);//добавить машину
        assertEquals(allocation.amountPlaces - 1, allocation.amountFreePlaces());

        //после попытки добавления машины с тем же номером, количество свободных мест
        //не должно сократиться
        allocation.registration(auto1);
        assertEquals(allocation.amountPlaces - 1, allocation.amountFreePlaces());
        //allocation.print();
    }

    /*
    Демонстрация подставного объекта, который можно считать предварительно
    программируемой заглушкой или суперзаглушкой. Работать с подставным
    объектом очень просто — вы подготавливаете его к применению,
    сообщаете ему, какую последовательность вызовов следует ожидать,
    а также указываете, как нужно реагировать на каждый конкретный вызов.
     */
    @Test
    public void hasFreePlaces() throws Exception {
        Transport auto = mock(Transport.class); //подставной объект
        //заполнить стоянку машинами - для этого используются mock-объекты,
        //имеющие разные номера
        for (int i = 0; i < 100; i++) {
            //когда нужно получить номер(when) - возвращается новый результат(thenReturn)
            if (i < 10) {
                when(auto.getNumber()).thenReturn("AA" + "00" + i + "A");
                allocation.registration(auto);
            } else {
                when(auto.getNumber()).thenReturn("AA" + "0" + i + "A");
                allocation.registration(auto);
            }
        }
        //на стоянке не должно остаться свободных мест
        assertFalse(allocation.hasFreePlaces());
        //allocation.print();
    }
}