/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.Conf;

/**
 *
 * @author erick
 */
public class ItemComboBox {
    private String key;
    private String value;
    public ItemComboBox(String key,String value){
        this.key=key;
        this.value=value;
    }
    public String getKey(){
        return this.key;
    }
    public String getValue(){
        return this.value;
    }
    @Override
    public String toString() { return this.key; }
}
