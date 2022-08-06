package excel;

import static excel.FakeDataProvider.tableContent;
import interaccion_BD.conexion;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data provider for excel
 *
 * @author 4l3
 */
public final class FakeDataProvider {

   
    static Statement s;
    static ResultSet rs;
    static PreparedStatement ps;

    /**
     * Return the columns name for the table
     */
    public static List<String> getTableHeaders() {
        List<String> tableHeader = new ArrayList<String>();
        //TITULOS DE LAS COLUMNAS
        tableHeader.add("ID-GOYA");
        tableHeader.add("No CXTO");
        tableHeader.add("No DE EXPEDIENTE");
        tableHeader.add("DESCRIPCION");
        tableHeader.add("TIPO DE CXTO");
        tableHeader.add("PRIORIDAD");
        tableHeader.add("TIPO SERVICIO O INVERSION");
        tableHeader.add("PROMOTOR");
        tableHeader.add("AREA");
        tableHeader.add("UNIDAD");
        tableHeader.add("RESP AREA");
        tableHeader.add("RESP UNIDAD");
        tableHeader.add("UNIDAD AUXILIAR");
        tableHeader.add("RESPONSABLE AUXILIAR");
        tableHeader.add("PRESUPUESTO BASE SIN IVA");
        tableHeader.add("IMPORTE ADJUDICADO SIN IVA");
        tableHeader.add("ESTADO EXPEDIENTE");
        tableHeader.add("MTO GARANTIA");
        tableHeader.add("TIEMPO EJECUCION");
        tableHeader.add("INICIO GARANTIA APROX");
        tableHeader.add("FIN GARANTIA APROX");
        tableHeader.add("AÑOS PRORROGABLE");
        tableHeader.add("ALARMA");
        tableHeader.add("FUTURO LOTE");
        tableHeader.add("PROYECTO");
        tableHeader.add("ESTADO DE GARANTIA");
        tableHeader.add("PSADO A MTOS INCLUIDA EN");
        tableHeader.add("SOL ADQUISICION");
        tableHeader.add("MEMORIA TECNICA VALIDADA");
        tableHeader.add("DL VALIDADO");
        tableHeader.add("NUEVO EXPTE COTEC DE");
        tableHeader.add("TIPO EXPEDIENTE");
        tableHeader.add("PROCEDIMIENTO");
        tableHeader.add("IMPORTE EXPEDIENTE");
        tableHeader.add("ULT DIA PREST OFERTAS");
        tableHeader.add("INFORME TECNICO REALIZADO");
        tableHeader.add("FECHA ADJUDICACION");
        tableHeader.add("EMPRESA ADJUDICATORIA");
        tableHeader.add("IMPORTE DE ADJUDICACION");
        tableHeader.add("FECHA FORNALIZACION");
        tableHeader.add("OTRAS FECHAS");
        tableHeader.add("CAPITULO");
        tableHeader.add("CERTIFICADOS A NOV 2020");
        tableHeader.add("ESTADO OOCC A 09/07/2021");
        tableHeader.add("OBSERVACIONES");
        tableHeader.add("OBSERVACIONES DE OYA");

        return tableHeader;
    }

    /**
     * Return values for the table
     *
     * @param numberOfRows Number of rows we want to receive
     *
     * @return Values
     */
    
    public static List<List<String>> tableContent = new ArrayList<>();
    public static List<List<String>> getTableContent(String id, String tabla) throws IOException {
        try {
            String SQL = "SELECT * FROM "+tabla+" where id_goya='"+id+"'";
            conexion obconeccion=new conexion();
            //Para ejecutar la consulta
            s = obconeccion.getCn().createStatement();
            //Ejecutamos la consulta y los datos lo almacenamos en un ResultSet
            rs = s.executeQuery(SQL);
            
            int i = 0;
            List<String> row = null;
            while (rs.next()) {
                tableContent.add(row = new ArrayList<>());

                row.add(rs.getString("ID_GOYA"));
                row.add(rs.getString("NO_CXTO"));
                row.add(rs.getString("NO_DE_EXPEDIENTE"));
                row.add(rs.getString("DESCRIPCION"));
                row.add(rs.getString("TIPO_DE_CXTO"));
                row.add(rs.getString("PRIORIDAD"));
                row.add(rs.getString("TIPO_SERVICIO_O_INVERSION"));
                row.add(rs.getString("PROMOTOR"));
                row.add(rs.getString("AREA"));
                row.add(rs.getString("UNIDAD"));
                row.add(rs.getString("RESP_AREA"));
                row.add(rs.getString("RESP_UNIDAD"));
                row.add(rs.getString("UNIDAD_AUXILIAR"));
                row.add(rs.getString("RESPONSABLE_AUXILIAR"));
                row.add(rs.getString("PRESUPUESTO_BASE_SIN_IVA"));
                row.add(rs.getString("IMPORTE_ADJUDICADO_SIN_IVA"));
                row.add(rs.getString("ESTADO_EXPEDIENTE"));
                row.add(rs.getString("MTO_GARANTIA"));
                row.add(rs.getString("TIEMPO_EJECUCION"));
                row.add(rs.getString("INICIO_GARANTIA_APROX"));
                row.add(rs.getString("FIN_GARANTIA_APROX"));
                row.add(rs.getString("ANOS_PRORROGABLE"));
                row.add(rs.getString("ALARMA"));
                row.add(rs.getString("FUTURO_LOTE"));
                row.add(rs.getString("PROYECTO"));
                row.add(rs.getString("ESTADO_DE_GARANTIA"));
                row.add(rs.getString("PSADO_A_MTOS_INCLUIDA_EN"));
                row.add(rs.getString("SOL_ADQUISICION"));
                row.add(rs.getString("MEMORIA_TECNICA_VALIDADA"));
                row.add(rs.getString("DL_VALIDADO"));
                row.add(rs.getString("NUEVO_EXPTE_COTEC_DE"));
                row.add(rs.getString("TIPO_EXPEDIENTE"));
                row.add(rs.getString("PROCEDIMIENTO"));
                row.add(rs.getString("IMPORTE_EXPEDIENTE"));
                row.add(rs.getString("ULT_DIA_PREST_OFERTAS"));
                row.add(rs.getString("INFORME_TECNICO_REALIZADO"));
                row.add(rs.getString("FECHA_ADJUDICACION"));
                row.add(rs.getString("EMPRESA_ADJUDICATORIA"));
                row.add(rs.getString("IMPORTE_DE_ADJUDICACION"));
                row.add(rs.getString("FECHA_FORNALIZACION"));
                row.add(rs.getString("OTRAS_FECHAS"));
                row.add(rs.getString("CAPITULO"));
                row.add(rs.getString("CERTIFICADOS_A_NOV_2020"));
                row.add(rs.getString("ESTADO_OOCC_A_09_07_2021"));
                row.add(rs.getString("OBSERVACIONES"));
                row.add(rs.getString("OBSERVACIONES_DE_OYA"));

                i++;
            }
            return tableContent;
        } catch (SQLException ex) {
            Logger.getLogger(FakeDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
//    public static List<List<String>> getTableContent(int numberOfRows) {
//        try {
//            if (numberOfRows <= 0) {
//                throw new IllegalArgumentException("The number of rows must be a positive integer");
//            }
//
//            List<List<String>> tableContent = new ArrayList<List<String>>();
//            
//            List<String> row = null;
//            
//                for (int i = 0; i < pnlHome.tabla_general.getRowCount(); i++) {
//                tableContent.add(row = new ArrayList<String>());
//                for (int j = 0; j < pnlHome.tabla_general.getColumnCount() - 2; j++) {
//                        if (pnlHome.tabla_general.getValueAt(i, 11).toString().equals("true")) {
//                        if (pnlHome.tabla_general.getValueAt(i, j) == null) {
//                            row.add("");
//                        } else {
//                            row.add(pnlHome.tabla_general.getValueAt(i, j).toString());
//                        }
//                    }
//                }
//            }
//            
//            
//            return tableContent;
//        } catch (Exception ex) {
//            Logger.getLogger(FakeDataProvider.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
//    }

}
