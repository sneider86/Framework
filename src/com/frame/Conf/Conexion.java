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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conexion {
    private String usuario;
    private String clave;
    private String host;
    private String bd;
    private String puerto;
    private PreparedStatement prepared;
    private ResultSet result;
    private Connection con;
    private String ssl;
    /**
     *
     * @param usuario Se establece el valor de usuario para la conexion a la Base de Datos.
     * @param clave Se establece el valor de la clave para la conexion a la Base de Datos.
     */
    public Conexion(String usuario,String clave){
        this.usuario=usuario;
        this.clave=clave;
        this.puerto="3306";
        this.host="localhost";
        this.con=null;
        this.result=null;
        this.prepared=null;
        this.ssl="false";
    }

    public Conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     *
     * Obtiene el usuario de la conexion.
     */
    private String getUsuario(){
        return this.usuario;
    }
    /**
     *
     * @param usuario Se establece el valor de usuario para la conexion a la Base de Datos.
     */
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    /**
     *
     * Se obtiene el valor de la clave de la conexion de la Base de Datos.
     */
    private String getClave(){
        return this.clave;
    }
    /**
     *
     * @param clave Se establece el valor para la conexion de la Base de Datos.
     */
    public void setClave(String clave){
        this.clave=clave;
    }
    /**
     *
     * Se obtiene el nombre del host o la ip para la conexion de la Base de Datos.
     */
    private String getHost(){
        return this.host;
    }
    /**
     *
     * @param host Se establece el nombre del host o la ip para la conexion de la Base de Datos.
     */
    public void setHost(String host){
        this.host=host;
    }
    /**
     *
     * Se obtiene el nombre de la Base de Datos.
     */
    private String getBD(){
        return this.bd;
    }
    /**
     *
     * @param bd Se establece el nombre de la Base de Datos.
     */
    public void setBD(String bd){
        this.bd=bd;
    }
    /**
     *
     * @return Se obtiene el puerto de conecion a la Base de Datos.
     */
    public String getPuerto(){
        return this.puerto;
    }
    /**
     *
     * @param puerto Establece el puerto de conecion a la Base de Datos.
     */
    public void setPuerto(String puerto){
        this.puerto=puerto;
    }
    /**
     *
     * Se obtiene el PreparedStatement
     * @return 
     */
    public PreparedStatement getPreparedStatement(){
        return this.prepared;
    }
    /**
     *
     * @param prepared Establece el PreparedStatement
     */
    public void setPreparedStatement(PreparedStatement prepared){
        this.prepared=prepared;
    }
    /**
     *
     * 
     * @return Se obtiene el valor del Cursor.
     */
    public ResultSet getResult(){
        return this.result;
    }
    /**
     *
     * @param result Se establece el valor del Cursor.
     */
    public void setResultSet(ResultSet result){
        this.result=result;
    }
    /**
     *
     * @return Se obtiene el valor de la conexion.
     */
    public Connection getCon(){
        return this.con;
    }
    /**
     *
     * @param con Se establece el valor de la conexion.
     */
    public void setCon(Connection con){
        this.con=con;
    }
    /**
     *
     * @return Se obtiene el estado de la conexion ssl
     */
    public String getSSl(){
        return this.ssl;
    }
    /**
     *
     * @param ssl Se establece el valor de la conexion.
     */
    public void setSSl(String ssl){
        this.ssl=ssl;
    }
    /**
     *
     * Se conecta a la Base de Datos.
     * @throws java.lang.Exception
     */
    public void Conectar() throws Exception{
        if(!this.getUsuario().trim().equals("")){
            if(!this.getHost().trim().equals("")){
                if(!this.getPuerto().trim().equals("")){
                    if(!this.getBD().trim().equals("")){
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            this.con=DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bd+"?useServerPrepStmts=true&useSSL="+this.ssl,this.usuario,this.clave);
                        }catch(ClassNotFoundException | SQLException err){
                            throw new Exception(err.getMessage());
                        }
                    }else{
                        throw new Exception("La Base de Datos no puede estar vacia");
                    }
                }else{
                    throw new Exception("El Puerto no puede estar vacio");
                }
            }else{
                throw new Exception("El Host no puede estar vacio");
            }
        }else{
            throw new Exception("El Usuario no puede estar vacio");
        }
    }
    /**
     * 
     * Si se van a usar parametros en la consulta se aconseja usar la otra funcion.
     * @return Retorna el ResultSet de la consulta
     * @throws Exception Si al intentar ejecutar la consulta falla se genera una exception
     */
    public ResultSet consultaSeleccion() throws Exception{
        try{
            if(this.getCon()!=null){
                if(this.prepared!=null){
                    this.result=this.prepared.executeQuery();
                    return this.result;
                }else{
                    throw new Exception("No se puede ejecutar la consulta porque no se ha preparado");
                }
            }else{
                throw new Exception("No hay conexion con la Base de Datos");
            }
        }catch(Exception err){
            throw new Exception(err.getMessage());
        }
    }
    /**
     * 
     * @param param Se establece los parametros de la consulta en el WHERE. Debe ser un Array
     * @return Retorna el ResultSet de la consulta
     * @throws Exception Si al intentar ejecutar la consulta falla se genera una exception
     */
    public ResultSet consultaSeleccionParametros(ParametrosQuery[] param) throws Exception{
        try{
            if(this.getCon()!=null){
                if(param!=null){
                    if(param.length>0){
                        int i=0;
                        int j=1;
                        while(i<param.length){
                            this.agregarParametro(j, param[i]);
                            i++;
                            j++;
                        }
                    }
                }
                if(this.prepared!=null){
                }else{
                    throw new Exception();
                }
                this.result=this.prepared.executeQuery();
                return this.result;
            }else{
                throw new Exception("No hay conexion con la Base de Datos");
            }
        }catch(Exception err){
            throw new Exception(err.getMessage());
        }
    }
    /**
     * 
     * @param index indice del valor dentro del sql
     * @param param Objeto tipo ParametrosQuery
     * @throws Exception 
     */
    private void agregarParametro(int index,ParametrosQuery param) throws Exception{
        try{
            switch(param.getTipoValor()){
                case 1:
                    this.prepared.setInt(index,Integer.parseInt(param.getValor().toString()));
                break;
                case 2:
                    this.prepared.setString(index,param.getValor().toString());
                break;
                case 3:
                    this.prepared.setDouble(index,Double.parseDouble(param.getValor().toString()));
                break;
                case 4:
                    this.prepared.setBoolean(index,Boolean.parseBoolean(param.getValor().toString()));
                break;
                case 5:
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // your template here
                    Date date = formatter.parse(param.getValor().toString()); // mysql datetime format
                    java.sql.Timestamp fe = new java.sql.Timestamp(date.getTime());
                    this.prepared.setTimestamp(index, fe);
                break;
                case 6:
                    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd"); // your template here
                    Date date2 = formatter2.parse(param.getValor().toString()); // mysql datetime format
                    this.prepared.setDate(index,new java.sql.Date(date2.getTime()));
                break;
            }
        }catch(NumberFormatException | SQLException err){
            throw new Exception(err.getMessage());
        }
        
    }
    /**
     * Se cierra el ResultSet y el PreparedStatement
     * @throws Exception Si falla al intentar cerrar se genera una exception
     */
    public void cerrarResultyPrepared() throws Exception{
        try{
            if(this.result!=null){
                this.result.close();
            }
            if(this.prepared!=null){
                this.prepared.close();
            }
        }catch(Exception err){
            throw new Exception(err.getMessage());
        }
    }
    /**
     * Cierra la conexion a la Base de Datos
     * @throws Exception Si no puede cerrar la conexion genera una Exception
     */
    public void cerrarConexion() throws Exception{
        try{
            if(this.con!=null){
                this.con.close();
            }
        }catch(Exception err){
            throw new Exception(err.getMessage());
        }
    }
    /**
     * 
     * @param param Parametros de la consulta
     * @return Retorna el numero de filas afectadas
     * @throws Exception 
     */
    public int consultAccion(ParametrosQuery[] param) throws Exception{
        try{
            if(this.getCon()!=null){
                if(param!=null){
                    if(param.length>0){
                        int i=0;
                        int j=1;
                        while(i<param.length){
                            this.agregarParametro(j, param[i]);
                            i++;
                            j++;
                        }
                    }
                }
                int respuesta;
                respuesta=this.prepared.executeUpdate();
                return respuesta;
            }else{
                throw new Exception("No hay conexion con la Base de Datos");
            }
        }catch(Exception err){
            throw new Exception(err.getMessage());
        }
    }
    /**
     * 
     * @param sql Query de la Consulta.
     * @throws Exception Se genera una exception si no se puede preparar la consulta
     */
    public void prepararConsulta(String sql) throws Exception{
        try{
            if(this.getCon()!=null){
                this.prepared=this.getCon().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            }else{
                throw new Exception("No se pudo preparar la consulta porque no hay conexion con la Base de Datos");
            }
        }catch(Exception err){
            throw new Exception(err.getMessage());
        }
    }
}