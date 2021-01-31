package lesson1.enums;

public class DayOfWeekMain {

    private final static int WORKING_HOURS_PER_DAY = 8;

    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
    }

    private static String getWorkingHours (DayOfWeek day) {
        String result;
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            result = "Сегодня выходной";
        } else {
            result = ((DayOfWeek.values().length - day.ordinal() - 2) * WORKING_HOURS_PER_DAY) + " часов";
        }
        return result;
    }
}
