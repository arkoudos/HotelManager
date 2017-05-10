package hotelmanagerjava;

import java.io.*;
import java.text.ParseException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class Main 
{
    static File filePath = null;
    
    public static void main(String args[]) throws ParseException
    {
        String userDirLocation = System.getProperty("user.dir");
        
        
        
        File searchFile = new File("dat2a.csv");
        
        if(searchFile.exists() && !searchFile.isDirectory())
        {
           JOptionPane.showConfirmDialog(null, "Loading File!", "File founded.", JOptionPane.DEFAULT_OPTION);
           filePath = searchFile;
        }else{
            //JOptionPane.showConfirmDialog(null, "Please choose the file for load.", "File not founded.", JOptionPane.WARNING_MESSAGE);
            JFileChooser fs = new JFileChooser();
            File f = new File(userDirLocation);
            fs.setCurrentDirectory(f);
            fs.showOpenDialog(null);
            filePath = fs.getSelectedFile();// userDirLocation;
            //JOptionPane.showConfirmDialog(null, "Loading File!", "File founded.", JOptionPane.DEFAULT_OPTION);
        }
        FileManager.readFile();
        //MainMenu.label1.setText(Integer.toString(FileManager.getNumberOfHotels()));
        MainMenu.CreateMenu();
        System.out.println("STOP");
    }
}
