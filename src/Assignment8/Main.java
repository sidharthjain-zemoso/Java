package Assignment8;

public class Main {
    boolean isValidTitle(String title) throws InvalidTitleException, ShorterLengthException, LongerLengthException {
        if(title.length() ==0 || title.contains("<") || title.contains(">")){
            throw new InvalidTitleException("Invalid Title");
        }else if(title.length() < 6){
            throw new ShorterLengthException("Title is too short");
        }else if(title.length() > 30){
            throw new LongerLengthException("Title is too long");
        }
        return true;
    }
    public static void main(String[] args) throws InvalidTitleException, LongerLengthException, ShorterLengthException {
        Main obj = new Main();
        try{
//            obj.isValidTitle("<this is invalid>");
//            obj.isValidTitle("Exceptions");
//            obj.isValidTitle("some long string to make sure LongerLengthException is thrown");
            obj.isValidTitle(null); // will throw null pointer exception
        }catch (Exception e){
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        finally {
            System.out.println("This will execute irrespective of error");
        }
        System.out.println("Rest of the code");
    }
}
