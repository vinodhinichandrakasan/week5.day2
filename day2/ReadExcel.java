package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel{

	
		public static String[][] readData(String fileName) throws IOException {
			// Step1: Setup the path for the workbook
			XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
			// Step2: Get into the respective sheet
			XSSFSheet ws = wb.getSheet("Sheet1");

			int rowCount = ws.getLastRowNum();
			System.out.println(rowCount);
//			int physicalNumberOfRows = ws.getPhysicalNumberOfRows(); // (including header)
//			System.out.println(physicalNumberOfRows);
			// To get no. of cells
			int cellCount = ws.getRow(0).getLastCellNum();
			
			String[][] data = new String[rowCount][cellCount];
			for(int i=1; i<=rowCount; i++) {
				for (int j = 0; j < cellCount; j++) {
					data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
					System.out.println(data);
				}
			}
			wb.close();
			

			
			return data;
		}

	}


