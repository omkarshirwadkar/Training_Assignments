// package ClassWork.Feb05;
import java.time.*;
import static java.time.Month.*;
import java.util.*;

public class DateAndTimeDemo {
    public static void main(String[] args) throws Exception{
        // LocalDate date = LocalDate.now();
        // System.out.println("Current Date: " + date);
        // LocalTime time = LocalTime.now();
        // System.out.println("Current Time: " + time);
        // for (int i = 0; i < 10; i++) {
        //     LocalDateTime dateTime = LocalDateTime.now();
        //     System.out.println("Current Date and Time: " + dateTime);
        //     Thread.sleep(1000);
        // }
        // LocalDateTime dateTime = LocalDateTime.now();
        // System.out.println(dateTime.withMonth(Month.NOVEMBER.getValue()));

        // // SEPTEMBER can only be passed if import static java.time.Month.* is imported
        // LocalDate date1 = LocalDate.of(2020, SEPTEMBER, 29);

        // // LocalDate date2 = LocalDate.of(2020, 9, 29); // --> This Works
        // // LocalDate date2 = LocalDate.of(2020, Month.NOVEMBER, 29); // --> This Works
        // System.out.println("Date: " + date1);

        Set <String> dates = ZoneId.getAvailableZoneIds();
        dates.forEach(System.out:: println);
        
        LocalTime time1 = LocalTime.now(ZoneId.of("America/New_York"));
        System.out.println("New York Time: " + time1);
        LocalTime time2 = LocalTime.now(ZoneId.of("Europe/London"));
        System.out.println("London Time: " + time2);
        LocalTime time3 = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Kolkata Time: " + time3);
    }
}
