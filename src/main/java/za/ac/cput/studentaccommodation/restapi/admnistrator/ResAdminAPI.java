package za.ac.cput.studentaccommodation.restapi.admnistrator;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.ResAdmin;

import java.util.Set;

public class ResAdminAPI {
    public static ResAdmin save(ResAdmin contentType){
        return RestUtil.save(ResAdminBaseUrl.ResAdmin.POST, contentType, ResAdmin.class);
    }

    public static ResAdmin findById(String id){
        return RestUtil.getById(ResAdminBaseUrl.ResAdmin.GET,id,ResAdmin.class);
    }
    public static ResAdmin update(ResAdmin contentType){
        return RestUtil.update(ResAdminBaseUrl.ResAdmin.PUT,contentType);
    }
    public static Set<ResAdmin> findAll(){
        return RestUtil.getAll(ResAdminBaseUrl.ResAdmin.GET_ALL,ResAdmin.class);
    }
}

