package za.ac.cput.studentaccommodation.restapi.room;

import za.ac.cput.studentaccommodation.conf.RestUtil;

public class RoomBaseUrl {
    public static class Room{
        public static final String POST    = RestUtil.URL+"/api/ctype/create";
        public static final String GET     = RestUtil.URL+"/api/ctype/";
        public static final String PUT     =RestUtil.URL+"/api/ctype/update";
        public static final String GET_ALL =RestUtil.URL+"/api/ctype/get/ctypes";
    }
}
