/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion_BD;

import alertas.ErrorAlert;
import configuracion.pnl_Gestionar_usuarios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_usuarios {
    
    static Statement s;
    static ResultSet rs;
    static PreparedStatement ps;
    
     String user;
     String pass;
     String user_permiso;
     String add_permiso_contratos;
     String edit_permiso_contratos;
     String delete_permiso_contratos;
     String listar_usuarios;
     String add_permiso_usuarios;
     String edit_permiso_usuarios;
     String delete_permiso_usuarios;
     String datos_cargados;
     String area;
    public static String user_control;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser_permiso() {
        return user_permiso;
    }

    public void setUser_permiso(String user_permiso) {
        this.user_permiso = user_permiso;
    }

    public String getAdd_permiso_contratos() {
        return add_permiso_contratos;
    }

    public void setAdd_permiso_contratos(String add_permiso_contratos) {
        this.add_permiso_contratos = add_permiso_contratos;
    }

    public String getEdit_permiso_contratos() {
        return edit_permiso_contratos;
    }

    public void setEdit_permiso_contratos(String edi_permiso_contratos) {
        this.edit_permiso_contratos = edi_permiso_contratos;
    }

    public String getDelete_permiso_contratos() {
        return delete_permiso_contratos;
    }

    public void setDelete_permiso_contratos(String delete_permiso_contratos) {
        this.delete_permiso_contratos = delete_permiso_contratos;
    }

    public String getListar_usuarios() {
        return listar_usuarios;
    }

    public void setListar_usuarios(String listar_usuarios) {
        this.listar_usuarios = listar_usuarios;
    }

    public String getAdd_permiso_usuarios() {
        return add_permiso_usuarios;
    }

    public void setAdd_permiso_usuarios(String add_permiso_usuarios) {
        this.add_permiso_usuarios = add_permiso_usuarios;
    }

    public String getEdit_permiso_usuarios() {
        return edit_permiso_usuarios;
    }

    public void setEdit_permiso_usuarios(String edit_permiso_usuarios) {
        this.edit_permiso_usuarios = edit_permiso_usuarios;
    }

    public String getDelete_permiso_usuarios() {
        return delete_permiso_usuarios;
    }

    public void setDelete_permiso_usuarios(String delete_permiso_usuarios) {
        this.delete_permiso_usuarios = delete_permiso_usuarios;
    }

    public String getUser_control() {
        return user_control;
    }

    public void setUser_control(String user_control) {
        this.user_control = user_control;
    }

    public String getDatos_cargados() {
        return datos_cargados;
    }

    public void setDatos_cargados(String datos_cargados) {
        this.datos_cargados = datos_cargados;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    
    
    public static int registrar_user(String user, String pass, String area) throws SQLException, IOException {
        int rsu = 0;
        conexion obconeccion=new conexion();
        String sql = "INSERT INTO usuarios(userr, pass, area) VALUES(?,?,?)";
        try {
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, area);
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
    
    public static int registrar_permisos(String user,String add_permiso_contrato,String edit_permiso_contrato,String delete_permiso_contrato,String listar_usuarios,String add_usuarios,String edit_usuarios,String delete_usuarios, String datos_cargados) throws SQLException, IOException {
        int rsu = 0;
        conexion obconeccion=new conexion();
        String sql = "INSERT INTO permisos (usuario, add_contratos,edit_contratos,delete_contratos, panel_usuarios,add_usuarios,edit_usuarios,delete_usuarios, edit_list) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, add_permiso_contrato);
            ps.setString(3, edit_permiso_contrato);
            ps.setString(4, delete_permiso_contrato);
            ps.setString(5, listar_usuarios);
            ps.setString(6, add_usuarios);
            ps.setString(7, edit_usuarios);
            ps.setString(8, delete_usuarios);
            ps.setString(9, datos_cargados);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        
                        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            ErrorAlert.lanza_error(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static void setListar(String busca) {
        try {
            
            DefaultTableModel modelo = (DefaultTableModel) pnl_Gestionar_usuarios.tabla_usuarios.getModel();
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery("select * from "+opciones_tabla_general.nombre_tabla);
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            String sql = "";
            if (busca.equals("")) {
                sql = "select * from "+opciones_tabla_general.nombre_tabla;
            } else {
                sql = "SELECT * FROM "+opciones_tabla_general.nombre_tabla+" WHERE ("
                        + "UPPER(userr) LIKE UPPER('" + busca + "%') OR "
                        + "UPPER(area) LIKE UPPER('" + busca + "%') OR "
                        + "UPPER(pass) LIKE UPPER('" + busca + "%')"
                        + ")";
            }
            String datos[] = new String[3];
            try {
                s = obconeccion.getCn().createStatement();
               rs = s.executeQuery(sql);
              while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                modelo.addRow(datos);
                  System.out.println(datos);
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
    
     public static int actualizar_permisos(String user,String add_permiso_contrato,String edit_permiso_contrato,String delete_permiso_contrato,String listar_usuarios,
             String add_usuarios,String edit_usuarios,String delete_usuarios, String datos_guardados,String user_cont) throws SQLException, IOException {
        int rsu = 0;
        conexion obconeccion=new conexion();
        String sql = "UPDATE permisos SET usuario=?,add_contratos=?,edit_contratos=?,delete_contratos=?, panel_usuarios=?, add_usuarios=?,"
            + "edit_usuarios=?,delete_usuarios=?,edit_list=? WHERE usuario=?";
        try {
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, add_permiso_contrato);
            ps.setString(3, edit_permiso_contrato);
            ps.setString(4, delete_permiso_contrato);
            ps.setString(5, listar_usuarios);
            ps.setString(6, add_usuarios);
            ps.setString(7, edit_usuarios);
            ps.setString(8, delete_usuarios);
            ps.setString(9, datos_guardados);
            ps.setString(10, user_cont);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        
                        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            ErrorAlert.lanza_error(ex);
        }
        System.out.println(sql);
        return rsu;
    }
     
     public static int actualizar_user(String user,String pass,  String area, String user_cont) throws SQLException, IOException {
       int rsu = 0;
       conexion obconeccion=new conexion();
        String sql = "UPDATE usuarios SET userr=?,pass=?, area=? WHERE userr=?";
        try {
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, area);
            ps.setString(4, user_cont);
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        
                        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            ErrorAlert.lanza_error(ex);
        }
        System.out.println(sql);
        return rsu;
    }
     
     public static int eliminar_user(String nombre) {
        int rsu = 0;
        String sql = "DELETE FROM usuarios WHERE userr = '"+nombre+"'";
        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rsu = s.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }
     
     public static int eliminar_permisos(String nombre) {
        int rsul = 0;
        String sql = "DELETE FROM permisos WHERE usuario = '"+nombre+"'";
        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rsul = s.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);
        return rsul;
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
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            ErrorAlert.lanza_error(ex);
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("dime si existe "+existe);
        return existe;
        
    }
     
     public static int extraer_id(String sql) {
        int cant = 1;

        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery(sql);
            while (rs.next()) {
                cant = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
    }
     
     public static String extraer_area(String sql) {
        String area = "";

        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery(sql);
            while (rs.next()) {
                area = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return area;
    }
     
     public static void activa_checbox_contratos(String user,String sql,JCheckBox add,JCheckBox editar,JCheckBox eliminar,JCheckBox desmarcar,JCheckBox marcar, JCheckBox datos) {
        
        int add_permiso = 0;
        int editar_permiso = 0;
        int eliminar_permiso = 0;
        int datos_cargados = 0;
        String user_permiso="";

        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery(sql);
            while (rs.next()) {
                user_permiso = rs.getString(1);
                add_permiso = rs.getInt(2);
                editar_permiso = rs.getInt(3);
                eliminar_permiso = rs.getInt(4);
                datos_cargados = rs.getInt(9);
            }
            if(user_permiso.equals(user)){
                if(add_permiso==1){
                    add.setSelected(true);
                }else{
                    add.setSelected(false);
                }
                if(editar_permiso==1){
                    editar.setSelected(true);
                }else{
                    editar.setSelected(false);
                }
                if(eliminar_permiso==1){
                    eliminar.setSelected(true);
                }else{
                    eliminar.setSelected(false);
                }
                if(datos_cargados==1){
                    datos.setSelected(true);
                }else{
                    datos.setSelected(false);
                }
                if(add_permiso==1&&editar_permiso==1&&eliminar_permiso==1&&datos_cargados==1){
                    marcar.setSelected(true);
                    add.setSelected(true);
                    editar.setSelected(true);
                    eliminar.setSelected(true);
                    datos.setSelected(true);
                    desmarcar.setSelected(false);
                }
                if(add_permiso==0&&editar_permiso==0&&eliminar_permiso==0&&datos_cargados==0){
                    desmarcar.setSelected(true);
                    add.setSelected(false);
                    editar.setSelected(false);
                    datos.setSelected(false);
                    eliminar.setSelected(false);
                    marcar.setSelected(false);
                }
                if(add_permiso==1||editar_permiso==1||eliminar_permiso==1||datos_cargados==1){
                    desmarcar.setSelected(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static void activa_checbox_usuario(String user,String sql,JCheckBox listar,JCheckBox add,JCheckBox editar,JCheckBox eliminar,JCheckBox desmarcar,JCheckBox marcar) {
        int listar_permiso = 0;
        int add_permiso = 0;
        int editar_permiso = 0;
        int eliminar_permiso = 0;
        String user_permiso="";

        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery(sql);
            while (rs.next()) {
                user_permiso = rs.getString(1);
                listar_permiso = rs.getInt(5);
                add_permiso = rs.getInt(6);
                editar_permiso = rs.getInt(7);
                eliminar_permiso = rs.getInt(8);
            }
            if(user_permiso.equals(user)){
                if(listar_permiso==1){
                    listar.setSelected(true);
                }else{
                    listar.setSelected(false);
                }
                if(add_permiso==1){
                    add.setSelected(true);
                }else{
                    add.setSelected(false);
                }
                if(editar_permiso==1){
                    editar.setSelected(true);
                }else{
                    editar.setSelected(false);
                }
                if(eliminar_permiso==1){
                    eliminar.setSelected(true);
                }else{
                    eliminar.setSelected(false);
                }
                if(listar_permiso==1&&add_permiso==1&&editar_permiso==1&&eliminar_permiso==1){
                    marcar.setSelected(true);
                    listar.setSelected(true);
                    add.setSelected(true);
                    editar.setSelected(true);
                    eliminar.setSelected(true);
                    desmarcar.setSelected(false);
                }
                if(listar_permiso==0&&add_permiso==0&&editar_permiso==0&&eliminar_permiso==0){
                    desmarcar.setSelected(true);
                    listar.setSelected(false);
                    add.setSelected(false);
                    editar.setSelected(false);
                    eliminar.setSelected(false);
                    marcar.setSelected(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
