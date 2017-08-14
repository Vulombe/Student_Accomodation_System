package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.Booking;

import java.sql.Date;

/**
 * Created by student on 2015/04/28.
 */
public class BookingFactory
{
    public static Booking createBooking(String date, String numOfDays)
    {
        Booking booking = new Booking.Builder().date(date).numOfDays(numOfDays).build();

        return booking;
    }
}
