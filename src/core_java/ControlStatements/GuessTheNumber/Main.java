package core_java.ControlStatements.GuessTheNumber;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randomNumber = new Random().nextInt(100)+1;
        System.out.print("Enter your guess: ");
        int userInput = sc.nextInt();
        while(userInput!=randomNumber){
            if(userInput>randomNumber){
                System.out.println("Your guess is high");
            }else{
                System.out.println("Your guess is low");
            }
            System.out.print("Enter your guess: ");
            userInput = sc.nextInt();
        }
        System.out.println("Congratulations!! You guessed it right..");
    }
}
