package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.*;

import java.awt.event.ContainerAdapter;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class StudentFactory
{

   public static Student createStudent(String level, Map<String,String> names,
                                        ContactAddress contactAddress, StudentHomeAddress address, List<Payment> payments,
                                       List<Room> rooms)
    {
        Student student = new Student
                .Builder()
                .levelOfStudy(level)
                .fName(names.get("fName"))
                .lName(names.get("lName"))
                .contactAddress(contactAddress)
                .address(address)
                .payments(payments)
                .rooms(rooms)
                .build();
        return student;

    }
}
