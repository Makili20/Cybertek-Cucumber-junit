package com.cybertek.test;

import com.cybertek.pages.GasMileageCalcualtorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class GasMileageTest {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalcualtorPage gasMileageCalcualtorPage = new GasMileageCalcualtorPage();

    @Test
    public void gasMileageCalculatorTest() throws Exception {
        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");
        String path = "src/test/resources/testData/GasMileage.xlsx";
        //loading the file to class
        FileInputStream fileInputStream = new FileInputStream(path);
        //loading the workbook to classs
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");

        for(int rowNum=1;rowNum<= sheet.getLastRowNum();rowNum++) {

            XSSFRow currentRow = sheet.getRow(rowNum);
            if(!currentRow.getCell(0).toString().equals("Y")){
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("Skip Requested!");
                continue;
            }

            // double current = 123000;
            double current = currentRow.getCell(1).getNumericCellValue();
            gasMileageCalcualtorPage.currentOdo.clear();
            gasMileageCalcualtorPage.currentOdo.sendKeys(String.valueOf(current));

            //double prevous = 122000;
            double prevous = currentRow.getCell(2).getNumericCellValue();
            gasMileageCalcualtorPage.prevousOdo.clear();
            gasMileageCalcualtorPage.prevousOdo.sendKeys(String.valueOf(prevous));

            //double gas = 70;
            double gas = currentRow.getCell(3).getNumericCellValue();
            gasMileageCalcualtorPage.gasInput.clear();
            gasMileageCalcualtorPage.gasInput.sendKeys(String.valueOf(gas));

            gasMileageCalcualtorPage.calculateButton.click();

            double expectedResult = (current - prevous) / gas;
            System.out.println("Expected result: " + expectedResult);

            String[] actualResult = gasMileageCalcualtorPage.resultInGas.getText().split(" ");
            System.out.println("Actual result: " + actualResult[0]);
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            System.out.println("Formated version: " + decimalFormat.format(expectedResult));
            //creating the cell if the current cell is empty
            //sending the expected value from our formula
            if (currentRow.getCell(3) == null) {
                currentRow.createCell(3);
            }
            currentRow.getCell(3).setCellValue(decimalFormat.format(expectedResult));

            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }
            currentRow.getCell(4).setCellValue(decimalFormat.format(expectedResult));

            //=================================================================
            //sending the actual result we get from app
            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }

            currentRow.getCell(5).setCellValue(actualResult[0]);


            if (String.valueOf(decimalFormat.format(expectedResult)).equals(actualResult[0])) {
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("PASS!");
                System.out.println("PASS!");
            } else {
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("FAIL!");
                System.out.println("FAIL!");
            }
            //========================
            //getting localdatetime and passing into excell
            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }
            currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());
        }
        //=================================================================

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
