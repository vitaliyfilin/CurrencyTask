package BYN.Exception;

public class PatternArgumentException extends IllegalArgumentException{
    public PatternArgumentException(String s) {
        System.out.println("Pattern doesn't match");
    }
}
