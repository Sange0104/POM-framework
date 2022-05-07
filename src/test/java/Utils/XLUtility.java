package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	 public FileInputStream fi;
	    public FileOutputStream fo;
	    public XSSFWorkbook workbook;
	    public XSSFSheet sheet;
	    public XSSFRow row;
	    public XSSFCell cell;
	    public CellStyle style;
	    String path;

	    XLUtility(String path) {
	        this.path = path;
	    }

	    public int getRowCount(String sheetName) throws IOException {
	        this.fi = new FileInputStream(this.path);
	        this.workbook = new XSSFWorkbook(this.fi);
	        this.sheet = this.workbook.getSheet(sheetName);
	        int rowcount = this.sheet.getLastRowNum();
	        this.workbook.close();
	        this.fi.close();
	        return rowcount;
	    }

	    public int getCellCount(String sheetName, int rownum) throws IOException {
	        this.fi = new FileInputStream(this.path);
	        this.workbook = new XSSFWorkbook(this.fi);
	        this.sheet = this.workbook.getSheet(sheetName);
	        this.row = this.sheet.getRow(rownum);
	        int cellcount = this.row.getLastCellNum();
	        this.workbook.close();
	        this.fi.close();
	        return cellcount;
	    }

	    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
	        this.fi = new FileInputStream(this.path);
	        this.workbook = new XSSFWorkbook(this.fi);
	        this.sheet = this.workbook.getSheet(sheetName);
	        this.row = this.sheet.getRow(rownum);
	        this.cell = this.row.getCell(colnum);
	        DataFormatter formatter = new DataFormatter();

	        String data;
	        try {
	            data = formatter.formatCellValue(this.cell);
	        } catch (Exception var7) {
	            data = "";
	        }

	        this.workbook.close();
	        this.fi.close();
	        return data;
	    }

}
