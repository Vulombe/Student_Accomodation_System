package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.RoomType;

/**
 * Created by student on 2015/04/28.
 */
public class RoomTypeFactory
{
    public static RoomType createRoomFactory(String status, String type)
    {
        RoomType roomType = new RoomType
                                        .Builder()
                                        .status(status)
                                        .type(type)
                                        .build();
        return roomType;
    }
}
