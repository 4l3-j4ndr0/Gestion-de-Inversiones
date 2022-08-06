/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion_BD;

import alertas.ErrorAlert;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_datos_cargados {
   
    public static String tabla_datos_cargados="";
    static Statement s;
    static ResultSet rs;
    static PreparedStatement ps;
    
    public static String nombre_tabla="";
    public static String columna_tabla="";
    public static String dato_tabla="";

    public static String getNombre_tabla() {
        return nombre_tabla;
    }

    public static void setNombre_tabla(String nombre_tabla) {
        opciones_de_gestionar_datos_cargados.nombre_tabla = nombre_tabla;
    }

    public static String getColumna_tabla() {
        return columna_tabla;
    }

    public static void setColumna_tabla(String columna_tabla) {
        opciones_de_gestionar_datos_cargados.columna_tabla = columna_tabla;
    }

    public static String getDato_tabla() {
        return dato_tabla;
    }

    public static void setDato_tabla(String dato_tabla) {
        opciones_de_gestionar_datos_cargados.dato_tabla = dato_tabla;
    }
    
    
    
    public static void setListar(JTable tabla,String nombre_tabla, String sql) {
        try {
            
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery("select * from "+nombre_tabla);
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            String datos[] = new String[1];
            try {
                s = obconeccion.getCn().createStatement();
               rs = s.executeQuery(sql);
              while (rs.next()) {
                    datos[0] = rs.getString(1);
                modelo.addRow(datos);
                }
            } catch (SQLException ex) {
                Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
                ErrorAlert error = new ErrorAlert(new JFrame(), true);
                error.msj1.setText(ex.toString());
                error.msj2.setText("Por favor contacte con soporte técnico");
                error.msj3.setText("");
                error.preferredSize();
                error.pack();
                error.setVisible(true);
                 
            }
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void setListar2Columnas(JTable tabla,String nombre_tabla, String sql) {
        try {
            
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery("select * from "+nombre_tabla);
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            String datos[] = new String[2];
            try {
                s = obconeccion.getCn().createStatement();
               rs = s.executeQuery(sql);
              while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                modelo.addRow(datos);
                }
            } catch (SQLException ex) {
                Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
                ErrorAlert error = new ErrorAlert(new JFrame(), true);
                error.msj1.setText(ex.toString());
                error.msj2.setText("Por favor contacte con soporte técnico");
                error.msj3.setText("");
                error.preferredSize();
                error.pack();
                error.setVisible(true);
                 
            }
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static int registrar(String tabla, String columna,String  valor) throws SQLException, IOException {
        int rsu = 0;
        conexion obconeccion=new conexion();
        String sql = "INSERT INTO "+tabla+"("+columna+") VALUES(?)";
        try {
            
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, valor);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Por favor solucione el error antes de volver a intentarlo.");
            error.msj3.setText("En caso de no saber como corregir el error, por favor contacte con soporte técnico");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int registrar2Columnas(String valor1, String  valor2) throws SQLException, IOException {
        int rsu = 0;
        conexion obconeccion=new conexion();
        String sql = "INSERT INTO lista_area (area,resp_area) VALUES(?,?)";
        try {
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, valor1);
            ps.setString(2, valor2);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Por favor solucione el error antes de volver a intentarlo.");
            error.msj3.setText("En caso de no saber como corregir el error, por favor contacte con soporte técnico");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int registrar3Columnas(String  valor1, String  valor2, String  valor3) throws SQLException, IOException {
        int rsu = 0;
        conexion obconeccion=new conexion();
        String sql = "INSERT INTO lista_unidad (unidad,area,resp_unidad) VALUES(?,?,?)";
        try {
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, valor1);
            ps.setString(2, valor2);
            ps.setString(3, valor3);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Por favor solucione el error antes de volver a intentarlo.");
            error.msj3.setText("En caso de no saber como corregir el error, por favor contacte con soporte técnico");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static boolean existe(String sql) {
        String c = null;
        boolean existe=false;
        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery(sql);
             if (rs.next()) {
                c = rs.getString(1);
            }
            if (c != null) {
                existe=true;
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_datos_cargados.class.getName()).log(Level.SEVERE, null, ex);
            ErrorAlert.lanza_error(ex);
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_datos_cargados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    public static int eliminar_dato(String tabla, String columna, String dato) {
        int rsu = 0;
        String sql = "DELETE FROM "+tabla+" WHERE "+columna+" = '"+dato+"'";
        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rsu = s.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_datos_cargados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }
    
    
    
    public static int actualizar_datos(String tabla,String columna, String dato, String dato_control) throws SQLException, IOException {
       int rsu = 0;
       conexion obconeccion=new conexion();
        String sql = "UPDATE "+tabla+" SET "+columna+"=? WHERE "+columna+"=?";
        try {
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, dato);
            ps.setString(2, dato_control);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        
                        Logger.getLogger(opciones_de_gestionar_datos_cargados.class.getName()).log(Level.SEVERE, null, ex);
            ErrorAlert.lanza_error(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static String extraer_valor(String sql) throws IOException {
        String cant ="";

        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery(sql);
            while (rs.next()) {
                cant = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(opciones_tabla_general.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(cant);
        return cant;
    }
}
