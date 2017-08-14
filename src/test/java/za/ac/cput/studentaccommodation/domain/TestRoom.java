package za.ac.cput.studentaccommodation.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.studentaccommodation.conf.factory.BookingFactory;
import za.ac.cput.studentaccommodation.conf.factory.RoomFactory;
import za.ac.cput.studentaccommodation.conf.factory.RoomTypeFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class TestRoom
{
    String date  = "monday";
    String num = "15";

    Booking booking = BookingFactory.createBooking(date, num);
    @Test
    public void testCreateRoom() throws Exception
    {

        List<Student> students = new ArrayList<Student>();
        String type = "Double";
        String status = "Available";
        RoomType roomType = RoomTypeFactory.createRoomFactory(status,type);
        int floornum = 1;

        Room room = RoomFactory.createRoom(floornum,roomType,booking);

        Assert.assertEquals("Double", roomType.getType());
    }

    @Test
    public void testUpdateRoom() throws Exception {
        List<Student> students = new ArrayList<Student>();
        String type = "Double";
        String status = "Available";
        RoomType roomType = RoomTypeFactory.createRoomFactory(status,type);
        int floornum = 1;

        Room room = RoomFactory.createRoom(floornum,roomType, booking);
        Room newRoom = new Room.Builder().copy(room).floorNumber(2).build();

        Assert.assertEquals("Double", roomType.getType());
        Assert.assertEquals(2, newRoom.getFloorNumber());
        Assert.assertEquals(1, room.getFloorNumber());

    }
}
