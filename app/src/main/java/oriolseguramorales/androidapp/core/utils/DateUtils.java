package oriolseguramorales.androidapp.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    static final String DATE_FORMAT = "dd/MM";
    static final String DATE_STRING_FORMAT = "dd/MM/YYYY";

    public static CharSequence formatDate(Date date) {
        return android.text.format.DateFormat.format(DATE_FORMAT, date);
    }

    public static Date dateFromString(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_STRING_FORMAT);
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_STRING_FORMAT);
        return format.format(date);
    }
}
