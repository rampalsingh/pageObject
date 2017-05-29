package qa.pageObject.Base.Util;
import org.testng.annotations.Test;

import qa.pageObject.Base.Util.Xls_Reader;

public class roughMine {

	
	@Test
	public void readData(){
		String testCaseName = "ChangePasswordTest";
		String sheetName = "TestData";
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\data\\Data.xlsx");

		//testcase start Row nos
		
		int StartRow = 1;
		while(!xls.getCellData(sheetName, 0, StartRow).equals(testCaseName)){
			StartRow++;
		}
		System.out.println("Test start row number : "+StartRow);
		
		int ColNameStartNumber = StartRow+1;
		int DataStartNumber = StartRow+2;
		
		
		//Total Number of rows
		int row=1;
		while(!xls.getCellData(sheetName, 0, row).equals("")){
			row++;
		}
		System.out.println("Test Rows : "+row);
		
		//Total Number of Columns
		int col=1;
		while(!xls.getCellData(sheetName, col, ColNameStartNumber).equals("")){
			col++;
		}
		System.out.println("Test Col : "+col);
	}
	
	
}
