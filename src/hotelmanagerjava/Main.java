package hotelmanagerjava;

import static hotelmanagerjava.FileManager.hotelList;
import java.io.*;
import java.text.ParseException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



public class Main 
{
    static File filePath = null;
     
    public static void main(String args[]) throws ParseException
    {
        String userDirLocation = System.getProperty("user.dir");
       
        
        File searchFile = new File("data.csv");
        
        if(searchFile.exists() && !searchFile.isDirectory())
        {
            CreateMenu.output.append("File have been founded.\n Loading File...\n");
           filePath = searchFile;
        }else{
           JFileChooser fs = new JFileChooser();
            File f = new File(userDirLocation);
            fs.setCurrentDirectory(f);
            fs.showOpenDialog(null);
            filePath = fs.getSelectedFile();// userDirLocation;
            CreateMenu.output.append("File have been founded.\n Loading File...\n");
        }
        
        FileManager.readFile();
        
        FileManager.createAVLTrees();
        
        FileManager.TrieFill();
        
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new CreateMenu().DisplayMenu();
            }
        });
    }
    
}
