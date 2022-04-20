package Assignment11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/sidhaj/Documents/changes.txt");
        Scanner sc = new Scanner(file);
        Map<Character, Integer> map = new HashMap<>();
        while(sc.hasNext()){
            String line = sc.nextLine();
            for(char c:line.toCharArray()){
                map.put(c, (map.get(c)!=null?map.get(c):0)+1);
            }
        }
        File outputFile = new File("output.txt");
        outputFile.createNewFile();
        FileWriter fileWriter = new FileWriter(outputFile.getName());
        fileWriter.write("");
        for(var item: map.entrySet()){
            fileWriter.append(item.getKey()+": "+item.getValue()+"\n");
            System.out.println(item.getKey()+": "+item.getValue());
        }
        fileWriter.close();
//        PrintWriter can also be used to wrtie into files
    }
}
