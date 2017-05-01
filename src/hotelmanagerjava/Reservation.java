package hotelmanagerjava;

import java.util.*;

public class Reservation
{
    String name;
    Date checkinDate;
    int stayDurationDays;

    //getters
    public String getName() {
        return name;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public int getStayDurationDays() {
        return stayDurationDays;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public void setStayDurationDays(int stayDurationDays) {
        this.stayDurationDays = stayDurationDays;
    }
}
