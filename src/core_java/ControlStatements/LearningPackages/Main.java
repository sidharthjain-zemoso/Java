package core_java.ControlStatements.LearningPackages;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCost = 0;
        int packageNo, numCourses = 0;
        int numIncluded, costPerCourse, packageCost;
        System.out.println("Package 1: $10/month includes 2 courses per month.\nEach additional course is $6\n");
        System.out.println("Package 2: $12/month includes 4 courses per month.\nEach additional course is $4\n");
        System.out.println("Package 3: $15/month includes 6 courses per month.\nEach additional course is $3\n");
        System.out.print("Enter your package (1, 2 or 3): ");
        packageNo = sc.nextInt();
        System.out.print("Enter number of courses taken this month: ");
        numCourses = sc.nextInt();
        switch (packageNo){
            case 1:
                numIncluded = 2;
                costPerCourse = 6;
                packageCost = 10;
                break;
            case 2:
                numIncluded = 4;
                costPerCourse = 4;
                packageCost = 12;
                break;
            case 3:
                numIncluded = 6;
                costPerCourse = 3;
                packageCost = 15;
                break;
            default:
                numIncluded = 0;
                costPerCourse = 0;
                packageCost = 0;
        }
        if(numCourses>numIncluded){
            totalCost = packageCost +  (numCourses-numIncluded)*costPerCourse;
        }
        System.out.println("Your total cost is: "+totalCost);
    }
}
