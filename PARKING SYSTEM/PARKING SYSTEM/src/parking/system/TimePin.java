
package parking.system;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class TimePin {
    //time function
    public static int Time() {
        LocalTime t = LocalTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh");
        String timem = t.format(f);
        int time = Integer.parseInt(timem);
        return time;
    }

    public static String Time3() {
        LocalTime t = LocalTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm");
        String time = t.format(f);
        // String time=Integer.parseInt(timem);
        return time;
    }

    public static int Time2() {
        LocalTime t = LocalTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("mm");
        String timem = t.format(f);
        int time = Integer.parseInt(timem);

        return time;
    }

//Pin genarate  
    public static int pin() {

        int rand = (int) (int) ((Math.random() * 100000 + Math.random() * 100000 + Math.random() * 100000) * 9999);
        return rand;
    }

}
