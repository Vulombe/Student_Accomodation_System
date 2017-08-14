package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.Booking;
import za.ac.cput.studentaccommodation.domain.Room;
import za.ac.cput.studentaccommodation.domain.RoomType;
import za.ac.cput.studentaccommodation.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class RoomFactory
{

    public static Room createRoom(int floorNumber, RoomType roomType, Booking booking)
    {
        Room room = new Room.Builder()
                            .roomType(roomType)
                            .floorNumber(floorNumber)
                            .booking(booking)
                            .build();
        return room;
    }
}
