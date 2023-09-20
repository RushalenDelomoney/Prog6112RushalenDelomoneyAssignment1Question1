/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lab_services_student
 */
public class StudentManager {
 private List<Student> students = new ArrayList<>();

    public void saveStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
  //Above a loop was used to perform through the students list and compare the studentId of each student.
    public boolean deleteStudent(String studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equals(studentId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}    

