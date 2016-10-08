/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.Conf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author erick
 */
public class TextFieldCustom extends JTextField{
    @SuppressWarnings("FieldMayBeFinal")
    private Dimension d = new Dimension(200,32);
    @SuppressWarnings("FieldMayBeFinal")
    private String placeholder = "";
    @SuppressWarnings("FieldMayBeFinal")
    private Color phColor= new Color(0,0,0);
    @SuppressWarnings("FieldMayBeFinal")
    private boolean band = true;
    
    public TextFieldCustom(){
        super();
        this.setSize(d);
        this.setPreferredSize(d);
        this.setVisible(true);
        this.setMargin( new Insets(3,6,3,6));
        //atento a cambios 
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                band = (getText().length() <= 0) ;
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                band = false;
            }
            @Override
            public void changedUpdate(DocumentEvent de) {}
        });
    }
    public void setPlaceholder(String placeholder)
    {
        this.placeholder=placeholder;
    }

    public String getPlaceholder()
    {
        return placeholder;
    }

    public Color getPhColor() {
        return phColor;
    }

    public void setPhColor(Color phColor) {
        this.phColor = phColor;
    }    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //color de placeholder 
        g.setColor( new Color(phColor.getRed(),phColor.getGreen(),phColor.getBlue(),90));
        //dibuja texto
        g.drawString((band)?placeholder:"",
                     getMargin().left,
                     (getSize().height)/2 + getFont().getSize()/2 );
      }
    
}