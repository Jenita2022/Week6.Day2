package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String[][] readData(String sheetName) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/CommonWB.xlsx");
		XSSFSheet ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		short cellCount = ws.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
			for (int j=0;j<cellCount;j++) {
				String CellValue = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(CellValue);
				data[i-1][j]=CellValue;
			}
		wb.close();
		return data;	
		
	}
}
