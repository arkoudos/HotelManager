package hotelmanagerjava;
import java.util.*;

public class Hotel
{
    int id;
    String name;
    int stars;
    int numberOfRooms;
    ArrayList <Reservation> reservations = new ArrayList<Reservation>();

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}