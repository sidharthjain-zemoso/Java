package core_java.ControlStatements.DiceSimulation;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int dieRoll;
        for (int i = 0; i < 10; i++) {
            dieRoll = random.nextInt(6)+1;
            System.out.println(dieRoll);
        }
    }
}
