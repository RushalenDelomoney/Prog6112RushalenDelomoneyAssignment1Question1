/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment1;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class StudentManagerTest {
  private StudentManager studentManager;

    @Before
    public void setUp() {
        studentManager = new StudentManager();
    }

    @Test
    public void testSaveAndSearchStudent() {
        Student student = new Student("1", "jadon sancho", 22, "jadonsancho6@gmail.com", "Computer Science");
        studentManager.saveStudent(student);
        
        Student foundStudent = studentManager.searchStudent("1");
        assertNotNull(foundStudent);
        assertEquals("jadon sancho", foundStudent.getStudentName());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        Student foundStudent = studentManager.searchStudent("2");
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("5", "Paul Pogba", 21, "paulpogba@gmail.com", "Mathematics");
        studentManager.saveStudent(student);

        boolean deleted = studentManager.deleteStudent("5");
        assertTrue(deleted);

        Student deletedStudent = studentManager.searchStudent("5");
        assertNull(deletedStudent);
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        boolean deleted = studentManager.deleteStudent("4");
        assertFalse(deleted);
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        Student student = new Student("7", "Mason Greenwood", 19, "masongreenwood@gmail.com", "History");
        studentManager.saveStudent(student);

        Student foundStudent = studentManager.searchStudent("7");
        assertNotNull(foundStudent);
        assertEquals(19, foundStudent.getStudentAge());
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        Student student = new Student("6", "Sarah Johnson", 17, "sarahjohnson@gmail.com", "Chemistry");
        studentManager.saveStudent(student);
    }

    @Test(expected = NumberFormatException.class)
    public void testStudentAge_StudentAgeInvalidCharacter() {
        Student student = new Student("7", "mason", Integer.parseInt("msn"), "mason@.com", "Geography");
        studentManager.saveStudent(student);
    }
}

