package Assignment12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* 1. Print the name of all departments in the college?
2.Get the names of all students who have enrolled after 2018?
3. Get the details of all male student in the computer sci department?
4. How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)
5.What is the average age of male and female students?
6.Get the details of highest student having highest percentage ?
7.Count the number of students in each department? (Hint :use Collectors.groupingBy())
8. What is the average percentage achieved in each department?
9. Get the details of youngest male student in the Electronic department?(Hint :Use Collectors.minBy)
10.How many male and female students are there in the computer science department?
* */

public class StreamDemo {
    ArrayList<Student> students;

    StreamDemo(){
        this.students = new ArrayList<>();
        Student.loadData(this.students);
    }

    public static void printStream(Stream stream){
        stream.forEach(System.out::println);
    }

    private Stream<String> getEngDepartments() {
        return students.stream().map(Student::getEngDepartment);
    }

    private Stream<String> getStudentNamesEnrolledAfter(int year) {
        return students.stream().filter(s -> s.isEnrolledAfter(year)).map(Student::getName);
    }

    private Stream<Student> getMaleStudentsOfDept(String dept){
        return students.stream().filter(s -> Objects.equals(s.getEngDepartment(), dept)).filter(Student:: isMale);
    }

    private void maleAndFemaleCount(){
        students.stream().collect(Collectors.groupingBy(Student::getGender)).forEach((s, students1) -> System.out.println(s+": "+students1.size()));;
    }

    private void maleAndFemaleAgeAverage(){
        students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge))).forEach((gender, ageAverage) -> System.out.println(gender+": "+ageAverage));
    }

    private Student studentWithHighestPerc(){
        return students.stream().min(Student::compareTo).get();
    }

    private void numStudentsInEachDept(){
        students.stream().collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.counting())).forEach((dept, count) -> System.out.println(dept+": "+count));
    }

    private void averagePercInEachDept(){
        students.stream().collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.averagingDouble(Student::getPercentTillDate))).forEach((dept, avgPercentage) -> System.out.println(dept+": "+avgPercentage));
    }

    private Student youngestMaleStudentInDept(String dept){
        return students.stream().filter(student -> student.getEngDepartment().equals(dept)).min((o1, o2) -> o2.getAge()<o1.getAge()?1:o1.getAge()==o2.getAge()?0:-1).get();
    }

    private void maleAndFemaleCountIn(String dept){
        students.stream().filter(student -> student.getEngDepartment().equals(dept)).collect(Collectors.groupingBy(Student::getGender, Collectors.counting())).forEach((gender, count) -> System.out.println(gender+": "+count));
    }

    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();

        System.out.println("Engineering Depts:");
        printStream(streamDemo.getEngDepartments());

        System.out.println("\nStudents enrolled after 2018:");
        printStream(streamDemo.getStudentNamesEnrolledAfter(2018));

        System.out.println("\nMale students of CS:");
        printStream(streamDemo.getMaleStudentsOfDept("Computer Science"));

        System.out.println("Male and female count:");
        streamDemo.maleAndFemaleCount();

        System.out.println("Male Female Age average:");
        streamDemo.maleAndFemaleAgeAverage(); // male age sum: 195, female: 107

        System.out.println("Student with highest percentage:");
        System.out.println(streamDemo.studentWithHighestPerc());

        System.out.println("Number of students in each dept:");
        streamDemo.numStudentsInEachDept();

        System.out.println("Average Perc in each dept:");
        streamDemo.averagePercInEachDept();

        System.out.println("Youngest Male Students in Electronic dept:");
        System.out.println(streamDemo.youngestMaleStudentInDept("Electronic"));

        System.out.println("Male and female count in CS:");
        streamDemo.maleAndFemaleCountIn("Computer Science");
    }
}
