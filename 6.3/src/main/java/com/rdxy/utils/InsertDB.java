package com.rdxy.utils;


import com.rdxy.entity.Student;
import com.rdxy.service.StudentService;
import com.rdxy.service.impl.StudentServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InsertDB {
    public static void main(String[] args) throws IOException {
        insert();
    }

    /**
     *
     * @author 人道逍遥
     *
     */
    public static void insert() throws IOException {{
        insert("3.5.1/6.3/src/main/webapp/file/Students.xlsx");
    }}
    public static void insert(String path) throws IOException {

        StudentService StudentService=new StudentServiceImpl();

        //调用getObjList方法，得到Product的list集合
        List<Student> Students = getObjList(path);
        System.out.println(Students);
        //插入数据库
        Integer save = StudentService.saveByIds(Students);
        System.out.println("成功插入"+save+"条数据");
    }

    /**
     * 传入文件地址，返回list集合
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Student> getObjList(String path) throws IOException {
        List<Student> lists = new ArrayList<>();
        //获取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(path);
        //过去工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //获取最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        //排除第一行
        for (int i = 1; i <= lastRowNum; i++) {
            //获取每一行
            XSSFRow row = sheet.getRow(i);
            if (row!=null){
                //将每一行封装到一个list中
                List<String> list = new ArrayList<>();
                for (Cell cell : row) {
                    if (cell!=null){
                        //设置单元格类型
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();
                        list.add(value);
                    }
                }
                //将每一行的内容封装为一个实体类
                Student  Student = new Student(Integer.parseInt(list.get(0)),list.get(1),list.get(2),Integer.parseInt(list.get(3)),list.get(4),Integer.parseInt(list.get(5)));
                //将每一个实体类加入到productList中
                lists.add(Student);
            }
        }
        //关闭资源
        workbook.close();
        return lists;
    }
}


/*
git config --global http.sslVerify "false"

git config --global --unset http.proxy
git config --global --unset https.proxy

 */
