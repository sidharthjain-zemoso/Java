package Assignment7.First.Rodents;

public class Main {
    public static void main(String[] args) {
        Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};
        for(Rodent rodent: rodents){
            rodent.defaultMethod();
            rodent.whoAmI();
            System.out.println();
        }
    }
}
