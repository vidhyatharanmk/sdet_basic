package com.vidhyatharan.sdet.basic.restassured;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

	public static Map<String, String> readCredentials(String filePath, String sheetName) {
		System.out.println("Read credentials start");

		Map<String, String> credentials = new HashMap<>();
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				System.out.println("Sheet '" + sheetName + "' not found.");
				return credentials;
			}

			Row row = sheet.getRow(1);
			if (row == null) {
				System.out.println("Row 1 is empty or missing.");
				return credentials;
			}

			System.out.println("Value in A2 cell : " + row.getCell(0));
			System.out.println("Value in B2 cell : " + row.getCell(1));

			if (row.getCell(0) != null) {
				credentials.put("email", row.getCell(0).getStringCellValue());
			} else {
				System.out.println("Email cell is missing.");
			}

			if (row.getCell(1) != null) {
				credentials.put("password", row.getCell(1).getStringCellValue());
			} else {
				System.out.println("Password cell is missing.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Read credentials return");
		return credentials;
	}
}