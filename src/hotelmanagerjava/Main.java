package hotelmanagerjava;

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
           //JOptionPane.showConfirmDialog(null, "Loading File!", "File founded.", JOptionPane.DEFAULT_OPTION);
            CreateMenu.output.append("File have been founded.\n Loading File...\n");
           filePath = searchFile;
        }else{
            //JOptionPane.showConfirmDialog(null, "Please choose the file for load.", "File not founded.", JOptionPane.WARNING_MESSAGE);
            JFileChooser fs = new JFileChooser();
            File f = new File(userDirLocation);
            fs.setCurrentDirectory(f);
            fs.showOpenDialog(null);
            filePath = fs.getSelectedFile();// userDirLocation;
            CreateMenu.output.append("File have been founded.\n Loading File...\n");
            //JOptionPane.showConfirmDialog(null, "Loading File!", "File founded.", JOptionPane.DEFAULT_OPTION);
        }
        FileManager.readFile();
        
 
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
