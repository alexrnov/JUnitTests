package parking;

import java.util.HashMap;
import java.util.Map;

public class AllocationOfPlace {
    public final int amountPlaces = 100;
    private Map<Integer, String> places;
    private ScheduleOfWork scheduleOfWork;

    public AllocationOfPlace(ScheduleOfWork scheduleOfWork) {
        this.scheduleOfWork = scheduleOfWork;
        places = new HashMap<>();
        for (int i = 0; i < amountPlaces; i++) {
            places.put(i, "");
        }
    }

    public void registration(Transport auto) {
        if (!hasFreePlaces()) {
            return; //выйти, поскольку на стоянке больше нет свободных мест
        }

        String number = auto.getNumber();

        if (isAutoRegister(number)) {
            return; //выйти, поскольку машина с таким номером уже зарегистрирована
        }
        /*
        Найти самое близкое свободное парковочное место (с пустым значением
        и ключем с наименьшим целым значением)
         */
        places.entrySet()
              .stream()
              .filter(e -> e.getValue().equals("")) //отобрать элементы с пустыми значениями
              .findFirst() //взять первый найденный элемент
              .map(k -> k.setValue(number)); //и для него заменить значение

    }

    /**
     * Возвращает количесвто свободных мест
     * @return свободные места
     */
    public int amountFreePlaces() {
        long f = places.entrySet()
                       .stream()
                       .filter(e -> e.getValue().equals(""))
                       .count(); //подсчитать количество элементов с пустыми значениями
        return (int)f;
    }

    /**
     * Проверяет, остались ли на стоянке свободные места
     * @return <code>true</code> - если есть свободные места,
     * <code>false</code> - в обратном случае
     */
    public boolean hasFreePlaces() {
        boolean b = places.entrySet()
                .stream() //если есть хоть один элемент с пустым значением - вернуть true
                .anyMatch(e -> e.getValue().equals(""));
        return b;
    }

    /**
     * Проверяет, зарегистрирован ли уже автомобиль
     * @return <code>true</code> - если автомобиль уже зарегистрирован
     * на стоянке, <code>false</code> - в обратном случае
     */
    public boolean isAutoRegister(String number) {
        boolean b = places.entrySet()
                          .stream()
                          .anyMatch(e -> e.getValue().equals(number));
        return b;
    }

    public void print() {
        places.forEach((k, v) -> {
            System.out.println("k = " + k + " v = " + v);
        });
    }
}
