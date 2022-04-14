package Assignment1;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class Main {

    static File[] getFilesMatchingPattern(String pathname, String regex){
        Pattern pattern = Pattern.compile(regex);
        File directory = new File(pathname);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                Matcher matcher = pattern.matcher(pathname.getName());
                if(matcher.find()){
                    return true;
                }
                return false;
            }
        };
        return directory.listFiles(fileFilter);
    }

    static void printFilePaths(File[] files){
        for(var file: files){
            System.out.println(file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Please enter pathname: ");
            String pathname = sc.nextLine(); // eg: "/home/sidhaj/Documents"
            if(pathname.equals("quit")){
                break;
            }
            System.out.print("Please enter regex: ");
            String regex = sc.nextLine(); // eg: "[a-zA-Z0-9]*.txt"


            File[] files = getFilesMatchingPattern(pathname, regex);
            printFilePaths(files);
        }

//        FilenameFilter ff = new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return false;
//            }
//        };

//        String[] listOfFiles =  f.list(ff);
//        for(var file: listOfFiles){
//            System.out.println(file);
//        }

//        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*.png");
//        Matcher matcher = pattern.matcher("This is some string containing a.png b.png c.jpg d.jpeg e.png");
//        Stream s = matcher.results();
//        System.out.println(s.count());

    }
}
