package za.ac.cput.studentaccommodation.restapi.location;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.Location;

import java.util.Set;

public class LocationAPI {
    public static Location save(Location location){
        return RestUtil.save(LocationBaseUrl.Location.POST, location, Location.class);
    }

    public static Location findById(String id){
        return RestUtil.getById(LocationBaseUrl.Location.GET,id,Location.class);
    }
    public static Location update(Location location){
        return RestUtil.update(LocationBaseUrl.Location.PUT,location);
    }
    public static Set<Location> findAll(){
        return RestUtil.getAll(LocationBaseUrl.Location.GET_ALL,Location.class);
    }
}

