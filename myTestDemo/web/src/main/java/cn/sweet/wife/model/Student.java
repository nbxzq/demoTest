package cn.sweet.wife.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author ziqiang.xia
 */
@Data
public class Student {
    @ExcelProperty("学生姓名")
    private String student;
    @ExcelProperty("学生性别")
    private String sex;
}
