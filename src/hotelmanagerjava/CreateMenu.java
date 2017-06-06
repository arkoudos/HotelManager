package hotelmanagerjava;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CreateMenu// extends JFrame implements ActionListener
{
    //Frames
    private JFrame MainMenu,SearchMenuID,SearchMenuSur;
    
    //Action Listener
    private ActionListener action;
    
    //Buttons & Utils
    private JButton LoadButton,SaveButton,AddButton,SearchButton,DisplayButton,ExitButton,LinearSIDButton,LinearSSurButton,BinarySearchButton,InterpolationSearchButton,AVLSearchButton,TrieSearchButton,IDSearchTimeButton,SurnameSearchTimeButton;
    public static JTextArea output = new JTextArea(7,50);
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
        IDSearchTimeButton = new JButton("ID Search Time");
        SurnameSearchTimeButton = new JButton("Surname Search Time");
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
        
        //LinearS Button
        LinearSSurButton = new JButton("Linear Search");
        SearchPaneSur.add(LinearSSurButton);
                
        //TrieS Button
        TrieSearchButton = new JButton("TrieSearch");
        SearchPaneSur.add(TrieSearchButton);
        
        SearchMenuSur.getContentPane().add(SearchPaneSur);
        SearchMenuSur.setSize(100,115);
        
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
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == SaveButton)
                {
                    FileManager.FileSave();
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == AddButton)
                {
                    Hotel.addHotel();
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == SearchButton)
                {
                    SearchMenuID.setVisible(true);
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == LinearSIDButton)
                {
                    //FileManager.SearchByID(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE)));
                    //searchHotel
                    output.append("The hotel you searched is " + FileManager.SearchByID(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE))).getName() + "\n");
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == BinarySearchButton)
                {
                    BinarySearch BS = new BinarySearch();
                    output.append("The hotel you searched is " + FileManager.hotelList.get(BS.binarySearch((Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE))))).getName() + "\n");
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == InterpolationSearchButton)
                {
                    output.append("The hotel you searched is " + FileManager.hotelList.get(InterpolationSearch.interpolationSearch(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE)))).getName() + "\n");
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if (button == AVLSearchButton)
                {
                    FileManager.SearchAVL(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the ID:","Search Hotel by ID",JOptionPane.QUESTION_MESSAGE)));
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == DisplayButton)
                {
                    SearchMenuSur.setVisible(true);
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == LinearSSurButton)
                {
                    FileManager.setPrintTest(1);
                    FileManager.SearchBySur(JOptionPane.showInputDialog(null,"Enter the Surname:","Search Hotel by Surname",JOptionPane.QUESTION_MESSAGE));
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == TrieSearchButton)
                {
                    Trie.setPrintSearch(1);
                    System.out.println(FileManager.tr.search(JOptionPane.showInputDialog(null,"Enter the Surname:","Search Hotel by Surnmae",JOptionPane.QUESTION_MESSAGE)));
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == IDSearchTimeButton)
                {
                    SearchTime.IDSearchTime();
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == SurnameSearchTimeButton)
                {
                    Trie.setPrintSearch(0);
                    FileManager.setPrintTest(0);
                    SearchTime.SurnnameSearchTime();
                    output.setCaretPosition(output.getDocument().getLength());
                }
                
                else if(button == ExitButton)
                {
                    FileManager.FileSave();
                    System.exit(0);
                }
            }
        };
        
        //this is to make the buttons work
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
        TrieSearchButton.addActionListener(action);
        IDSearchTimeButton.addActionListener(action);
        SurnameSearchTimeButton.addActionListener(action);
        ExitButton.addActionListener(action);
        
        //to correct the menu items position and GUI
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
        MainPane.add(IDSearchTimeButton,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        MainPane.add(SurnameSearchTimeButton,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        MainPane.add(ExitButton,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridheight =40;
        c.gridy = 0;
        c.ipady = 90;
        c.ipadx = 500;
        MainPane.add(ops,c);
        
        
        MainMenu.setLayout(new GridLayout(1,1));
        MainMenu.setSize(600,600);
        MainMenu.setUndecorated(false);
        MainMenu.getContentPane().add(MainPane);
        MainMenu.pack();
        MainMenu.setVisible(true);



    }  
}
