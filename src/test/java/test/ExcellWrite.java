package test;

public class ExcellWrite {
    public static void main(String[] args) throws Exception {
      /*  XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;

        String path = "src/SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        //workbook>sheet>row>cell
        //loading Excell workbook into class
        workbook = new XSSFWorkbook(fileInputStream);
        //get our sheet
        sheet = workbook.getSheet("Employees");

        //king's row
        row = sheet.getRow(1);
        //king's cell
        cell = row.getCell(1);
        //storing adam's name cell if you are frequently using it
        XSSFCell adamsCell = sheet.getRow(2).getCell(0);
        System.out.println("Before: " + adamsCell);
        adamsCell.setCellValue("Madam");
        System.out.println("After: " + adamsCell);
        //TODO: CHANGE STEVEN'S NAME TO TOM

        for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Steven")) {
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }


        }
        //create a fileInputStream to specify which file we are writing to
        FileInputStream fileOutputStream = new FileInputStream(path);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();



       */
    }
}
