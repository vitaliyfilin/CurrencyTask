package BYN.Exception;

public class NonpositiveArgumentException extends IllegalArgumentException{
    public NonpositiveArgumentException(String s, int value) {
        System.out.printf("Field: %s value: %d", s, value);
    }
}
