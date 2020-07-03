package postoffice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/*
 Демонстрация подставного объекта, который можно считать предварительно
 программируемой заглушкой или суперзаглушкой. Работать с подставным
 объектом очень просто — вы подготавливаете его к применению,
 сообщаете ему, какую последовательность вызовов следует ожидать,
 а также указываете, как нужно реагировать на каждый конкретный вызов.
*/
public class PackingTest {
    private Packing packing;

    @Before
    public void setUp() throws Exception {
       packing = new Packing();
    }

    @After
    public void tearDown() throws Exception {
       packing = null;
    }

    /**
     * Тест проверяет класс почтовой упаковки для груза.
     * В этом классе агрегирован еще один класс: Goods (Груз).
     * В свою очередь класс Goods тоже агрегирует класс
     * Dimension(Размер груза). Чтобы имулировать поведение
     * классов Goods и Dimension используются подставные объекты (моки)
     */
    @Test
    public void typePacking() throws Exception {
        Goods mockGoods = mock(Goods.class); //подставной объект для груза
        //подставной объект для размера груза
        Dimension mockDimension = mock(Dimension.class);
        when(mockDimension.size()).thenReturn(0); //вернуть объем груза
        //вместо объекта груза возвращается подставной объект
        when(mockGoods.getDimension()).thenReturn(mockDimension);
        //вернуть логическую переменную для типа упаковки
        when(mockGoods.isFragile()).thenReturn(false);
        packing.setGoods(mockGoods);//передать мок тестируемому объекту
        packing.spotTypeOfPacking();//определить тип упаковки
        assertEquals("Envelope. Standard pack", packing.getTypeOfPacking());

        when(mockDimension.size()).thenReturn(9999); //вернуть объем груза
        //вернуть логическую переменную для типа упаковки
        when(mockGoods.isFragile()).thenReturn(true);
        packing.spotTypeOfPacking();//определить тип упаковки
        assertEquals("Parcel. Strong pack", packing.getTypeOfPacking());

        when(mockDimension.size()).thenReturn(10_000); //вернуть объем груза
        //вернуть логическую переменную для типа упаковки
        when(mockGoods.isFragile()).thenReturn(false);
        packing.spotTypeOfPacking();//определить тип упаковки
        assertEquals("Container. Standard pack", packing.getTypeOfPacking());
    }

    //тест для метода sender() класса почтовой упаковки
    @Test
    public void sender() throws Exception {
        Goods mockGoods = mock(Goods.class);//подставной объект для груза
        when(mockGoods.getSender()).thenReturn("Sender: Name Surname");
        //Если метод имеет какие-то аргументы, но Вам всё равно, что будет
        //в них передано или предсказать это невозможно, то используйте anyInt()
        //(и альтернативные значения для других типов)
        when(mockGoods.departure(anyInt())).thenReturn("standard departure");
        packing.setGoods(mockGoods);
        assertEquals("Sender: Name Surname, standard departure",
                     packing.labelOfSender(0));
        //в этом вызове мы проверяем, что packing совершает вызов getSender() во
        //вложенном mockGoods
        verify(mockGoods).getSender();
        //в этом вызове мы проверяем, что packing совершает вызов departure() во
        //вложенном mockGoods
        verify(mockGoods).departure(anyInt());

        when(mockGoods.departure(anyInt())).thenReturn("quickly departure");
        assertEquals("Sender: Name Surname, quickly departure",
                    packing.labelOfSender(1));
    }

}