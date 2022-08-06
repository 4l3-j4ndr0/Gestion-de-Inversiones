package estilo_tabla;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import paneles.pnlHome;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 4l3
 */
public class Clase_CellRender extends JCheckBox implements TableCellRenderer {

    public final JComponent component = new JCheckBox();

    /**
     * Constructor de clase
     */
    public Clase_CellRender() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // tuneado del jchecbox
        ((JCheckBox) component).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck_tabla.png"))); // NOI18N
        ((JCheckBox) component).setIconTextGap(12);
        ((JCheckBox) component).setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check_tabla.png"))); // NOI18N
        
        //Color de fondo en modo edicion
        ( (JCheckBox) component).setBackground( new Color(69,87,252) );
        
        if (table.getValueAt(row, 46).equals("gestion_produccion")) {
            component.setBackground(new java.awt.Color(184, 204, 228));
            component.setForeground(Color.black);
            component.setFont(new java.awt.Font("Dialog", 1, 14));
            
        }
        if (table.getValueAt(row, 46).equals("sistema_base")) {
            component.setBackground(new java.awt.Color(242, 220, 219));
            component.setForeground(Color.black);
            component.setFont(new java.awt.Font("Dialog", 1, 14));
        }
        if (table.getValueAt(row, 46).equals("gestion_aplicaciones")) {
            component.setBackground(new java.awt.Color(252, 213, 180));
            component.setForeground(Color.black);
            component.setFont(new java.awt.Font("Dialog", 1, 14));
        }
        if (table.getValueAt(row, 46).equals("sistema_comunicaciones")) {
            component.setBackground(new java.awt.Color(217, 229, 189));
            component.setForeground(Color.black);
            component.setFont(new java.awt.Font("Dialog", 1, 14));
        }
        
        
//        //obtiene valor boolean y coloca valor en el JCheckBox
        boolean b = ((Boolean) value);
        ((JCheckBox) component).setSelected(b);
        if(pnlHome.seleccionar_todos.isSelected()&&pnlHome.todos_marcados()==false){
            pnlHome.seleccionar_todos.setSelected(false);
            pnlHome.seleccionar_todos.setText("MARCAR TODOS");
        }
        // colocar el checkbox en el centro de la celda
        ((JCheckBox) component).setHorizontalAlignment(CENTER);
        return ((JCheckBox) component);
    }
}
