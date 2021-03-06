/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.Conf;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JPanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


/**
 *
 * @author erick
 */
public class DatePickerCustom extends JPanel{
    private UtilDateModel model;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private Properties p;
    public DatePickerCustom(){
        this.model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        this.datePanel = new JDatePanelImpl(model,p) ;
        this.datePanel.setBackground(Color.yellow);
        this.datePanel.setForeground(Color.yellow);
        
        this.datePicker = new JDatePickerImpl(this.datePanel,new DateLabelFormatter());
        this.add(this.datePicker);        
    }
    public UtilDateModel getModel(){
        return this.model;
    }
    public void setModel(UtilDateModel model){
        this.model=model;
    }
    /**
     * Obtiene el dia de la fecha seleccionada.
     * @return Retorna un int
     */
    public int getDay(){
        return this.model.getDay();
    }
    /**
     * Obtiene el mes de la fecha seleccionada.
     * @return Retorna un int
     */
    public int getMonth(){
        return this.model.getMonth();
    }
    /**
     * Obtiene el año de la fecha seleccionada.
     * @return Retorna un int
     */
    public int getYear(){
        return this.model.getYear();
    }
    /**
     * Obtiene la fecha seleccionada en el calendario
     * @param format Formato de la fecha seleccionada
     * @return Retorna un String
     */
    public String dateSelect(String format){
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        return dateFormatter.format(this.model.getValue().getTime());
    }
    /**
     * Obtiene la fecha seleccionada en el calendario
     * @return Retorna un objeto tipo Date
     */
    public Date dateSelect(){
        return this.model.getValue();
    }
    
    
    
    
}
