package za.ac.cput.studentaccommodation.restapi.booking;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.Booking;

import java.util.Set;

public class BookingAPI {
    public static Booking save(Booking booking){
        return RestUtil.save(BookingBaseUrl.Booking.POST, booking, Booking.class);
    }

    public static Booking findById(String id){
        return RestUtil.getById(BookingBaseUrl.Booking.GET,id,Booking.class);
    }
    public static Booking update(Booking booking){
        return RestUtil.update(BookingBaseUrl.Booking.PUT,booking);
    }
    public static Set<Booking> findAll(){
        return RestUtil.getAll(BookingBaseUrl.Booking.GET_ALL,Booking.class);
    }
}

