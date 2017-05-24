package hotelmanagerjava;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

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
    
    public static void addHotel()
    {
        Hotel newHotel = new Hotel();
        newHotel.setId(Integer.parseInt(JOptionPane.showInputDialog(null,"Hotel ID:","Hotel ID",JOptionPane.QUESTION_MESSAGE)));
        newHotel.setName(JOptionPane.showInputDialog(null,"Hotel name:","Hotel Name.",JOptionPane.QUESTION_MESSAGE));
        newHotel.setNumberOfRooms(Integer.parseInt(JOptionPane.showInputDialog(null, "How many rooms?", "Hotel Rooms",JOptionPane.QUESTION_MESSAGE)));
        newHotel.setStars(Integer.parseInt(JOptionPane.showInputDialog(null, "Hotel stars:", "Hotel Stars",JOptionPane.QUESTION_MESSAGE)));
        FileManager.hotelList.add(newHotel);
        
        while(JOptionPane.YES_OPTION== JOptionPane.showConfirmDialog(null, "Do you want to add a reservation?","Reservation",JOptionPane.YES_NO_OPTION))
        {
            Reservation newRes = new Reservation();
        
        newRes.setName(JOptionPane.showInputDialog(null, "Name of reservation:","Reservation Name", JOptionPane.QUESTION_MESSAGE));
        
        Date date;
        
        try
        {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog(null, "Date of reservation(dd/MM/yyyy):","Reservation Date",JOptionPane.QUESTION_MESSAGE));
            newRes.setCheckinDate(date);
        }catch(HeadlessException  e)
        {
            e.printStackTrace();
        }catch(ParseException e)
        {
            CreateMenu.output.append("Wrong Date Format.\n");
        }
        
        newRes.setStayDurationDays(Integer.parseInt(JOptionPane.showInputDialog(null, "Days for the reservation:", "Reservation Days", JOptionPane.QUESTION_MESSAGE)));
        
        newHotel.reservations.add(newRes);
        }
        CreateMenu.output.append("Hotel have been successfully added.\n");
    }
}