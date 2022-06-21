package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_New {

	public static String[][] readData(String fileName) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowCount = ws.getLastRowNum();
		System.out.println("RowCount: " +rowCount);
		short colCount = ws.getRow(0).getLastCellNum();
		System.out.println("ColumnCount: " +colCount);

		String[][] data = new String[rowCount][colCount];
		for (int i=1;i<=rowCount;i++) {
			for (int j=0;j<colCount;j++) {
				data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();	
				System.out.println(data);
			}
		}
		wb.close();//workbook should be closed before returning data to the method.
		return data;

	}

}
