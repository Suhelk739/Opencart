package utilities;



import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

public class Data {
	
	@DataProvider(name="LoginData")
	
	public  String [][] getData() throws IOException {
		
		//get the path of the excel file
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility utils=new ExcelUtility(path);
		//to get the number of rows 
		int rows=utils.getRowCount("Sheet1");
		int colm=utils.getCellCount("Sheet1", 1);
		
		//after getting number of rows and columns create the 2 dimentional array\
		
		String data[][]=new String[rows][colm];
		
		// get the all data in to 2 dimentional array
		for(int r=1;r<=rows;r++) {
			for(int c=0;c<colm;c++) {

				data[r-1][c]=utils.getCellData("Sheet1", r, c);
				
				}

		}
		return data;
		
	}
}
