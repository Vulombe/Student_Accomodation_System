package za.ac.cput.studentaccommodation.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.studentaccommodation.conf.factory.ContactAddressFactory;
import za.ac.cput.studentaccommodation.conf.factory.StudentFactory;
import za.ac.cput.studentaccommodation.conf.factory.StudentHomeAddressFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/24.
 */
public class TestStudent
{
    List<Payment> payments = new ArrayList<Payment>();
    List<Room> rooms = new ArrayList<Room>();

    @Test
    public void testStudent() throws Exception {
        Map<String,String> names = new HashMap<String, String>();
        Map<String,String> values = new HashMap<String, String>();

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

        Assert.assertEquals("Vulombe", student.getfName());

    }


    @Test
    public void testStudentUpdate() throws Exception {
        Map<String,String> names = new HashMap<String, String>();
        Map<String,String> values = new HashMap<String, String>();




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

        Student newStudent = new Student
                                .Builder()
                                .copy(student)
                                .levelOfStudy("4th")
                                .build();
        Assert.assertEquals("Vulombe", newStudent.getfName());
        Assert.assertEquals("Makhubele", newStudent.getlName());
        Assert.assertEquals("4th", newStudent.getLevelOfStudy());
        Assert.assertEquals("3rd", student.getLevelOfStudy());
    }
}
