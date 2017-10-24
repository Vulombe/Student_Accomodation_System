package za.ac.cput.studentaccommodation.restapi.roomtype;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.RoomType;

import java.util.Set;

public class RoomTypeAPI
{
    public static RoomType save(RoomType roomType){
        return RestUtil.save(RoomTypeBaseUrl.RoomType.POST, roomType, RoomType.class);
    }

    public static RoomType findById(String id){
        return RestUtil.getById(RoomTypeBaseUrl.RoomType.GET,id,RoomType.class);
    }
    public static RoomType update(RoomType roomType){
        return RestUtil.update(RoomTypeBaseUrl.RoomType.PUT,roomType);
    }
    public static Set<RoomType> findAll(){
        return RestUtil.getAll(RoomTypeBaseUrl.RoomType.GET_ALL,RoomType.class);
    }
}

