package Assignment3;

// ref: https://mkyong.com/java/how-to-execute-shell-command-from-java/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
* Write a java function that will ping any host ( given as input ) and computes
* the median of the time taken to ping.
*
* Use the system ping utility, do not use any deprecated methods.
*/

public class Main {

    static float getMedian(ArrayList<Float> timeArr){
        int n = timeArr.size();
        float median;
        if(n%2==0){
            median = (timeArr.get(n/2) + timeArr.get(n/2-1))/2;
        }else{
            median = timeArr.get(n/2);
        }
        return median;
    }

    static void pingHostAndPrintTimeTaken(String hostName, int numPackets){
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("ping", "-c "+String.valueOf(numPackets), hostName);
        try {

            Process process = processBuilder.start();

            // whenever we are working in single thread and have many string manipulation operations we use StringBuilder
            StringBuilder output = new StringBuilder();
            ArrayList<Float> timeArr = new ArrayList<>();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
                int timeIdx = line.indexOf("time");

                if(timeIdx >-1 && count<numPackets){
//                    System.out.println(line.substring(timeIdx +5, timeIdx +10));
                    float time = Float.parseFloat(line.substring(timeIdx +5, timeIdx +10));
                    timeArr.add(time);
                    count++;
                }
            }

            int exitVal = process.waitFor(); // wait for process to finish
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.out.println("Median: "+getMedian(timeArr));
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hostname: ");
        String hostName = sc.nextLine();
        System.out.print("Enter number of packets to send:");
        int numPackets = sc.nextInt();
        pingHostAndPrintTimeTaken(hostName, numPackets);
    }
}
