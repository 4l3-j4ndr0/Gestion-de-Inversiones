/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estilo_tabla;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author 4l3
 */

    public class EstiloTablaRenderer extends DefaultTableCellRenderer {

    public Component componenete;
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;  //
}

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.       
        this.setHorizontalAlignment(0);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        if (value instanceof JCheckBox) {
            JCheckBox chk = (JCheckBox) value;
            return chk;
        }
        
        if(table.getValueAt(row,46).equals("gestion_produccion")){
           componenete.setBackground(new java.awt.Color(184,204,228));
//           ( (JCheckBox) componenete).setBackground( new Color(184,204,228) );
           componenete.setForeground(Color.black);
           componenete.setFont(new java.awt.Font("Dialog", 1, 14));
           
        } 
        if(table.getValueAt(row,46).equals("sistema_base")){
           componenete.setBackground(new java.awt.Color(242,220,219));
//           ((JCheckBox) componenete).setBackground( new Color(242,220,219) );
           componenete.setForeground(Color.black);
           componenete.setFont(new java.awt.Font("Dialog", 1, 14));
           
        } 
        if(table.getValueAt(row,46).equals("gestion_aplicaciones")){
           componenete.setBackground(new java.awt.Color(252,213,180));
//           ( (JCheckBox) componenete).setBackground( new Color(252,213,180) );
           componenete.setForeground(Color.black);
           componenete.setFont(new java.awt.Font("Dialog", 1, 14));
        } 
        if(table.getValueAt(row,46).equals("sistema_comunicaciones")){
           componenete.setBackground(new java.awt.Color(217,229,189));
//           ( (JCheckBox) componenete).setBackground( new Color(217,229,189) );
           componenete.setForeground(Color.black);
           componenete.setFont(new java.awt.Font("Dialog", 1, 14));
        } 
        if (table.getValueAt(row, 48)!=null && table.getValueAt(row, 48).equals("pendiente")) {
                 componenete.setBackground(new java.awt.Color(250, 151, 128));
            }
        
        
        
//        isCellEditable(row, column);
//        return componenete;


        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
    }
    

}

