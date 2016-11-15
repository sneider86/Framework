/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.Conf;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author erick
 */
public class ComboBoxCustom extends JComboBox{
    ArrayList key=new ArrayList();
    ArrayList value=new ArrayList();   
    public ComboBoxCustom(){
        
    }
    /**
     * @param key Este es el parametro llave del combo box.
     * @param value Este es el valor del combo box y es lo que se muestra como etiqueta al usuario.
    */
    public void addItem(String key,String value){
        this.key.add(key);
        this.value.add(value);
        this.addItem(value);
    }
    /**
     * 
     * @return Retorna un String con la llave seleccionada del combo box.
     */
    public String getKey(){
        return (String) this.key.get(this.getSelectedIndex());
    }
    /**
     * 
     * @return Retorna un String con el valor seleccionado del combo box.
     */
    public String getValue(){
        return (String) this.value.get(this.getSelectedIndex());
    }
    /**
     * Establece un key en el ComboBox
     * @param key 
     * @throws java.lang.Exception 
     */
    public void setKey(String key) throws Exception{
        if(!key.trim().equals("")){
            boolean sw=false;
            for(int i=0;i<this.key.size();i++){
                if(this.key.get(i).equals(key)){
                    this.setSelectedIndex(i);
                    sw=true;
                }
            }
            if(!sw){
                throw new Exception("El valor a establecer no existe");
            }
        }else{
            throw new Exception("El Key no puede estar vacío");
        }
    }
}
