package za.ac.cput.studentaccommodation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.studentaccommodation.domain.Booking;
import za.ac.cput.studentaccommodation.domain.RoomType;


/**
 * Created by student on 2015/09/13.
 */
public class RoomResource extends ResourceSupport
{
    private Long roomNumber;
    private int floorNumber;
    private Booking booking;
    private RoomType roomType;



    private RoomResource(){}

    public RoomResource(Builder builder)
    {
        roomNumber = builder.roomNumber;
        floorNumber = builder.floorNumber;
        booking = builder.booking;
        roomType = builder.roomType;

    }

    public Long getRoomNumber() {
        return roomNumber;
    }


    public int getFloorNumber() {
        return floorNumber;
    }



    public Booking getBooking() {
        return booking;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public static class Builder
    {
        private Long roomNumber;
        private int floorNumber;
        private Booking booking;
        private RoomType roomType;

        public Builder roomNumber(Long value)
        {
            this.roomNumber = value;
            return this;
        }

        public Builder booking(Booking value)
        {
            this.booking = value;
            return this;
        }

        public Builder floorNumber(int value)
        {
            this.floorNumber = value;
            return this;
        }



        public Builder roomType(RoomType value)
        {
            this.roomType = value;
            return this;
        }
        public Builder copy(RoomResource value)
        {
            this.roomNumber = value.getRoomNumber();
            this.floorNumber = value.getFloorNumber();
            this.booking = value.getBooking();
            this.roomType = value.getRoomType();
            return this;
        }

        public RoomResource build(){return new RoomResource(this);}
    }
}
