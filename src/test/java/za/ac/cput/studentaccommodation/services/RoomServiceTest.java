package za.ac.cput.studentaccommodation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.BookingFactory;
import za.ac.cput.studentaccommodation.conf.factory.RoomFactory;
import za.ac.cput.studentaccommodation.conf.factory.RoomTypeFactory;
import za.ac.cput.studentaccommodation.domain.Booking;
import za.ac.cput.studentaccommodation.domain.Room;
import za.ac.cput.studentaccommodation.domain.RoomType;
import za.ac.cput.studentaccommodation.repository.RoomRepository;

/**
 * Created by ashdyani on 2015/05/29.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RoomServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    RoomService roomService;

    private Long id;
    String date  = "monday";
    String num = "15";

    Booking booking = BookingFactory.createBooking(date, num);
    @Autowired
    private RoomRepository repository;
    @Test
    public void create() throws Exception
    {

        String type = "Double";
        String status = "Available";


        RoomType roomType = RoomTypeFactory.createRoomFactory(status, type);
        int floornum = 1;

        Room room = RoomFactory.createRoom(floornum, roomType, booking);

        repository.save(room);
        id=room.getRoomNumber();
        Assert.assertNotNull(room.getRoomNumber());

        Assert.assertEquals("Double", roomType.getType());
    }
}
