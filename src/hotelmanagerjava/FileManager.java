package hotelmanagerjava;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileManager
{
    static ArrayList<Hotel>hotelList=new ArrayList<Hotel>();
    static int numberOfHotels;
    
    public static ArrayList<Hotel> readFile() throws ParseException
    {
        
        try
        {
            
            String lineReader;
            String[] lineR;
            //FileReader readFile = new FileReader("C:\\Users\\Mike\\Documents\\NetBeansProjects\\HotelManagerJava\\src\\hotelmanagerjava\\Data.csv");
            FileReader readFile = new FileReader(Main.filePath);
            BufferedReader br = new BufferedReader(readFile);
            
            //read the first line
            lineReader = br.readLine();
            lineR= lineReader.split(";");
            numberOfHotels = Integer.parseInt(lineR[0]);
            //System.out.println("Number Of Registers: " + numberOfHotels);
            
            for(int i=0;i<numberOfHotels;i++)
            {
                lineReader = br.readLine();
                lineR = lineReader.split(";");
                Hotel temp = new Hotel();
                temp.setId(Integer.parseInt(lineR[0]));
                temp.setName(lineR[1]);
                temp.setStars(Integer.parseInt(lineR[2]));
                temp.setNumberOfRooms(Integer.parseInt(lineR[3]));
                hotelList.add(temp);
                
                for(int j=4;j<lineR.length;j+=3)
                {
                    Reservation tempRes = new Reservation();
                    tempRes.setName(lineR[j]);
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(lineR[j+1]);//to see the exception
                    tempRes.setCheckinDate(date);
                    tempRes.setStayDurationDays(Integer.parseInt(lineR[j+2]));
                    temp.getReservations().add(tempRes);
                }
            }
        }catch(IOException ioe)
        {
            
        }
        return hotelList;
    }
    
    public static int getNumberOfHotels() {
        return numberOfHotels;
    }
    
public static void clear(){
	   hotelList.clear();
}

    public void printArr()
    {
        for(Hotel x : hotelList)
        {
            //System.out.println(x.getName());
            for(Reservation y : x.reservations)
            {
                //System.out.println(y.getName());
                MainMenu.list1.add(y.getName());
            }
        }
    }
}