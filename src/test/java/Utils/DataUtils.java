package Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataUtils {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
	    String path = ".\\src\\test\\resources\\datafiles\\loginData.xlsx";
	    XLUtility xlutil = new XLUtility(path);
	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = xlutil.getCellCount("Sheet1", 1);
	    String[][] loginData = new String[totalrows][totalcols];

	    for(int i = 1; i <= totalrows; ++i) {
	        for(int j = 0; j < totalcols; ++j) {
	            loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	        }
	    }

	    return loginData;
	}
}
