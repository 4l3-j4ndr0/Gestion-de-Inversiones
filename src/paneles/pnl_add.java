/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import alertas.ErrorAlert;
import alertas.SuccessAlert;
import alertas.combo_autoseleccionado;
import check_de_android.Switch;
import com.toedter.calendar.JDateChooser;
import combobox.BoundsPopupMenuListener;
import interaccion_BD.datos_reporte;
import interaccion_BD.inicio;
import interaccion_BD.opciones_de_gestionar_datos_cargados;
import interaccion_BD.opciones_de_gestionar_usuarios;
import interaccion_BD.opciones_tabla_general;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import org.bolivia.combo.SComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import principal.Principal;

/**
 *
 * @author 4l3
 */
public final class pnl_add extends javax.swing.JPanel {
    String tabla="";
   public static String id_control="";
   public static boolean editable=true;
   
   private int widestLengh = 0;
   private boolean layingOut = false;
   private boolean wide = false;
   public static ArrayList<datos_reporte> dato_list=new ArrayList<>();
   
    /**
     * Creates new form pnlHome
     */
    public pnl_add() throws SQLException, IOException {
        initComponents();
        // eliminar barra horizontal y que se ajuste la palabra entera(si no cabe, la palabra entera pasa a la siguiente fila)
        descripcion.setLineWrap(true);
        descripcion.setWrapStyleWord(true);
        text_area_fecha_inicio_garantia_aproximada.setLineWrap(true);
        text_area_fecha_inicio_garantia_aproximada.setWrapStyleWord(true);
        text_area_estado_oocc_09_07_2021.setLineWrap(true);
        text_area_estado_oocc_09_07_2021.setWrapStyleWord(true);
        text_area_fin_garantia_aprox.setLineWrap(true);
        text_area_fin_garantia_aprox.setWrapStyleWord(true);
        text_area_otras_fechas.setLineWrap(true);
        text_area_otras_fechas.setWrapStyleWord(true);
        text_area_sol_adquisicion.setLineWrap(true);
        text_area_sol_adquisicion.setWrapStyleWord(true);
        text_area_observaciones.setLineWrap(true);
        text_area_observaciones.setWrapStyleWord(true);
        text_memoria_tecnica_validada.setLineWrap(true);
        text_memoria_tecnica_validada.setWrapStyleWord(true);
        text_area_nuevo_expte_cotec.setLineWrap(true);
        text_area_nuevo_expte_cotec.setWrapStyleWord(true);
        text_area_ult_dia_prest_ofertas.setLineWrap(true);
        text_area_ult_dia_prest_ofertas.setWrapStyleWord(true);
        text_area_informe_tecnico_realizado.setLineWrap(true);
        text_area_informe_tecnico_realizado.setWrapStyleWord(true);
        text_area_fecha_adjudicacion.setLineWrap(true);
        text_area_fecha_adjudicacion.setWrapStyleWord(true);
        text_area_fecha_formalizacion.setLineWrap(true);
        text_area_fecha_formalizacion.setWrapStyleWord(true);
        text_area_observaciones_oya.setLineWrap(true);
        text_area_observaciones_oya.setWrapStyleWord(true);
//         cargar combos desde BD
        cargar_combos();
        esconder();
        Principal.txt_buscar.setVisible(false);
        //################### detectar cambios en los combobox ######################
        combo_tipo_contexto.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_tipo_contexto.getSelectedItem().toString().equals("Tipo de Cxto")){
       lbl_error_combo_tipo_cxto.setVisible(true);
       lbl_error_combo_tipo_cxto.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_tipo_cxto.setIcon(null); // NOI18N
       lbl_error_combo_tipo_cxto.setText("Tipo de Cxto");
        }else{
            lbl_error_combo_tipo_cxto.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_tipo_espediente.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_tipo_espediente.getSelectedItem().toString().equals("Tipo Expediente")){
       lbl_error_combo_tipo_expediente.setVisible(true);
       lbl_error_combo_tipo_expediente.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_tipo_expediente.setIcon(null); // NOI18N
       lbl_error_combo_tipo_expediente.setText("Tipo Expediente");
        }else{
            lbl_error_combo_tipo_expediente.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_resp_area.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_resp_area.getSelectedItem().toString().equals("Resp Área")){
       lbl_error_combo_resp_area.setVisible(true);
       lbl_error_combo_resp_area.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_resp_area.setIcon(null); // NOI18N
       lbl_error_combo_resp_area.setText("Resp Área");
        }else{
            lbl_error_combo_resp_area.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_promotor.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_promotor.getSelectedItem().toString().equals("Promotor")){
       lbl_error_combo_promotor.setVisible(true);
       lbl_error_combo_promotor.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_promotor.setIcon(null); // NOI18N
       lbl_error_combo_promotor.setText("Promotor");
        }else{
            lbl_error_combo_promotor.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_unidad.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
               if(combo_unidad.getModel().getSize()>0){
              if(!combo_unidad.getSelectedItem().toString().equals("Unidad")){
                  try {
                      lbl_error_combo_unidad.setVisible(true);
                      lbl_error_combo_unidad.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_unidad.setIcon(null); // NOI18N
                      lbl_error_combo_unidad.setText("Unidad");
                      String valor=opciones_de_gestionar_datos_cargados.extraer_valor("select resp_unidad from lista_unidad where unidad='"+combo_unidad.getSelectedItem().toString()+"'");
                      combo_resp_unidad.getModel().setSelectedItem(valor);
                  } catch (IOException ex) {
                      Logger.getLogger(pnl_add.class.getName()).log(Level.SEVERE, null, ex);
                  }
        }else{
                      lbl_error_combo_unidad.setVisible(false);
                      
        }
               }
              
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_estado_expediente.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_estado_expediente.getSelectedItem().toString().equals("Estado Expediente")){
       lbl_error_combo_estado_expediente.setVisible(true);
       lbl_error_combo_estado_expediente.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_estado_expediente.setIcon(null); // NOI18N
       lbl_error_combo_estado_expediente.setText("Estado Expediente");
        }else{
            lbl_error_combo_estado_expediente.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_prioridad.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_prioridad.getSelectedItem().toString().equals("Prioridad")){
       lbl_error_combo_prioridad.setVisible(true);
       lbl_error_combo_prioridad.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_prioridad.setIcon(null); // NOI18N
       lbl_error_combo_prioridad.setText("Prioridad");
        }else{
            lbl_error_combo_prioridad.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_resp_unidad.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_resp_unidad.getSelectedItem().toString().equals("Resp Unidad")){
       lbl_error_combo_resp_unidad.setVisible(true);
       lbl_error_combo_resp_unidad.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_resp_unidad.setIcon(null); // NOI18N
       lbl_error_combo_resp_unidad.setText("Resp Unidad");
        }else{
            lbl_error_combo_resp_unidad.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_procedimiento.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_procedimiento.getSelectedItem().toString().equals("Procedimiento")){
       lbl_error_combo_procedimiento.setVisible(true);
       lbl_error_combo_procedimiento.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_procedimiento.setIcon(null); // NOI18N
       lbl_error_combo_procedimiento.setText("Procedimiento");
        }else{
            lbl_error_combo_procedimiento.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_materia.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_materia.getSelectedItem().toString().equals("Materia")){
       lbl_error_combo_materia.setVisible(true);
       lbl_error_combo_materia.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_materia.setIcon(null); // NOI18N
       lbl_error_combo_materia.setText("Materia");
        }else{
            lbl_error_combo_materia.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_area.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
               if(editable){
              if(!combo_area.getSelectedItem().toString().equals("Área")){
                  try {
                      lbl_error_combo_area.setVisible(true);
                      lbl_error_combo_area.setForeground(new java.awt.Color(0, 0, 0));
                      lbl_error_combo_area.setIcon(null); // NOI18N
                      lbl_error_combo_area.setText("Área");
                      String valor=opciones_de_gestionar_datos_cargados.extraer_valor("select resp_area from lista_area where area='"+combo_area.getSelectedItem().toString()+"'");
                      combo_resp_area.getModel().setSelectedItem(valor);
                      combo_unidad.removeAllItems();
                      combo_unidad.addItem("Unidad");
                      try {
                          opciones_tabla_general.get_combos(combo_unidad,"select unidad from lista_unidad where area='"+combo_area.getSelectedItem().toString()+"'");
                      } catch (SQLException ex) {
                          Logger.getLogger(pnl_add.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  } catch (IOException ex) {
                      Logger.getLogger(pnl_add.class.getName()).log(Level.SEVERE, null, ex);
                  }
        }else{
                  try {
                      opciones_tabla_general.get_combos(combo_unidad,"select unidad from lista_unidad");
                      combo_resp_area.setSelectedIndex(0);
                      combo_unidad.setSelectedIndex(0);
                      combo_resp_unidad.setSelectedIndex(0);
                      lbl_error_combo_area.setVisible(false);
                  } catch (SQLException ex) {
                      Logger.getLogger(pnl_add.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(pnl_add.class.getName()).log(Level.SEVERE, null, ex);
                  }
        }
           }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        
        combo_empresa_adjudicatoria.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              if(!combo_empresa_adjudicatoria.getSelectedItem().toString().equals("Empresa Adjudicatoria")){
       lbl_error_combo_empresa_adjudicatoria.setVisible(true);
       lbl_error_combo_empresa_adjudicatoria.setForeground(new java.awt.Color(0, 0, 0));
       lbl_error_combo_empresa_adjudicatoria.setIcon(null); // NOI18N
       lbl_error_combo_empresa_adjudicatoria.setText("Empresa Adjudicatoria");
        }else{
            lbl_error_combo_empresa_adjudicatoria.setVisible(false);
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        // ##########################################################################
        // llamo la clase que gestiona el popmenu que hace posible mantener un ancho predefinido del jcombobox pero que su lista desplegable se ajuste al tamaño del item mas largo
                BoundsPopupMenuListener listener = new BoundsPopupMenuListener(true, false);
                    combo_area.addPopupMenuListener( listener );
                    combo_area.setPrototypeDisplayValue("ItemWWW");
                    // hasta aki, en lo adelante solo hago lo msimo para todos los combo que tengo
                    combo_empresa_adjudicatoria.addPopupMenuListener( listener );
                    combo_empresa_adjudicatoria.setPrototypeDisplayValue("ItemWWW");
                    combo_resp_area.addPopupMenuListener( listener );
                    combo_resp_area.setPrototypeDisplayValue("ItemWWW");
                    combo_tipo_contexto.addPopupMenuListener( listener );
                    combo_tipo_contexto.setPrototypeDisplayValue("ItemWWW");
                    combo_tipo_espediente.addPopupMenuListener( listener );
                    combo_tipo_espediente.setPrototypeDisplayValue("ItemWWW");
                    combo_materia.addPopupMenuListener( listener );
                    combo_materia.setPrototypeDisplayValue("ItemWWW");
                    combo_estado_expediente.addPopupMenuListener( listener );
                    combo_estado_expediente.setPrototypeDisplayValue("ItemWWW");
                    combo_promotor.addPopupMenuListener( listener );
                    combo_promotor.setPrototypeDisplayValue("ItemWWW");
                    combo_unidad.addPopupMenuListener( listener );
                    combo_unidad.setPrototypeDisplayValue("ItemWWW");
                    combo_procedimiento.addPopupMenuListener( listener );
                    combo_procedimiento.setPrototypeDisplayValue("ItemWWW");
                    combo_prioridad.addPopupMenuListener( listener );
                    combo_prioridad.setPrototypeDisplayValue("ItemWWW");
                    combo_resp_unidad.addPopupMenuListener( listener );
                    combo_resp_unidad.setPrototypeDisplayValue("ItemWWW");
           nada_editable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_selection = new javax.swing.JPanel();
        produccion = new javax.swing.JCheckBox();
        base = new javax.swing.JCheckBox();
        aplicaciones = new javax.swing.JCheckBox();
        comunicaciones = new javax.swing.JCheckBox();
        titulo_add = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        id_goya = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_id_goya = new javax.swing.JLabel();
        no_cxto = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_no_cxto = new javax.swing.JLabel();
        no_expediente = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_no_expediente = new javax.swing.JLabel();
        lbl_error_responsable_auxiliar = new javax.swing.JLabel();
        responsable_auxiliar = new rojeru_san.rsfield.RSTextMaterial();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        unidad_auxiliar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_unidad_auxiliar = new javax.swing.JLabel();
        tiempo_ejecucion = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_tiempo_ejecucion = new javax.swing.JLabel();
        mto_garantia = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_mto_garantia = new javax.swing.JLabel();
        lbl_error_anos_prorrogable = new javax.swing.JLabel();
        anos_prorrogable = new rojeru_san.rsfield.RSTextMaterial();
        alarma = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_alarma = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        fecha_observaciones_oya = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_observaciones_oya = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        text_area_observaciones_oya = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        fecha_inicio_garantia_aproximada = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_inicio_garantia_aproximada = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        text_area_fecha_inicio_garantia_aproximada = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        fecha_estado_oocc_09_07_2021 = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_estado_oocc_09_07_2021 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        text_area_estado_oocc_09_07_2021 = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        fecha_fin_garantia_aprox = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_fin_garantia_aproximada = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        text_area_fin_garantia_aprox = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        fecha_otras_fechas = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_otras_fechas = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        text_area_otras_fechas = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        fecha_sol_adquisicion = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_sol_adquisicion = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        text_area_sol_adquisicion = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        fecha_observaciones = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_observaciones = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        text_area_observaciones = new javax.swing.JTextArea();
        futuro_lote = new rojeru_san.rsfield.RSTextMaterial();
        proyecto = new rojeru_san.rsfield.RSTextMaterial();
        estado_garantia = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_estado_de_garantia = new javax.swing.JLabel();
        lbl_error_proyecto = new javax.swing.JLabel();
        lbl_error_futuro_lote = new javax.swing.JLabel();
        pasado_mtos_incluida_en = new rojeru_san.rsfield.RSTextMaterial();
        dl_validado = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_dl_validado = new javax.swing.JLabel();
        lbl_error_pasado_mtos_incluida_en = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        fecha_informe_tecnico_realizado = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_informe_tecnico_realizado = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        text_area_informe_tecnico_realizado = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        fecha_fecha_adjudicacion = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_fecha_adjudicacion = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        text_area_fecha_adjudicacion = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        fecha_fecha_formalizacion = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_fecha_formalizacion = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        text_area_fecha_formalizacion = new javax.swing.JTextArea();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        fecha_memoria_tecni_validada = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_memoria_tecnica_validada = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        text_memoria_tecnica_validada = new javax.swing.JTextArea();
        jPanel21 = new javax.swing.JPanel();
        fecha_nuevo_expte_cotec = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_nuevo_expte_cotec = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        text_area_nuevo_expte_cotec = new javax.swing.JTextArea();
        jPanel22 = new javax.swing.JPanel();
        fecha_ult_dia_prest_ofertas = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_ultimo_dia_prest_ofert = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        text_area_ult_dia_prest_ofertas = new javax.swing.JTextArea();
        importe_expediente = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_importe_expediente = new javax.swing.JLabel();
        lbl_error_importe_adjudicacion_sin_iva = new javax.swing.JLabel();
        importe_adjudicado_sin_iva = new rojeru_san.rsfield.RSTextMaterial();
        presupuesto_base_sin_iva = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_presupuesto_base_sin_iva = new javax.swing.JLabel();
        importe_adjudicacion = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_importe_adjudicacion = new javax.swing.JLabel();
        capitulo = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_capitulo = new javax.swing.JLabel();
        certificados_nov_2020 = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_certificados_nov_2020 = new javax.swing.JLabel();
        combo_tipo_contexto = new org.bolivia.combo.SComboBox();
        lbl_error_combo_tipo_cxto = new javax.swing.JLabel();
        check_tipo_contexto = new check_de_android.Switch();
        combo_prioridad = new org.bolivia.combo.SComboBox();
        lbl_error_combo_prioridad = new javax.swing.JLabel();
        check_prioridad = new check_de_android.Switch();
        combo_promotor = new org.bolivia.combo.SComboBox();
        lbl_error_combo_promotor = new javax.swing.JLabel();
        check_promotor = new check_de_android.Switch();
        lbl_error_combo_materia = new javax.swing.JLabel();
        combo_materia = new org.bolivia.combo.SComboBox();
        check_materia = new check_de_android.Switch();
        check_area = new check_de_android.Switch();
        check_procedimiento = new check_de_android.Switch();
        lbl_error_combo_unidad = new javax.swing.JLabel();
        check_unidad = new check_de_android.Switch();
        lbl_error_combo_resp_area = new javax.swing.JLabel();
        combo_tipo_espediente = new org.bolivia.combo.SComboBox();
        lbl_error_combo_procedimiento = new javax.swing.JLabel();
        check_empresa_adjudicatoria = new check_de_android.Switch();
        check_resp_unidad = new check_de_android.Switch();
        combo_resp_area = new org.bolivia.combo.SComboBox();
        combo_procedimiento = new org.bolivia.combo.SComboBox();
        check_tipo_espediente = new check_de_android.Switch();
        lbl_error_combo_empresa_adjudicatoria = new javax.swing.JLabel();
        combo_area = new org.bolivia.combo.SComboBox();
        lbl_error_combo_estado_expediente = new javax.swing.JLabel();
        check_resp_area = new check_de_android.Switch();
        lbl_error_combo_tipo_expediente = new javax.swing.JLabel();
        check_estado_expediente = new check_de_android.Switch();
        lbl_error_combo_resp_unidad = new javax.swing.JLabel();
        combo_estado_expediente = new org.bolivia.combo.SComboBox();
        combo_empresa_adjudicatoria = new org.bolivia.combo.SComboBox();
        lbl_error_combo_area = new javax.swing.JLabel();
        combo_unidad = new org.bolivia.combo.SComboBox();
        combo_resp_unidad = new org.bolivia.combo.SComboBox();
        panel_selection1 = new javax.swing.JPanel();
        add_produccion = new javax.swing.JCheckBox();
        add_base = new javax.swing.JCheckBox();
        add_aplicaciones = new javax.swing.JCheckBox();
        add_comunicaciones = new javax.swing.JCheckBox();
        boton_registrar = new rojeru_san.RSButtonRiple();
        boton_borrar_todo = new rojeru_san.RSButtonRiple();
        boton_borrar_todo1 = new rojeru_san.RSButtonRiple();
        boton_registrar1 = new rojeru_san.RSButtonRiple();
        btn_pdf = new javax.swing.JLabel();

        panel_selection.setOpaque(false);

        produccion.setBackground(new java.awt.Color(184, 204, 228));
        produccion.setForeground(new java.awt.Color(0, 0, 0));
        produccion.setText("GESTIÓN DE LA PRODUCCIÓN ");
        produccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck.png"))); // NOI18N
        produccion.setIconTextGap(12);
        produccion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check.png"))); // NOI18N
        panel_selection.add(produccion);

        base.setBackground(new java.awt.Color(242, 220, 219));
        base.setForeground(new java.awt.Color(0, 0, 0));
        base.setText("SISTEMAS BASE ");
        base.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck.png"))); // NOI18N
        base.setIconTextGap(12);
        base.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check.png"))); // NOI18N
        panel_selection.add(base);

        aplicaciones.setBackground(new java.awt.Color(252, 213, 180));
        aplicaciones.setForeground(new java.awt.Color(0, 0, 0));
        aplicaciones.setText("GESTION DE APLICACIONES ");
        aplicaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck.png"))); // NOI18N
        aplicaciones.setIconTextGap(12);
        aplicaciones.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check.png"))); // NOI18N
        panel_selection.add(aplicaciones);

        comunicaciones.setBackground(new java.awt.Color(217, 229, 189));
        comunicaciones.setForeground(new java.awt.Color(0, 0, 0));
        comunicaciones.setText("SISTEMA DE COMUNICACIONES ");
        comunicaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck.png"))); // NOI18N
        comunicaciones.setIconTextGap(12);
        comunicaciones.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check.png"))); // NOI18N
        panel_selection.add(comunicaciones);

        setBackground(new java.awt.Color(255, 255, 255));

        titulo_add.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        titulo_add.setForeground(new java.awt.Color(128, 128, 131));
        titulo_add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_add.setText("Añadir");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1348, 3000));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1319, 89));

        id_goya.setForeground(new java.awt.Color(0, 0, 0));
        id_goya.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_goya.setColorMaterial(new java.awt.Color(99, 70, 250));
        id_goya.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        id_goya.setPlaceholder("ID_GOYA");
        id_goya.setSelectionColor(new java.awt.Color(220, 23, 111));
        id_goya.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_goyaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                id_goyaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_goyaKeyTyped(evt);
            }
        });

        lbl_error_id_goya.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_id_goya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_id_goya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_id_goya.setText("¡Dato no Válido!");

        no_cxto.setForeground(new java.awt.Color(0, 0, 0));
        no_cxto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        no_cxto.setColorMaterial(new java.awt.Color(99, 70, 250));
        no_cxto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        no_cxto.setPlaceholder("Nº Cxto");
        no_cxto.setSelectionColor(new java.awt.Color(220, 23, 111));
        no_cxto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                no_cxtoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_cxtoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                no_cxtoKeyTyped(evt);
            }
        });

        lbl_error_no_cxto.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_no_cxto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_no_cxto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_no_cxto.setText("¡Dato no Válido!");

        no_expediente.setForeground(new java.awt.Color(0, 0, 0));
        no_expediente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        no_expediente.setColorMaterial(new java.awt.Color(99, 70, 250));
        no_expediente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        no_expediente.setPlaceholder("Nº Expediente");
        no_expediente.setSelectionColor(new java.awt.Color(220, 23, 111));
        no_expediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_expedienteActionPerformed(evt);
            }
        });
        no_expediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                no_expedienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_expedienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                no_expedienteKeyTyped(evt);
            }
        });

        lbl_error_no_expediente.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_no_expediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_no_expediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_no_expediente.setText("¡Dato no Válido!");

        lbl_error_responsable_auxiliar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_responsable_auxiliar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_responsable_auxiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_responsable_auxiliar.setText("¡Dato no Válido!");

        responsable_auxiliar.setForeground(new java.awt.Color(0, 0, 0));
        responsable_auxiliar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        responsable_auxiliar.setColorMaterial(new java.awt.Color(99, 70, 250));
        responsable_auxiliar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        responsable_auxiliar.setPlaceholder("Responsable Auxiliar");
        responsable_auxiliar.setSelectionColor(new java.awt.Color(220, 23, 111));
        responsable_auxiliar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                responsable_auxiliarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                responsable_auxiliarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                responsable_auxiliarKeyTyped(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        descripcion.setBackground(new java.awt.Color(255, 255, 255));
        descripcion.setColumns(20);
        descripcion.setRows(5);
        descripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane2.setViewportView(descripcion);

        unidad_auxiliar.setForeground(new java.awt.Color(0, 0, 0));
        unidad_auxiliar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        unidad_auxiliar.setColorMaterial(new java.awt.Color(99, 70, 250));
        unidad_auxiliar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        unidad_auxiliar.setPlaceholder("Unidad Auxiliar");
        unidad_auxiliar.setSelectionColor(new java.awt.Color(220, 23, 111));
        unidad_auxiliar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                unidad_auxiliarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unidad_auxiliarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unidad_auxiliarKeyTyped(evt);
            }
        });

        lbl_error_unidad_auxiliar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_unidad_auxiliar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_unidad_auxiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_unidad_auxiliar.setText("¡Dato no Válido!");

        tiempo_ejecucion.setForeground(new java.awt.Color(0, 0, 0));
        tiempo_ejecucion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tiempo_ejecucion.setColorMaterial(new java.awt.Color(99, 70, 250));
        tiempo_ejecucion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tiempo_ejecucion.setPlaceholder("Tiempo Ejecución");
        tiempo_ejecucion.setSelectionColor(new java.awt.Color(220, 23, 111));
        tiempo_ejecucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tiempo_ejecucionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tiempo_ejecucionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tiempo_ejecucionKeyTyped(evt);
            }
        });

        lbl_error_tiempo_ejecucion.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_tiempo_ejecucion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_tiempo_ejecucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_tiempo_ejecucion.setText("¡Dato no Válido!");

        mto_garantia.setForeground(new java.awt.Color(0, 0, 0));
        mto_garantia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mto_garantia.setColorMaterial(new java.awt.Color(99, 70, 250));
        mto_garantia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mto_garantia.setPlaceholder("Mto/Garantía");
        mto_garantia.setSelectionColor(new java.awt.Color(220, 23, 111));
        mto_garantia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mto_garantiaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mto_garantiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mto_garantiaKeyTyped(evt);
            }
        });

        lbl_error_mto_garantia.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_mto_garantia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_mto_garantia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_mto_garantia.setText("¡Dato no Válido!");

        lbl_error_anos_prorrogable.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_anos_prorrogable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_anos_prorrogable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_anos_prorrogable.setText("¡Dato no Válido!");

        anos_prorrogable.setForeground(new java.awt.Color(0, 0, 0));
        anos_prorrogable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        anos_prorrogable.setColorMaterial(new java.awt.Color(99, 70, 250));
        anos_prorrogable.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        anos_prorrogable.setPlaceholder("Años Prorrogable");
        anos_prorrogable.setSelectionColor(new java.awt.Color(220, 23, 111));
        anos_prorrogable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                anos_prorrogableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anos_prorrogableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anos_prorrogableKeyTyped(evt);
            }
        });

        alarma.setForeground(new java.awt.Color(0, 0, 0));
        alarma.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alarma.setColorMaterial(new java.awt.Color(99, 70, 250));
        alarma.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        alarma.setPlaceholder("Alarma");
        alarma.setSelectionColor(new java.awt.Color(220, 23, 111));
        alarma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alarmaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                alarmaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alarmaKeyTyped(evt);
            }
        });

        lbl_error_alarma.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_alarma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_alarma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_alarma.setText("¡Dato no Válido!");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones de OYA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_observaciones_oya.setDateFormatString("dd/MM/yyyy");
        fecha_observaciones_oya.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_observaciones_oya.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_observaciones_oya.setText("¡Debe ingresar una fecha!");

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(null);
        jScrollPane7.setOpaque(false);

        text_area_observaciones_oya.setBackground(new java.awt.Color(255, 255, 255));
        text_area_observaciones_oya.setColumns(20);
        text_area_observaciones_oya.setRows(5);
        text_area_observaciones_oya.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane7.setViewportView(text_area_observaciones_oya);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_observaciones_oya, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_observaciones_oya))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fecha_observaciones_oya, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_error_fecha_observaciones_oya, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inicio Garantía Aproximada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_inicio_garantia_aproximada.setDateFormatString("dd/MM/yyyy");
        fecha_inicio_garantia_aproximada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_inicio_garantia_aproximada.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_inicio_garantia_aproximada.setText("¡Debe ingresar una fecha!");

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setBorder(null);
        jScrollPane8.setOpaque(false);

        text_area_fecha_inicio_garantia_aproximada.setBackground(new java.awt.Color(255, 255, 255));
        text_area_fecha_inicio_garantia_aproximada.setColumns(20);
        text_area_fecha_inicio_garantia_aproximada.setRows(5);
        text_area_fecha_inicio_garantia_aproximada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane8.setViewportView(text_area_fecha_inicio_garantia_aproximada);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_inicio_garantia_aproximada, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_inicio_garantia_aproximada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(fecha_inicio_garantia_aproximada, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_error_fecha_inicio_garantia_aproximada, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado OOCC a 09/07/2021", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_estado_oocc_09_07_2021.setDateFormatString("dd/MM/yyyy");
        fecha_estado_oocc_09_07_2021.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_estado_oocc_09_07_2021.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_estado_oocc_09_07_2021.setText("¡Debe ingresar una fecha!");

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane9.setBorder(null);
        jScrollPane9.setOpaque(false);

        text_area_estado_oocc_09_07_2021.setBackground(new java.awt.Color(255, 255, 255));
        text_area_estado_oocc_09_07_2021.setColumns(20);
        text_area_estado_oocc_09_07_2021.setRows(5);
        text_area_estado_oocc_09_07_2021.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane9.setViewportView(text_area_estado_oocc_09_07_2021);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_error_fecha_estado_oocc_09_07_2021)
                    .addComponent(fecha_estado_oocc_09_07_2021, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(fecha_estado_oocc_09_07_2021, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_estado_oocc_09_07_2021, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fin Garantía Aproximada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_fin_garantia_aprox.setDateFormatString("dd/MM/yyyy");
        fecha_fin_garantia_aprox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_fin_garantia_aproximada.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_fin_garantia_aproximada.setText("¡Debe ingresar una fecha!");

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setBorder(null);
        jScrollPane10.setOpaque(false);

        text_area_fin_garantia_aprox.setBackground(new java.awt.Color(255, 255, 255));
        text_area_fin_garantia_aprox.setColumns(20);
        text_area_fin_garantia_aprox.setRows(5);
        text_area_fin_garantia_aprox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane10.setViewportView(text_area_fin_garantia_aprox);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fecha_fin_garantia_aprox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_fin_garantia_aproximada, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(fecha_fin_garantia_aprox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_fin_garantia_aproximada, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otras Fechas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_otras_fechas.setDateFormatString("dd/MM/yyyy");
        fecha_otras_fechas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_otras_fechas.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_otras_fechas.setText("¡Debe ingresar una fecha!");

        jScrollPane11.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane11.setBorder(null);
        jScrollPane11.setOpaque(false);

        text_area_otras_fechas.setBackground(new java.awt.Color(255, 255, 255));
        text_area_otras_fechas.setColumns(20);
        text_area_otras_fechas.setRows(5);
        text_area_otras_fechas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane11.setViewportView(text_area_otras_fechas);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_otras_fechas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_otras_fechas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(fecha_otras_fechas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_error_fecha_otras_fechas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sol Adquisición", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_sol_adquisicion.setDateFormatString("dd/MM/yyyy");
        fecha_sol_adquisicion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_sol_adquisicion.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_sol_adquisicion.setText("¡Debe ingresar una fecha!");

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane12.setBorder(null);
        jScrollPane12.setOpaque(false);

        text_area_sol_adquisicion.setBackground(new java.awt.Color(255, 255, 255));
        text_area_sol_adquisicion.setColumns(20);
        text_area_sol_adquisicion.setRows(5);
        text_area_sol_adquisicion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane12.setViewportView(text_area_sol_adquisicion);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_error_fecha_sol_adquisicion)
                    .addComponent(fecha_sol_adquisicion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(fecha_sol_adquisicion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_sol_adquisicion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_observaciones.setDateFormatString("dd/MM/yyyy");
        fecha_observaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_observaciones.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_observaciones.setText("¡Debe ingresar una fecha!");

        jScrollPane13.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane13.setBorder(null);
        jScrollPane13.setOpaque(false);

        text_area_observaciones.setBackground(new java.awt.Color(255, 255, 255));
        text_area_observaciones.setColumns(20);
        text_area_observaciones.setRows(5);
        text_area_observaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane13.setViewportView(text_area_observaciones);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fecha_observaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_observaciones, javax.swing.GroupLayout.Alignment.LEADING))
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(fecha_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        futuro_lote.setForeground(new java.awt.Color(0, 0, 0));
        futuro_lote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        futuro_lote.setColorMaterial(new java.awt.Color(99, 70, 250));
        futuro_lote.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        futuro_lote.setPlaceholder("Futuro Lote");
        futuro_lote.setSelectionColor(new java.awt.Color(220, 23, 111));
        futuro_lote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                futuro_loteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                futuro_loteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                futuro_loteKeyTyped(evt);
            }
        });

        proyecto.setForeground(new java.awt.Color(0, 0, 0));
        proyecto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proyecto.setColorMaterial(new java.awt.Color(99, 70, 250));
        proyecto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        proyecto.setPlaceholder("Proyecto");
        proyecto.setSelectionColor(new java.awt.Color(220, 23, 111));
        proyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                proyectoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                proyectoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                proyectoKeyTyped(evt);
            }
        });

        estado_garantia.setForeground(new java.awt.Color(0, 0, 0));
        estado_garantia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        estado_garantia.setColorMaterial(new java.awt.Color(99, 70, 250));
        estado_garantia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        estado_garantia.setPlaceholder("Estado de Garantía");
        estado_garantia.setSelectionColor(new java.awt.Color(220, 23, 111));
        estado_garantia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                estado_garantiaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                estado_garantiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                estado_garantiaKeyTyped(evt);
            }
        });

        lbl_error_estado_de_garantia.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_estado_de_garantia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_estado_de_garantia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_estado_de_garantia.setText("¡Dato no Válido!");

        lbl_error_proyecto.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_proyecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_proyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_proyecto.setText("¡Dato no Válido!");

        lbl_error_futuro_lote.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_futuro_lote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_futuro_lote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_futuro_lote.setText("¡Dato no Válido!");

        pasado_mtos_incluida_en.setForeground(new java.awt.Color(0, 0, 0));
        pasado_mtos_incluida_en.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pasado_mtos_incluida_en.setColorMaterial(new java.awt.Color(99, 70, 250));
        pasado_mtos_incluida_en.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pasado_mtos_incluida_en.setPlaceholder("Psado a Mtos/ Incluida en:");
        pasado_mtos_incluida_en.setSelectionColor(new java.awt.Color(220, 23, 111));
        pasado_mtos_incluida_en.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pasado_mtos_incluida_enKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pasado_mtos_incluida_enKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pasado_mtos_incluida_enKeyTyped(evt);
            }
        });

        dl_validado.setForeground(new java.awt.Color(0, 0, 0));
        dl_validado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dl_validado.setColorMaterial(new java.awt.Color(99, 70, 250));
        dl_validado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dl_validado.setPlaceholder("DL Validado");
        dl_validado.setSelectionColor(new java.awt.Color(220, 23, 111));
        dl_validado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dl_validadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dl_validadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dl_validadoKeyTyped(evt);
            }
        });

        lbl_error_dl_validado.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_dl_validado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_dl_validado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_dl_validado.setText("¡Dato no Válido!");

        lbl_error_pasado_mtos_incluida_en.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_pasado_mtos_incluida_en.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_pasado_mtos_incluida_en.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_pasado_mtos_incluida_en.setText("¡Dato no Válido!");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informe Técnico Realizado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_informe_tecnico_realizado.setDateFormatString("dd/MM/yyyy");
        fecha_informe_tecnico_realizado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_informe_tecnico_realizado.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_informe_tecnico_realizado.setText("¡Debe ingresar una fecha!");

        jScrollPane14.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane14.setBorder(null);
        jScrollPane14.setOpaque(false);

        text_area_informe_tecnico_realizado.setBackground(new java.awt.Color(255, 255, 255));
        text_area_informe_tecnico_realizado.setColumns(20);
        text_area_informe_tecnico_realizado.setRows(5);
        text_area_informe_tecnico_realizado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane14.setViewportView(text_area_informe_tecnico_realizado);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_informe_tecnico_realizado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_informe_tecnico_realizado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(fecha_informe_tecnico_realizado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_error_fecha_informe_tecnico_realizado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Adjudicación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_fecha_adjudicacion.setDateFormatString("dd/MM/yyyy");
        fecha_fecha_adjudicacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_fecha_adjudicacion.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_fecha_adjudicacion.setText("¡Debe ingresar una fecha!");

        jScrollPane15.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane15.setBorder(null);
        jScrollPane15.setOpaque(false);

        text_area_fecha_adjudicacion.setBackground(new java.awt.Color(255, 255, 255));
        text_area_fecha_adjudicacion.setColumns(20);
        text_area_fecha_adjudicacion.setRows(5);
        text_area_fecha_adjudicacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane15.setViewportView(text_area_fecha_adjudicacion);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_error_fecha_fecha_adjudicacion)
                    .addComponent(fecha_fecha_adjudicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(fecha_fecha_adjudicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_fecha_adjudicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Fornalización", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_fecha_formalizacion.setDateFormatString("dd/MM/yyyy");
        fecha_fecha_formalizacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_fecha_formalizacion.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_fecha_formalizacion.setText("¡Debe ingresar una fecha!");

        jScrollPane16.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane16.setBorder(null);
        jScrollPane16.setOpaque(false);

        text_area_fecha_formalizacion.setBackground(new java.awt.Color(255, 255, 255));
        text_area_fecha_formalizacion.setColumns(20);
        text_area_fecha_formalizacion.setRows(5);
        text_area_fecha_formalizacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane16.setViewportView(text_area_fecha_formalizacion);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fecha_fecha_formalizacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_fecha_formalizacion, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(fecha_fecha_formalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_fecha_formalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Memoria Técnica Validada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_memoria_tecni_validada.setDateFormatString("dd/MM/yyyy");
        fecha_memoria_tecni_validada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_memoria_tecnica_validada.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_memoria_tecnica_validada.setText("¡Debe ingresar una fecha!");

        jScrollPane17.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane17.setBorder(null);
        jScrollPane17.setOpaque(false);

        text_memoria_tecnica_validada.setBackground(new java.awt.Color(255, 255, 255));
        text_memoria_tecnica_validada.setColumns(20);
        text_memoria_tecnica_validada.setRows(5);
        text_memoria_tecnica_validada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane17.setViewportView(text_memoria_tecnica_validada);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_memoria_tecni_validada, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_memoria_tecnica_validada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(fecha_memoria_tecni_validada, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_error_fecha_memoria_tecnica_validada, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Expte Cotec de", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_nuevo_expte_cotec.setDateFormatString("dd/MM/yyyy");
        fecha_nuevo_expte_cotec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_nuevo_expte_cotec.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_nuevo_expte_cotec.setText("¡Debe ingresar una fecha!");

        jScrollPane18.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane18.setBorder(null);
        jScrollPane18.setOpaque(false);

        text_area_nuevo_expte_cotec.setBackground(new java.awt.Color(255, 255, 255));
        text_area_nuevo_expte_cotec.setColumns(20);
        text_area_nuevo_expte_cotec.setRows(5);
        text_area_nuevo_expte_cotec.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane18.setViewportView(text_area_nuevo_expte_cotec);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_error_fecha_nuevo_expte_cotec)
                    .addComponent(fecha_nuevo_expte_cotec, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(fecha_nuevo_expte_cotec, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_nuevo_expte_cotec, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ult Dia Prest Ofertas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(170, 170, 170))); // NOI18N

        fecha_ult_dia_prest_ofertas.setDateFormatString("dd/MM/yyyy");
        fecha_ult_dia_prest_ofertas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_error_fecha_ultimo_dia_prest_ofert.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_ultimo_dia_prest_ofert.setText("¡Debe ingresar una fecha!");

        jScrollPane19.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane19.setBorder(null);
        jScrollPane19.setOpaque(false);

        text_area_ult_dia_prest_ofertas.setBackground(new java.awt.Color(255, 255, 255));
        text_area_ult_dia_prest_ofertas.setColumns(20);
        text_area_ult_dia_prest_ofertas.setRows(5);
        text_area_ult_dia_prest_ofertas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(170, 170, 170))); // NOI18N
        jScrollPane19.setViewportView(text_area_ult_dia_prest_ofertas);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fecha_ult_dia_prest_ofertas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_fecha_ultimo_dia_prest_ofert, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(fecha_ult_dia_prest_ofertas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_ultimo_dia_prest_ofert, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        importe_expediente.setForeground(new java.awt.Color(0, 0, 0));
        importe_expediente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        importe_expediente.setColorMaterial(new java.awt.Color(99, 70, 250));
        importe_expediente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        importe_expediente.setPlaceholder("Importe Expediente");
        importe_expediente.setSelectionColor(new java.awt.Color(220, 23, 111));
        importe_expediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                importe_expedienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                importe_expedienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                importe_expedienteKeyTyped(evt);
            }
        });

        lbl_error_importe_expediente.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_importe_expediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_importe_expediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_importe_expediente.setText("¡Dato no Válido!");

        lbl_error_importe_adjudicacion_sin_iva.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_importe_adjudicacion_sin_iva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_importe_adjudicacion_sin_iva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_importe_adjudicacion_sin_iva.setText("¡Dato no Válido!");

        importe_adjudicado_sin_iva.setForeground(new java.awt.Color(0, 0, 0));
        importe_adjudicado_sin_iva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        importe_adjudicado_sin_iva.setColorMaterial(new java.awt.Color(99, 70, 250));
        importe_adjudicado_sin_iva.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        importe_adjudicado_sin_iva.setPlaceholder("Importe Adjudicado sin IVA");
        importe_adjudicado_sin_iva.setSelectionColor(new java.awt.Color(220, 23, 111));
        importe_adjudicado_sin_iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                importe_adjudicado_sin_ivaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                importe_adjudicado_sin_ivaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                importe_adjudicado_sin_ivaKeyTyped(evt);
            }
        });

        presupuesto_base_sin_iva.setForeground(new java.awt.Color(0, 0, 0));
        presupuesto_base_sin_iva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        presupuesto_base_sin_iva.setColorMaterial(new java.awt.Color(99, 70, 250));
        presupuesto_base_sin_iva.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        presupuesto_base_sin_iva.setPlaceholder("Presupuesto Base sin IVA");
        presupuesto_base_sin_iva.setSelectionColor(new java.awt.Color(220, 23, 111));
        presupuesto_base_sin_iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                presupuesto_base_sin_ivaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                presupuesto_base_sin_ivaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                presupuesto_base_sin_ivaKeyTyped(evt);
            }
        });

        lbl_error_presupuesto_base_sin_iva.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_presupuesto_base_sin_iva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_presupuesto_base_sin_iva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_presupuesto_base_sin_iva.setText("¡Dato no Válido!");

        importe_adjudicacion.setForeground(new java.awt.Color(0, 0, 0));
        importe_adjudicacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        importe_adjudicacion.setColorMaterial(new java.awt.Color(99, 70, 250));
        importe_adjudicacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        importe_adjudicacion.setPlaceholder("Importe de Adjudicación");
        importe_adjudicacion.setSelectionColor(new java.awt.Color(220, 23, 111));
        importe_adjudicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                importe_adjudicacionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                importe_adjudicacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                importe_adjudicacionKeyTyped(evt);
            }
        });

        lbl_error_importe_adjudicacion.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_importe_adjudicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_importe_adjudicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_importe_adjudicacion.setText("¡Dato no Válido!");

        capitulo.setForeground(new java.awt.Color(0, 0, 0));
        capitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        capitulo.setColorMaterial(new java.awt.Color(99, 70, 250));
        capitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        capitulo.setPlaceholder("Capítulo");
        capitulo.setSelectionColor(new java.awt.Color(220, 23, 111));
        capitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                capituloKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                capituloKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capituloKeyTyped(evt);
            }
        });

        lbl_error_capitulo.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_capitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_capitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_capitulo.setText("¡Dato no Válido!");

        certificados_nov_2020.setForeground(new java.awt.Color(0, 0, 0));
        certificados_nov_2020.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        certificados_nov_2020.setColorMaterial(new java.awt.Color(99, 70, 250));
        certificados_nov_2020.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        certificados_nov_2020.setPlaceholder("Certificados a Nov_2020");
        certificados_nov_2020.setSelectionColor(new java.awt.Color(220, 23, 111));
        certificados_nov_2020.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                certificados_nov_2020KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                certificados_nov_2020KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                certificados_nov_2020KeyTyped(evt);
            }
        });

        lbl_error_certificados_nov_2020.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_certificados_nov_2020.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_certificados_nov_2020.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_certificados_nov_2020.setText("¡Dato no Válido!");

        combo_tipo_contexto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de Cxto" }));
        combo_tipo_contexto.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_tipo_contexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipo_contextoActionPerformed(evt);
            }
        });

        lbl_error_combo_tipo_cxto.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_tipo_cxto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_tipo_cxto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_tipo_cxto.setText("¡Dato no Válido!");

        check_tipo_contexto.setToolTipText("Hacer o deshacer editable");
        check_tipo_contexto.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_tipo_contexto.setOnOff(false);
        check_tipo_contexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_tipo_contextoMouseClicked(evt);
            }
        });

        combo_prioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prioridad" }));
        combo_prioridad.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_prioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_prioridadActionPerformed(evt);
            }
        });
        combo_prioridad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_prioridadKeyReleased(evt);
            }
        });

        lbl_error_combo_prioridad.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_prioridad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_prioridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_prioridad.setText("¡Dato no Válido!");

        check_prioridad.setToolTipText("Hacer o deshacer editable");
        check_prioridad.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_prioridad.setOnOff(false);
        check_prioridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_prioridadMouseClicked(evt);
            }
        });

        combo_promotor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Promotor" }));
        combo_promotor.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_promotor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_promotorKeyReleased(evt);
            }
        });

        lbl_error_combo_promotor.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_promotor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_promotor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_promotor.setText("¡Dato no Válido!");

        check_promotor.setToolTipText("Hacer o deshacer editable");
        check_promotor.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_promotor.setOnOff(false);
        check_promotor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_promotorMouseClicked(evt);
            }
        });

        lbl_error_combo_materia.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_materia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_materia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_materia.setText("¡Dato no Válido!");

        combo_materia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Materia" }));
        combo_materia.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_materia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_materiaKeyReleased(evt);
            }
        });

        check_materia.setToolTipText("Hacer o deshacer editable");
        check_materia.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_materia.setOnOff(false);
        check_materia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_materiaMouseClicked(evt);
            }
        });

        check_area.setToolTipText("Hacer o deshacer editable");
        check_area.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_area.setOnOff(false);
        check_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_areaMouseClicked(evt);
            }
        });

        check_procedimiento.setToolTipText("Hacer o deshacer editable");
        check_procedimiento.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_procedimiento.setOnOff(false);
        check_procedimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_procedimientoMouseClicked(evt);
            }
        });

        lbl_error_combo_unidad.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_unidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_unidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_unidad.setText("¡Dato no Válido!");

        check_unidad.setToolTipText("Hacer o deshacer editable");
        check_unidad.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_unidad.setOnOff(false);
        check_unidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_unidadMouseClicked(evt);
            }
        });

        lbl_error_combo_resp_area.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_resp_area.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_resp_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_resp_area.setText("¡Dato no Válido!");

        combo_tipo_espediente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo Expediente" }));
        combo_tipo_espediente.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_tipo_espediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_tipo_espedienteKeyReleased(evt);
            }
        });

        lbl_error_combo_procedimiento.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_procedimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_procedimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_procedimiento.setText("¡Dato no Válido!");

        check_empresa_adjudicatoria.setToolTipText("Hacer o deshacer editable");
        check_empresa_adjudicatoria.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_empresa_adjudicatoria.setOnOff(false);
        check_empresa_adjudicatoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_empresa_adjudicatoriaMouseClicked(evt);
            }
        });

        check_resp_unidad.setToolTipText("Hacer o deshacer editable");
        check_resp_unidad.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_resp_unidad.setOnOff(false);
        check_resp_unidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_resp_unidadMouseClicked(evt);
            }
        });

        combo_resp_area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Resp Área" }));
        combo_resp_area.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_resp_area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_resp_areaKeyReleased(evt);
            }
        });

        combo_procedimiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Procedimiento" }));
        combo_procedimiento.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_procedimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_procedimientoKeyReleased(evt);
            }
        });

        check_tipo_espediente.setToolTipText("Hacer o deshacer editable");
        check_tipo_espediente.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_tipo_espediente.setOnOff(false);
        check_tipo_espediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_tipo_espedienteMouseClicked(evt);
            }
        });

        lbl_error_combo_empresa_adjudicatoria.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_empresa_adjudicatoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_empresa_adjudicatoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_empresa_adjudicatoria.setText("¡Dato no Válido!");

        combo_area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Área" }));
        combo_area.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_areaKeyReleased(evt);
            }
        });

        lbl_error_combo_estado_expediente.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_estado_expediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_estado_expediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_estado_expediente.setText("¡Dato no Válido!");

        check_resp_area.setToolTipText("Hacer o deshacer editable");
        check_resp_area.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_resp_area.setOnOff(false);
        check_resp_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_resp_areaMouseClicked(evt);
            }
        });

        lbl_error_combo_tipo_expediente.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_tipo_expediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_tipo_expediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_tipo_expediente.setText("¡Dato no Válido!");

        check_estado_expediente.setToolTipText("Hacer o deshacer editable");
        check_estado_expediente.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_estado_expediente.setOnOff(false);
        check_estado_expediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_estado_expedienteMouseClicked(evt);
            }
        });

        lbl_error_combo_resp_unidad.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_resp_unidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_resp_unidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_resp_unidad.setText("¡Dato no Válido!");

        combo_estado_expediente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estado Expediente" }));
        combo_estado_expediente.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_estado_expediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_estado_expedienteActionPerformed(evt);
            }
        });
        combo_estado_expediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_estado_expedienteKeyReleased(evt);
            }
        });

        combo_empresa_adjudicatoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empresa Adjudicatoria" }));
        combo_empresa_adjudicatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_empresa_adjudicatoriaActionPerformed(evt);
            }
        });
        combo_empresa_adjudicatoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_empresa_adjudicatoriaKeyReleased(evt);
            }
        });

        lbl_error_combo_area.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_combo_area.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_combo_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_combo_area.setText("¡Dato no Válido!");

        combo_unidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unidad" }));
        combo_unidad.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_unidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_unidadKeyReleased(evt);
            }
        });

        combo_resp_unidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Resp Unidad" }));
        combo_resp_unidad.setMinimumSize(new java.awt.Dimension(151, 22));
        combo_resp_unidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_resp_unidadKeyReleased(evt);
            }
        });

        panel_selection1.setOpaque(false);

        add_produccion.setBackground(new java.awt.Color(184, 204, 228));
        add_produccion.setForeground(new java.awt.Color(0, 0, 0));
        add_produccion.setText("GESTIÓN DE LA PRODUCCIÓN ");
        add_produccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck.png"))); // NOI18N
        add_produccion.setIconTextGap(12);
        add_produccion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check.png"))); // NOI18N
        add_produccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_produccionActionPerformed(evt);
            }
        });
        panel_selection1.add(add_produccion);

        add_base.setBackground(new java.awt.Color(242, 220, 219));
        add_base.setForeground(new java.awt.Color(0, 0, 0));
        add_base.setText("SISTEMAS BASE ");
        add_base.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck.png"))); // NOI18N
        add_base.setIconTextGap(12);
        add_base.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check.png"))); // NOI18N
        add_base.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_baseActionPerformed(evt);
            }
        });
        panel_selection1.add(add_base);

        add_aplicaciones.setBackground(new java.awt.Color(252, 213, 180));
        add_aplicaciones.setForeground(new java.awt.Color(0, 0, 0));
        add_aplicaciones.setText("GESTION DE APLICACIONES ");
        add_aplicaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck.png"))); // NOI18N
        add_aplicaciones.setIconTextGap(12);
        add_aplicaciones.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check.png"))); // NOI18N
        add_aplicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_aplicacionesActionPerformed(evt);
            }
        });
        panel_selection1.add(add_aplicaciones);

        add_comunicaciones.setBackground(new java.awt.Color(217, 229, 189));
        add_comunicaciones.setForeground(new java.awt.Color(0, 0, 0));
        add_comunicaciones.setText("SISTEMA DE COMUNICACIONES ");
        add_comunicaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck.png"))); // NOI18N
        add_comunicaciones.setIconTextGap(12);
        add_comunicaciones.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check.png"))); // NOI18N
        add_comunicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_comunicacionesActionPerformed(evt);
            }
        });
        panel_selection1.add(add_comunicaciones);

        boton_registrar.setBackground(new java.awt.Color(38, 86, 186));
        boton_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/btnRegistrar.png"))); // NOI18N
        boton_registrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_registrar.setLabel("REGISTRAR");
        boton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registrarActionPerformed(evt);
            }
        });

        boton_borrar_todo.setBackground(new java.awt.Color(38, 86, 186));
        boton_borrar_todo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/btnEliminar.png"))); // NOI18N
        boton_borrar_todo.setText("Limpiar Campos");
        boton_borrar_todo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_borrar_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_borrar_todoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_selection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(presupuesto_base_sin_iva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_error_presupuesto_base_sin_iva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(proyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_error_proyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(alarma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_error_alarma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pasado_mtos_incluida_en, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_error_pasado_mtos_incluida_en, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(futuro_lote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_error_futuro_lote, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(anos_prorrogable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_error_anos_prorrogable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(responsable_auxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_error_responsable_auxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(certificados_nov_2020, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_error_certificados_nov_2020, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(importe_adjudicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_error_importe_adjudicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_error_dl_validado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dl_validado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_goya, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_id_goya, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(no_cxto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_no_cxto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(no_expediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_no_expediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(importe_expediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_importe_expediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(capitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_capitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(unidad_auxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_unidad_auxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tiempo_ejecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_tiempo_ejecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(importe_adjudicado_sin_iva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_importe_adjudicacion_sin_iva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(estado_garantia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_estado_de_garantia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mto_garantia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_mto_garantia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(boton_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_borrar_todo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_area, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_combo_area, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_resp_area, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_combo_resp_area, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_resp_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_unidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_combo_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_resp_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_combo_resp_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_resp_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_estado_expediente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_combo_estado_expediente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_estado_expediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(combo_tipo_contexto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_combo_tipo_cxto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_tipo_contexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_procedimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_combo_procedimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_procedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_prioridad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_combo_prioridad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_prioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(combo_tipo_espediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_combo_tipo_expediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_tipo_espediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_promotor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_combo_promotor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_promotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_error_combo_empresa_adjudicatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_empresa_adjudicatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(check_empresa_adjudicatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combo_materia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_combo_materia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(check_materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_goya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(no_cxto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_error_id_goya)
                            .addComponent(lbl_error_no_cxto)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(no_expediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_no_expediente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(importe_expediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_importe_expediente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(capitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_capitulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(unidad_auxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_unidad_auxiliar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tiempo_ejecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_tiempo_ejecucion)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(importe_adjudicado_sin_iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(lbl_error_importe_adjudicacion_sin_iva))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(estado_garantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(lbl_error_estado_de_garantia)))
                    .addComponent(mto_garantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_mto_garantia, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(presupuesto_base_sin_iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_error_presupuesto_base_sin_iva))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_error_proyecto)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(importe_adjudicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(lbl_error_importe_adjudicacion)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dl_validado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_dl_validado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(alarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_error_alarma))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(anos_prorrogable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_error_anos_prorrogable)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(pasado_mtos_incluida_en, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_error_pasado_mtos_incluida_en))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(futuro_lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_error_futuro_lote))))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(certificados_nov_2020, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_certificados_nov_2020)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(responsable_auxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_responsable_auxiliar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_resp_area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_resp_area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl_error_combo_resp_area))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(combo_area, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_area, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl_error_combo_area))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_estado_expediente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_estado_expediente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_combo_estado_expediente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_resp_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_resp_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_combo_resp_unidad))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_combo_unidad)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_procedimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_procedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_combo_procedimiento))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_tipo_espediente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_tipo_espediente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_error_combo_tipo_expediente)
                            .addComponent(lbl_error_combo_prioridad)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_promotor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_promotor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_combo_promotor))
                    .addComponent(combo_prioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_prioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_tipo_contexto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(combo_tipo_contexto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_combo_tipo_cxto)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_materia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_materia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_combo_materia))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_empresa_adjudicatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_empresa_adjudicatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_combo_empresa_adjudicatoria)))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(panel_selection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_borrar_todo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        boton_borrar_todo1.setBackground(new java.awt.Color(38, 86, 186));
        boton_borrar_todo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/btnEliminar.png"))); // NOI18N
        boton_borrar_todo1.setText("Limpiar Campos");
        boton_borrar_todo1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_borrar_todo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_borrar_todo1ActionPerformed(evt);
            }
        });

        boton_registrar1.setBackground(new java.awt.Color(38, 86, 186));
        boton_registrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/btnRegistrar.png"))); // NOI18N
        boton_registrar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_registrar1.setLabel("REGISTRAR");
        boton_registrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registrar1ActionPerformed(evt);
            }
        });

        btn_pdf.setForeground(new java.awt.Color(0, 0, 0));
        btn_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btn_pdf.setText("EXPORTAR A PDF");
        btn_pdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pdf.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pdfMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pdfMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_registrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo_add, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_borrar_todo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_pdf)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_pdf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boton_registrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boton_borrar_todo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(titulo_add)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    public void cambia(){
        combo_area.setSelectedIndex(3);
    }
   private void esconder(){
       lbl_error_alarma.setVisible(false);
       lbl_error_anos_prorrogable.setVisible(false);
       lbl_error_capitulo.setVisible(false);
       lbl_error_combo_area.setVisible(false);
       lbl_error_combo_empresa_adjudicatoria.setVisible(false);
       lbl_error_combo_estado_expediente.setVisible(false);
       lbl_error_combo_materia.setVisible(false);
       lbl_error_combo_prioridad.setVisible(false);
       lbl_error_combo_procedimiento.setVisible(false);
       lbl_error_combo_promotor.setVisible(false);
       lbl_error_combo_resp_area.setVisible(false);
       lbl_error_combo_resp_unidad.setVisible(false);
       lbl_error_combo_tipo_cxto.setVisible(false);
       lbl_error_combo_tipo_expediente.setVisible(false);
       lbl_error_combo_unidad.setVisible(false);
       lbl_error_dl_validado.setVisible(false);
       lbl_error_estado_de_garantia.setVisible(false);
       lbl_error_fecha_estado_oocc_09_07_2021.setVisible(false);
       lbl_error_fecha_fecha_adjudicacion.setVisible(false);
       lbl_error_fecha_fecha_formalizacion.setVisible(false);
       lbl_error_fecha_fin_garantia_aproximada.setVisible(false);
       lbl_error_fecha_informe_tecnico_realizado.setVisible(false);
       lbl_error_fecha_inicio_garantia_aproximada.setVisible(false);
       lbl_error_fecha_memoria_tecnica_validada.setVisible(false);
       lbl_error_fecha_nuevo_expte_cotec.setVisible(false);
       lbl_error_fecha_observaciones.setVisible(false);
       lbl_error_fecha_observaciones_oya.setVisible(false);
       lbl_error_fecha_otras_fechas.setVisible(false);
       lbl_error_fecha_sol_adquisicion.setVisible(false);
       lbl_error_fecha_ultimo_dia_prest_ofert.setVisible(false);
       lbl_error_futuro_lote.setVisible(false);
       lbl_error_id_goya.setVisible(false);
       lbl_error_importe_adjudicacion.setVisible(false);
       lbl_error_importe_adjudicacion_sin_iva.setVisible(false);
       lbl_error_importe_expediente.setVisible(false);
       lbl_error_mto_garantia.setVisible(false);
       lbl_error_no_cxto.setVisible(false);
       lbl_error_no_expediente.setVisible(false);
       lbl_error_pasado_mtos_incluida_en.setVisible(false);
       lbl_error_presupuesto_base_sin_iva.setVisible(false);
       lbl_error_proyecto.setVisible(false);
       lbl_error_responsable_auxiliar.setVisible(false);
       lbl_error_tiempo_ejecucion.setVisible(false);
       lbl_error_unidad_auxiliar.setVisible(false);
       lbl_error_certificados_nov_2020.setVisible(false);
   }
    
   private void cargar_combos() throws SQLException, IOException{
    if(editable){
        opciones_tabla_general.get_combos(combo_tipo_contexto,"select * from lista_tipo_contexto");
        opciones_tabla_general.get_combos(combo_prioridad,"select * from lista_prioridad");
        opciones_tabla_general.get_combos(combo_materia,"select * from lista_materia");
        opciones_tabla_general.get_combos(combo_promotor,"select * from lista_promotor");
        opciones_tabla_general.get_combos(combo_resp_unidad,"select resp_unidad from lista_unidad");
        opciones_tabla_general.get_combos(combo_resp_area,"select resp_area from lista_area");
        opciones_tabla_general.get_combos(combo_unidad,"select unidad from lista_unidad");
        opciones_tabla_general.get_combos(combo_area,"select area from lista_area");
        opciones_tabla_general.get_combos(combo_estado_expediente,"select * from lista_estado_expediente");
        opciones_tabla_general.get_combos(combo_tipo_espediente,"select * from lista_tipo_expediente");
        opciones_tabla_general.get_combos(combo_procedimiento,"select * from lista_procedimiento");
        opciones_tabla_general.get_combos(combo_empresa_adjudicatoria,"select * from lista_empresa_adjudicadoria");
    }
}
   
   int menos=0;
   int lugares_id_goya=0;
    private void id_goyaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_goyaKeyTyped
        // TODO add your handling code here:
        
       char caracter = evt.getKeyChar();
       if(editable){
        if(caracter=='-'){
            menos++;
        }
         if( menos>=2){
            menos=2;
           }
        if( lugares_id_goya>=4){
            lugares_id_goya--;
           }
        
        if(caracter == KeyEvent.VK_BACK_SPACE){
          if( menos>=0){
            lugares_id_goya--;
           }
          
          if(!id_goya.getText().contains("-")){
              menos=0;
          }
          if( menos==0){
            lugares_id_goya=0;
           }
        }
        if (id_goya.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='-' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(id_goya.getText().length()<10){     
        char num = evt.getKeyChar();
        if (Character.isDigit(num)||num=='-') {
            if(num=='-'&&menos<2){
                   // escribe
                }else{
                if(menos!=0&&num!='-'){
                lugares_id_goya++;
                }
                if(lugares_id_goya<4 && num!='-'){
                    // escribe
                }else{
                    evt.consume();
                }
                }
        }else{
            evt.consume();
        }
        }else{
            evt.consume();
        }
        }
        }else{
//           if(caracter==evt.VK_BACK_SPACE){
                if(caracter == KeyEvent.VK_LEFT){
                evt.consume();  // desecha
           }else{
                    evt.consume();  // desecha
                }
            
        }
    }//GEN-LAST:event_id_goyaKeyTyped

    private void no_cxtoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_cxtoKeyReleased
        // TODO add your handling code here:
        if(no_cxto.getText().length()>0){
        lbl_error_no_cxto.setVisible(true);
        lbl_error_no_cxto.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_no_cxto.setIcon(null); // NOI18N
        lbl_error_no_cxto.setText("Nº Cxto");
        }else{
            lbl_error_no_cxto.setVisible(false);
        }
    }//GEN-LAST:event_no_cxtoKeyReleased

    private void no_cxtoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_cxtoKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_no_cxtoKeyTyped

    private void no_expedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_expedienteKeyReleased
        // TODO add your handling code here:
        if(no_expediente.getText().length()>0){
        lbl_error_no_expediente.setVisible(true);
        lbl_error_no_expediente.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_no_expediente.setIcon(null); // NOI18N
        lbl_error_no_expediente.setText("Nº Expediente");
        }else{
            lbl_error_no_expediente.setVisible(false);
        }
    }//GEN-LAST:event_no_expedienteKeyReleased

    private void no_expedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_expedienteKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_no_expedienteKeyTyped

    private void responsable_auxiliarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_responsable_auxiliarKeyReleased
        // TODO add your handling code here:
        if(responsable_auxiliar.getText().length()>0){
        lbl_error_responsable_auxiliar.setVisible(true);
        lbl_error_responsable_auxiliar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_responsable_auxiliar.setIcon(null); // NOI18N
        lbl_error_responsable_auxiliar.setText("Responsable Auxiliar");
        }else{
            lbl_error_responsable_auxiliar.setVisible(false);
        }
    }//GEN-LAST:event_responsable_auxiliarKeyReleased

    private void responsable_auxiliarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_responsable_auxiliarKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_responsable_auxiliarKeyTyped

    private void check_tipo_contextoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_tipo_contextoMouseClicked
        // TODO add your handling code here:
        editar(check_tipo_contexto, combo_tipo_contexto);
    }//GEN-LAST:event_check_tipo_contextoMouseClicked

    private void combo_prioridadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_prioridadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_prioridadKeyReleased

    private void check_prioridadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_prioridadMouseClicked
        // TODO add your handling code here:
        editar(check_prioridad, combo_prioridad);
    }//GEN-LAST:event_check_prioridadMouseClicked

    private void combo_materiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_materiaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_materiaKeyReleased

    private void check_materiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_materiaMouseClicked
        // TODO add your handling code here:
        editar(check_materia, combo_materia);
    }//GEN-LAST:event_check_materiaMouseClicked

    private void combo_promotorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_promotorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_promotorKeyReleased

    private void check_promotorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_promotorMouseClicked
        // TODO add your handling code here:
        editar(check_promotor, combo_promotor);
    }//GEN-LAST:event_check_promotorMouseClicked

    private void combo_resp_unidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_resp_unidadKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_combo_resp_unidadKeyReleased

    private void check_resp_unidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_resp_unidadMouseClicked
        // TODO add your handling code here:
        editar(check_resp_unidad, combo_resp_unidad);
    }//GEN-LAST:event_check_resp_unidadMouseClicked

    private void combo_resp_areaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_resp_areaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_resp_areaKeyReleased

    private void check_resp_areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_resp_areaMouseClicked
        // TODO add your handling code here:
        editar(check_resp_area, combo_resp_area);
    }//GEN-LAST:event_check_resp_areaMouseClicked

    private void combo_unidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_unidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_unidadKeyReleased

    private void check_unidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_unidadMouseClicked
        // TODO add your handling code here:
        editar(check_unidad, combo_unidad);
    }//GEN-LAST:event_check_unidadMouseClicked

    private void combo_areaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_areaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_areaKeyReleased

    private void check_areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_areaMouseClicked
        // TODO add your handling code here:
        editar(check_area, combo_area);
    }//GEN-LAST:event_check_areaMouseClicked

    private void combo_estado_expedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_estado_expedienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_estado_expedienteKeyReleased

    private void check_estado_expedienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_estado_expedienteMouseClicked
        // TODO add your handling code here:
        editar(check_estado_expediente, combo_estado_expediente);
    }//GEN-LAST:event_check_estado_expedienteMouseClicked

    private void combo_tipo_espedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_tipo_espedienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipo_espedienteKeyReleased

    private void check_tipo_espedienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_tipo_espedienteMouseClicked
        // TODO add your handling code here:
        editar(check_tipo_espediente, combo_tipo_espediente);
    }//GEN-LAST:event_check_tipo_espedienteMouseClicked

    private void combo_procedimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_procedimientoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_procedimientoKeyReleased

    private void check_procedimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_procedimientoMouseClicked
        // TODO add your handling code here:
        editar(check_procedimiento, combo_procedimiento);
    }//GEN-LAST:event_check_procedimientoMouseClicked

    private void combo_empresa_adjudicatoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_empresa_adjudicatoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_empresa_adjudicatoriaKeyReleased

    private void check_empresa_adjudicatoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_empresa_adjudicatoriaMouseClicked
        // TODO add your handling code here:
        editar(check_empresa_adjudicatoria, combo_empresa_adjudicatoria);
    }//GEN-LAST:event_check_empresa_adjudicatoriaMouseClicked

    private void unidad_auxiliarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unidad_auxiliarKeyReleased
        // TODO add your handling code here:
        if(unidad_auxiliar.getText().length()>0){
        lbl_error_unidad_auxiliar.setVisible(true);
        lbl_error_unidad_auxiliar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_unidad_auxiliar.setIcon(null); // NOI18N
        lbl_error_unidad_auxiliar.setText("Unidad Auxiliar");
        }else{
            lbl_error_unidad_auxiliar.setVisible(false);
        }
    }//GEN-LAST:event_unidad_auxiliarKeyReleased

    private void unidad_auxiliarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unidad_auxiliarKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_unidad_auxiliarKeyTyped

    private void tiempo_ejecucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tiempo_ejecucionKeyReleased
        // TODO add your handling code here:
        if(tiempo_ejecucion.getText().length()>0){
        lbl_error_tiempo_ejecucion.setVisible(true);
        lbl_error_tiempo_ejecucion.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_tiempo_ejecucion.setIcon(null); // NOI18N
        lbl_error_tiempo_ejecucion.setText("Tiempo Ejecución");
        }else{
            lbl_error_tiempo_ejecucion.setVisible(false);
        }
    }//GEN-LAST:event_tiempo_ejecucionKeyReleased

    private void tiempo_ejecucionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tiempo_ejecucionKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_tiempo_ejecucionKeyTyped

    private void mto_garantiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mto_garantiaKeyReleased
        // TODO add your handling code here:
        if(mto_garantia.getText().length()>0){
        lbl_error_mto_garantia.setVisible(true);
        lbl_error_mto_garantia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_mto_garantia.setIcon(null); // NOI18N
        lbl_error_mto_garantia.setText("Mto/Garantía");
        }else{
            lbl_error_mto_garantia.setVisible(false);
        }
    }//GEN-LAST:event_mto_garantiaKeyReleased

    private void mto_garantiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mto_garantiaKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_mto_garantiaKeyTyped

    private void anos_prorrogableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anos_prorrogableKeyReleased
        // TODO add your handling code here:
        if(anos_prorrogable.getText().length()>0){
        lbl_error_anos_prorrogable.setVisible(true);
        lbl_error_anos_prorrogable.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_anos_prorrogable.setIcon(null); // NOI18N
        lbl_error_anos_prorrogable.setText("Años Prorrogable");
        }else{
            lbl_error_anos_prorrogable.setVisible(false);
        }
    }//GEN-LAST:event_anos_prorrogableKeyReleased

    private void anos_prorrogableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anos_prorrogableKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_anos_prorrogableKeyTyped

    private void alarmaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alarmaKeyReleased
        // TODO add your handling code here:
        if(alarma.getText().length()>0){
        lbl_error_alarma.setVisible(true);
        lbl_error_alarma.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_alarma.setIcon(null); // NOI18N
        lbl_error_alarma.setText("Alarma");
        }else{
            lbl_error_alarma.setVisible(false);
        }
    }//GEN-LAST:event_alarmaKeyReleased

    private void alarmaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alarmaKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_alarmaKeyTyped

    private void no_expedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_expedienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_expedienteActionPerformed

    private void futuro_loteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_futuro_loteKeyReleased
        // TODO add your handling code here:
        if(futuro_lote.getText().length()>0){
        lbl_error_futuro_lote.setVisible(true);
        lbl_error_futuro_lote.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_futuro_lote.setIcon(null); // NOI18N
        lbl_error_futuro_lote.setText("Futuro Lote");
        }else{
            lbl_error_futuro_lote.setVisible(false);
        }
    }//GEN-LAST:event_futuro_loteKeyReleased

    private void futuro_loteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_futuro_loteKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_futuro_loteKeyTyped

    private void proyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proyectoKeyReleased
        // TODO add your handling code here:
        if(proyecto.getText().length()>0){
        lbl_error_proyecto.setVisible(true);
        lbl_error_proyecto.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_proyecto.setIcon(null); // NOI18N
        lbl_error_proyecto.setText("Proyecto");
        }else{
            lbl_error_proyecto.setVisible(false);
        }
    }//GEN-LAST:event_proyectoKeyReleased

    private void proyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proyectoKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_proyectoKeyTyped

    private void estado_garantiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estado_garantiaKeyReleased
        // TODO add your handling code here:
        if(estado_garantia.getText().length()>0){
        lbl_error_estado_de_garantia.setVisible(true);
        lbl_error_estado_de_garantia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_estado_de_garantia.setIcon(null); // NOI18N
        lbl_error_estado_de_garantia.setText("Estado de Garantía");
        }else{
            lbl_error_estado_de_garantia.setVisible(false);
        }
    }//GEN-LAST:event_estado_garantiaKeyReleased

    private void estado_garantiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estado_garantiaKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_estado_garantiaKeyTyped

    private void pasado_mtos_incluida_enKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pasado_mtos_incluida_enKeyReleased
        // TODO add your handling code here:
        if(pasado_mtos_incluida_en.getText().length()>0){
        lbl_error_pasado_mtos_incluida_en.setVisible(true);
        lbl_error_pasado_mtos_incluida_en.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_pasado_mtos_incluida_en.setIcon(null); // NOI18N
        lbl_error_pasado_mtos_incluida_en.setText("Psado a Mtos/ Incluida en:");
        }else{
            lbl_error_pasado_mtos_incluida_en.setVisible(false);
        }
    }//GEN-LAST:event_pasado_mtos_incluida_enKeyReleased

    private void pasado_mtos_incluida_enKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pasado_mtos_incluida_enKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_pasado_mtos_incluida_enKeyTyped

    private void dl_validadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dl_validadoKeyReleased
        // TODO add your handling code here:
        if(dl_validado.getText().length()>0){
        lbl_error_dl_validado.setVisible(true);
        lbl_error_dl_validado.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_dl_validado.setIcon(null); // NOI18N
        lbl_error_dl_validado.setText("DL Validado");
        }else{
            lbl_error_dl_validado.setVisible(false);
        }
    }//GEN-LAST:event_dl_validadoKeyReleased

    private void dl_validadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dl_validadoKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_dl_validadoKeyTyped

    private void importe_expedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_expedienteKeyReleased
        // TODO add your handling code here:
        if(importe_expediente.getText().length()>0){
        lbl_error_importe_expediente.setVisible(true);
        lbl_error_importe_expediente.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_importe_expediente.setIcon(null); // NOI18N
        lbl_error_importe_expediente.setText("Importe Expediente");
        }else{
            lbl_error_importe_expediente.setVisible(false);
        }
    }//GEN-LAST:event_importe_expedienteKeyReleased
    
    private void editar(Switch on, SComboBox combo){
        if(on.isOnOff()){
            combo.setEditable(true);
            AutoCompleteDecorator.decorate(combo);
        }else{
            combo.setEditable(false);
            combo.requestFocus();
        }
    }
    
    int pto_importe=0;
    int lugares_importe=0;
    private void importe_expedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_expedienteKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }else{
         pto_importe=0;
        lugares_importe=0;
         char caracter = evt.getKeyChar();
        if(caracter=='.'){
            pto_importe++;
        }
         if( pto_importe>=2){
            pto_importe=2;
           }
        if( lugares_importe>=3){
            lugares_importe--;
           }
        
        if(caracter == KeyEvent.VK_BACK_SPACE){
          if( pto_importe>=0){
            lugares_importe--;
           }
          
          if(!importe_expediente.getText().contains(".")){
              pto_importe=0;
          }
          if( pto_importe==0){
            lugares_importe=0;
           }
        }
        if (importe_expediente.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(importe_expediente.getText().length()<10){     
        char num = evt.getKeyChar();
        if (Character.isDigit(num)||num=='.') {
            if(num=='.'&&pto_importe<2){
                   // escribe
                }else{
                if(pto_importe!=0&&num!='.'){
                lugares_importe++;
                }
                if(lugares_importe<3 && num!='.'){
                    // escribe
                }else{
                    evt.consume();
                }
                }
        }else{
            evt.consume();
        }
        }else{
            evt.consume();
        }
        }
        }
    }//GEN-LAST:event_importe_expedienteKeyTyped

    private void importe_adjudicado_sin_ivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_adjudicado_sin_ivaKeyReleased
        // TODO add your handling code here:
        if(importe_adjudicado_sin_iva.getText().length()>0){
        lbl_error_importe_adjudicacion_sin_iva.setVisible(true);
        lbl_error_importe_adjudicacion_sin_iva.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_importe_adjudicacion_sin_iva.setIcon(null); // NOI18N
        lbl_error_importe_adjudicacion_sin_iva.setText("Importe Adjudicado sin IVA");
        }else{
            lbl_error_importe_adjudicacion_sin_iva.setVisible(false);
        }
    }//GEN-LAST:event_importe_adjudicado_sin_ivaKeyReleased
    int pto=0;
    int lugares=0;
    private void importe_adjudicado_sin_ivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_adjudicado_sin_ivaKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }else{
        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            pto++;
        }
         if( pto>=2){
            pto=2;
           }
        if( lugares>=3){
            lugares--;
           }
        
        if(caracter == KeyEvent.VK_BACK_SPACE){
          if( pto>=0){
            lugares--;
           }
          
          if(!importe_adjudicado_sin_iva.getText().contains(".")){
              pto=0;
          }
          if( pto==0){
            lugares=0;
           }
        }
        if (importe_adjudicado_sin_iva.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(importe_adjudicado_sin_iva.getText().length()<10){     
        char num = evt.getKeyChar();
        if (Character.isDigit(num)||num=='.') {
            if(num=='.'&&pto<2){
                   // escribe
                }else{
                if(pto!=0&&num!='.'){
                lugares++;
                }
                if(lugares<3 && num!='.'){
                    // escribe
                }else{
                    evt.consume();
                }
                }
        }else{
            evt.consume();
        }
        }else{
            evt.consume();
        }
        }
        }
    }//GEN-LAST:event_importe_adjudicado_sin_ivaKeyTyped

    private void presupuesto_base_sin_ivaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_presupuesto_base_sin_ivaKeyReleased
        // TODO add your handling code here:
        if(presupuesto_base_sin_iva.getText().length()>0){
        lbl_error_presupuesto_base_sin_iva.setVisible(true);
        lbl_error_presupuesto_base_sin_iva.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_presupuesto_base_sin_iva.setIcon(null); // NOI18N
        lbl_error_presupuesto_base_sin_iva.setText("Presupuesto Base sin IVA");
        }else{
            lbl_error_presupuesto_base_sin_iva.setVisible(false);
        }
    }//GEN-LAST:event_presupuesto_base_sin_ivaKeyReleased

    int pto_presup=0;
    int lugares_presup=0;
    private void presupuesto_base_sin_ivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_presupuesto_base_sin_ivaKeyTyped
         // TODO add your handling code here:
         if(editable==false){
            evt.consume();
        }else{
        pto_presup=0;
        lugares_presup=0;
         char caracter = evt.getKeyChar();
        if(caracter=='.'){
            pto_presup++;
        }
         if( pto_presup>=2){
            pto_presup=2;
           }
        if( lugares_presup>=3){
            lugares_presup--;
           }
        
        if(caracter == KeyEvent.VK_BACK_SPACE){
          if( pto_presup>=0){
            lugares_presup--;
           }
          
          if(!presupuesto_base_sin_iva.getText().contains(".")){
              pto_presup=0;
          }
          if( pto_presup==0){
            lugares_presup=0;
           }
        }
        if (presupuesto_base_sin_iva.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(presupuesto_base_sin_iva.getText().length()<10){     
        char num = evt.getKeyChar();
        if (Character.isDigit(num)||num=='.') {
            if(num=='.'&&pto_presup<2){
                   // escribe
                }else{
                if(pto_presup!=0&&num!='.'){
                lugares_presup++;
                }
                if(lugares_presup<3 && num!='.'){
                    // escribe
                }else{
                    evt.consume();
                }
                }
        }else{
            evt.consume();
        }
        }else{
            evt.consume();
        }
        }
         }
    }//GEN-LAST:event_presupuesto_base_sin_ivaKeyTyped

    private void importe_adjudicacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_adjudicacionKeyReleased
        // TODO add your handling code here:
        if(importe_adjudicacion.getText().length()>0){
        lbl_error_importe_adjudicacion.setVisible(true);
        lbl_error_importe_adjudicacion.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_importe_adjudicacion.setIcon(null); // NOI18N
        lbl_error_importe_adjudicacion.setText("Importe de Adjudicación");
        }else{
            lbl_error_importe_adjudicacion.setVisible(false);
        }
    }//GEN-LAST:event_importe_adjudicacionKeyReleased
     int pto_adjudica=0;
     int lugares_adjudica=0;
    private void importe_adjudicacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_adjudicacionKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }else{
         pto_adjudica=0;
        lugares_adjudica=0;
         char caracter = evt.getKeyChar();
        if(caracter=='.'){
            pto_adjudica++;
        }
         if( pto_adjudica>=2){
            pto_adjudica=2;
           }
        if( lugares_adjudica>=3){
            lugares_adjudica--;
           }
        
        if(caracter == KeyEvent.VK_BACK_SPACE){
          if( pto_adjudica>=0){
            lugares_adjudica--;
           }
          
          if(!importe_adjudicacion.getText().contains(".")){
              pto_adjudica=0;
          }
          if( pto_adjudica==0){
            lugares_adjudica=0;
           }
        }
        if (importe_adjudicacion.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(importe_adjudicacion.getText().length()<10){     
        char num = evt.getKeyChar();
        if (Character.isDigit(num)||num=='.') {
            if(num=='.'&&pto_adjudica<2){
                   // escribe
                }else{
                if(pto_adjudica!=0&&num!='.'){
                lugares_presup++;
                }
                if(lugares_adjudica<3 && num!='.'){
                    // escribe
                }else{
                    evt.consume();
                }
                }
        }else{
            evt.consume();
        }
        }else{
            evt.consume();
        }
        }
        }
    }//GEN-LAST:event_importe_adjudicacionKeyTyped

    private void capituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capituloKeyReleased
        // TODO add your handling code here:
        if(capitulo.getText().length()>0){
        lbl_error_capitulo.setVisible(true);
        lbl_error_capitulo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_capitulo.setIcon(null); // NOI18N
        lbl_error_capitulo.setText("Capítulo");
        }else{
            lbl_error_capitulo.setVisible(false);
        }
    }//GEN-LAST:event_capituloKeyReleased

    private void capituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capituloKeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_capituloKeyTyped

    private void certificados_nov_2020KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_certificados_nov_2020KeyReleased
        // TODO add your handling code here:
        if(certificados_nov_2020.getText().length()>0){
        lbl_error_certificados_nov_2020.setVisible(true);
        lbl_error_certificados_nov_2020.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_certificados_nov_2020.setIcon(null); // NOI18N
        lbl_error_certificados_nov_2020.setText("Certificados a Nov_2020");
        }else{
            lbl_error_certificados_nov_2020.setVisible(false);
        }
    }//GEN-LAST:event_certificados_nov_2020KeyReleased

    private void certificados_nov_2020KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_certificados_nov_2020KeyTyped
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_certificados_nov_2020KeyTyped

    private void combo_prioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_prioridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_prioridadActionPerformed

    private void combo_empresa_adjudicatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_empresa_adjudicatoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_empresa_adjudicatoriaActionPerformed

    private void boton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registrarActionPerformed
        // TODO add your handling code here:
        String sql = "";
        
        if(add_aplicaciones.isSelected()){
            tabla="gestion_aplicaciones";
        }else if(add_base.isSelected()){
            tabla="sistema_base";
        }else if(add_comunicaciones.isSelected()){
            tabla="sistema_comunicaciones";
        }else if(add_produccion.isSelected()){
            tabla="gestion_produccion";
        }
        String sql_existe = "select * from " + tabla + " where id_goya='" + id_goya.getText().trim() + "'";
        if (add_aplicaciones.isSelected() == false && add_base.isSelected() == false && add_comunicaciones.isSelected() == false && add_produccion.isSelected() == false) {
                    ErrorAlert.lanza_error_variable_sin_ex("", "Por favor indique en que tabla seran guardados los datos", "");
                } else {
        if (id_goya.getText().isEmpty()) {
            lbl_error_id_goya.setVisible(true);
            ErrorAlert.lanza_error_variable_sin_ex("'ID-GOYA' no puede estar vacio", "", "");
        } else {
            if (opciones_de_gestionar_usuarios.existe(sql_existe)&&!id_control.equals(id_goya.getText())) {
                ErrorAlert.lanza_error_variable_sin_ex("", "El id que intenta registrar ya existe", "");
                lbl_error_id_goya.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_id_goya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error_id_goya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/label-error-backup.png"))); // NOI18N
        lbl_error_id_goya.setText("¡Dato no Válido!");
            } else {
                try {
                    if(boton_registrar.getText().equals("REGISTRAR")){
                        sql = "INSERT INTO " + tabla + " (ID_GOYA, NO_CXTO, NO_DE_EXPEDIENTE, DESCRIPCION, TIPO_DE_CXTO, PRIORIDAD, TIPO_SERVICIO_O_INVERSION, "
                                + "PROMOTOR, AREA, UNIDAD, RESP_AREA, RESP_UNIDAD, UNIDAD_AUXILIAR, RESPONSABLE_AUXILIAR, PRESUPUESTO_BASE_SIN_IVA, IMPORTE_ADJUDICADO_SIN_IVA, ESTADO_EXPEDIENTE,"
                                + " MTO_GARANTIA, TIEMPO_EJECUCION, INICIO_GARANTIA_APROX, FIN_GARANTIA_APROX, ANOS_PRORROGABLE, ALARMA, FUTURO_LOTE, PROYECTO, ESTADO_DE_GARANTIA, "
                                + "PSADO_A_MTOS_INCLUIDA_EN, SOL_ADQUISICION, MEMORIA_TECNICA_VALIDADA, DL_VALIDADO, NUEVO_EXPTE_COTEC_DE, TIPO_EXPEDIENTE, PROCEDIMIENTO, IMPORTE_EXPEDIENTE,"
                                + " ULT_DIA_PREST_OFERTAS, INFORME_TECNICO_REALIZADO, FECHA_ADJUDICACION, EMPRESA_ADJUDICATORIA, IMPORTE_DE_ADJUDICACION, FECHA_FORNALIZACION, OTRAS_FECHAS, CAPITULO,"
                                + " CERTIFICADOS_A_NOV_2020, ESTADO_OOCC_A_09_07_2021, OBSERVACIONES, OBSERVACIONES_DE_OYA)"
                                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    }else{
                        sql="UPDATE "+tabla+" SET ID_GOYA = ?, NO_CXTO = ?, NO_DE_EXPEDIENTE = ?, DESCRIPCION = ?, TIPO_DE_CXTO = ?, PRIORIDAD = ?, TIPO_SERVICIO_O_INVERSION = ?, "
                                + "PROMOTOR = ?, AREA = ?, UNIDAD = ?, RESP_AREA = ?, RESP_UNIDAD = ?, UNIDAD_AUXILIAR = ?, RESPONSABLE_AUXILIAR = ?, PRESUPUESTO_BASE_SIN_IVA = ?,"
                                + " IMPORTE_ADJUDICADO_SIN_IVA = ?, ESTADO_EXPEDIENTE = ?, MTO_GARANTIA = ?, TIEMPO_EJECUCION = ?, INICIO_GARANTIA_APROX = ?, FIN_GARANTIA_APROX = ?,"
                                + " ANOS_PRORROGABLE = ?, ALARMA = ?, FUTURO_LOTE = ?, PROYECTO = ?, ESTADO_DE_GARANTIA = ?, PSADO_A_MTOS_INCLUIDA_EN = ?, SOL_ADQUISICION = ?, "
                                + "MEMORIA_TECNICA_VALIDADA = ?, DL_VALIDADO = ?, NUEVO_EXPTE_COTEC_DE = ?, TIPO_EXPEDIENTE = ?, PROCEDIMIENTO = ?, IMPORTE_EXPEDIENTE = ?,"
                                + " ULT_DIA_PREST_OFERTAS = ?, INFORME_TECNICO_REALIZADO = ?, FECHA_ADJUDICACION = ?, EMPRESA_ADJUDICATORIA = ?, IMPORTE_DE_ADJUDICACION = ?,"
                                + " FECHA_FORNALIZACION = ?, OTRAS_FECHAS = ?, CAPITULO = ?, CERTIFICADOS_A_NOV_2020 = ?, ESTADO_OOCC_A_09_07_2021 = ?, OBSERVACIONES = ?,"
                                + " OBSERVACIONES_DE_OYA = ? WHERE ID_GOYA = '"+id_control+"'";
                    }
                    int control = opciones_tabla_general.registrar_tabla_genaral(id_goya.getText().trim(), no_cxto.getText().trim(), no_expediente.getText().trim(), descripcion.getText().trim(), combo_vacio(combo_tipo_contexto),
                            combo_vacio(combo_prioridad), combo_vacio(combo_materia), combo_vacio(combo_promotor), combo_vacio(combo_area),
                            combo_vacio(combo_unidad), combo_vacio(combo_resp_area), combo_vacio(combo_resp_unidad), unidad_auxiliar.getText().trim(), responsable_auxiliar.getText().trim(),
                            presupuesto_base_sin_iva.getText().trim(), importe_adjudicado_sin_iva.getText().trim(), combo_vacio(combo_estado_expediente), mto_garantia.getText().trim(),
                            tiempo_ejecucion.getText().trim(),
                            toma_fecha(fecha_inicio_garantia_aproximada, text_area_fecha_inicio_garantia_aproximada.getText().trim()),
                            toma_fecha(fecha_fin_garantia_aprox, text_area_fin_garantia_aprox.getText().trim()), anos_prorrogable.getText().trim(), alarma.getText().trim(), 
                            futuro_lote.getText().trim(),
                            proyecto.getText().trim(), estado_garantia.getText().trim(), pasado_mtos_incluida_en.getText().trim(), 
                            toma_fecha(fecha_sol_adquisicion,
                                    text_area_sol_adquisicion.getText().trim()),
                            toma_fecha(fecha_memoria_tecni_validada, text_memoria_tecnica_validada.getText().trim()), dl_validado.getText().trim(), 
                            toma_fecha(fecha_nuevo_expte_cotec, text_area_nuevo_expte_cotec.getText().trim()),
                            combo_vacio(combo_tipo_espediente), combo_vacio(combo_procedimiento), importe_expediente.getText().trim(),
                            toma_fecha(fecha_ult_dia_prest_ofertas, text_area_ult_dia_prest_ofertas.getText().trim()),
                            toma_fecha(fecha_informe_tecnico_realizado, 
                                    text_area_informe_tecnico_realizado.getText().trim()),
                            toma_fecha(fecha_fecha_adjudicacion, text_area_fecha_adjudicacion.getText().trim()), combo_vacio(combo_empresa_adjudicatoria), 
                            importe_adjudicacion.getText().trim(),
                            toma_fecha(fecha_fecha_formalizacion, text_area_fecha_formalizacion.getText().trim()), toma_fecha(fecha_otras_fechas, text_area_otras_fechas.getText().trim()),
                            capitulo.getText().trim(), certificados_nov_2020.getText().trim(), toma_fecha(fecha_estado_oocc_09_07_2021, text_area_estado_oocc_09_07_2021.getText().trim()),
                            toma_fecha(fecha_observaciones, text_area_observaciones.getText().trim()), toma_fecha(fecha_observaciones_oya, text_area_observaciones_oya.getText().trim()),
                            sql);
                    if (control == 1) {
                        tabla = "";
                        SuccessAlert s = new SuccessAlert(new JFrame(), true);
                        s.msj1.setText("");
                        s.msj2.setText("¡Datos guardados con éxito!");
                        s.msj3.setText("");
                        s.setVisible(true);
                    } else {
                        ErrorAlert.lanza_error_variable_sin_ex("", "", "");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(pnl_add.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(pnl_add.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        }
    }//GEN-LAST:event_boton_registrarActionPerformed

    private String combo_vacio(SComboBox combo){
        String salida="";
        if(combo.getSelectedIndex()!=0){
            salida=combo.getSelectedItem().toString();
        }
        return salida;
    }
    
    private void id_goyaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_goyaKeyReleased
        // TODO add your handling code here:
        if(id_goya.getText().length()>0){
        lbl_error_id_goya.setVisible(true);
        lbl_error_id_goya.setForeground(new java.awt.Color(0, 0, 0));
        lbl_error_id_goya.setIcon(null); // NOI18N
        lbl_error_id_goya.setText("ID_GOYA");
        }else{
            lbl_error_id_goya.setVisible(false);
        }
    }//GEN-LAST:event_id_goyaKeyReleased

    private void boton_borrar_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_borrar_todoActionPerformed
        // TODO add your handling code here:
        limpia();
        SuccessAlert s = new SuccessAlert(new JFrame(), true);
        s.msj1.setText("¡Limpiado de campos exitoso!");
        s.msj2.setText("");
        s.msj3.setText("");
        s.setVisible(true);
    }//GEN-LAST:event_boton_borrar_todoActionPerformed

    private void add_produccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_produccionActionPerformed
        // TODO add your handling code here:
        add_produccion.setSelected(true);
        add_base.setSelected(false);
        add_aplicaciones.setSelected(false);
        add_comunicaciones.setSelected(false);
        tabla="gestion_produccion";
    }//GEN-LAST:event_add_produccionActionPerformed

    private void add_baseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_baseActionPerformed
        // TODO add your handling code here:
        add_base.setSelected(true);
        add_produccion.setSelected(false);
        add_aplicaciones.setSelected(false);
        add_comunicaciones.setSelected(false);
        tabla="sistema_base";
    }//GEN-LAST:event_add_baseActionPerformed

    private void add_aplicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_aplicacionesActionPerformed
        // TODO add your handling code here:
        add_aplicaciones.setSelected(true);
        add_produccion.setSelected(false);
        add_base.setSelected(false);
        add_comunicaciones.setSelected(false);
        tabla="gestion_aplicaciones";
    }//GEN-LAST:event_add_aplicacionesActionPerformed

    private void add_comunicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_comunicacionesActionPerformed
        // TODO add your handling code here:
        add_comunicaciones.setSelected(true);
        add_aplicaciones.setSelected(false);
        add_produccion.setSelected(false);
        add_base.setSelected(false);
        tabla="sistema_comunicaciones";
    }//GEN-LAST:event_add_comunicacionesActionPerformed

    private void combo_estado_expedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_estado_expedienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_estado_expedienteActionPerformed

    private void combo_tipo_contextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipo_contextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipo_contextoActionPerformed

    private void boton_borrar_todo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_borrar_todo1ActionPerformed
        // TODO add your handling code here:
        boton_borrar_todoActionPerformed(evt);
    }//GEN-LAST:event_boton_borrar_todo1ActionPerformed

    private void boton_registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registrar1ActionPerformed
        // TODO add your handling code here:
        boton_registrarActionPerformed(evt);
    }//GEN-LAST:event_boton_registrar1ActionPerformed

    private void id_goyaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_goyaKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_id_goyaKeyPressed

    private void no_cxtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_cxtoKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_no_cxtoKeyPressed

    private void no_expedienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_expedienteKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_no_expedienteKeyPressed

    private void importe_expedienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_expedienteKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_importe_expedienteKeyPressed

    private void capituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capituloKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_capituloKeyPressed

    private void unidad_auxiliarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unidad_auxiliarKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_unidad_auxiliarKeyPressed

    private void tiempo_ejecucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tiempo_ejecucionKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_tiempo_ejecucionKeyPressed

    private void importe_adjudicado_sin_ivaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_adjudicado_sin_ivaKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_importe_adjudicado_sin_ivaKeyPressed

    private void estado_garantiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estado_garantiaKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_estado_garantiaKeyPressed

    private void mto_garantiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mto_garantiaKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_mto_garantiaKeyPressed

    private void presupuesto_base_sin_ivaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_presupuesto_base_sin_ivaKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_presupuesto_base_sin_ivaKeyPressed

    private void proyectoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proyectoKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_proyectoKeyPressed

    private void certificados_nov_2020KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_certificados_nov_2020KeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_certificados_nov_2020KeyPressed

    private void importe_adjudicacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importe_adjudicacionKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_importe_adjudicacionKeyPressed

    private void dl_validadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dl_validadoKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_dl_validadoKeyPressed

    private void alarmaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alarmaKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_alarmaKeyPressed

    private void anos_prorrogableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anos_prorrogableKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_anos_prorrogableKeyPressed

    private void responsable_auxiliarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_responsable_auxiliarKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_responsable_auxiliarKeyPressed

    private void pasado_mtos_incluida_enKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pasado_mtos_incluida_enKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_pasado_mtos_incluida_enKeyPressed

    private void futuro_loteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_futuro_loteKeyPressed
        // TODO add your handling code here:
        if(editable==false){
            evt.consume();
        }
    }//GEN-LAST:event_futuro_loteKeyPressed

    private void btn_pdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pdfMouseEntered
        // TODO add your handling code here:
        btn_pdf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_btn_pdfMouseEntered

    private void btn_pdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pdfMouseExited
        // TODO add your handling code here:
        btn_pdf.setBorder(null);
    }//GEN-LAST:event_btn_pdfMouseExited

    private void btn_pdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pdfMouseClicked
        try {
            // TODO add your handling code here:
            ArrayList<datos_reporte> dato_list = new ArrayList<>();
            datos_reporte datos = new datos_reporte();

                if(id_goya.getText().isEmpty()){
                    datos.setId_goya("");
                }else{
                    datos.setId_goya(id_goya.getText().trim());
                }
                if(no_cxto.getText().isEmpty()){
                    datos.setNo_cxto("");
                }else{
                    datos.setNo_cxto(no_cxto.getText().trim());
                }
                if(no_expediente.getText().isEmpty()){
                    datos.setNo_de_expediente("");
                }else{
                    datos.setNo_de_expediente(no_expediente.getText().trim());
                }           
                if(descripcion.getText().isEmpty()){
                    datos.setDescripcion("");
                }else{
                    datos.setDescripcion(descripcion.getText().trim());
                }            
                if(combo_tipo_contexto.getSelectedItem().toString().equals("Tipo de Cxto")){
                    datos.setTipo_de_cxto("");
                }else{
                    datos.setTipo_de_cxto(combo_tipo_contexto.getSelectedItem().toString());
                }       
                if(combo_prioridad.getSelectedItem().toString().equals("Prioridad")){
                    datos.setPrioridad("");
                }else{
                    datos.setPrioridad(combo_prioridad.getSelectedItem().toString());
                }        
                if(combo_materia.getSelectedItem().toString().equals("Materia")){
                    datos.setTipo_servicio_o_inversion("");
                }else{
                    datos.setTipo_servicio_o_inversion(combo_materia.getSelectedItem().toString());
                }       
                if(combo_promotor.getSelectedItem().toString().equals("Promotor")){
                    datos.setPromotor("");
                }else{
                    datos.setPromotor(combo_promotor.getSelectedItem().toString());
                }       
                if(combo_area.getSelectedItem().toString().equals("Promotor")){
                    datos.setArea("");
                }else{
                    datos.setArea(combo_area.getSelectedItem().toString());
                }       
                if(combo_unidad.getSelectedItem().toString().equals("Unidad")){
                    datos.setUnidad("");
                }else{
                    datos.setUnidad(combo_unidad.getSelectedItem().toString());
                }        
                if(combo_resp_area.getSelectedItem().toString().equals("Resp Área")){
                    datos.setResp_area("");
                }else{
                    datos.setResp_area(combo_resp_area.getSelectedItem().toString());
                }        
                if(combo_resp_unidad.getSelectedItem().toString().equals("Resp Unidad")){
                    datos.setResp_unidad("");
                }else{
                    datos.setResp_unidad(combo_resp_unidad.getSelectedItem().toString());
                }        
                if(unidad_auxiliar.getText().isEmpty()){
                    datos.setUnidad_auxiliar("");
                }else{
                    datos.setUnidad_auxiliar(unidad_auxiliar.getText());
                }        
                if(responsable_auxiliar.getText().isEmpty()){
                    datos.setResponsable_auxiliar("");
                }else{
                    datos.setResponsable_auxiliar(responsable_auxiliar.getText());
                }        
                if(presupuesto_base_sin_iva.getText().isEmpty()){
                    datos.setPresupuesto_base_sin_iva("");
                }else{
                    datos.setPresupuesto_base_sin_iva(presupuesto_base_sin_iva.getText());
                }        
                if(importe_adjudicado_sin_iva.getText().isEmpty()){
                    datos.setImporte_adjudicado_sin_iva("");
                }else{
                    datos.setImporte_adjudicado_sin_iva(importe_adjudicado_sin_iva.getText());
                }
                if(combo_estado_expediente.getSelectedItem().toString().equals("Estado Expediente")){
                    datos.setEstado_expediente("");
                }else{
                    datos.setEstado_expediente(combo_estado_expediente.getSelectedItem().toString());
                }        
                if(mto_garantia.getText().isEmpty()){
                    datos.setMto_garantia("");
                }else{
                    datos.setMto_garantia(mto_garantia.getText());
                }        
                if(tiempo_ejecucion.getText().isEmpty()){
                    datos.setTiempo_ejecucion("");
                }else{
                    datos.setTiempo_ejecucion(tiempo_ejecucion.getText());
                }        
                if(text_area_fecha_inicio_garantia_aproximada.getText().isEmpty()){
                    datos.setInicio_garantia_aprox("");
                }else{
                    datos.setInicio_garantia_aprox(text_area_fecha_inicio_garantia_aproximada.getText());
                }        
                if(text_area_fin_garantia_aprox.getText().isEmpty()){
                    datos.setFin_garantia_aprox("");
                }else{
                    datos.setFin_garantia_aprox(text_area_fin_garantia_aprox.getText());
                }        
                if(anos_prorrogable.getText().isEmpty()){
                    datos.setAnos_prorrogable("");
                }else{
                    datos.setAnos_prorrogable(anos_prorrogable.getText());
                }        
                if(alarma.getText().isEmpty()){
                    datos.setAlarma("");
                }else{
                    datos.setAlarma(alarma.getText());
                }        
                if(futuro_lote.getText().isEmpty()){
                    datos.setFuturo_lote("");
                }else{
                    datos.setFuturo_lote(futuro_lote.getText());
                }        
                if(proyecto.getText().isEmpty()){
                    datos.setProyecto("");
                }else{
                    datos.setProyecto(proyecto.getText());
                }        
                if(estado_garantia.getText().isEmpty()){
                    datos.setEstado_de_garantia("");
                }else{
                    datos.setEstado_de_garantia(estado_garantia.getText());
                }        
                if(pasado_mtos_incluida_en.getText().isEmpty()){
                    datos.setPsado_a_mtos_incluida_en("");
                }else{
                    datos.setPsado_a_mtos_incluida_en(pasado_mtos_incluida_en.getText());
                }        
                if(text_area_sol_adquisicion.getText().isEmpty()){
                    datos.setSol_adquisicion("");
                }else{
                    datos.setSol_adquisicion(text_area_sol_adquisicion.getText());
                }        
                if(text_memoria_tecnica_validada.getText().isEmpty()){
                    datos.setMemoria_tecnica_validada("");
                }else{
                    datos.setMemoria_tecnica_validada(text_memoria_tecnica_validada.getText());
                }        
                if(dl_validado.getText().isEmpty()){
                    datos.setDl_validado("");
                }else{
                    datos.setDl_validado(dl_validado.getText());
                }        
                if(text_area_nuevo_expte_cotec.getText().isEmpty()){
                    datos.setNuevo_expte_cotec_de("");
                }else{
                    datos.setNuevo_expte_cotec_de(text_area_nuevo_expte_cotec.getText());
                }        
                if(combo_tipo_espediente.getSelectedItem().toString().equals("Tipo Expediente")){
                    datos.setTipo_expediente("");
                }else{
                    datos.setTipo_expediente(combo_tipo_espediente.getSelectedItem().toString());
                }        
                if(combo_procedimiento.getSelectedItem().toString().equals("Procedimiento")){
                    datos.setProcedimiento("");
                }else{
                    datos.setProcedimiento(combo_procedimiento.getSelectedItem().toString());
                }        
                if(importe_expediente.getText().isEmpty()){
                    datos.setImporte_expediente("");
                }else{
                    datos.setImporte_expediente(importe_expediente.getText());
                }        
                if(text_area_ult_dia_prest_ofertas.getText().isEmpty()){
                    datos.setUlt_dia_prest_ofertas("");
                }else{
                    datos.setUlt_dia_prest_ofertas(text_area_ult_dia_prest_ofertas.getText());
                }        
                if(text_area_informe_tecnico_realizado.getText().isEmpty()){
                    datos.setInforme_tecnico_realizado("");
                }else{
                    datos.setInforme_tecnico_realizado(text_area_informe_tecnico_realizado.getText());
                }        
                if(text_area_fecha_adjudicacion.getText().isEmpty()){
                    datos.setFecha_adjudicacion("");
                }else{
                    datos.setFecha_adjudicacion(text_area_fecha_adjudicacion.getText());
                }        
                if(combo_empresa_adjudicatoria.getSelectedItem().toString().equals("Empresa Adjudicatoria")){
                    datos.setEmpresa_adjudicatoria("");
                }else{
                    datos.setEmpresa_adjudicatoria(combo_empresa_adjudicatoria.getSelectedItem().toString());
                }        
                if(importe_adjudicacion.getText().isEmpty()){
                    datos.setImporte_de_adjudicacion("");
                }else{
                    datos.setImporte_de_adjudicacion(importe_adjudicacion.getText());
                }        
                if(text_area_fecha_formalizacion.getText().isEmpty()){
                    datos.setFecha_fornalizacion("");
                }else{
                    datos.setFecha_fornalizacion(text_area_fecha_formalizacion.getText());
                }        
                if(text_area_otras_fechas.getText().isEmpty()){
                    datos.setOtras_fechas("");
                }else{
                    datos.setOtras_fechas(text_area_otras_fechas.getText());
                }        
                if(capitulo.getText().isEmpty()){
                    datos.setCapitulo("");
                }else{
                    datos.setCapitulo(capitulo.getText());
                }        
                if(certificados_nov_2020.getText().isEmpty()){
                    datos.setCertificados_a_nov_2020("");
                }else{
                    datos.setCertificados_a_nov_2020(certificados_nov_2020.getText());
                }        
                if(text_area_estado_oocc_09_07_2021.getText().isEmpty()){
                    datos.setEstado_oocc_a_09_07_2021("");
                }else{
                    datos.setEstado_oocc_a_09_07_2021(text_area_estado_oocc_09_07_2021.getText());
                }        
                if(text_area_observaciones.getText().isEmpty()){
                    datos.setObservaciones("");
                }else{
                    datos.setObservaciones(text_area_observaciones.getText());
                }        
                if(text_area_observaciones_oya.getText().isEmpty()){
                    datos.setObservaciones_de_oya("");
                }else{
                    datos.setObservaciones_de_oya(text_area_observaciones_oya.getText());
                }
            dato_list.add(datos);

            reportes.Reportes_box r = new reportes.Reportes_box();
            String ruta_logo = "imagenes/logo.png";
            Map parametro = new HashMap();
            parametro.put("logo", ruta_logo);

            JasperPrint jprint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("reportes/final.jasper"), parametro, new JRBeanCollectionDataSource(dato_list));
            JRViewer jrv = new JRViewer(jprint);
            r.contenedor.removeAll();

            r.contenedor.setLayout(new BorderLayout());
            r.contenedor.add(jrv, BorderLayout.CENTER);

            r.contenedor.repaint();
            r.contenedor.revalidate();
            jrv.setVisible(true);
            r.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(pnl_add.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_pdfMouseClicked

        
    private void limpia(){
        esconder();
        // text areas
        descripcion.setText("");
        text_area_fecha_inicio_garantia_aproximada.setText("");
        text_area_estado_oocc_09_07_2021.setText("");
        text_area_fin_garantia_aprox.setText("");
        text_area_otras_fechas.setText("");
        text_area_sol_adquisicion.setText("");
        text_area_observaciones.setText("");
        text_memoria_tecnica_validada.setText("");
        text_area_nuevo_expte_cotec.setText("");
        text_area_ult_dia_prest_ofertas.setText("");
        text_area_informe_tecnico_realizado.setText("");
        text_area_fecha_adjudicacion.setText("");
        text_area_fecha_formalizacion.setText("");
        text_area_observaciones_oya.setText("");
        // combos 
        combo_tipo_contexto.setSelectedIndex(0);
        combo_prioridad.setSelectedIndex(0);
        combo_materia.setSelectedIndex(0);
        combo_promotor.setSelectedIndex(0);
        combo_resp_unidad.setSelectedIndex(0);
        combo_resp_area.setSelectedIndex(0);
        combo_unidad.setSelectedIndex(0);
        combo_area.setSelectedIndex(0);
        combo_estado_expediente.setSelectedIndex(0);
        combo_tipo_espediente.setSelectedIndex(0);
        combo_procedimiento.setSelectedIndex(0);
        combo_empresa_adjudicatoria.setSelectedIndex(0);
        // fechas
        fecha_inicio_garantia_aproximada.setDate(null);
        fecha_fin_garantia_aprox.setDate(null);
        fecha_sol_adquisicion.setDate(null);
        fecha_memoria_tecni_validada.setDate(null);
        fecha_nuevo_expte_cotec.setDate(null);
        fecha_ult_dia_prest_ofertas.setDate(null);
        fecha_informe_tecnico_realizado.setDate(null);
        fecha_fecha_adjudicacion.setDate(null);
        fecha_fecha_formalizacion.setDate(null);
        fecha_otras_fechas.setDate(null);
        fecha_estado_oocc_09_07_2021.setDate(null);
        fecha_observaciones.setDate(null);
        fecha_observaciones_oya.setDate(null);
        // jlabels
        id_goya.setText("");
        no_cxto.setText("");
        unidad_auxiliar.setText("");
        no_expediente.setText("");
        tiempo_ejecucion.setText("");
        importe_adjudicado_sin_iva.setText("");
        presupuesto_base_sin_iva.setText("");
        proyecto.setText("");
        certificados_nov_2020.setText("");
        alarma.setText("");
        anos_prorrogable.setText("");
        responsable_auxiliar.setText("");
        estado_garantia.setText("");
        dl_validado.setText("");
        pasado_mtos_incluida_en.setText("");
        capitulo.setText("");
        importe_expediente.setText("");
        importe_adjudicacion.setText("");
        futuro_lote.setText("");
        mto_garantia.setText("");
    }
    
    private void nada_editable(){
        if(editable==false){
        // text areas
        descripcion.setEditable(false);
        text_area_fecha_inicio_garantia_aproximada.setEditable(false);
        text_area_estado_oocc_09_07_2021.setEditable(false);
        text_area_fin_garantia_aprox.setEditable(false);
        text_area_otras_fechas.setEditable(false);
        text_area_sol_adquisicion.setEditable(false);
        text_area_observaciones.setEditable(false);
        text_memoria_tecnica_validada.setEditable(false);
        text_area_nuevo_expte_cotec.setEditable(false);
        text_area_ult_dia_prest_ofertas.setEditable(false);
        text_area_informe_tecnico_realizado.setEditable(false);
        text_area_fecha_adjudicacion.setEditable(false);
        text_area_fecha_formalizacion.setEditable(false);
        text_area_observaciones_oya.setEditable(false);
        // combos 
        combo_tipo_contexto.setEditable(false);
        combo_prioridad.setEditable(false);
        combo_materia.setEditable(false);
        combo_promotor.setEditable(false);
        combo_resp_unidad.setEditable(false);
        combo_resp_area.setEditable(false);
        combo_unidad.setEditable(false);
        combo_area.setEditable(false);
        combo_estado_expediente.setEditable(false);
        combo_tipo_espediente.setEditable(false);
        combo_procedimiento.setEditable(false);
        combo_empresa_adjudicatoria.setEditable(false);
        // check de combos
        check_tipo_contexto.setVisible(false);
        check_prioridad.setVisible(false);
        check_materia.setVisible(false);
        check_promotor.setVisible(false);
        check_resp_unidad.setVisible(false);
        check_resp_area.setVisible(false);
        check_unidad.setVisible(false);
        check_area.setVisible(false);
        check_estado_expediente.setVisible(false);
        check_tipo_espediente.setVisible(false);
        check_procedimiento.setVisible(false);
        check_empresa_adjudicatoria.setVisible(false);
        // fechas
        fecha_inicio_garantia_aproximada.setVisible(false);
        fecha_fin_garantia_aprox.setVisible(false);
        fecha_sol_adquisicion.setVisible(false);
        fecha_memoria_tecni_validada.setVisible(false);
        fecha_nuevo_expte_cotec.setVisible(false);
        fecha_ult_dia_prest_ofertas.setVisible(false);
        fecha_informe_tecnico_realizado.setVisible(false);
        fecha_fecha_adjudicacion.setVisible(false);
        fecha_fecha_formalizacion.setVisible(false);
        fecha_otras_fechas.setVisible(false);
        fecha_estado_oocc_09_07_2021.setVisible(false);
        fecha_observaciones.setVisible(false);
        fecha_observaciones_oya.setVisible(false);
        // jlabels
        }else{
            btn_pdf.setVisible(false);
        }
    }
    
    private String toma_fecha(JDateChooser fecha, String texto) {      
        String txt_fecha ="";
        if (fecha.getDate() != null) {
             String formato = fecha.getDateFormatString();
            Date date = fecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            txt_fecha=String.valueOf(sdf.format(date));
        }
        if(txt_fecha.isEmpty()){
            txt_fecha=texto;
        }else{
            txt_fecha=txt_fecha+" "+texto;
        }
        return txt_fecha;
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox add_aplicaciones;
    public static javax.swing.JCheckBox add_base;
    public static javax.swing.JCheckBox add_comunicaciones;
    public static javax.swing.JCheckBox add_produccion;
    public static rojeru_san.rsfield.RSTextMaterial alarma;
    public static rojeru_san.rsfield.RSTextMaterial anos_prorrogable;
    private javax.swing.JCheckBox aplicaciones;
    private javax.swing.JCheckBox base;
    public static rojeru_san.RSButtonRiple boton_borrar_todo;
    public static rojeru_san.RSButtonRiple boton_borrar_todo1;
    public static rojeru_san.RSButtonRiple boton_registrar;
    public static rojeru_san.RSButtonRiple boton_registrar1;
    public static javax.swing.JLabel btn_pdf;
    public static rojeru_san.rsfield.RSTextMaterial capitulo;
    public static rojeru_san.rsfield.RSTextMaterial certificados_nov_2020;
    private check_de_android.Switch check_area;
    private check_de_android.Switch check_empresa_adjudicatoria;
    private check_de_android.Switch check_estado_expediente;
    private check_de_android.Switch check_materia;
    private check_de_android.Switch check_prioridad;
    private check_de_android.Switch check_procedimiento;
    private check_de_android.Switch check_promotor;
    private check_de_android.Switch check_resp_area;
    private check_de_android.Switch check_resp_unidad;
    private check_de_android.Switch check_tipo_contexto;
    private check_de_android.Switch check_tipo_espediente;
    private check_de_android.Switch check_unidad;
    public static org.bolivia.combo.SComboBox combo_area;
    public static org.bolivia.combo.SComboBox combo_empresa_adjudicatoria;
    public static org.bolivia.combo.SComboBox combo_estado_expediente;
    public static org.bolivia.combo.SComboBox combo_materia;
    public static org.bolivia.combo.SComboBox combo_prioridad;
    public static org.bolivia.combo.SComboBox combo_procedimiento;
    public static org.bolivia.combo.SComboBox combo_promotor;
    public static org.bolivia.combo.SComboBox combo_resp_area;
    public static org.bolivia.combo.SComboBox combo_resp_unidad;
    public static org.bolivia.combo.SComboBox combo_tipo_contexto;
    public static org.bolivia.combo.SComboBox combo_tipo_espediente;
    public static org.bolivia.combo.SComboBox combo_unidad;
    private javax.swing.JCheckBox comunicaciones;
    public static javax.swing.JTextArea descripcion;
    public static rojeru_san.rsfield.RSTextMaterial dl_validado;
    public static rojeru_san.rsfield.RSTextMaterial estado_garantia;
    public static com.toedter.calendar.JDateChooser fecha_estado_oocc_09_07_2021;
    public static com.toedter.calendar.JDateChooser fecha_fecha_adjudicacion;
    public static com.toedter.calendar.JDateChooser fecha_fecha_formalizacion;
    public static com.toedter.calendar.JDateChooser fecha_fin_garantia_aprox;
    public static com.toedter.calendar.JDateChooser fecha_informe_tecnico_realizado;
    public static com.toedter.calendar.JDateChooser fecha_inicio_garantia_aproximada;
    public static com.toedter.calendar.JDateChooser fecha_memoria_tecni_validada;
    public static com.toedter.calendar.JDateChooser fecha_nuevo_expte_cotec;
    public static com.toedter.calendar.JDateChooser fecha_observaciones;
    public static com.toedter.calendar.JDateChooser fecha_observaciones_oya;
    public static com.toedter.calendar.JDateChooser fecha_otras_fechas;
    public static com.toedter.calendar.JDateChooser fecha_sol_adquisicion;
    public static com.toedter.calendar.JDateChooser fecha_ult_dia_prest_ofertas;
    public static rojeru_san.rsfield.RSTextMaterial futuro_lote;
    public static rojeru_san.rsfield.RSTextMaterial id_goya;
    public static rojeru_san.rsfield.RSTextMaterial importe_adjudicacion;
    public static rojeru_san.rsfield.RSTextMaterial importe_adjudicado_sin_iva;
    public static rojeru_san.rsfield.RSTextMaterial importe_expediente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JLabel lbl_error_alarma;
    public static javax.swing.JLabel lbl_error_anos_prorrogable;
    public static javax.swing.JLabel lbl_error_capitulo;
    public static javax.swing.JLabel lbl_error_certificados_nov_2020;
    public static javax.swing.JLabel lbl_error_combo_area;
    public static javax.swing.JLabel lbl_error_combo_empresa_adjudicatoria;
    public static javax.swing.JLabel lbl_error_combo_estado_expediente;
    public static javax.swing.JLabel lbl_error_combo_materia;
    public static javax.swing.JLabel lbl_error_combo_prioridad;
    public static javax.swing.JLabel lbl_error_combo_procedimiento;
    public static javax.swing.JLabel lbl_error_combo_promotor;
    public static javax.swing.JLabel lbl_error_combo_resp_area;
    public static javax.swing.JLabel lbl_error_combo_resp_unidad;
    public static javax.swing.JLabel lbl_error_combo_tipo_cxto;
    public static javax.swing.JLabel lbl_error_combo_tipo_expediente;
    public static javax.swing.JLabel lbl_error_combo_unidad;
    public static javax.swing.JLabel lbl_error_dl_validado;
    public static javax.swing.JLabel lbl_error_estado_de_garantia;
    private javax.swing.JLabel lbl_error_fecha_estado_oocc_09_07_2021;
    private javax.swing.JLabel lbl_error_fecha_fecha_adjudicacion;
    private javax.swing.JLabel lbl_error_fecha_fecha_formalizacion;
    private javax.swing.JLabel lbl_error_fecha_fin_garantia_aproximada;
    private javax.swing.JLabel lbl_error_fecha_informe_tecnico_realizado;
    private javax.swing.JLabel lbl_error_fecha_inicio_garantia_aproximada;
    private javax.swing.JLabel lbl_error_fecha_memoria_tecnica_validada;
    private javax.swing.JLabel lbl_error_fecha_nuevo_expte_cotec;
    private javax.swing.JLabel lbl_error_fecha_observaciones;
    private javax.swing.JLabel lbl_error_fecha_observaciones_oya;
    private javax.swing.JLabel lbl_error_fecha_otras_fechas;
    private javax.swing.JLabel lbl_error_fecha_sol_adquisicion;
    private javax.swing.JLabel lbl_error_fecha_ultimo_dia_prest_ofert;
    public static javax.swing.JLabel lbl_error_futuro_lote;
    public static javax.swing.JLabel lbl_error_id_goya;
    public static javax.swing.JLabel lbl_error_importe_adjudicacion;
    public static javax.swing.JLabel lbl_error_importe_adjudicacion_sin_iva;
    public static javax.swing.JLabel lbl_error_importe_expediente;
    public static javax.swing.JLabel lbl_error_mto_garantia;
    public static javax.swing.JLabel lbl_error_no_cxto;
    public static javax.swing.JLabel lbl_error_no_expediente;
    public static javax.swing.JLabel lbl_error_pasado_mtos_incluida_en;
    public static javax.swing.JLabel lbl_error_presupuesto_base_sin_iva;
    public static javax.swing.JLabel lbl_error_proyecto;
    public static javax.swing.JLabel lbl_error_responsable_auxiliar;
    public static javax.swing.JLabel lbl_error_tiempo_ejecucion;
    public static javax.swing.JLabel lbl_error_unidad_auxiliar;
    public static rojeru_san.rsfield.RSTextMaterial mto_garantia;
    public static rojeru_san.rsfield.RSTextMaterial no_cxto;
    public static rojeru_san.rsfield.RSTextMaterial no_expediente;
    private javax.swing.JPanel panel_selection;
    private javax.swing.JPanel panel_selection1;
    public static rojeru_san.rsfield.RSTextMaterial pasado_mtos_incluida_en;
    public static rojeru_san.rsfield.RSTextMaterial presupuesto_base_sin_iva;
    private javax.swing.JCheckBox produccion;
    public static rojeru_san.rsfield.RSTextMaterial proyecto;
    public static rojeru_san.rsfield.RSTextMaterial responsable_auxiliar;
    public static javax.swing.JTextArea text_area_estado_oocc_09_07_2021;
    public static javax.swing.JTextArea text_area_fecha_adjudicacion;
    public static javax.swing.JTextArea text_area_fecha_formalizacion;
    public static javax.swing.JTextArea text_area_fecha_inicio_garantia_aproximada;
    public static javax.swing.JTextArea text_area_fin_garantia_aprox;
    public static javax.swing.JTextArea text_area_informe_tecnico_realizado;
    public static javax.swing.JTextArea text_area_nuevo_expte_cotec;
    public static javax.swing.JTextArea text_area_observaciones;
    public static javax.swing.JTextArea text_area_observaciones_oya;
    public static javax.swing.JTextArea text_area_otras_fechas;
    public static javax.swing.JTextArea text_area_sol_adquisicion;
    public static javax.swing.JTextArea text_area_ult_dia_prest_ofertas;
    public static javax.swing.JTextArea text_memoria_tecnica_validada;
    public static rojeru_san.rsfield.RSTextMaterial tiempo_ejecucion;
    public static javax.swing.JLabel titulo_add;
    public static rojeru_san.rsfield.RSTextMaterial unidad_auxiliar;
    // End of variables declaration//GEN-END:variables
}
