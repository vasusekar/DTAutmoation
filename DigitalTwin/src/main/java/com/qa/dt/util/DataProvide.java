package com.qa.dt.util;

import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.DataProvider;

import com.qa.dt.base.BaseClass;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class DataProvide extends  BaseClass {
	
	 String [][]data = null;
		
		@DataProvider(name="loginTest")
		public String[][] loginDataProvider() throws BiffException, IOException {
			data=LogiData();
			
			return data;
		}
		
		public String[][] LogiData() throws BiffException, IOException {
			FileInputStream fileInput = new FileInputStream("src\\main\\resources\\com.qa.testdata\\SSOTestData.xls");
			Workbook workbook = Workbook.getWorkbook(fileInput);
			Sheet sheet = workbook.getSheet("loginData");
			int rows = sheet.getRows();
			int columns = sheet.getColumns();
			String testData[][]= new String [rows-1][columns];
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					testData[i-1][j] = sheet.getCell(j, i).getContents();
					
				}
				
				
			}
			return testData;
		}	
//	@DataProvider(name ="testdata")
	public Object[][] LogiDataDriven()  {
		
		Object[][]data = new Object[4][2];
		
		data[0][0]="vasu.sekar@invicara.com";
		data[0][1]="Test@123";
		
		data[1][0]="asu.sekar@invicara.com";
		data[1][1]="Test@123";
		
		data[2][0]="vasu.sekar@invicara.com";
		data[2][1]="est@123";
				
		data[3][0]="vsu.sekar@invicara.com";
		data[3][1]="Tst@123";	
		
		return data;
	}

		}
	

