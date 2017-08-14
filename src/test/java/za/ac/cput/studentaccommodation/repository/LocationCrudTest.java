package za.ac.cput.studentaccommodation.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.LocationFactory;
import za.ac.cput.studentaccommodation.domain.Location;


import java.util.HashMap;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class LocationCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private LocationRepository repository;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String, String>();

        values.put("buildingName", "SouthPoint");
        values.put("city","Woodstock");

        Location location = LocationFactory.createLocation(values, "Long Street", 7925);

        repository.save(location);
        id=location.getLocationID();
        Assert.assertNotNull(location.getLocationID());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Location location = repository.findOne(id);
        Assert.assertNotNull(location.getLocationID());
        Assert.assertEquals(7925, location.getCityCode());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Location location = repository.findOne(id);

        Location newLocation = new Location
                .Builder()
                .copy(location)
                .buildingName("NMJ")
                .build();

        repository.save(newLocation);

        Location updateLocation = repository.findOne(id);
        Assert.assertEquals(updateLocation.getBuildingName(),"NMJ");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Location location = repository.findOne(id);
        repository.delete(location);
        Location deletedLocatin = repository.findOne(id);
        Assert.assertNull(deletedLocatin);
    }
}
