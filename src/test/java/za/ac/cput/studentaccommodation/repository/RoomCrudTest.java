package za.ac.cput.studentaccommodation.repository;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.*;
import za.ac.cput.studentaccommodation.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RoomCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    String date  = "monday";
    String num = "15";

    Booking booking = BookingFactory.createBooking(date,num);
    @Autowired
    private RoomRepository repository;
    @Test
    public void create() throws Exception
    {

        String type = "Double";
        String status = "Available";


        RoomType roomType = RoomTypeFactory.createRoomFactory(status, type);
        int floornum = 1;

        Room room = RoomFactory.createRoom(floornum, roomType,booking);

        repository.save(room);
        id=room.getRoomNumber();
        Assert.assertNotNull(room.getRoomNumber());

        Assert.assertEquals("Double", roomType.getType());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Room room = repository.findOne(id);
        Assert.assertNotNull(room);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {


        Room room = repository.findOne(id);

        Room newRoom = new Room.Builder().roomNumber(room.getRoomNumber())
                                .floorNumber(2)
                                .copy(room)
                                .booking(booking)
                                .build();
        repository.save(newRoom);
        Room updateRoom = repository.findOne(id);
        Assert.assertEquals(1,updateRoom.getFloorNumber());

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Room room = repository.findOne(id);
        repository.delete(room);
        Room deleteRoom = repository.findOne(id);
        Assert.assertNull(deleteRoom);
    }
}
