package excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static jxl.biff.BaseCellFeatures.logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import paneles.pnlHome;

/**
 * Data provider for excel
 *
 * @author 4l3
 */

public class ExcelGenerator {
    public static ArrayList<String> id_produccion = new ArrayList<String>();
    public static ArrayList<String> id_base = new ArrayList<String>();
    public static ArrayList<String> id_aplicaciones = new ArrayList<String>();
    public static ArrayList<String> id_comunicaciones = new ArrayList<String>();
	
	// Excel work book
	private HSSFWorkbook workbook;
	
	// Fonts
	private HSSFFont headerFont;
	private HSSFFont contentFont;
	
	// Styles
	private HSSFCellStyle headerStyle;
	private HSSFCellStyle produccion;
	private HSSFCellStyle base;
        private HSSFCellStyle aplicaciones;
	private HSSFCellStyle comunicaciones;
	
	// Integer to store the index of the next row
	private int rowIndex;
	

	/**
	 * Make a new excel workbook with sheet that contains a stylized table
	 * 
	 * @return
     * @throws java.io.IOException
	 */
	public HSSFWorkbook generateExcel() throws IOException {
		
		// Initialize rowIndex
		rowIndex = 0;
		
		// New Workbook
		workbook = new HSSFWorkbook();
		
		// Generate fonts
		headerFont  = createFont(HSSFColor.WHITE.index, (short)14, true);
		contentFont = createFont(HSSFColor.BLACK.index, (short)10, true);
		
		// Generate styles
		headerStyle  = createStyle(headerFont,  HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLUE.index, true, HSSFColor.WHITE.index);
                
               HSSFWorkbook hwb = new HSSFWorkbook();
               HSSFPalette palette = hwb.getCustomPalette();
               // devuelvo el color que deseo luego de editar el color en las oltimas posiciones de la tabla pq la primera la tomo para el color de las letras (negro)
               HSSFColor color_produccion = setColor(workbook,(byte) 184, (byte)204,(byte) 228,(byte)40);
               HSSFColor color_base = setColor(workbook,(byte) 242, (byte)220,(byte) 219,(byte)39);
               HSSFColor color_aplicaciones = setColor(workbook,(byte) 252, (byte)213,(byte) 180,(byte)38);
               HSSFColor color_comunicaciones = setColor(workbook,(byte) 217, (byte)229,(byte) 189,(byte)37);
               // get the palette index of that color 
               short palIndex_aplicaciones = color_aplicaciones.getIndex();
               short palIndex_base = color_base.getIndex();
               short palIndex_produccion = color_produccion.getIndex();
               short palIndex_comunicaciones = color_comunicaciones.getIndex();
                
		produccion  = createStyle(contentFont, HSSFCellStyle.ALIGN_CENTER,  palIndex_produccion, true, HSSFColor.GREY_80_PERCENT.index);
                base  = createStyle(contentFont, HSSFCellStyle.ALIGN_CENTER,   palIndex_base, true, HSSFColor.GREY_80_PERCENT.index);
                aplicaciones  = createStyle(contentFont, HSSFCellStyle.ALIGN_CENTER,   palIndex_aplicaciones, true, HSSFColor.GREY_80_PERCENT.index);
                comunicaciones  = createStyle(contentFont, HSSFCellStyle.ALIGN_CENTER,   palIndex_comunicaciones, true, HSSFColor.GREY_80_PERCENT.index);
		
		// New sheet
		HSSFSheet sheet = workbook.createSheet("INVERSIONES");
		
		// Table header
		HSSFRow      headerRow    = sheet.createRow( rowIndex++ );
		List<String> headerValues = FakeDataProvider.getTableHeaders();
		
		HSSFCell headerCell = null;
		for (int i = 0; i < headerValues.size(); i++) {
			headerCell = headerRow.createCell(i);
			headerCell.setCellStyle(headerStyle);
			headerCell.setCellValue( headerValues.get(i) );
		}
		
		
		// Table content
		HSSFRow  contentRow  = null;
		HSSFCell contentCell = null;
		// Obtain table content values
                List<List<String>> contentRowValues = new ArrayList<>();
                contentRowValues.clear();
                FakeDataProvider.tableContent.clear();
                   if(contador_checbox("gestion_produccion")>0){
                       for(int p=0;p<id_produccion.size();p++){
                       contentRowValues = FakeDataProvider.getTableContent(id_produccion.get(p),"gestion_produccion");
                   }
                   }
                   
                   if(contador_checbox("sistema_base")>0){
                       for(int b=0;b<id_base.size();b++){
                       contentRowValues = FakeDataProvider.getTableContent(id_base.get(b),"sistema_base");
                   }
                   }
                   if(contador_checbox("gestion_aplicaciones")>0){
                       for(int a=0;a<id_aplicaciones.size();a++){
                       contentRowValues = FakeDataProvider.getTableContent(id_aplicaciones.get(a),"gestion_aplicaciones");
                   }
                   }
                   if(contador_checbox("sistema_comunicaciones")>0){
                       for(int c=0;c<id_comunicaciones.size();c++){
                       contentRowValues = FakeDataProvider.getTableContent(id_comunicaciones.get(c),"sistema_comunicaciones");
                   }
                   }
                
		for (List<String> rowValues : contentRowValues) {
			
			// At each row creation, rowIndex must grow one unit
                        
                        
			contentRow = sheet.createRow( rowIndex++ );
                        
			for (int i = 0; i < rowValues.size(); i++) {
				contentCell = contentRow.createCell(i);
				contentCell.setCellValue( rowValues.get(i) );
				                        
//				 el estilo (color) de la celda del excel depende de a que tabla de la bd pertenezca la celda del jtable
                                    
                                           
                       for(int p=0;p<id_produccion.size();p++){
                       if(rowValues.get(0).equals(id_produccion.get(p))){
                           contentCell.setCellStyle( produccion);
                       }
                   }
                       for(int b=0;b<id_base.size();b++){
                       if(rowValues.get(0).equals(id_base.get(b))){
                           contentCell.setCellStyle( base);
                       }
                   }
                       
                       for(int a=0;a<id_aplicaciones.size();a++){
                      if(rowValues.get(0).equals(id_aplicaciones.get(a))){
                           contentCell.setCellStyle(aplicaciones );
                       }
                   }
                   
                   
                       for(int c=0;c<id_comunicaciones.size();c++){
                       if(rowValues.get(0).equals(id_comunicaciones.get(c))){
                           contentCell.setCellStyle( comunicaciones);
                       }
                   }
                   
//                                        if(pnlHome.tabla_general.getValueAt(rowIndex-2, 10).toString().equals("gestion_produccion")&& pnlHome.tabla_general.getValueAt(rowIndex-2, 11).equals("true")){
//                                            System.out.println("actual "+pnlHome.tabla_general.getValueAt(rowIndex-2, 11).toString());
//                                        contentCell.setCellStyle( produccion);
//                                    }
//                                    if(pnlHome.tabla_general.getValueAt(rowIndex-2, 10).toString().equals("sistema_base")&& pnlHome.tabla_general.getValueAt(rowIndex-2, 11).equals("true")){
//                                        System.out.println("actual dos "+pnlHome.tabla_general.getValueAt(rowIndex-2, 11).toString());
//                                        contentCell.setCellStyle( base);
//                                    }
//                                    if(pnlHome.tabla_general.getValueAt(rowIndex-2, 10).toString().equals("gestion_aplicaciones")){
//                                        contentCell.setCellStyle(aplicaciones );
//                                    }
//                                    if(pnlHome.tabla_general.getValueAt(rowIndex-2, 10).toString().equals("sistema_comunicaciones")){
//                                        contentCell.setCellStyle( comunicaciones);
//                                    }
			}
		}
		
		
		// Autosize columns
		for (int i = 0; i < headerValues.size(); sheet.autoSizeColumn(i++));
		
		return workbook;
	}
	
	
	/**
	 * Create a new font on base workbook
	 * 
	 * @param fontColor       Font color (see {@link HSSFColor})
	 * @param fontHeight      Font height in points
	 * @param fontBold        Font is boldweight (<code>true</code>) or not (<code>false</code>)
	 * 
	 * @return New cell style
	 */
        
        private int contador_checbox(String tabla){
        int cont=0;
        for(int k=0;k<pnlHome.tabla_general.getRowCount();k++){
                if((pnlHome.tabla_general.getValueAt(k, 47).toString().equals("true"))&&(pnlHome.tabla_general.getValueAt(k, 46).toString().equals(tabla))){
                        cont++;
                    }
            }
        return cont;
    }
        
	private HSSFFont createFont(short fontColor, short fontHeight, boolean fontBold) {
		
		HSSFFont font = workbook.createFont();
		font.setBold(fontBold);
		font.setColor(fontColor);
		font.setFontName("Arial");
		font.setFontHeightInPoints(fontHeight);
		
		return font;
	}
	// la paleta tiene posiciones limitadas, desde 0x8-0x40, por eso sobreescribo con el color que deseo poner en una posicion especifica y devuelvo ese color
     public HSSFColor setColor(HSSFWorkbook workbook, byte r, byte g, byte b, byte pos_en_paleta_de_colores) {
        HSSFPalette palette = workbook.getCustomPalette();
        HSSFColor hssfColor = null;
        try {
            hssfColor = palette.findColor(r, g, b);
            if (hssfColor == null) {
                palette.setColorAtIndex(pos_en_paleta_de_colores, r, g, b);
                hssfColor = palette.getColor(pos_en_paleta_de_colores);
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return hssfColor;
    }
     
	
	/**
	 * Create a style on base workbook
	 * 
	 * @param font            Font used by the style
	 * @param cellAlign       Cell alignment for contained text (see {@link HSSFCellStyle})
	 * @param cellColor       Cell background color (see {@link HSSFColor})
	 * @param cellBorder      Cell has border (<code>true</code>) or not (<code>false</code>)
	 * @param cellBorderColor Cell border color (see {@link HSSFColor})
	 * 
	 * @return New cell style
	 */
	private HSSFCellStyle createStyle(HSSFFont font, short cellAlign, short cellColor, boolean cellBorder, short cellBorderColor) {

		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setAlignment(cellAlign);
		style.setFillForegroundColor(cellColor);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		if (cellBorder) {
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			
			style.setTopBorderColor(cellBorderColor);
			style.setLeftBorderColor(cellBorderColor);
			style.setRightBorderColor(cellBorderColor);
			style.setBottomBorderColor(cellBorderColor);
		}
		
		return style;
	}
}
