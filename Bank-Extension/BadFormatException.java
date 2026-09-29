import java.util.InputMismatchException;

public class BadFormatException extends InputMismatchException
{
    public BadFormatException()
    {
        super();
    }

    public BadFormatException(String message)
    {
        super(message);

    }

}