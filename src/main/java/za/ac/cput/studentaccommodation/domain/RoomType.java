package za.ac.cput.studentaccommodation.domain;

import javax.persistence.Embeddable;

/**
 * Created by student on 2015/04/28.
 */
@Embeddable
public class RoomType
{
    private String status;
    private String type;

    private RoomType()
    {}

    public RoomType(Builder builder)
    {
        status = builder.status;
        type = builder.type;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public static class Builder{
        private String status;
        private String type;

        public Builder status(String value)
        {
            this.status = value;
            return this;
        }

        public  Builder type(String value)
        {
            this.type = value;
            return this;
        }

        public Builder copy(RoomType value)
        {
            this.status = value.getStatus();
            this.type = value.getType();
            return this;
        }

        public RoomType build(){return new RoomType(this);}

    }
}
