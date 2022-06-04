package BYN;

import BYN.Exception.CsvLineException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class WrapperEntry {
    private final WrapperDate date;
    private final Purchase purchase;

    public WrapperEntry(WrapperDate date, Purchase purchase) {
        this.date = date;
        this.purchase = purchase;

    }

    public WrapperDate getDate() {
        return date;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public static WrapperEntry getValidEntry(String csv) throws CsvLineException, ParseException {
        String[] values = csv.split(";", 2);
        if (values.length < 2) {
            throw new CsvLineException("");

        }
        WrapperDate date = new WrapperDate(values[0]);
        Purchase purchase = PurchasesFactory.getPurchaseFromFactory(values[1]);
        return new WrapperEntry(date, purchase);
    }

    public static Weekday getDayOfWeek(String date) throws ParseException {
        String[] values = date.split(";", 2);
        try {

            return Weekday.values()[LocalDate.parse(values[0], DateTimeFormatter.ofPattern("yy-MM-dd")).getDayOfWeek().getValue()-1];
        } catch (ArrayIndexOutOfBoundsException | DateTimeParseException e) {
            //throw new CsvLineException("");
return null;
        }

    }
    public static Purchase getPurchaseList (String csv) {
        String[] values = csv.split(";", 2);
        if (values.length < 2) {
            throw new CsvLineException("");
        }
        Purchase purchase = PurchasesFactory.getPurchaseFromFactory(values[1]);
        return purchase;
    }

    @Override
    public String toString() {
        return "WrapperEntry{" +
                "date=" + date +
                ", purchase=" + purchase +
                '}';
    }
}