package BYN.Exception;

public class NegativeArgumentException extends IllegalArgumentException{
    public NegativeArgumentException(String s, int value) {
        System.out.printf("Field: %s value: %d", s, value);
    }
}
