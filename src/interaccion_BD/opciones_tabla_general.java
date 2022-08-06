/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion_BD;

import alertas.ErrorAlert;
import estilo_tabla.Clase_CellEditor;
import estilo_tabla.EstiloTablaRenderer;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import paneles.pnlHome;
import paneles.pnl_add;
import static paneles.pnl_add.alarma;
import static paneles.pnl_add.anos_prorrogable;
import static paneles.pnl_add.capitulo;
import static paneles.pnl_add.certificados_nov_2020;
import static paneles.pnl_add.combo_area;
import static paneles.pnl_add.combo_empresa_adjudicatoria;
import static paneles.pnl_add.combo_estado_expediente;
import static paneles.pnl_add.combo_materia;
import static paneles.pnl_add.combo_prioridad;
import static paneles.pnl_add.combo_procedimiento;
import static paneles.pnl_add.combo_promotor;
import static paneles.pnl_add.combo_resp_area;
import static paneles.pnl_add.combo_resp_unidad;
import static paneles.pnl_add.combo_tipo_contexto;
import static paneles.pnl_add.combo_tipo_espediente;
import static paneles.pnl_add.combo_unidad;
import static paneles.pnl_add.descripcion;
import static paneles.pnl_add.dl_validado;
import static paneles.pnl_add.estado_garantia;
import static paneles.pnl_add.futuro_lote;
import static paneles.pnl_add.id_goya;
import static paneles.pnl_add.importe_adjudicacion;
import static paneles.pnl_add.importe_adjudicado_sin_iva;
import static paneles.pnl_add.importe_expediente;
import static paneles.pnl_add.lbl_error_alarma;
import static paneles.pnl_add.lbl_error_anos_prorrogable;
import static paneles.pnl_add.lbl_error_capitulo;
import static paneles.pnl_add.lbl_error_certificados_nov_2020;
import static paneles.pnl_add.lbl_error_combo_area;
import static paneles.pnl_add.lbl_error_combo_empresa_adjudicatoria;
import static paneles.pnl_add.lbl_error_combo_estado_expediente;
import static paneles.pnl_add.lbl_error_combo_materia;
import static paneles.pnl_add.lbl_error_combo_prioridad;
import static paneles.pnl_add.lbl_error_combo_procedimiento;
import static paneles.pnl_add.lbl_error_combo_promotor;
import static paneles.pnl_add.lbl_error_combo_resp_area;
import static paneles.pnl_add.lbl_error_combo_resp_unidad;
import static paneles.pnl_add.lbl_error_combo_tipo_cxto;
import static paneles.pnl_add.lbl_error_combo_tipo_expediente;
import static paneles.pnl_add.lbl_error_combo_unidad;
import static paneles.pnl_add.lbl_error_dl_validado;
import static paneles.pnl_add.lbl_error_estado_de_garantia;
import static paneles.pnl_add.lbl_error_futuro_lote;
import static paneles.pnl_add.lbl_error_id_goya;
import static paneles.pnl_add.lbl_error_importe_adjudicacion;
import static paneles.pnl_add.lbl_error_importe_adjudicacion_sin_iva;
import static paneles.pnl_add.lbl_error_importe_expediente;
import static paneles.pnl_add.lbl_error_mto_garantia;
import static paneles.pnl_add.lbl_error_no_expediente;
import static paneles.pnl_add.lbl_error_pasado_mtos_incluida_en;
import static paneles.pnl_add.lbl_error_presupuesto_base_sin_iva;
import static paneles.pnl_add.lbl_error_proyecto;
import static paneles.pnl_add.lbl_error_responsable_auxiliar;
import static paneles.pnl_add.lbl_error_tiempo_ejecucion;
import static paneles.pnl_add.lbl_error_unidad_auxiliar;
import static paneles.pnl_add.mto_garantia;
import static paneles.pnl_add.no_cxto;
import static paneles.pnl_add.no_expediente;
import static paneles.pnl_add.pasado_mtos_incluida_en;
import static paneles.pnl_add.presupuesto_base_sin_iva;
import static paneles.pnl_add.proyecto;
import static paneles.pnl_add.responsable_auxiliar;
import static paneles.pnl_add.text_area_estado_oocc_09_07_2021;
import static paneles.pnl_add.text_area_fecha_adjudicacion;
import static paneles.pnl_add.text_area_fecha_formalizacion;
import static paneles.pnl_add.text_area_fecha_inicio_garantia_aproximada;
import static paneles.pnl_add.text_area_fin_garantia_aprox;
import static paneles.pnl_add.text_area_informe_tecnico_realizado;
import static paneles.pnl_add.text_area_nuevo_expte_cotec;
import static paneles.pnl_add.text_area_observaciones;
import static paneles.pnl_add.text_area_observaciones_oya;
import static paneles.pnl_add.text_area_otras_fechas;
import static paneles.pnl_add.text_area_sol_adquisicion;
import static paneles.pnl_add.text_memoria_tecnica_validada;
import static paneles.pnl_add.tiempo_ejecucion;
import static paneles.pnl_add.unidad_auxiliar;
import rojeru_san.rsfield.RSTextMaterial;


/**
 *
 * @author 4l3
 */
public class opciones_tabla_general {
    
    
    static Statement s;
    static ResultSet rs;
    public static String nombre_tabla = "gestion_produccion";
    static PreparedStatement ps;
    
    
    
    public static void no_mostrar(String tabla) {
        DefaultTableModel modelo = (DefaultTableModel) pnlHome.tabla_general.getModel();
        for (int i = 0; i < pnlHome.tabla_general.getRowCount(); i++) {
            while (pnlHome.tabla_general.getValueAt(i, 46).toString().equals(tabla)) {
                pnlHome.tabla_general.setValueAt(false, i, 47);
                modelo.removeRow(i);
                i=0;
            }
        }
    }
    
    
    public static void setListar(String busca,String tabla) {
        try {
            conexion obconeccion=new conexion();
            DefaultTableModel modelo = (DefaultTableModel) pnlHome.tabla_general.getModel();
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery("select * from "+tabla);
            String sql = "";
            if (busca.equals("")) {
                sql = "select * from "+tabla;
            } else {
                sql = "SELECT * FROM "+tabla+" WHERE ("
                        + "id_goya LIKE'" + busca + "%' OR "
                        + "no_cxto LIKE'" + busca + "%' OR "
                        + "no_de_expediente LIKE'" + busca + "%' OR "
                        + "UPPER(descripcion) LIKE UPPER('%" + busca + "%') OR "
                        + "UPPER(tipo_de_cxto) LIKE UPPER('" + busca + "%') OR "
                        + "UPPER(area) LIKE UPPER('" + busca + "%') OR "
                        + "UPPER(unidad) LIKE UPPER('" + busca + "%') OR "
                        + "UPPER(resp_area) LIKE UPPER('" + busca + "%') OR "
                        + "UPPER(resp_unidad) LIKE UPPER('" + busca + "%') OR "
                        + "UPPER(pendiente) LIKE UPPER('" + busca + "%') OR "
                        + "UPPER(estado_expediente) LIKE UPPER('" + busca + "%')"
                        + ")";
            }
            
            
            
            Object datos[] = new Object[49];
            try {
                s = obconeccion.getCn().createStatement();
               rs = s.executeQuery(sql);
              while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);
                datos[13] = rs.getString(14);
                datos[14] = rs.getString(15);
                datos[15] = rs.getString(16);
                datos[16] = rs.getString(17);
                datos[17] = rs.getString(18);
                datos[18] = rs.getString(19);
                datos[19] = rs.getString(20);
                datos[20] = rs.getString(21);
                datos[21] = rs.getString(22);
                datos[22] = rs.getString(23);
                datos[23] = rs.getString(24);
                datos[24] = rs.getString(25);
                datos[25] = rs.getString(26);
                datos[26] = rs.getString(27);
                datos[27] = rs.getString(28);
                datos[28] = rs.getString(29);
                datos[29] = rs.getString(30);
                datos[30] = rs.getString(31);
                datos[31] = rs.getString(32);
                datos[32] = rs.getString(33);
                datos[33] = rs.getString(34);
                datos[34] = rs.getString(35);
                datos[35] = rs.getString(36);
                datos[36] = rs.getString(37);
                datos[37] = rs.getString(38);
                datos[38] = rs.getString(39);
                datos[39] = rs.getString(40);
                datos[40] = rs.getString(41);
                datos[41] = rs.getString(42);
                datos[42] = rs.getString(43);
                datos[43] = rs.getString(44);
                datos[44] = rs.getString(45);
                datos[45] = rs.getString(46);
                datos[46] = tabla;
                datos[47] = false;
                datos[48] = rs.getString(47);
                modelo.addRow(datos);
                }
              pnlHome.tabla_general.setModel(modelo);
              pnlHome.tabla_general.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
            } catch (SQLException ex) {
                Logger.getLogger(pnlHome.class.getName()).log(Level.SEVERE, null, ex);
                ErrorAlert error = new ErrorAlert(new JFrame(), true);
                error.msj1.setText(ex.toString());
                error.msj2.setText("Por favor contacte con soporte técnico");
                error.msj3.setText("");
                error.preferredSize();
                error.pack();
                error.setVisible(true);
                 
            }
        } catch (IOException ex) {
            Logger.getLogger(pnlHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(pnlHome.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    public static int eliminar(String id, String tabla) {
        int rsu = 0;
        String sql = "";

        try {
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rsu = s.executeUpdate("DELETE FROM "+tabla+" WHERE id_goya = '"+id+"'");
            //Obteniendo la informacion de las columnas que estan siendo consultadas
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(opciones_tabla_general.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsu;
    }
    
    public static void get_combos(JComboBox combo1, String sql) throws SQLException, IOException {     
        conexion obconeccion=new conexion();
        try {
            Statement st = obconeccion.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                combo1.addItem(rs.getString(1));
            }
            rs.close();
        } catch (Exception ex) {
            ErrorAlert.lanza_error(ex);
        }
    }
    
    public static int registrar_tabla_genaral(String ID_Goya, String NO_Cxto, String NO_Expediente, String Descripcion, String Tipo_Cxto, String Prioridad, 
            String materia, String Promotor, String Area, String Unidad, String Resp_area, String Resp_Unidad, String	Unidad_auxiliar, String	Responsable_Auxiliar, 
            
            String Presupuesto_Base_sin_IVA, String Importe_Adjudicado_sin_IVA, String Estado_Expediente, String Mto_Garantia, String	Tiempo_Ejecucion, 
            
            String Inicio_Garantia_Aprox, String Fin_Garantia_Aprox, String Anos_Prorrogable, String Alarma, String Futuro_Lote, String Proyecto, String Estado_de_Garantia, 
           
            String Psado_Mtos_Incluida_en, String Sol_adquisicion, String Memoria_Tecnica_validada, String DL_Validado, String Nuevo_Expte_Cotec_de, String Tipo_Expediente, 
           
            String Procedimiento, String Importe_Expediente, String Ult_dia_prest_Ofertas, String Informe_Tecnico_realizado, String Fecha_Adjudicacion, String Empresa_Adjudicatoria, 
           
            String Importe_de_Adjudicacion, String Fecha_Fornalizacion, String Otras_Fechas, String Capitulo, String Certificados_Nov_2020, String Estado_OOCC_09_07_2021, 
           
            String Observaciones, String Observaciones_de_OYA, String sql) throws SQLException, IOException {
        int rsu = 0;
        conexion obconeccion=new conexion();
        try {
            ps = obconeccion.getCn().prepareStatement(sql);
            ps.setString(1, ID_Goya);
            ps.setString(2, NO_Cxto);
            ps.setString(3, NO_Expediente);
            ps.setString(4, Descripcion);
            ps.setString(5, Tipo_Cxto);
            ps.setString(6, Prioridad);
            ps.setString(7, materia);
            ps.setString(8, Promotor);
            ps.setString(9, Area);
            ps.setString(10, Unidad);
            ps.setString(11, Resp_area);
            ps.setString(12, Resp_Unidad);
            ps.setString(13, Unidad_auxiliar);
            ps.setString(14, Responsable_Auxiliar);
            ps.setString(15, Presupuesto_Base_sin_IVA);
            ps.setString(16, Importe_Adjudicado_sin_IVA);
            ps.setString(17, Estado_Expediente);
            ps.setString(18, Mto_Garantia);
            ps.setString(19, Tiempo_Ejecucion);
            ps.setString(20, Inicio_Garantia_Aprox);
            ps.setString(21, Fin_Garantia_Aprox);
            ps.setString(22, Anos_Prorrogable);
            ps.setString(23, Alarma);
            ps.setString(24, Futuro_Lote);
            ps.setString(25, Proyecto);
            ps.setString(26, Estado_de_Garantia);
            ps.setString(27, Psado_Mtos_Incluida_en);
            ps.setString(28, Sol_adquisicion);
            ps.setString(29, Memoria_Tecnica_validada);
            ps.setString(30, DL_Validado);
            ps.setString(31, Nuevo_Expte_Cotec_de);
            ps.setString(32, Tipo_Expediente);
            ps.setString(33, Procedimiento);
            ps.setString(34, Importe_Expediente);
            ps.setString(35, Ult_dia_prest_Ofertas);
            ps.setString(36, Informe_Tecnico_realizado);
            ps.setString(37, Fecha_Adjudicacion);
            ps.setString(38, Empresa_Adjudicatoria);
            ps.setString(39, Importe_de_Adjudicacion);
            ps.setString(40, Fecha_Fornalizacion);
            ps.setString(41, Otras_Fechas);
            ps.setString(42, Capitulo);
            ps.setString(43, Certificados_Nov_2020);
            ps.setString(44, Estado_OOCC_09_07_2021);
            ps.setString(45, Observaciones);
            ps.setString(46, Observaciones_de_OYA);
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
    
    public static void actualizar_pendiente(String valor,String id, String tabla) throws SQLException, IOException {
        String sql="UPDATE "+tabla+" SET pendiente = '"+valor+"' WHERE id_goya = '"+id+"'"; 
        conexion obconeccion=new conexion();
        try {
            Statement stmt=obconeccion.getCn().createStatement();
            rs = stmt.executeQuery(sql);
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
    }
    
    public static void extraerDatos(String sql) throws SQLException, IOException {
        conexion obconeccion=new conexion();
        try {
            Statement st = obconeccion.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
    // jlabel 
            if (rs.next()) {
                id_goya.setText(String.valueOf(rs.getString(1)));
                if(id_goya.getText().length()>0){
        lbl_error_id_goya.setVisible(true);
        lbl_error_id_goya.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_id_goya.setIcon(null); // NOI18N
        lbl_error_id_goya.setText("ID_GOYA");
        }else{
            lbl_error_id_goya.setVisible(false);
        }
                if(!String.valueOf(rs.getString(2)).equals("null")){
                    no_cxto.setText(String.valueOf(rs.getString(2)));
                    if(no_cxto.getText().length()>0){
                        pnl_add.lbl_error_no_cxto.setVisible(true);
        pnl_add.lbl_error_no_cxto.setForeground(new java.awt.Color(0, 0, 0));
        pnl_add.lbl_error_no_cxto.setIcon(null); // NOI18N
        pnl_add.lbl_error_no_cxto.setText("Nº Cxto");
        }else{
            pnl_add.lbl_error_no_cxto.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(13)).equals("null")){
                    unidad_auxiliar.setText(String.valueOf(rs.getString(13)));
                    if(unidad_auxiliar.getText().length()>0){
        lbl_error_unidad_auxiliar.setVisible(true);
        lbl_error_unidad_auxiliar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_unidad_auxiliar.setIcon(null); // NOI18N
        lbl_error_unidad_auxiliar.setText("Unidad Auxiliar");
        }else{
            lbl_error_unidad_auxiliar.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(3)).equals("null")){
                    no_expediente.setText(String.valueOf(rs.getString(3)));
                    if(no_expediente.getText().length()>0){
        lbl_error_no_expediente.setVisible(true);
        lbl_error_no_expediente.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_no_expediente.setIcon(null); // NOI18N
        lbl_error_no_expediente.setText("Nº Expediente");
        }else{
            lbl_error_no_expediente.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(19)).equals("null")){
                    tiempo_ejecucion.setText(String.valueOf(rs.getString(19)));
                    if(tiempo_ejecucion.getText().length()>0){
        lbl_error_tiempo_ejecucion.setVisible(true);
        lbl_error_tiempo_ejecucion.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_tiempo_ejecucion.setIcon(null); // NOI18N
        lbl_error_tiempo_ejecucion.setText("Tiempo Ejecución");
        }else{
            lbl_error_tiempo_ejecucion.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(16)).equals("null")){
                    importe_adjudicado_sin_iva.setText(String.valueOf(rs.getString(16)));
                    if(importe_adjudicado_sin_iva.getText().length()>0){
        lbl_error_importe_adjudicacion_sin_iva.setVisible(true);
        lbl_error_importe_adjudicacion_sin_iva.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_importe_adjudicacion_sin_iva.setIcon(null); // NOI18N
        lbl_error_importe_adjudicacion_sin_iva.setText("Importe Adjudicado sin IVA");
        }else{
            lbl_error_importe_adjudicacion_sin_iva.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(15)).equals("null")){
                    presupuesto_base_sin_iva.setText(String.valueOf(rs.getString(15)));
                    if(presupuesto_base_sin_iva.getText().length()>0){
        lbl_error_presupuesto_base_sin_iva.setVisible(true);
        lbl_error_presupuesto_base_sin_iva.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_presupuesto_base_sin_iva.setIcon(null); // NOI18N
        lbl_error_presupuesto_base_sin_iva.setText("Presupuesto Base sin IVA");
        }else{
            lbl_error_presupuesto_base_sin_iva.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(25)).equals("null")){
                    proyecto.setText(String.valueOf(rs.getString(25)));
                    if(proyecto.getText().length()>0){
        lbl_error_proyecto.setVisible(true);
        lbl_error_proyecto.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_proyecto.setIcon(null); // NOI18N
        lbl_error_proyecto.setText("Proyecto");
        }else{
            lbl_error_proyecto.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(43)).equals("null")){
                    certificados_nov_2020.setText(String.valueOf(rs.getString(43)));
                    if(certificados_nov_2020.getText().length()>0){
        lbl_error_certificados_nov_2020.setVisible(true);
        lbl_error_certificados_nov_2020.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_certificados_nov_2020.setIcon(null); // NOI18N
        lbl_error_certificados_nov_2020.setText("Certificados a Nov_2020");
        }else{
            lbl_error_certificados_nov_2020.setVisible(false);
        }
                }
                
                if(!String.valueOf(rs.getString(23)).equals("null")){
                    alarma.setText(String.valueOf(rs.getString(23)));
                    if(alarma.getText().length()>0){
        lbl_error_alarma.setVisible(true);
        lbl_error_alarma.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_alarma.setIcon(null); // NOI18N
        lbl_error_alarma.setText("Alarma");
        }else{
            lbl_error_alarma.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(22)).equals("null")){
                   anos_prorrogable.setText(String.valueOf(rs.getString(22)));
                   if(anos_prorrogable.getText().length()>0){
        lbl_error_anos_prorrogable.setVisible(true);
        lbl_error_anos_prorrogable.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_anos_prorrogable.setIcon(null); // NOI18N
        lbl_error_anos_prorrogable.setText("Años Prorrogable");
        }else{
            lbl_error_anos_prorrogable.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(14)).equals("null")){
                   responsable_auxiliar.setText(String.valueOf(rs.getString(14)));
                   if(responsable_auxiliar.getText().length()>0){
        lbl_error_responsable_auxiliar.setVisible(true);
        lbl_error_responsable_auxiliar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_responsable_auxiliar.setIcon(null); // NOI18N
        lbl_error_responsable_auxiliar.setText("Responsable Auxiliar");
        }else{
            lbl_error_responsable_auxiliar.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(26)).equals("null")){
                   estado_garantia.setText(String.valueOf(rs.getString(26)));
                   if(estado_garantia.getText().length()>0){
        lbl_error_estado_de_garantia.setVisible(true);
        lbl_error_estado_de_garantia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_estado_de_garantia.setIcon(null); // NOI18N
        lbl_error_estado_de_garantia.setText("Estado de Garantía");
        }else{
            lbl_error_estado_de_garantia.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(30)).equals("null")){
                   dl_validado.setText(String.valueOf(rs.getString(30)));
                   if(dl_validado.getText().length()>0){
        lbl_error_dl_validado.setVisible(true);
        lbl_error_dl_validado.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_dl_validado.setIcon(null); // NOI18N
        lbl_error_dl_validado.setText("DL Validado");
        }else{
            lbl_error_dl_validado.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(27)).equals("null")){
                   pasado_mtos_incluida_en.setText(String.valueOf(rs.getString(27)));
                   if(pasado_mtos_incluida_en.getText().length()>0){
        lbl_error_pasado_mtos_incluida_en.setVisible(true);
        lbl_error_pasado_mtos_incluida_en.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_pasado_mtos_incluida_en.setIcon(null); // NOI18N
        lbl_error_pasado_mtos_incluida_en.setText("Psado a Mtos/ Incluida en:");
        }else{
            lbl_error_pasado_mtos_incluida_en.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(42)).equals("null")){
                   capitulo.setText(String.valueOf(rs.getString(42)));
                   if(capitulo.getText().length()>0){
        lbl_error_capitulo.setVisible(true);
        lbl_error_capitulo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_capitulo.setIcon(null); // NOI18N
        lbl_error_capitulo.setText("Capítulo");
        }else{
            lbl_error_capitulo.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(34)).equals("null")){
                   importe_expediente.setText(String.valueOf(rs.getString(34)));
                   if(importe_expediente.getText().length()>0){
        lbl_error_importe_expediente.setVisible(true);
        lbl_error_importe_expediente.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_importe_expediente.setIcon(null); // NOI18N
        lbl_error_importe_expediente.setText("Importe Expediente");
        }else{
            lbl_error_importe_expediente.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(39)).equals("null")){
                   importe_adjudicacion.setText(String.valueOf(rs.getString(39)));
                   if(importe_adjudicacion.getText().length()>0){
        lbl_error_importe_adjudicacion.setVisible(true);
        lbl_error_importe_adjudicacion.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_importe_adjudicacion.setIcon(null); // NOI18N
        lbl_error_importe_adjudicacion.setText("Importe de Adjudicación");
        }else{
            lbl_error_importe_adjudicacion.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(24)).equals("null")){
                   futuro_lote.setText(String.valueOf(rs.getString(24)));
                   if(futuro_lote.getText().length()>0){
        lbl_error_futuro_lote.setVisible(true);
        lbl_error_futuro_lote.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_futuro_lote.setIcon(null); // NOI18N
        lbl_error_futuro_lote.setText("Futuro Lote");
        }else{
            lbl_error_futuro_lote.setVisible(false);
        }
                }
                if(!String.valueOf(rs.getString(18)).equals("null")){
                   mto_garantia.setText(String.valueOf(rs.getString(18)));
                   if(mto_garantia.getText().length()>0){
        lbl_error_mto_garantia.setVisible(true);
        lbl_error_mto_garantia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_mto_garantia.setIcon(null); // NOI18N
        lbl_error_mto_garantia.setText("Mto/Garantía");
        }else{
            lbl_error_mto_garantia.setVisible(false);
        }
                }
       
       // combos
                if (!String.valueOf(rs.getString(9)).equals("null")) {
                    if (pnl_add.editable == false) {
                        pnl_add.combo_area.addItem(rs.getString(9));
                        pnl_add.combo_area.setSelectedItem(String.valueOf(rs.getString(9)));
                        pnl_add.combo_area.removeItemAt(0);
                        lbl_error_combo_area.setVisible(true);
                        lbl_error_combo_area.setForeground(new java.awt.Color(0, 0, 0));
                        lbl_error_combo_area.setIcon(null); // NOI18N
                        lbl_error_combo_area.setText("Área");
                    } else {
                   pnl_add.combo_area.setSelectedItem(String.valueOf(rs.getString(9)));
              }
                   if(!combo_area.getSelectedItem().toString().equals("Área")){
       lbl_error_combo_area.setVisible(true);
       lbl_error_combo_area.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_area.setIcon(null); // NOI18N
       lbl_error_combo_area.setText("Área");
        }else{
            lbl_error_combo_area.setVisible(false);
        }
                   
                }
              if(!String.valueOf(rs.getString(11)).equals("null")){
                  if (pnl_add.editable == false) {
                        pnl_add.combo_resp_area.addItem(rs.getString(11));
                        pnl_add.combo_resp_area.setSelectedItem(String.valueOf(rs.getString(11)));
                        pnl_add.combo_resp_area.removeItemAt(0);
                        lbl_error_combo_resp_area.setVisible(true);
                        lbl_error_combo_resp_area.setForeground(new java.awt.Color(0, 0, 0));
                        lbl_error_combo_resp_area.setIcon(null); // NOI18N
                        lbl_error_combo_resp_area.setText("Resp Área");
                    }else{
                   pnl_add.combo_resp_area.setSelectedItem(String.valueOf(rs.getString(11)));
                  }
                   if(!combo_resp_area.getSelectedItem().toString().equals("Resp Área")){
       lbl_error_combo_resp_area.setVisible(true);
       lbl_error_combo_resp_area.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_resp_area.setIcon(null); // NOI18N
       lbl_error_combo_resp_area.setText("Resp Área");
        }else{
            lbl_error_combo_resp_area.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(5)).equals("null")){
                  if (pnl_add.editable == false) {
                        pnl_add.combo_tipo_contexto.addItem(rs.getString(5));
                        pnl_add.combo_tipo_contexto.setSelectedItem(String.valueOf(rs.getString(5)));
                        pnl_add.combo_tipo_contexto.removeItemAt(0);
                        lbl_error_combo_tipo_cxto.setVisible(true);
                        lbl_error_combo_tipo_cxto.setForeground(new java.awt.Color(0, 0, 0));
                        lbl_error_combo_tipo_cxto.setIcon(null); // NOI18N
                        lbl_error_combo_tipo_cxto.setText("Tipo de Cxto");
                    }else{
                   combo_tipo_contexto.setSelectedItem(String.valueOf(rs.getString(5)));
                  }
                   if(!combo_tipo_contexto.getSelectedItem().toString().equals("Tipo de Cxto")){
       lbl_error_combo_tipo_cxto.setVisible(true);
       lbl_error_combo_tipo_cxto.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_tipo_cxto.setIcon(null); // NOI18N
       lbl_error_combo_tipo_cxto.setText("Tipo de Cxto");
        }else{
            lbl_error_combo_tipo_cxto.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(32)).equals("null")){
                  if (pnl_add.editable == false) {
                  pnl_add.combo_tipo_espediente.addItem(rs.getString(32));
                        pnl_add.combo_tipo_espediente.setSelectedItem(String.valueOf(rs.getString(32)));
                        pnl_add.combo_tipo_espediente.removeItemAt(0);
                        lbl_error_combo_tipo_expediente.setVisible(true);
                        lbl_error_combo_tipo_expediente.setForeground(new java.awt.Color(0, 0, 0));
                        lbl_error_combo_tipo_expediente.setIcon(null); // NOI18N
                        lbl_error_combo_tipo_expediente.setText("Tipo Expediente");
                    }else{
                   combo_tipo_espediente.setSelectedItem(String.valueOf(rs.getString(32)));
              }
                   if(!combo_tipo_espediente.getSelectedItem().toString().equals("Tipo Expediente")){
       lbl_error_combo_tipo_expediente.setVisible(true);
       lbl_error_combo_tipo_expediente.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_tipo_expediente.setIcon(null); // NOI18N
       lbl_error_combo_tipo_expediente.setText("Tipo Expediente");
        }else{
            lbl_error_combo_tipo_expediente.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(7)).equals("null")){
                  if (pnl_add.editable == false) {
                  pnl_add.combo_materia.addItem(rs.getString(7));
                        pnl_add.combo_materia.setSelectedItem(String.valueOf(rs.getString(7)));
                        pnl_add.combo_materia.removeItemAt(0);
                        lbl_error_combo_materia.setVisible(true);
                        lbl_error_combo_materia.setForeground(new java.awt.Color(0, 0, 0));
                        lbl_error_combo_materia.setIcon(null); // NOI18N
                        lbl_error_combo_materia.setText("Materia");
                    }else{
                   combo_materia.setSelectedItem(String.valueOf(rs.getString(7)));
              }
                   if(!combo_materia.getSelectedItem().toString().equals("Materia")){
       lbl_error_combo_materia.setVisible(true);
       lbl_error_combo_materia.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_materia.setIcon(null); // NOI18N
       lbl_error_combo_materia.setText("Materia");
        }else{
            lbl_error_combo_materia.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(17)).equals("null")){
                  if (pnl_add.editable == false) {
                      pnl_add.combo_estado_expediente.addItem(rs.getString(17));
                      pnl_add.combo_estado_expediente.setSelectedItem(String.valueOf(rs.getString(17)));
                      pnl_add.combo_estado_expediente.removeItemAt(0);
                      lbl_error_combo_estado_expediente.setVisible(true);
                      lbl_error_combo_estado_expediente.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_estado_expediente.setIcon(null); // NOI18N
                      lbl_error_combo_estado_expediente.setText("Estado Expediente");
                  } else {
                   combo_estado_expediente.setSelectedItem(String.valueOf(rs.getString(17)));
                  }
                   if(!combo_estado_expediente.getSelectedItem().toString().equals("Estado Expediente")){
       lbl_error_combo_estado_expediente.setVisible(true);
       lbl_error_combo_estado_expediente.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_estado_expediente.setIcon(null); // NOI18N
       lbl_error_combo_estado_expediente.setText("Estado Expediente");
        }else{
            lbl_error_combo_estado_expediente.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(8)).equals("null")){
                  if (pnl_add.editable == false) {
                      pnl_add.combo_promotor.addItem(rs.getString(8));
                      pnl_add.combo_promotor.setSelectedItem(String.valueOf(rs.getString(8)));
                      pnl_add.combo_promotor.removeItemAt(0);
                      lbl_error_combo_promotor.setVisible(true);
                      lbl_error_combo_promotor.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_promotor.setIcon(null); // NOI18N
                      lbl_error_combo_promotor.setText("Promotor");
                  } else {
                   combo_promotor.setSelectedItem(String.valueOf(rs.getString(8)));
                  }
                   if(!combo_promotor.getSelectedItem().toString().equals("Promotor")){
       lbl_error_combo_promotor.setVisible(true);
       lbl_error_combo_promotor.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_promotor.setIcon(null); // NOI18N
       lbl_error_combo_promotor.setText("Promotor");
        }else{
            lbl_error_combo_promotor.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(10)).equals("null")){
                  if (pnl_add.editable == false) {
                      pnl_add.combo_unidad.addItem(rs.getString(10));
                      pnl_add.combo_unidad.setSelectedItem(String.valueOf(rs.getString(10)));
                      pnl_add.combo_unidad.removeItemAt(0);
                      lbl_error_combo_unidad.setVisible(true);
                      lbl_error_combo_unidad.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_unidad.setIcon(null); // NOI18N
                      lbl_error_combo_unidad.setText("Unidad");
                  } else {
                   combo_unidad.setSelectedItem(String.valueOf(rs.getString(10)));
                  }
                   if(!combo_unidad.getSelectedItem().toString().equals("Unidad")){
       lbl_error_combo_unidad.setVisible(true);
       lbl_error_combo_unidad.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_unidad.setIcon(null); // NOI18N
       lbl_error_combo_unidad.setText("Unidad");
        }else{
            lbl_error_combo_unidad.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(38)).equals("null")){
                  if (pnl_add.editable == false) {
                      pnl_add.combo_empresa_adjudicatoria.addItem(rs.getString(38));
                      pnl_add.combo_empresa_adjudicatoria.setSelectedItem(String.valueOf(rs.getString(38)));
                      pnl_add.combo_empresa_adjudicatoria.removeItemAt(0);
                      lbl_error_combo_empresa_adjudicatoria.setVisible(true);
                      lbl_error_combo_empresa_adjudicatoria.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_empresa_adjudicatoria.setIcon(null); // NOI18N
                      lbl_error_combo_empresa_adjudicatoria.setText("Empresa Adjudicatoria");
                  } else {
                   combo_empresa_adjudicatoria.setSelectedItem(String.valueOf(rs.getString(38)));
                  }
                   if(!combo_empresa_adjudicatoria.getSelectedItem().toString().equals("Empresa Adjudicatoria")){
       lbl_error_combo_empresa_adjudicatoria.setVisible(true);
       lbl_error_combo_empresa_adjudicatoria.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_empresa_adjudicatoria.setIcon(null); // NOI18N
       lbl_error_combo_empresa_adjudicatoria.setText("Empresa Adjudicatoria");
        }else{
            lbl_error_combo_empresa_adjudicatoria.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(33)).equals("null")){
                  if (pnl_add.editable == false) {
                      pnl_add.combo_procedimiento.addItem(rs.getString(33));
                      pnl_add.combo_procedimiento.setSelectedItem(String.valueOf(rs.getString(33)));
                      pnl_add.combo_procedimiento.removeItemAt(0);
                      lbl_error_combo_procedimiento.setVisible(true);
                      lbl_error_combo_procedimiento.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_procedimiento.setIcon(null); // NOI18N
                      lbl_error_combo_procedimiento.setText("Procedimiento");
                  } else {
                   combo_procedimiento.setSelectedItem(String.valueOf(rs.getString(33)));
                  }
                   if(!combo_procedimiento.getSelectedItem().toString().equals("Procedimiento")){
       lbl_error_combo_procedimiento.setVisible(true);
       lbl_error_combo_procedimiento.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_procedimiento.setIcon(null); // NOI18N
       lbl_error_combo_procedimiento.setText("Procedimiento");
        }else{
            lbl_error_combo_procedimiento.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(6)).equals("null")){
                  if (pnl_add.editable == false) {
                      pnl_add.combo_prioridad.addItem(rs.getString(6));
                      pnl_add.combo_prioridad.setSelectedItem(String.valueOf(rs.getString(6)));
                      pnl_add.combo_prioridad.removeItemAt(0);
                      lbl_error_combo_prioridad.setVisible(true);
                      lbl_error_combo_prioridad.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_prioridad.setIcon(null); // NOI18N
                      lbl_error_combo_prioridad.setText("Prioridad");
                  } else {
                   combo_prioridad.setSelectedItem(String.valueOf(rs.getString(6)));
                  }
                   if(!combo_prioridad.getSelectedItem().toString().equals("Prioridad")){
       lbl_error_combo_prioridad.setVisible(true);
       lbl_error_combo_prioridad.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_prioridad.setIcon(null); // NOI18N
       lbl_error_combo_prioridad.setText("Prioridad");
        }else{
            lbl_error_combo_prioridad.setVisible(false);
        }
                }
              if(!String.valueOf(rs.getString(12)).equals("null")){
                  if (pnl_add.editable == false) {
                      pnl_add.combo_resp_unidad.addItem(rs.getString(12));
                      pnl_add.combo_resp_unidad.setSelectedItem(String.valueOf(rs.getString(12)));
                      pnl_add.combo_resp_unidad.removeItemAt(0);
                      lbl_error_combo_resp_unidad.setVisible(true);
                      lbl_error_combo_resp_unidad.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_resp_unidad.setIcon(null); // NOI18N
                      lbl_error_combo_resp_unidad.setText("Resp Unidad");
                  } else {
                   combo_resp_unidad.setSelectedItem(String.valueOf(rs.getString(12)));
                  }
                   if(!combo_resp_unidad.getSelectedItem().toString().equals("Resp Unidad")){
       lbl_error_combo_resp_unidad.setVisible(true);
       lbl_error_combo_resp_unidad.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_resp_unidad.setIcon(null); // NOI18N
       lbl_error_combo_resp_unidad.setText("Resp Unidad");
        }else{
            lbl_error_combo_resp_unidad.setVisible(false);
        }
                }
        // text areas
            if(!String.valueOf(rs.getString(20)).equals("null")){
                   text_area_fecha_inicio_garantia_aproximada.setText(String.valueOf(rs.getString(20)));
                }
            if(!String.valueOf(rs.getString(4)).equals("null")){
                   descripcion.setText(String.valueOf(rs.getString(4)));
                }
            if(!String.valueOf(rs.getString(44)).equals("null")){
                   text_area_estado_oocc_09_07_2021.setText(String.valueOf(rs.getString(44)));
                }
            if(!String.valueOf(rs.getString(21)).equals("null")){
                   text_area_fin_garantia_aprox.setText(String.valueOf(rs.getString(21)));
                }
            if(!String.valueOf(rs.getString(45)).equals("null")){
                   text_area_observaciones.setText(String.valueOf(rs.getString(45)));
                }
            if(!String.valueOf(rs.getString(28)).equals("null")){
                   text_area_sol_adquisicion.setText(String.valueOf(rs.getString(28)));
                }
            if(!String.valueOf(rs.getString(41)).equals("null")){
                   text_area_otras_fechas.setText(String.valueOf(rs.getString(41)));
                }
            if(!String.valueOf(rs.getString(29)).equals("null")){
                   text_memoria_tecnica_validada.setText(String.valueOf(rs.getString(29)));
                }
            if(!String.valueOf(rs.getString(36)).equals("null")){
                   text_area_informe_tecnico_realizado.setText(String.valueOf(rs.getString(36)));
                }
            if(!String.valueOf(rs.getString(37)).equals("null")){
                   text_area_fecha_adjudicacion.setText(String.valueOf(rs.getString(37)));
                }
            if(!String.valueOf(rs.getString(40)).equals("null")){
                   text_area_fecha_formalizacion.setText(String.valueOf(rs.getString(40)));
                }
            if(!String.valueOf(rs.getString(46)).equals("null")){
                   text_area_observaciones_oya.setText(String.valueOf(rs.getString(46)));
                }
            if(!String.valueOf(rs.getString(31)).equals("null")){
                   text_area_nuevo_expte_cotec.setText(String.valueOf(rs.getString(31)));
                }
            if(!String.valueOf(rs.getString(35)).equals("null")){
                   pnl_add.text_area_ult_dia_prest_ofertas.setText(String.valueOf(rs.getString(35)));
                }
            }
        } catch (SQLException ex) {
            ErrorAlert.lanza_error(ex);
        }
    }
    
    public static int extraer_id(String sql) throws SQLException, IOException, IOException, IOException {
        int cant = 1;
        conexion obconeccion=new conexion();
        try {
            Statement st = obconeccion.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cant = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(opciones_tabla_general.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
    }
    
     public static boolean existe_id(String sql) throws SQLException, IOException {
        String c = null;
        conexion obconeccion=new conexion();
        boolean existe=false;
        try {
            Statement st = obconeccion.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c != null) {
                existe=true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(opciones_tabla_general.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
}

