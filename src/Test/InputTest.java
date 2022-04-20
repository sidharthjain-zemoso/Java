package Test;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest {
    public static void main(String[] args) throws IOException {
        char a = (char)System.in.read(); //read from standard input (keyboard) and returns ascii value as int
        System.out.println(a);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        int i = inputStreamReader.read();
        System.out.println(i);
        char[] charStream = new char[15];
        inputStreamReader.read(charStream);
        System.out.println();
        for(char c:charStream){
            System.out.print(c);
        }
    }
}
