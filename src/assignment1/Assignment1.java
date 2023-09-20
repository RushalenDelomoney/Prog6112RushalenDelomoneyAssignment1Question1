/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
//scanner is used as represented in the assignment brief
        while (true) {
            System.out.println(" MY STUDENT MANAGEMENT APPLICATION");
            System.out.println("****************************");
            System.out.println(" PLEASE ENTER (1) TO LAUNCH THE  MENU AND IF YOU WISH TO EXIT PLEASE INPUT ANOTHER COMMAND");
            String input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("THE APPLICATION WILL NOW BE CLOSING.GOODBYE");
                break;
            }
            showMenu(studentManager, scanner);
        }
        scanner.close();
    }
    //Based on the loop above 
    //The loop starts by displaying a header and menu options for the student management application.
    //The loop hints the user to enter a choice by reading input from the scanner object.
    //So if the user anything besides 1 the loop will exit and it will display the message that says goodbye
    //If the user inputs 1 then the showMenu is called upon.
   

    private static void showMenu(StudentManager studentManager, Scanner scanner) {
        while (true) {
            System.out.println("PLEASE SELECT ONE OF THE FOLLOWING MENU ITEMS:");
            System.out.println("(1) Captures a new student");
            System.out.println("(2) Search for a student");
            System.out.println("(3) Deletes a student");
            System.out.println("(4) Prints a student report");
            System.out.println("(5) Exits the application");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    captureNewStudent(studentManager, scanner);
                    break;
                case "2":
                    searchStudent(studentManager, scanner);
                    break;
                case "3":
                    deleteStudent(studentManager, scanner);
                    break;
                case "4":
                    printStudentReport(studentManager);
                    break;
                case "5":
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void captureNewStudent(StudentManager studentManager, Scanner scanner) {
        System.out.println(" You are now able to capture a new student,please fill in the details below.");
        System.out.println("*******************************");
        System.out.print(" Please enter the student id: ");
        String studentId = scanner.nextLine();
        System.out.print(" Please enter the student name: ");
        String studentName = scanner.nextLine();
        int studentAge;
        while (true) {
            try {
                System.out.print(" Please enter the students age: ");
                studentAge = Integer.parseInt(scanner.nextLine());
                if (studentAge >= 16) {
                    break;
                } else {
                    System.out.println(" ERROR.You have entered an incorrect student age. The student must be 16 or older.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Your input is INVALID!. Please enter a valid age.");
            }
        }
        System.out.print(" Please enter the student email: ");
        String studentEmail = scanner.nextLine();
        System.out.print("Please enter the student course: ");
        String studentCourse = scanner.nextLine();
        //prints the messagesguiding the user on what details are required.
        

        Student newStudent = new Student(studentId, studentName, studentAge, studentEmail, studentCourse);
        studentManager.saveStudent(newStudent);
        System.out.println(" The students details have been successfully saved and captured.");
    }
    //This method take the student manager object and a scanner object for user input 
    //It hints the user and prompts them to fill in thye details of a new student.
    //Scanner is used because we use it to read the user input for student id, name ,age and email.
    // whilke loop is used when keeing track of students age.
    

    private static void searchStudent(StudentManager studentManager, Scanner scanner) {
        System.out.print(" Please enter the student id to search for the student: ");
        String searchId = scanner.nextLine();

        Student foundStudent = studentManager.searchStudent(searchId);

        if (foundStudent != null) {
            System.out.println("------------------------------------");
            System.out.println("Student ID: " + foundStudent.getStudentId());
            System.out.println("Student Name: " + foundStudent.getStudentName());
            System.out.println("Student Age: " + foundStudent.getStudentAge());
            System.out.println("Student Email: " + foundStudent.getStudentEmail());
            System.out.println("Student Course: " + foundStudent.getStudentCourse());
            System.out.println("------------------------------------");
        } else {
            System.out.println("Student with student ID " + searchId + " not found.");
        }
    }
     //StudentManager  is the object used object and is asking and searching for the student while the ccanner object is used to get input from the user.
    private static void deleteStudent(StudentManager studentManager, Scanner scanner) {
        System.out.print("Please enter the students id to delete their information: ");
        String deleteId = scanner.nextLine();

        if (studentManager.deleteStudent(deleteId)) {
            System.out.println("Student with student ID " + deleteId + " was deleted.");
        } else {
            System.out.println("Student with student ID " + deleteId + " not found.");
        }
    }
    //The scanner object is used to get an input from the user.
    //The method prompts the user to enter a student ID to delete their information.
    

    private static void printStudentReport(StudentManager studentManager) {
        List<Student> students = studentManager.getAllStudents();

        System.out.println("Student Report");
        System.out.println("----------------------------------");

        int studentCount = 1;
        for (Student student : students) {
            System.out.println("Student " + studentCount);
            System.out.println("-------------------------------");
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Student Age: " + student.getStudentAge());
            System.out.println("Student Email: " + student.getStudentEmail());
            System.out.println("Student Course: " + student.getStudentCourse());
            System.out.println("----------------------------------");
            studentCount++;
        }
    }
    //Methods are used to get a list of students using get all studentsand student manager as the object.

    private static void exitApplication() {
        System.out.println("You are now exiting.GOODBYE");
        System.exit(0);
    }
}    
 
