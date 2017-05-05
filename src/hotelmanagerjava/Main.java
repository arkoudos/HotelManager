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
        
        
        
        File searchFile = new File("data2.csv");
        
        if(searchFile.exists() && !searchFile.isDirectory())
        {
           JOptionPane.showConfirmDialog(null, "Loading File!", "File founded.", JOptionPane.DEFAULT_OPTION);
           filePath = searchFile;
        }else{
            JFileChooser fs = new JFileChooser();
            File f = new File(userDirLocation);
            fs.setCurrentDirectory(f);
            fs.showOpenDialog(null);
            filePath = fs.getSelectedFile();// userDirLocation;
         //  filePath = JOptionPane.showInternalInputDialog(null, "Enter the name of the file:", "File not found!",JOptionPane.OPTIONS_PROPERTY );
          // filePath = JOptionPane.showInputDialog(null,"Enter the name of the file:", "File not found!", JOptionPane.QUESTION_MESSAGE);
        }
//        final JFileChooser fc = new JFileChooser();
//        
//        String filePath = null;
//        
//        File searchFile = new File("data2.csv");
//        if(searchFile.exists() && !searchFile.isDirectory())
//        {
//            filePath = "data.csv";
//        }else{
//            filePath = JOptionPane.showInternalInputDialog(null, "Enter the name of the file:", "File not found!",JOptionPane.OPTIONS_PROPERTY );
//            //filePath = JOptionPane.showInputDialog(null,"Enter the name of the file:", "File not found!", JOptionPane.QUESTION_MESSAGE);
//        }
        
        System.out.println(filePath);
        //FileManager test = new FileManager();
        //test.readFile();
     //   test.printArr();
        //Menu.runMain();
       MainMenu.CreateMenu();
    }
}
