package edu.lnu;

import edu.lnu.domain.User;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meiling on 2016/7/15.
 */
public class TextExcel {
    public static List<User> getAllByExcel(String file) {
        List<User> list = new ArrayList<User>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos = rs.getColumns();//得到所有的列
            int rows = rs.getRows();//得到所有的行

            System.out.println(clos + " rows:" + rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String sno = rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name = rs.getCell(j++, i).getContents();
                    String sex = rs.getCell(j++, i).getContents();
                    String level = rs.getCell(j++, i).getContents();
                    String profession = rs.getCell(j++, i).getContents();
                    String password = rs.getCell(j++, i).getContents();
                    String limitation = rs.getCell(j++, i).getContents();

                    System.out.println("sno:" + sno + " name:" + name + " sex:" + sex + " profession:" + profession + "limitation=" + limitation);
                    //list.add(new User(Integer.parseInt(id), name, sex, Integer.parseInt(num)));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

 /*   private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    public static List<User> readXls(String file) throws IOException {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(new File(file)));
        User student = null;
        List<User> list = new ArrayList<User>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                for (int j = 0; j < 7; j++) {
                    if (hssfRow != null) {
                        student = new User();
                        HSSFCell sno = hssfRow.getCell(j++);
                        HSSFCell name = hssfRow.getCell(j++);
                        HSSFCell sex = hssfRow.getCell(j++);
                        HSSFCell level = hssfRow.getCell(j++);
                        HSSFCell profesion = hssfRow.getCell(j++);
                        HSSFCell password = hssfRow.getCell(j++);
                        HSSFCell limitation = hssfRow.getCell(j++);
                        student.setSno(Integer.parseInt(sno.getNumericCellValue()+""));
                        student.setName(name.getStringCellValue());
                        student.setSex(getValue(sex));
                        student.setLevel( getValue(level) );
                        student.setProfession( getValue(profesion) );
                        student.setLimitation( getValue(limitation) );
                        list.add(student);
                    }
                }

            }
        }
        return list;
    }*/

    public static void main(String[] args) {
      getAllByExcel("d://student.xls");
        /*try {
          List <User> users=  readXls("d://student.xlsx");
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
