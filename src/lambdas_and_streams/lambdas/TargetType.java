package lambdas_and_streams.lambdas;

public class TargetType {
    public interface Email{
        String constructEmail(String name);
    }

    public String getEmail(String name, Email email){
        return email.constructEmail(name);
    }

    public static void main(String[] args) {
        TargetType obj = new TargetType();
        Email emailImplementor = name -> name.toLowerCase()+"@zemosolabs.com";
        String name = "Sidharth";
        String email = obj.getEmail(name, emailImplementor);
        System.out.println(email);
    }
}
