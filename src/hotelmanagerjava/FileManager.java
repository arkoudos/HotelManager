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
    
    public static void FileSave()
    {
        //sorting the array
        FileSorter sort = new FileSorter();
        sort.sortList(FileManager.hotelList,sort);
        
        try
        {
            FileWriter saveFile = new FileWriter(Main.filePath);
            //Set the first line for the number of Hotels
            saveFile.append(new Integer(hotelList.size()).toString());
            //Writting line by line from the second line
            for(Hotel a : hotelList)
            {
                saveFile.append('\n');
                saveFile.append(new Integer(a.getId()).toString());
                saveFile.append(';');
                saveFile.append(a.getName());
                saveFile.append(';');
                saveFile.append(new Integer(a.getStars()).toString());
                saveFile.append(';');
                saveFile.append(new Integer(a.getNumberOfRooms()).toString());
                saveFile.append(';');
                
                for(Reservation b : a.reservations)
                {
                    saveFile.append(b.getName());
                    saveFile.append(';');
                    saveFile.append(new SimpleDateFormat("dd/MM/yyyy").format(b.getCheckinDate()));
                    saveFile.append(';');
                    saveFile.append(new Integer(b.getStayDurationDays()).toString());
                    saveFile.append(';');
                    
                }
            }
            saveFile.flush();
            saveFile.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static int getNumberOfHotels() {
        return numberOfHotels;
    }
    
    public static void clear()
    {
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