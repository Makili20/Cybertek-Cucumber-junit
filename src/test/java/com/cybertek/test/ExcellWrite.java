package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcellWrite {
    public static void main(String[] args) throws Exception {
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;

        String path = "src/SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        //woorkbook>sheet>row>cell
        workbook = new XSSFWorkbook(fileInputStream);
        //get ou=r sheet
        sheet = workbook.getSheet("Employees");
        //king's row
        row = sheet.getRow(1);
        //king's cell
        cell = row.getCell(1);
        //storing adam's name cell if you are frequently using it

        XSSFCell adamsCell = sheet.getRow(2).getCell(0);
        System.out.println("Before: " + adamsCell);
        adamsCell.setCellValue("madam");
//create a fileOutputStream to specify which file we are writing to
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

        //TODO:CHANGE STEVEN'S NAME TO TOM
        for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Steven")) {
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }
        }


    }}
