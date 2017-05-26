package hotelmanagerjava;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class CreateMenu// extends JFrame implements ActionListener
{
    //Frames
    private JFrame MainMenu,SearchMenuID,SearchMenuSur;
    
    //Action Listener
    private ActionListener action;
    
    //Buttons & Utils
    private JButton load,save,add,search,display,exit,linearSID,linearSSur;
    public static JTextArea output = new JTextArea(4,20);
    JScrollPane ops = new JScrollPane(output);
    
    
    public void DisplayMenu()
    {
        MainMenu = new JFrame("Hotel Manager");
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.setLocationByPlatform(true);
        
        Panel MainPane = new Panel();
        MainPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        load = new JButton("Load Hotels and Reservations from file");
        save = new JButton("Save Hotels and Reservations to file");
        add = new JButton("Add a Hotel(With reservations)");
        search = new JButton("Search and Display a Hotel by ID");
        display = new JButton("Display Reservations by surname search");
        exit = new JButton("Exit");
        
        
        //Search Menu by ID Items
        SearchMenuID = new JFrame("Search Menu by ID");
        SearchMenuID.setLocationByPlatform(true);
                    
        JPanel SearchPaneID = new JPanel();
        
        linearSID = new JButton("Linear Search");
        
        SearchPaneID.add(linearSID);
        SearchMenuID.getContentPane().add(SearchPaneID);
        SearchMenuID.setSize(300,300);
        
        
        //Search Menu by Sur Items
        SearchMenuSur = new JFrame("Search Menu by Surname");
        SearchMenuSur.setLocationByPlatform(true);
        
        JPanel SearchPaneSur = new JPanel();
        linearSSur = new JButton("Linear Search");
                
        SearchPaneSur.add(linearSSur);
        SearchMenuSur.getContentPane().add(SearchPaneSur);
        SearchMenuSur.setSize(300,300);
        
        action = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JButton button = (JButton) ae.getSource();
                
                if (button == load)
                {
                    FileManager.clear ();
                    FileManager.readFile();
                }else if(button == save)
                {
                    FileManager.FileSave();
                }else if(button == add)
                {
                    Hotel.addHotel();
                }else if(button == search)
                {
                    SearchMenuID.setVisible(true);
                }else if(button == linearSID)
                {
                    FileManager.SearchByID(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE)));
                }else if(button == display)
                {
                    SearchMenuSur.setVisible(true);
                }else if(button == linearSSur)
                {
                    FileManager.SearchBySur(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE));
                }
            }
        };
        
        load.addActionListener(action);
        save.addActionListener(action);
        add.addActionListener(action);
        search.addActionListener(action);
        linearSID.addActionListener(action);
        display.addActionListener(action);
        linearSSur.addActionListener(action);
        exit.addActionListener(action);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        MainPane.add(load,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        MainPane.add(save,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        MainPane.add(add,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        MainPane.add(search,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        MainPane.add(display,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        MainPane.add(exit,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridheight =40;
        c.gridy = 0;
        c.ipady = 90;
        c.ipadx = 500;
        MainPane.add(ops,c);
        
        
        MainMenu.setLayout(new GridLayout(1,1));
        MainMenu.setSize(500,500);
        MainMenu.setUndecorated(false);
        MainMenu.getContentPane().add(MainPane);
        MainMenu.pack();
        MainMenu.setVisible(true);



    }  
}
