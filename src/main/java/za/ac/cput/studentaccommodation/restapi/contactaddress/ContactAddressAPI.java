package za.ac.cput.studentaccommodation.restapi.contactaddress;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.ContactAddress;

import java.util.Set;

public class ContactAddressAPI {
    public static ContactAddress save(ContactAddress contactAddress){
        return RestUtil.save(ContactAddressBaseUrl.ContactAddress.POST, contactAddress, ContactAddress.class);
    }

    public static ContactAddress findById(String id){
        return RestUtil.getById(ContactAddressBaseUrl.ContactAddress.GET,id,ContactAddress.class);
    }
    public static ContactAddress update(ContactAddress contactAddress){
        return RestUtil.update(ContactAddressBaseUrl.ContactAddress.PUT,contactAddress);
    }
    public static Set<ContactAddress> findAll(){
        return RestUtil.getAll(ContactAddressBaseUrl.ContactAddress.GET_ALL,ContactAddress.class);
    }
}

