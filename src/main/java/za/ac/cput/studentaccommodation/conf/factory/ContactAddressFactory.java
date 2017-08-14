package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.ContactAddress;

/**
 * Created by student on 2015/04/28.
 */
public class ContactAddressFactory
{

    public static ContactAddress createContactAddress(String email, String cellNumber)
    {
        ContactAddress contactAddress = new ContactAddress.Builder(email)
                                                    .cellNumber(cellNumber)
                                                    .build();
        return contactAddress;

    }
}
