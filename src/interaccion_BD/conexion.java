/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion_BD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author 4l3
 */
public class conexion {
  inicio ini=new inicio();
  private Connection conexion;
  public String url;
  public  Connection cn;

 public static void main(String[] args) throws SQLException, IOException {
  conexion obconeccion=new conexion();
    obconeccion.Conectar();
    }

    public conexion() throws SQLException, IOException {
        this.url = "jdbc:oracle:thin:@"+ini.server()+":1521:GOYADES";
        this.cn = DriverManager.getConnection(url, "GOYA","GoyaAdmin01");
    }
 
    
 
    public conexion Conectar()
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@"+server()+":1521:GOYADES";
        conexion= DriverManager.getConnection(BaseDeDatos,"GOYA","GoyaAdmin01");
        if(conexion!=null)
        {
        System.out.println("Conexion exitosa");
        }
        else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {System.out.println("error"+e);}
       
    return this;
    }

    private String server() throws FileNotFoundException, IOException {
        String servidor = "";
        File archivo = new File("C:\\Users\\"+inicio.usuario()+"\\Documents\\Sistema Inversiones BD_system.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
         servidor = br.readLine();
         fr.close();
         
        return servidor;
    }

    public Connection getConexion() {
        return conexion;
    }

    public String getUrl() {
        return url;
    }

    public Connection getCn() {
        return cn;
    }
    
    
    

     
    
    
     
}
