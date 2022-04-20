package Assignment8;

public class ShorterLengthException extends Exception
{
    public ShorterLengthException(String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}