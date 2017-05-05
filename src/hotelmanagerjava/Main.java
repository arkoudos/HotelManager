package hotelmanagerjava;

import java.io.*;
import java.text.ParseException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main 
{
    public static void main(String args[]) throws ParseException
    {
        final JFileChooser fc = new JFileChooser();
        
        String filePath = null;
        
        File searchFile = new File("data2.csv");
        if(searchFile.exists() && !searchFile.isDirectory())
        {
            filePath = "data.csv";
        }else{
            filePath = JOptionPane.showInternalInputDialog(null, "Enter the name of the file:", "File not found!",JOptionPane.OPTIONS_PROPERTY );
            //filePath = JOptionPane.showInputDialog(null,"Enter the name of the file:", "File not found!", JOptionPane.QUESTION_MESSAGE);
        }
        
        System.out.println(filePath);
        //FileManager test = new FileManager();
        //test.readFile();
     //   test.printArr();
        //Menu.runMain();
        MainMenu.CreateMenu();
    }
}
