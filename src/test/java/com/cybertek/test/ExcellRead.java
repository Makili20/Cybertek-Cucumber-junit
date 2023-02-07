package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcellRead {
    public ExcellRead() throws IOException {
    }

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\marij\\Cybertek-Cucumber-junit\\src\\SampleData.xlsx");
        //  System.out.println(file.exists());
        //load the fileinto java memory using fileinputstream

        FileInputStream fileInputStream = new FileInputStream(file);
//load the excell workbook into the java class
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //workn=book>sheet>row>cell
        //getting the sheet from the workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        // System.out.println(sheet);
        //How to get Sandler from Excell sheet?

        System.out.println(sheet.getRow(2).getCell(1));

        int usedRows = sheet.getPhysicalNumberOfRows();
        //will count only the used cells
        //if there are some cells that are not used,they will not be count
        //starts counting from 1


        int lastUsedRow = sheet.getLastRowNum();
        //ill count from top to buttom
        //does not care if empty cell or used cell
        //this starts form 0


        //TODO:1-CREATE A LOGIC THAT PRINTS OUT NEENA'S NAME DINAMICALLY
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")) {
                System.out.println("Neena's name: " + sheet.getRow(rowNum).getCell(0));
            }
        }


        //TODO:2-CREATE A LOGIC THAT PRINTS OUT Adam'S LAST NAME DINAMICALLY
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Adam")) {
                System.out.println("Adam's last name: " + sheet.getRow(rowNum).getCell(1));
            }
        }
        //TODO:3-print out king's job-id dinamically
for(int rowNum=0;rowNum<usedRows;rowNum++){
    if(sheet.getRow(rowNum).getCell(1).toString().equals("King")){
        System.out.println("King's JOB-ID: "+sheet.getRow(rowNum).getCell(2));
    }
}






    }
    }