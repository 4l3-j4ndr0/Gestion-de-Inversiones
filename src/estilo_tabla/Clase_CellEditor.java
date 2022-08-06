package estilo_tabla;


import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author 4l3
 */
public class Clase_CellEditor extends DefaultCellEditor implements TableCellRenderer{
    private final JComponent component = new JCheckBox();    
    private boolean value = false; // valor de la celda
    
    
    /** Constructor de clase */
    public Clase_CellEditor() {
        super( new JCheckBox() );
    }

    /** retorna valor de celda
     * @return  */
    @Override
    public Object getCellEditorValue() {
        return ((JCheckBox)component).isSelected();  
    }

    /** Segun el valor de la celda selecciona/deseleciona el JCheckBox
     * @param table
     * @param value
     * @param isSelected
     * @param row
     * @param column
     * @return  */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        // tuneado del jchecbox
        ( (JCheckBox) component).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/uncheck_tabla.png"))); // NOI18N
       ( (JCheckBox) component).setIconTextGap(12);
       ( (JCheckBox) component).setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrato/check_tabla.png"))); // NOI18N
        
        //Color de fondo en modo edicion
        ( (JCheckBox) component).setBackground( new Color(69,87,252) );
        // colocar el checbox en el centro de la celda
        ( (JCheckBox) component).setHorizontalAlignment(CENTER);
        //obtiene valor de celda y coloca en el JCheckBox
        boolean b = ((Boolean) value).booleanValue();
        ( (JCheckBox) component).setSelected( b );
        System.out.println("tocado");
        return ( (JCheckBox) component);  
        
    }
    /** cuando termina la manipulacion de la celda
     * @return  */
    @Override
    public  boolean stopCellEditing() {        
        value = ((Boolean)getCellEditorValue()) ;
        System.out.println("final edicion");
        return super.stopCellEditing();
    }

    /** retorna componente
     * @return  */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         if (value == null)
            return null;         
         return ( (JCheckBox) component );
    }
}
