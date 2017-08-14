package za.ac.cput.studentaccommodation.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.studentaccommodation.conf.factory.ContactAddressFactory;
import za.ac.cput.studentaccommodation.conf.factory.ResAdminFactory;
import za.ac.cput.studentaccommodation.conf.factory.StudentValidationFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class TestResAdmin
{
    String studID = "1";
    int numOfSubjects = 3;
    int sum = 190;
    double avg = sum/numOfSubjects;
    StudentValidation validate = StudentValidationFactory.createStudentValidation(studID, avg,numOfSubjects,sum);

    @Test
    public void testCreateResAdmin() throws Exception {
        Long empID = 21425147L;
        Map<String,String> names = new HashMap<String, String>();

        names.put("fName","Jackson");
        names.put("lName","Davids");
        String email = "smale@v.com";
        String cellNum = "081147514";

        ContactAddress contactAddress = ContactAddressFactory.createContactAddress(email,cellNum);
        ResAdmin resAdmin = ResAdminFactory.createResAdminFactory(names, contactAddress,validate);

        Assert.assertEquals("smale@v.com", contactAddress.getEmail());
    }

    @Test
    public void testUpdateResAdmin() throws Exception {
        //Long empID = 21425147L;
        Map<String,String> names = new HashMap<String, String>();

        names.put("fName","Jackson");
        names.put("lName","Davids");
        String email = "smale@v.com";
        String cellNum = "081147514";

        ContactAddress contactAddress = ContactAddressFactory.createContactAddress(email,cellNum);
        ResAdmin resAdmin = ResAdminFactory.createResAdminFactory(names, contactAddress, validate);

        ContactAddress newContact = new ContactAddress.Builder(email).copy(contactAddress).cellNumber("084747147")
                                        .build();

        ResAdmin newResAdmin = new ResAdmin.Builder().copy(resAdmin).contactAddress(newContact)
                                .build();

        Assert.assertEquals("Jackson", newResAdmin.getfName());
        Assert.assertEquals("081147514", contactAddress.getCellNumber());
        Assert.assertEquals("084747147", newContact.getCellNumber());

    }
}
