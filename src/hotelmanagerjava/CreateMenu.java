package hotelmanagerjava;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CreateMenu extends JFrame implements ActionListener
{
    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    JButton add = new JButton("Add");
    JButton test = new JButton("Test");
    
    public CreateMenu()
    {
        super("Hotel Manager");
        setSize(140,170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        load.addActionListener(this);
        save.addActionListener(this);
        JPanel pane = new JPanel();
        pane.add(load);
        pane.add(save);
        pane.add(add);
        add(pane);
        pack();
        setVisible(true);
    }
    
    public void addButton()
    {
        JFrame addButtonF = new JFrame("Add Hotel");
        addButtonF.setSize(500,500);
        addButtonF.add(test);
        addButtonF.setVisible(true);
    }
    
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
            //addButton();
            JFrame addButtonF = new JFrame("Add Hotel");
        addButtonF.setSize(500,500);
        addButtonF.add(test);
        addButtonF.setVisible(true);
        }
        repaint();
    }
    
    
}
