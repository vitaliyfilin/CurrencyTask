package BYN.Exception;

public class OutofRangeException extends IllegalArgumentException{
    public OutofRangeException(String s, int value) {
        System.out.printf("Field: %s value: %d", s, value);
    }
}
