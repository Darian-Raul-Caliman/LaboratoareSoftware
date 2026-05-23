package ro.ulbs.proiectaresoftware.lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class Laborator8Aplicatie {

    public static void main(String[] args) {

        String inputFile = "laborator8_input.xlsx";
        String outputFile2 = "laborator8_output2.xlsx";
        String outputFile3 = "laborator8_output3.xlsx";

        System.out.println("citire fisier 1");
        citireSiAfisareExcel(inputFile);

        System.out.println("\nfacem media in java");
        generareFisierCuMediaCalculata(inputFile, outputFile2);

        System.out.println("\nfacem media cu formula");
        generareFisierCuFormulaExcel(inputFile, outputFile3);
    }

    public static void citireSiAfisareExcel(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                        case NUMERIC:
                            System.out.print((int) cell.getNumericCellValue() + "\t\t");
                            break;
                        default:
                            System.out.print(" \t\t");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("eroare citire: " + e.getMessage());
        }
    }

    public static void generareFisierCuMediaCalculata(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    Cell headerCell = row.createCell(6);
                    headerCell.setCellValue("Media Java");
                    continue;
                }

                Cell nota1Cell = row.getCell(3);
                Cell nota2Cell = row.getCell(4);
                Cell nota3Cell = row.getCell(5);

                if (nota1Cell != null && nota2Cell != null && nota3Cell != null) {
                    double nota1 = nota1Cell.getNumericCellValue();
                    double nota2 = nota2Cell.getNumericCellValue();
                    double nota3 = nota3Cell.getNumericCellValue();

                    double media = (nota1 + nota2 + nota3) / 3.0;

                    Cell mediaCell = row.createCell(6);
                    mediaCell.setCellValue(media);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbook.write(fos);
                System.out.println("am salvat " + outputFile);
            }

        } catch (IOException e) {
            System.err.println("eroare scriere media: " + e.getMessage());
        }
    }

    public static void generareFisierCuFormulaExcel(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    Cell headerCell = row.createCell(7);
                    headerCell.setCellValue("Media Formula");
                    continue;
                }

                int excelRowNumber = row.getRowNum() + 1;
                String formula = "AVERAGE(D" + excelRowNumber + ":F" + excelRowNumber + ")";

                Cell formulaCell = row.createCell(7);
                formulaCell.setCellFormula(formula);
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbook.write(fos);
                System.out.println("am salvat " + outputFile);
            }

        } catch (IOException e) {
            System.err.println("eroare la formula: " + e.getMessage());
        }
    }
}