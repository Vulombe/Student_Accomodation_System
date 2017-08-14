package za.ac.cput.studentaccommodation.services;

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
import za.ac.cput.studentaccommodation.repository.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/29.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StudentServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    StudentService studentService;

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
        StudentHomeAddress address = StudentHomeAddressFactory.createStudentHomeAddressFactory(values, street, cityCode);

        Student student = StudentFactory.createStudent(level, names, contactAddress, address, payments, rooms);

        repository.save(student);
        studentID = student.getStudentID();
        Assert.assertEquals("Vulombe", student.getfName());
    }
}
