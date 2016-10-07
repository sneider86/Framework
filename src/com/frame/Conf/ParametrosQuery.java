/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.Conf;

/**
 *
 * @author Erick
 */
public class ParametrosQuery {
    private int tipovalor;
    private Object valor;

    /**
     *
     * @param tipovalor tipo de del dato del valor a ingresar
     * 1:int
     * 2:String
     * 3:Double
     * 4:Boolean
     * 5:DateTime (yyyy-MM-dd HH:mm:ss)
     * @param valor
     */
    public ParametrosQuery(int tipovalor,Object valor){
        this.tipovalor=tipovalor;
        this.valor=valor;
    }

    public ParametrosQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @return  Obtiene el tipo de dato del valor ingresado ejem. (int,String,Double..etc)
     */
    public int getTipoValor(){
        return this.tipovalor;
    }
    /**
     * 
     * @param tipovalor Se establece el tipo de valor a ingresar ejem. (int,String,Double..etc)
     */
    public void setTipoValor(int tipovalor){
        this.tipovalor=tipovalor;
    }
    /**
     * 
     * @return Se obtiene el valor
     */
    public Object getValor(){
        return this.valor;
    }
    /**
     * 
     * @param valor Se establece el valor
     */
    public void setValor(Object valor){
        this.valor=valor;
    }
}
