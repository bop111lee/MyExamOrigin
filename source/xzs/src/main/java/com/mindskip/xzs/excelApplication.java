package com.mindskip.xzs;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class excelApplication {

    public void readExcel(String filePath) {

        try {

            InputStream is = new FileInputStream(filePath);

            Workbook rwb = Workbook.getWorkbook(is);

            // 这里有两种方法获取sheet表:名字和下标（从0开始）

            // Sheet st = rwb.getSheet("original");

            Sheet st = rwb.getSheet(0);

            /**
             *
             * //获得第一行第一列单元的值
             *
             * Cell c00 = st.getCell(0,0);
             *
             * //通用的获取cell值的方式,返回字符串
             *
             * String strc00 = c00.getContents();
             *
             * //获得cell具体类型值的方式
             *
             * if(c00.getType() == CellType.LABEL)
             *
             * {
             *
             * LabelCell labelc00 = (LabelCell)c00;
             *
             * strc00 = labelc00.getString();
             *
             * }
             *
             * //输出
             *
             * System.out.println(strc00);
             */

            // Sheet的下标是从0开始

            // 获取第一张Sheet表

            Sheet rst = rwb.getSheet(0);

            // 获取Sheet表中所包含的总列数

            int rsColumns = rst.getColumns();

            // 获取Sheet表中所包含的总行数

            int rsRows = rst.getRows();

            // 获取指定单元格的对象引用

            for (int i = 0; i < rsRows; i++) {

                for (int j = 0; j < rsColumns; j++) {
                    if(j == 0 || j == 4){
                        Cell cell = rst.getCell(j, i);

                        System.out.print(cell.getContents() + " ");
                    }

                }

                System.out.println();

            }

            // 关闭

            rwb.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        new excelApplication().readExcel("D:/02.xls");
    }
}