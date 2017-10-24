package za.ac.cput.studentaccommodation.restapi.booking;

import za.ac.cput.studentaccommodation.conf.RestUtil;

public class BookingBaseUrl {
    public static class Booking{
        public static final String POST    = RestUtil.URL+"/api/ctype/create";
        public static final String GET     = RestUtil.URL+"/api/ctype/";
        public static final String PUT     =RestUtil.URL+"/api/ctype/update";
        public static final String GET_ALL =RestUtil.URL+"/api/ctype/get/ctypes";
    }
}
