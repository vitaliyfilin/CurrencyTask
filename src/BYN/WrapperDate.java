package BYN;

import BYN.Exception.PatternArgumentException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WrapperDate {

    private Date date = null;



    public WrapperDate(Date date) {
        this.date = date;
    }

    public WrapperDate(String date) throws ParseException {
        this(parseDate(date));
    }

    private static Date parseDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        Date newDate = simpleDateFormat.parse(date);
        try {
            if (!date.matches("^\\d{2}-\\d{2}-\\d{2}$")) {
                throw new PatternArgumentException("Wrong date");
            }

            return newDate;
        } catch (PatternArgumentException e) {
            throw new PatternArgumentException("Wrong format");
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        String result = simpleDateFormat.format(date);
        return result + "";

    }
}
