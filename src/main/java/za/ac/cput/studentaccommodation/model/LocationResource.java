package za.ac.cput.studentaccommodation.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/13.
 */
public class LocationResource extends ResourceSupport
{

    private Long locationID;
    private String buildingName;
    private String city;
    private String street;
    private int cityCode;

    private LocationResource(){}

    public LocationResource(Builder builder)
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

        public Builder copy(LocationResource value)
        {
            this.locationID = value.getLocationID();
            this.buildingName = value.getBuildingName();
            this.city = value.getCity();
            this.street = value.getStreet();
            this.cityCode = value.getCityCode();

            return this;
        }

        public LocationResource build(){return new LocationResource(this);}
    }
}
