package Controller;

import java.awt.Desktop;
import java.sql.Connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import necesario.RSFileChooser;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class Documentos {

    private static String ruta;

    public static void subirDocumento() {
        RSFileChooser fileChooser = new necesario.RSFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xls", "xlsx");
        fileChooser.setFileFilter(filter);
        int eleccion = fileChooser.showOpenDialog(null);
        if (eleccion == RSFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ruta = file.getAbsolutePath();
        }
    }

    public static void leerDocumento() throws IOException {

        try {
            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (int a = 0; a <= numFilas; a++) {

                Row row = sheet.getRow(a);
                int numCols = row.getLastCellNum();

                for (int b = 0; b < numCols; b++) {

                    Cell cell = row.getCell(b);
                    if (cell == null) {
                        System.out.print("\t");
                        continue;
                    }

                    switch (cell.getCellType()) {

                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;

                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(dateFormat.format(cell.getDateCellValue()) + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;

                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                            break;

                        case BLANK:
                            System.out.print("\t");
                            break;

                        default:
                            break;
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void importar() throws IOException, SQLException {

        Conexion conexion = new Conexion();
        PreparedStatement statement;

        try {
            Connection cx = conexion.Conectar();
            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (int a = 1; a <= numFilas; a++) {

                Row row = sheet.getRow(a);

                statement = cx.prepareStatement("INSERT INTO Estudiantes (matricula, nombre, apellido, fecha_nacimiento, id_curso, id_usu) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, row.getCell(0).getStringCellValue());
                statement.setString(2, row.getCell(1).getStringCellValue());
                statement.setString(3, row.getCell(2).getStringCellValue());

                if (DateUtil.isCellDateFormatted(row.getCell(3))) {
                    String fechaNacimiento = dateFormat.format(row.getCell(3).getDateCellValue());
                    statement.setString(4, fechaNacimiento);
                } else {
                    statement.setString(4, null);
                }

                statement.setInt(5, (int) row.getCell(4).getNumericCellValue());
                statement.setInt(6, (int) row.getCell(5).getNumericCellValue());
                statement.execute();
            }
            cx.close();
            
            JOptionPane.showMessageDialog(null, "Archivo importado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void importar(String tabla) throws IOException, SQLException {

        Conexion conexion = new Conexion();
        PreparedStatement statement;

        try {
            Connection cx = conexion.Conectar();
            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (int a = 1; a <= numFilas; a++) {

                Row row = sheet.getRow(a);

                statement = cx.prepareStatement("INSERT INTO Profesores (matricula, nombre, apellido, cedula, fecha_nacimiento, id_usu) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, row.getCell(0).getStringCellValue());
                statement.setString(2, row.getCell(1).getStringCellValue());
                statement.setString(3, row.getCell(2).getStringCellValue());
                statement.setString(4, row.getCell(3).getStringCellValue());
                if (DateUtil.isCellDateFormatted(row.getCell(4))) {
                    String fechaNacimiento = dateFormat.format(row.getCell(4).getDateCellValue());
                    statement.setString(5, fechaNacimiento);
                } else {
                    statement.setString(5, null);
                }
                statement.setInt(6, (int) row.getCell(5).getNumericCellValue());
                statement.execute();
            }
            cx.close();
            
            JOptionPane.showMessageDialog(null, "Archivo importado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportarDocumento(String tabla) throws IOException, SQLException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(tabla);

        try {

            String[] titulos = new String[]{"Matricula", "Nombre", "Apellido", "Cedula", "Fecha de nacimiento", "Id de usuario"};

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);

            Font font = workbook.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaTitulos = sheet.createRow(0);

            for (int i = 0; i < titulos.length; i++) {

                Cell celdaTitulo = filaTitulos.createCell(i);
                celdaTitulo.setCellStyle(headerStyle);
                celdaTitulo.setCellValue(titulos[i]);
                
            }

            Conexion conexion = new Conexion();
            PreparedStatement statement;
            ResultSet rs;
            Connection cx = conexion.Conectar();
            
            CellStyle celdaStyle = workbook.createCellStyle();
            celdaStyle.setBorderBottom(BorderStyle.THIN);
            celdaStyle.setBorderLeft(BorderStyle.THIN);
            celdaStyle.setBorderRight(BorderStyle.THIN);

            int psInicial = 1; 

            statement = cx.prepareStatement("SELECT matricula, nombre, apellido, cedula, fecha_nacimiento, id_usu FROM " + tabla);

            rs = statement.executeQuery();
            
            int numCol = rs.getMetaData().getColumnCount();
            
            while(rs.next()){
                
                Row filaDatos = sheet.createRow(psInicial);
                
                for(int a = 0 ; a < numCol ; a ++){
                    
                    Cell celdaDatos = filaDatos.createCell(a);
                    celdaDatos.setCellStyle(celdaStyle);
                    
                    if(a == 5){
                        celdaDatos.setCellValue(rs.getInt(a+1));
                    }
                    else{
                        celdaDatos.setCellValue(rs.getString(a+1));
                    }
                    sheet.autoSizeColumn(a);
                }
                psInicial++; 
            }
            
            RSFileChooser fileChooser = new RSFileChooser();
            fileChooser.setFileSelectionMode(RSFileChooser.DIRECTORIES_ONLY);
            
            int userSelection = fileChooser.showOpenDialog(null);
            
            if (userSelection == RSFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = fileChooser.getSelectedFile();
            String rutaDeDescarga = carpetaSeleccionada.getAbsolutePath() + "/" + tabla +".xlsx";
            
            FileOutputStream fileout = new FileOutputStream(rutaDeDescarga);
            workbook.write(fileout);
            fileout.close();
            
            File archivo = new File(rutaDeDescarga);
            Desktop.getDesktop().open(archivo);
            }
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void exportarDocumento() throws IOException, SQLException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Estudiantes");

        try {

            String[] titulos = new String[]{"Matricula", "Nombre", "Apellido", "Fecha de nacimiento", "Id del Curso", "Id de usuario"};

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);

            Font font = workbook.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaTitulos = sheet.createRow(0);

            for (int i = 0; i < titulos.length; i++) {

                Cell celdaTitulo = filaTitulos.createCell(i);
                celdaTitulo.setCellStyle(headerStyle);
                celdaTitulo.setCellValue(titulos[i]);
                
            }

            Conexion conexion = new Conexion();
            PreparedStatement statement;
            ResultSet rs;
            Connection cx = conexion.Conectar();
            
            CellStyle celdaStyle = workbook.createCellStyle();
            celdaStyle.setBorderBottom(BorderStyle.THIN);
            celdaStyle.setBorderLeft(BorderStyle.THIN);
            celdaStyle.setBorderRight(BorderStyle.THIN);

            int psInicial = 1; 

            statement = cx.prepareStatement("SELECT matricula, nombre, apellido, fecha_nacimiento, id_curso, id_usu FROM Estudiantes");

            rs = statement.executeQuery();
            
            int numCol = rs.getMetaData().getColumnCount();
            
            while(rs.next()){
                
                Row filaDatos = sheet.createRow(psInicial);
                
                for(int a = 0 ; a < numCol ; a ++){
                    
                    Cell celdaDatos = filaDatos.createCell(a);
                    celdaDatos.setCellStyle(celdaStyle);
                    
                    if(a == 5 || a == 4){
                        celdaDatos.setCellValue(rs.getInt(a+1));
                    }
                    else{
                        celdaDatos.setCellValue(rs.getString(a+1));
                    }
                    sheet.autoSizeColumn(a);
                }
                psInicial++; 
            }
            
            RSFileChooser fileChooser = new RSFileChooser();
            fileChooser.setFileSelectionMode(RSFileChooser.DIRECTORIES_ONLY);
            
            int userSelection = fileChooser.showOpenDialog(null);
            
            if (userSelection == RSFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = fileChooser.getSelectedFile();
            String rutaDeDescarga = carpetaSeleccionada.getAbsolutePath() + "/Estudiantes.xlsx";
            
            FileOutputStream fileout = new FileOutputStream(rutaDeDescarga);
            workbook.write(fileout);
            fileout.close();
            
            File archivo = new File(rutaDeDescarga);
            Desktop.getDesktop().open(archivo);
            }
           
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
