package parking;

/**
 * объект-заглушка применяется в тех случаях, когда нужно заменить
 * реальную реализацию таким объектом, который всякий раз возвращает
 * один и тот же ответ.
 */
public class StubAuto implements Transport {

    @Override
    public String getNumber() {
        return "AA001A"; //всегда возвращается один и тот же объект
    }
}
