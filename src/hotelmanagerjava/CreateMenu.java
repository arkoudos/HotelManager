package hotelmanagerjava;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class CreateMenu extends JFrame implements ActionListener
{
    JButton load = new JButton("Load Hotels and Reservations from file");
    JButton save = new JButton("Save Hotels and Reservations to file");
    JButton add = new JButton("Add a Hotel(With reservations)");
    JButton search = new JButton("Search and Display a Hotel by ID");
    JButton display = new JButton("Display Reservations by surname search");
    JButton exit = new JButton("Exit");
    
    
    public static JTextArea output = new JTextArea(5,20);
    JScrollPane ops = new JScrollPane(output);
    
    public CreateMenu()
    {
        super("Hotel Manager");
        //setSize(500,500);
        //setResizable(false);
        load.addActionListener(this);
        save.addActionListener(this);
        add.addActionListener(this);
        search.addActionListener(this);
        display.addActionListener(this);
        exit.addActionListener(this);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(4,4));
        //pane.setSize(500,500);
        pane.add(load);
        pane.add(save);
        pane.add(add);
        pane.add(search);
        pane.add(display);
        pane.add(exit);
        pane.add(ops,BorderLayout.NORTH);
        setSize(650,650);
        setUndecorated(false);
        add(pane);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
