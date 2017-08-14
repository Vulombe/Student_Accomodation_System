package za.ac.cput.studentaccommodation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Entity
public class Room implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomNumber;
    private int floorNumber;
    @Embedded
    private Booking booking;
    @Embedded
    private RoomType roomType;



    private Room(){}

    public Room(Builder builder)
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
        public Builder copy(Room value)
        {
            this.roomNumber = value.getRoomNumber();
            this.floorNumber = value.getFloorNumber();
            this.booking = value.getBooking();
            this.roomType = value.getRoomType();
            return this;
        }

        public Room build(){return new Room(this);}
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return false;
        if(!(o instanceof Payment)) return false;

        Room room = (Room) o;

        return !(roomNumber != null ? !roomNumber.equals(room.roomNumber) : room.roomNumber != null);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", floorNumber=" + floorNumber +
                ", booking=" + booking +
                ", roomType=" + roomType +
                '}';
    }
}
