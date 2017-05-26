package hotelmanagerjava;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileManager
{
    static ArrayList<Hotel>hotelList=new ArrayList<Hotel>();
    static int numberOfHotels;
    static AVLTrees avlTree = new AVLTrees();
    static Trie tr = new Trie();
    
    //read file fuction
    public static ArrayList<Hotel> readFile()
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
            CreateMenu.output.append("Reading the number of hotels that are listed.\n");
            //System.out.println("Number Of Registers: " + numberOfHotels);
            CreateMenu.output.append("Loading File...\n");
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
        }catch(IOException | ParseException ioe)
        {
            CreateMenu.output.append(ioe + "\n");
        }
        CreateMenu.output.append("Hotels have been loaded to memmory. \n");
        return hotelList;
    }
    
    //Save to file fuction
    
    public static void FileSave()
    {
        //sorting the array
        FileSorter sort = new FileSorter();
        sort.sortList(FileManager.hotelList,sort);
        CreateMenu.output.append("Saving data to file...\n");
        
        try
        {
            FileWriter saveFile = new FileWriter(Main.filePath);
            //Set the first line for the number of Hotels
            saveFile.append(Integer.toString(hotelList.size()));
            //Writting line by line from the second line
            for(Hotel a : hotelList)
            {
                saveFile.append('\n');
                saveFile.append(Integer.toString(a.getId()));
                saveFile.append(';');
                saveFile.append(a.getName());
                saveFile.append(';');
                saveFile.append(Integer.toString(a.getStars()));
                saveFile.append(';');
                saveFile.append(Integer.toString(a.getNumberOfRooms()));
                saveFile.append(';');
                
                for(Reservation b : a.reservations)
                {
                    saveFile.append(b.getName());
                    saveFile.append(';');
                    saveFile.append(new SimpleDateFormat("dd/MM/yyyy").format(b.getCheckinDate()));
                    saveFile.append(';');
                    saveFile.append(Integer.toString(b.getStayDurationDays()));
                    saveFile.append(';');
                    
                }
            }
            saveFile.flush();
            saveFile.close();
        }
        catch (IOException e)
        {
        }
        CreateMenu.output.append("Data successful saved.\n");
    }
    
    public static int getNumberOfHotels() {
        return numberOfHotels;
    }
    
    public static void clear()
    {
        hotelList.clear();
        CreateMenu.output.append("Clearing memmory...\n");
    }

    
    public static Hotel SearchByID(int searchID)
    {
        Hotel searchHotel = new Hotel();
        searchHotel.setId(searchID);
        for(Hotel a : hotelList)
        {
            if(a.getId() == searchHotel.getId())
            {
                CreateMenu.output.append("The hotel you searched is " + a.getName()+"\n");
                break;
            }
        }
        return searchHotel;
    }
    
    public static Reservation SearchBySur(String surname){
	   Reservation searchSN=new Reservation();
	   searchSN.setName(surname);
	   for(Hotel x: hotelList){
		   for(Reservation y: x.reservations){
			   if(y.getName().equals(searchSN.getName())){
				   CreateMenu.output.append(searchSN.getName()+" is staying at: "+ x.getName() + " Checkin Date: " + new SimpleDateFormat("dd/MM/yyyy").format(y.getCheckinDate())+" Staying for:"+y.getStayDurationDays()+" Days\n");
				   //myGraphics.jTextArea.append(System.lineSeparator());
				   break;
			   }
		   }
			   
	   }
	   return searchSN;
}
    
   public static void TrieFill()
   {
       for(Hotel x : hotelList)
       {
           for(Reservation y:x.reservations)
           {
               tr.insert(y, x);
           }
       }
   }
    
    public static void createAVLTrees()
    {
        for(Hotel a : hotelList)
        {
            avlTree.insert(a);
        }
    }
    
    public static void SearchAVL(int searchID)
    {
        Hotel AVLSearch = new Hotel();
        AVLSearch.setId(searchID);
        CreateMenu.output.append("The hotel you searched is " + avlTree.search(AVLSearch.getId()).getName() + "\n");
    }
}