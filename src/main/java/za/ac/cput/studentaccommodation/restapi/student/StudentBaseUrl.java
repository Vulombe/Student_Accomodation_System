package za.ac.cput.studentaccommodation.restapi.student;

import za.ac.cput.studentaccommodation.conf.RestUtil;

public class StudentBaseUrl
{
    public static class Student{
        public static final String POST    =RestUtil.URL+"/api/ctype/create";
        public static final String GET     = RestUtil.URL+"/api/ctype/";
        public static final String PUT     =RestUtil.URL+"/api/ctype/update";
        public static final String GET_ALL =RestUtil.URL+"/api/ctype/get/ctypes";
    }

}
