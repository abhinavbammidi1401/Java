import java.util.*;
import java.util.TreeMap;
import java.util.Scanner;

public class component{
    private static TreeMap<String, Integer> studentMap = new TreeMap<>();

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Welcome to Student Manager: ");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            System.out.println("Select an Option: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateGrade(scanner);
                    break;
                case 4:
                    removeStudent(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid Choice: ");
            }
        }
    }
    public static void addStudent(Scanner scanner){
        System.out.println("Enter the student's name: ");
        String name = scanner.next();

        System.out.println("Enter the Student's grade: ");
        int grade = scanner.nextInt();

        studentMap.put(name, grade);
        System.out.println("Student added successfully.");
    }
    
    private static void viewStudents(){
        System.out.println("List of Students: ");
        for(var entry : studentMap.entrySet()){
            System.out.println("Name: " + entry.getKey() + ", Grade: " + entry.getValue());
        }

    }
    private static void updateGrade(Scanner scanner){
        System.out.println("Enter Student's name to update Grade: ");
        String name = scanner.next();

        if (studentMap.containsKey(name)){
            System.out.println("Grade: " + studentMap.get(name));

            System.out.println("Enter new grade: ");
            int newGrade = scanner.nextInt();

            studentMap.put(name, newGrade);
            System.out.println("Grade updated sucessfully.");
        }
        else{
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent(Scanner scanner){
        System.out.println("Enter Student's name to remove: ");
        String name = scanner.next();

        if(studentMap.containsKey(name)){
            studentMap.remove(name);
            System.out.println("Student removed.");
        }
        else{
            System.out.println("Student not found.");
        }

    }
    public static void searchStudent(Scanner scanner){
        System.out.println("Enter the student's name: ");
        String name = scanner.next();

        if(studentMap.containsKey(name)){
            System.out.println("Student Found - Name: " + name + ", Grade: " + studentMap.get(name));
        }
        else{
            System.out.println("Student not found.");
        }
    }
}