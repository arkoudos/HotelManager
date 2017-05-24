package hotelmanagerjava;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CreateMenu extends JFrame implements ActionListener
{
    JButton load = new JButton("Load Hotels and Reservations from file");
    JButton save = new JButton("Save Hotels and Reservations to file");
    JButton add = new JButton("Add a Hotel(With reservations)");
    JButton search = new JButton("Search and Display a Hotel by ID");
    JButton display = new JButton("Display Reservations by surname search");
    JButton exit = new JButton("Exit");
    
    //JFrame addButtonF = new JFrame("Add Hotel");
        
    
    
    public CreateMenu()
    {
        super("Hotel Manager");
        setSize(325,225);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        load.addActionListener(this);
        save.addActionListener(this);
        add.addActionListener(this);
        search.addActionListener(this);
        display.addActionListener(this);
        exit.addActionListener(this);
        JPanel pane = new JPanel();
        pane.add(load);
        pane.add(save);
        pane.add(add);
        pane.add(search);
        pane.add(display);
        pane.add(exit);
        add(pane);
        //pack();
        setVisible(true);
        
       // addButtonF.setSize(500,500);
        //addButtonF.add(test);
        //addButton();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Object source = evt.getSource();
        if(source == load)
        {
            FileManager.clear ();
            FileManager.readFile();
        }else if (source == save)
        {
             FileManager.FileSave();
        }else if (source == add)
        {
            
            Hotel.addHotel();
        }else if(source == search)
        {
            
        }else if(source == display)
        {
            
        }else if(source == exit)
        {
            FileManager.FileSave();
            System.exit(0);
        }
        repaint();
    }
    
    
}
