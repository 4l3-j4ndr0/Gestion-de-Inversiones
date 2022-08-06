/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion_BD;


import alertas.ErrorAlert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import login.login;

/**
 *
 * @author 4l3
 */
public class inicio {


    // brinda el nombre de usuario del pc donde se ejecuta
    public static String usuario(){
        String usr = System.getenv("USERNAME");
        System.out.println(usr);
        return usr;
    }
    
    private void escribe() throws IOException, SQLException {
         pide_server m = new pide_server(new JFrame(), true);
        if (existe_fichero()) {
            if (dbExists()) {
                new login().setVisible(true);
            }else{
                m.setVisible(true);
                escribe();
            }
        } else {
           
            m.setVisible(true);
            //creo un archivo en la directorio especificada
            File archivo = new File("C:\\Users\\"+usuario()+"\\Documents\\Sistema Inversiones BD_system.txt");
            String ruta=archivo.getAbsolutePath();
            File permiso=new File(ruta);
            permiso.setReadable(true); 
            permiso.setExecutable(true); 
            permiso.setWritable(true);
            BufferedWriter bw;
            bw =new BufferedWriter(new FileWriter(archivo));
           bw.write(pide_server.dir_server.getText().trim());
            bw.close();
            if (dbExists()) {
                new login().setVisible(true);
            }else{
                escribe();
            }
        }
    }
    
    private boolean existe_fichero(){
        boolean existe=false;
        File archivo = new File("C:\\Users\\"+usuario()+"\\Documents\\Sistema Inversiones BD_system.txt");
        if(archivo.exists()){
            existe=true;
        }
        System.out.println("fichero "+existe);
        return existe;
    }
    
    public boolean dbExists() throws IOException, SQLException {
        boolean exist = false;
        try {
            Connection conn = null;
            Statement st = null;
            conexion obconeccion=new conexion();
            conn=obconeccion.getCn();
            st = conn.createStatement();
            String sql = "SELECT * from gestion_aplicaciones";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                exist = true;
            }
        } catch (SQLException ex) { 
            exist = false;
            ErrorAlert error = new ErrorAlert(new JFrame(), true);
            error.msj1.setText("No pudimos conectar con el servidor de bases de datos.");
            error.msj2.setText("Por favor vuelva proporcionarnoslo");
            error.msj3.setText("");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
        }
       return exist;
    }
    
    public String server() throws FileNotFoundException, IOException {
        String servidor = "";
        File archivo = new File("C:\\Users\\"+usuario()+"\\Documents\\Sistema Inversiones BD_system.txt");
        String ruta=archivo.getAbsolutePath();
            File permiso=new File(ruta);
            permiso.setReadable(true); 
            permiso.setExecutable(true); 
            permiso.setWritable(true);
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
         servidor = br.readLine();
         fr.close();
         
        return servidor;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    new inicio().escribe();
                } catch (IOException ex) {
                    Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
