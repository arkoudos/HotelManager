package hotelmanagerjava;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileManager
{
    static ArrayList<Hotel>hotelList=new ArrayList<Hotel>();//Array List load with data from the file
    static int numberOfHotels;
    static AVLTrees avlTree = new AVLTrees(); // AVL tree creation
    static Trie tr = new Trie(); // Trie creation
    static private int printTest = 1;

    public static void setPrintTest(int printTest) {
        FileManager.printTest = printTest;
    }
    
    //read file fuction
    public static ArrayList<Hotel> readFile()
    {
        BufferedReader br = null;
        try
        {
            if(!FileManager.hotelList.isEmpty())
            {
                hotelList.clear();//If th hotel list have data, delete them
                CreateMenu.output.append("Data have been deleted.\n");
            }
            
            CreateMenu.output.append("Loading File...\n");
            String lineReader; // Read Line
            String[] lineR; // Store Readed Line
            FileReader readFile = new FileReader(Main.filePath); // File reader
            br = new BufferedReader(readFile); // Buffer
 
            //read the first line
            lineReader = br.readLine();
            lineR= lineReader.split(";");
            numberOfHotels = Integer.parseInt(lineR[0]); // save number of hotels listend
            CreateMenu.output.append("Reading the number of hotels that are listed.\n");
            CreateMenu.output.append("Hotels are listed: " + numberOfHotels + "\n");
            
            
            //Filling the ArrayList -> hotelList
            for(int i=0;i<numberOfHotels;i++)
            {
                lineReader = br.readLine();// read line by line
                lineR = lineReader.split(";"); // Line splitter
                Hotel readH = new Hotel(); //creating a temporary Hotel to fill array
                //Starting to load the temporary list
                readH.setId(Integer.parseInt(lineR[0]));
                readH.setName(lineR[1]);
                readH.setStars(Integer.parseInt(lineR[2]));
                readH.setNumberOfRooms(Integer.parseInt(lineR[3]));
                hotelList.add(readH);//Fill the temporary list
                //Filling the Reservation List to the hotels
                for(int j=4;j<lineR.length;j+=3)
                {
                    Reservation tempRes = new Reservation(); //Temporary reservation as above
                    tempRes.setName(lineR[j]);
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(lineR[j+1]);
                    tempRes.setCheckinDate(date);
                    tempRes.setStayDurationDays(Integer.parseInt(lineR[j+2]));
                    readH.getReservations().add(tempRes); // add the reservations to the temporary hotel
                }
            }
        }catch(FileNotFoundException fnf) // file not found exception call FileSave fuction to create a new one
        {
            CreateMenu.output.append("File not Found!\nCreating new....");
            FileManager.FileSave();
        }catch(IOException | ParseException ioe)
        {
            ioe.printStackTrace();
        }
        
        try
        {
            FileSorter sort = new FileSorter();
            sort.sortList(FileManager.hotelList, sort);
            br.close();
        }catch(IOException ioe)
        {
            CreateMenu.output.append("Error while closing the Buffer\n");
        }
        CreateMenu.output.append("Hotels have been loaded to memmory. \n");
        return hotelList; // return the hotel list loaded with the data
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
            FileWriter saveFile = new FileWriter(Main.filePath);//Creating the new file
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
    
//    public static int getNumberOfHotels() {
//        return numberOfHotels;
//    }
//    
    
    //clearing the hotel list fuction
    public static void clear()
    {
        hotelList.clear();
        CreateMenu.output.append("Clearing memmory...\n");
    }

    //Linear search fuction for ID
    public static Hotel SearchByID(int searchID)
    {
        Hotel searchHotel = new Hotel();
        searchHotel.setId(searchID);
        for(Hotel a : hotelList)
        {
            if(a.getId() == searchHotel.getId())
            {
                //CreateMenu.output.append("The hotel you searched is " + a.getName()+"\n");
                searchHotel.setName(a.getName());
                break;// stop when i get the id
            }
        }
        return searchHotel;
    }
    
    //Linear search fuction for Surname
    public static Reservation SearchBySur(String surname){
        int check=0;
	   Reservation searchSN=new Reservation();
	   searchSN.setName(surname);
	   for(Hotel x: hotelList){
		   for(Reservation y: x.reservations){
			   if(y.getName().equals(searchSN.getName())){
                               if(printTest == 1)
                               {
				   CreateMenu.output.append(searchSN.getName()+" is staying at: "+ x.getName() + " Checkin Date: " + new SimpleDateFormat("dd/MM/yyyy").format(y.getCheckinDate())+" Staying for:"+y.getStayDurationDays()+" Days\n");
                               }
                                   check=1;
				   break;
			   }
		   }
			   
	   }
           if (check == 0)
           {
               CreateMenu.output.append("No reservations found under this Surname!\n");
           }
	   return searchSN;
}
   //Filling the Trie with my data 
   public static void TrieFill()
   {
       for(Hotel x : hotelList)
       {
           for(Reservation y:x.reservations)
           {
               tr.insert(y, x); //fill trie with reservation=y and hotels = x
           }
       }
   }
    
   //Filling avl tree with the data
    public static void createAVLTrees()
    {
        for(Hotel a : hotelList)
        {
            avlTree.insert(a);
        }
    }
    
    //Avl creating a temporary hotel(AVLSearch) and calls avl search to find
    public static void SearchAVL(int searchID)
    {
        Hotel AVLSearch = new Hotel();
        AVLSearch.setId(searchID);
        CreateMenu.output.append("The hotel you searched is " + avlTree.search(AVLSearch.getId()).getName() + "\n");
    }
    
    
    
}