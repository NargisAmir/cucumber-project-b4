package io.loop.utilities;

import org.apache.logging.log4j.core.util.JsonUtils;

public class TestExcel {

    public static void main(String[] args) {


        ExcelUtils excelUtils = new ExcelUtils("C:\\IdeaProjects\\cucumber-project-b4\\src\\test\\resources\\Book1.xlsx", "Sheet1");
        System.out.println("excelUtils = " + excelUtils.getCellData(0,0));

        excelUtils.setCellData("nargiz is hungry",2,4);


    }
}