package Assignment9;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String and Type Information
 *
 * Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression
 * that checks a sentence to see that it begins with a capital letter and ends with a period.
 * */

public class Main {

    static boolean doesMatch(String str){
        Pattern pattern = Pattern.compile("^[A-Z][^\n]*\\.$"); //or "^[A-Z].*\.$"
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String str = sc.nextLine();
            if(str.equals("quit")){
                break;
            }
            System.out.println(doesMatch(str));
        }
    }
}
