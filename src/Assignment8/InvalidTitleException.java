package Assignment8;

public class InvalidTitleException extends Exception
{
    public InvalidTitleException(String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}
