package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.StudentHomeAddress;

import java.util.Map;

/**
 * Created by student on 2015/04/28.
 */
public class StudentHomeAddressFactory
{
    public static StudentHomeAddress createStudentHomeAddressFactory(
            Map<String, String> values,
            String street, String cityCode)
    {
        StudentHomeAddress studentHomeAddress = new StudentHomeAddress
                .Builder()
                .province(values.get("province"))
                .city(values.get("city"))
                .street(street)
                .cityCode(cityCode)
                .build();
        return studentHomeAddress;
    }
}
