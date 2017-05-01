package hotelmanagerjava;

import java.text.ParseException;

public class Main 
{
    public static void main(String args[]) throws ParseException
    {
        FileManager test = new FileManager();
        test.readFile();
        test.printArr();
        
    }
}
