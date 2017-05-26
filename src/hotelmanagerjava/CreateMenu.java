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
    private JButton LoadButton,SaveButton,AddButton,SearchButton,DisplayButton,ExitButton,LinearSIDButton,LinearSSurButton,BinarySearchButton,InterpolationSearchButton,AVLSearchButton;
    public static JTextArea output = new JTextArea(4,20);
    JScrollPane ops = new JScrollPane(output);
    
    
    public void DisplayMenu()
    {
        //Creation of Main Menu
        MainMenu = new JFrame("Hotel Manager");
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.setLocationByPlatform(true);
        
        //Main Panel
        JPanel MainPane = new JPanel();
        MainPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //Main Menu Buttons
        LoadButton = new JButton("Load Hotels and Reservations from file");
        SaveButton = new JButton("Save Hotels and Reservations to file");
        AddButton = new JButton("Add a Hotel(With reservations)");
        SearchButton = new JButton("Search and Display a Hotel by ID");
        DisplayButton = new JButton("Display Reservations by surname search");
        ExitButton = new JButton("Exit");
        
        
        //Search Menu by ID Items
        SearchMenuID = new JFrame("Search Menu by ID");
        SearchMenuID.setLocationByPlatform(true);
        
                    
        JPanel SearchPaneID = new JPanel();
        
        //LinearS Button
        LinearSIDButton = new JButton("Linear Search");
        SearchPaneID.add(LinearSIDButton);
        
        //BinaryS Button
        BinarySearchButton = new JButton("Binary Search");
        SearchPaneID.add(BinarySearchButton);
        
        //InterpolationS Button
        InterpolationSearchButton = new JButton("Interpolation Search");
        SearchPaneID.add(InterpolationSearchButton);
        
        //AVL Search
        AVLSearchButton = new JButton("AVL Search");
        SearchPaneID.add(AVLSearchButton);
        
        SearchMenuID.getContentPane().add(SearchPaneID);
        SearchMenuID.setSize(300,115);
        
        
        
        //Search Menu by Sur Items
        SearchMenuSur = new JFrame("Search Menu by Surname");
        SearchMenuSur.setLocationByPlatform(true);
        
        JPanel SearchPaneSur = new JPanel();
        LinearSSurButton = new JButton("Linear Search");
                
        SearchPaneSur.add(LinearSSurButton);
        SearchMenuSur.getContentPane().add(SearchPaneSur);
        SearchMenuSur.setSize(300,300);
        
        //Actions for the buttons
        
        action = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                JButton button = (JButton) ae.getSource();
                
                if (button == LoadButton)
                {
                    FileManager.clear ();
                    FileManager.readFile();
                }
                
                else if(button == SaveButton)
                {
                    FileManager.FileSave();
                }
                
                else if(button == AddButton)
                {
                    Hotel.addHotel();
                }
                
                else if(button == SearchButton)
                {
                    SearchMenuID.setVisible(true);
                }
                
                else if(button == LinearSIDButton)
                {
                    FileManager.SearchByID(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE)));
                }
                
                else if(button == BinarySearchButton)
                {
                    BinarySearch BS = new BinarySearch();
                    output.append("The hotel you searched is " + FileManager.hotelList.get(BS.binarySearch((Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE))))).getName() + "\n");
                }
                
                else if(button == InterpolationSearchButton)
                {
                    output.append("The hotel you searched is " + FileManager.hotelList.get(InterpolationSearch.interpolationSearch(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE)))).getName() + "\n");
                }
                
                else if (button == AVLSearchButton)
                {
                    System.out.println("TESTT");
                }
                
                else if(button == DisplayButton)
                {
                    SearchMenuSur.setVisible(true);
                }
                
                else if(button == LinearSSurButton)
                {
                    FileManager.SearchBySur(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE));
                }
            }
        };
        
        LoadButton.addActionListener(action);
        SaveButton.addActionListener(action);
        AddButton.addActionListener(action);
        SearchButton.addActionListener(action);
        LinearSIDButton.addActionListener(action);
        BinarySearchButton.addActionListener(action);
        InterpolationSearchButton.addActionListener(action);
        AVLSearchButton.addActionListener(action);
        DisplayButton.addActionListener(action);
        LinearSSurButton.addActionListener(action);
        ExitButton.addActionListener(action);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        MainPane.add(LoadButton,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        MainPane.add(SaveButton,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        MainPane.add(AddButton,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        MainPane.add(SearchButton,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        MainPane.add(DisplayButton,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        MainPane.add(ExitButton,c);
        
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
