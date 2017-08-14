package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.ContactAddress;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.domain.StudentValidation;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class ResAdminFactory
{

    public static ResAdmin createResAdminFactory(Map<String,String>
                                                          names,ContactAddress address, StudentValidation validate)
    {
        ResAdmin resAdmin = new ResAdmin.Builder()
                                        .fName(names.get("fName"))
                                        .lName(names.get("lname"))
                                        .contactAddress(address)
                                        .validate(validate)
                                        .build();
        return resAdmin;
    }
}
