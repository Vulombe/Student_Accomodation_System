package za.ac.cput.studentaccommodation.restapi.studenthomeaddress;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.StudentHomeAddress;

import java.util.Set;

public class StudentHomeAdressAPI {
    public static StudentHomeAddress save(StudentHomeAddress studentHomeAddress){
        return RestUtil.save(StudentHomeAddressBaseUrl.StudentHomeAddress.POST, studentHomeAddress, StudentHomeAddress.class);
    }

    public static StudentHomeAddress findById(String id){
        return RestUtil.getById(StudentHomeAddressBaseUrl.StudentHomeAddress.GET,id,StudentHomeAddress.class);
    }
    public static StudentHomeAddress update(StudentHomeAddress studentHomeAddress){
        return RestUtil.update(StudentHomeAddressBaseUrl.StudentHomeAddress.PUT,studentHomeAddress);
    }
    public static Set<StudentHomeAddress> findAll(){
        return RestUtil.getAll(StudentHomeAddressBaseUrl.StudentHomeAddress.GET_ALL,StudentHomeAddress.class);
    }
}

