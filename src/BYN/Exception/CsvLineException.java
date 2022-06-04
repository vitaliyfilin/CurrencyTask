package BYN.Exception;

public class CsvLineException extends IllegalArgumentException {
    public CsvLineException(String s) {
        super(s);
    }

    public CsvLineException(int length) {
        super(String.valueOf(length));
    }
}
