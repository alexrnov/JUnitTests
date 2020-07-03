package parking;

/**
 * Круглосуточный график работы стоянки
 */
public class DayAndNightSchedule  implements ScheduleOfWork {

    @Override
    public void changeKeeper() {
        System.out.println("change keeper at five o'clock");
    }
}
