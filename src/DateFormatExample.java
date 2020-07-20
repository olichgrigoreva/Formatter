import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("y-MM-d hh:m:s");
        System.out.println(sdf.format(date));
        
        try {
            date = sdf.parse("2020-07-16 7:54:16");
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
