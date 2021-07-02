package com.omibrowser;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkListener;

public class ReadFile<ActionEvent> extends JFrame
{
    private JTextField add_bar;     //top address bar to type website address
    private JEditorPane display;    //display content of the browser

    //contructor
    public ReadFile()
    {
        super("Omi's Browser");

        add_bar = new JTextField("Website Url");
        add_bar.addActionListener((ActionListener) event -> loadCrap(((java.awt.event.ActionEvent) event).getActionCommand())
        );
        add(add_bar, BorderLayout.NORTH);           //adding address bar at the top
        
        //content display
        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener((HyperlinkListener) new HyperlinkListener(){
            public <HyperlinkEvent> void hyperlinkUpdate(HyperlinkEvent event){
                if(((javax.swing.event.HyperlinkEvent) event).getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                    loadCrap(((javax.swing.event.HyperlinkEvent) event).getURL().toString());              //passing url of hyperlink to loadcrap method to visit the url page
                }
            }
        }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }

    //loadcrap method for url page visit
    private void loadCrap(String user_text)
    {
        try
        {
            display.setPage(user_text);      //method to take the url and display the url
            add_bar.setText(user_text);      //display url in the address bar roughout the website visit
        }
        catch(Exception e)
        {
            System.out.println("Enter a valid URL");
        }
    }
}