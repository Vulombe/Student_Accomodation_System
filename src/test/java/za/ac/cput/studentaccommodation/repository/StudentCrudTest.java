package za.ac.cput.studentaccommodation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.ContactAddressFactory;
import za.ac.cput.studentaccommodation.conf.factory.StudentFactory;
import za.ac.cput.studentaccommodation.conf.factory.StudentHomeAddressFactory;
import za.ac.cput.studentaccommodation.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StudentCrudTest extends AbstractTestNGSpringContextTests
{
    private Long studentID;

    @Autowired
    private StudentRepository repository;

    @Test
    public void create() throws Exception {
        Map<String,String> names = new HashMap<String, String>();
        Map<String,String> values = new HashMap<String, String>();
        List<Payment> payments = new ArrayList<Payment>();
        List<Room> rooms = new ArrayList<Room>();

        String level = "3rd";

        names.put("fName","Vulombe");
        names.put("lName","Makhubele");
        String email = "vmakhubele@gmail.com";
        String cellNumber = "0828139818";
        ContactAddress contactAddress = ContactAddressFactory.createContactAddress(email, cellNumber);
        values.put("province", "Limpompo");
        values.put("city", "Giyani");
        String street = "Dorset";
        String cityCode = "8000";
        StudentHomeAddress address = StudentHomeAddressFactory.createStudentHomeAddressFactory(values,street,cityCode);

        Student student = StudentFactory.createStudent(level, names, contactAddress, address, payments, rooms);

        repository.save(student);
        studentID = student.getStudentID();
        Assert.assertEquals("Vulombe", student.getfName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Student student = repository.findOne(studentID);
        Assert.assertNotNull(student.getStudentID());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Student student = repository.findOne(studentID);
        Student newStudent = new Student.Builder().copy(student).levelOfStudy("4th")
                .build();
        repository.save(newStudent);

        Student updateStudent = repository.findOne(studentID);
        Assert.assertEquals("4th", updateStudent.getLevelOfStudy());

    }

    /*@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Student student = repository.findOne(studentID);
        repository.delete(student);
        Student deleteStudent = repository.findOne(studentID);
        Assert.assertNull(deleteStudent);
    }*/
}
