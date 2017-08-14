package za.ac.cput.studentaccommodation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/16.
 */
@Entity
public class Location implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationID;
    private String buildingName;
    private String city;
    private String street;
    private int cityCode;

    private Location(){}

    public Location(Builder builder)
    {
        locationID = builder.locationID;
        buildingName = builder.buildingName;
        city = builder.city;
        street = builder.street;
        cityCode = builder.cityCode;
    }

    public Long getLocationID() {
        return locationID;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getCityCode() {
        return cityCode;
    }

    public static class Builder
    {
        private Long locationID;
        private String buildingName;
        private String city;
        private String street;
        private int cityCode;

        public Builder locationID(Long value)
        {
            this.locationID = value;
            return this;
        }

        public Builder buildingName(String value){
            this.buildingName = value;
            return  this;
        }

        public Builder city(String value)
        {
            this.city = value;
            return this;
        }

        public Builder street(String value)
        {
            this.street = value;
            return this;
        }

        public Builder cityCode(int value)
        {
            this.cityCode = value;
            return this;
        }

        public Builder copy(Location value)
        {
            this.locationID = value.getLocationID();
            this.buildingName = value.getBuildingName();
            this.city = value.getCity();
            this.street = value.getStreet();
            this.cityCode = value.getCityCode();

            return this;
        }

        public Location build(){return new Location(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (!locationID.equals(location.locationID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return locationID.hashCode();
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", buildingName='" + buildingName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", cityCode=" + cityCode +
                '}';
    }
}
