package za.ac.cput.studentaccommodation.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.studentaccommodation.conf.factory.LocationFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class TestLocation
{
    @Test
    public void testCreateLocation() throws Exception
    {

        Map<String,String> values = new HashMap<String, String>();

        values.put("buildingName", "SouthPoint");
        values.put("city","Woodstock");

        Location location = LocationFactory.createLocation(values, "Long Street", 7925);

        Assert.assertEquals(7925, location.getCityCode());

    }

    @Test
    public void testUpdateLocation() throws Exception
    {
        Map<String,String> values = new HashMap<String, String>();

        values.put("buildingName", "SouthPoint");
        values.put("city","Woodstock");

        Location location = LocationFactory.createLocation(values, "Long Street", 7925);
        Location newLocation  = new Location.Builder().copy(location).buildingName("NMJ")
                .build();
        Assert.assertEquals("NMJ", newLocation.getBuildingName());
        Assert.assertEquals("SouthPoint", location.getBuildingName());

    }

}
