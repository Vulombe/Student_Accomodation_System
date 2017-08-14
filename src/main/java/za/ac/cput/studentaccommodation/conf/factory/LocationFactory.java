package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.Location;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class LocationFactory
{

    public static Location createLocation(Map<String,String> values, String street, int cityCode)
    {
        Location location = new Location.Builder()
                                        .buildingName(values.get("buildingName"))
                                        .city(values.get("city"))
                                        .street(street)
                                        .cityCode(cityCode)
                                        .build();
        return location;
    }
}
