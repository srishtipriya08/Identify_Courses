package Utilities;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.Date;
import java.util.List;
public class ExcelUtility {	
	public static String path;
	public static FileOutputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet s;


public static void excelInit1() throws FileNotFoundException
{
	ExcelUtility.path = System.getProperty("user.dir")+"\\TestData\\Coursera.xlsx";
 
	ExcelUtility.file = new FileOutputStream(path);
 
	ExcelUtility.wb = new XSSFWorkbook();
	ExcelUtility.s = ExcelUtility.wb.createSheet("Learning Language");
 
}

public static String LearningData(List<String> count1, List<String> level1) throws FileNotFoundException {
			
	ExcelUtility.excelInit1();
	try {
					XSSFRow row1 = ExcelUtility.s.createRow(0);
 
					row1.createCell(0).setCellValue("All language name and its count");
					for(int r=2;r<count1.size()+2;r++) {
 
						XSSFRow row = ExcelUtility.s.createRow(r);
 
						row.createCell(0).setCellValue(count1.get(r-2));
 
					}
					
					XSSFRow row2 = ExcelUtility.s.createRow(28);
					 
					row2.createCell(0).setCellValue("Different level count");
					
					for(int r=30;r<34;r++) {
						 
						XSSFRow row = ExcelUtility.s.createRow(r);
 
						row.createCell(0).setCellValue(level1.get(r-30));
 
					}
					}
					catch(Exception e) {}
					return "Data Saved";

				}

public static void closeExcel() throws IOException
{
 
	ExcelUtility.wb.write(file);
 
	ExcelUtility.wb.close();
 
	ExcelUtility.file.close();
}
 
}