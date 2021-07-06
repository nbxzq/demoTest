package cn.sweet.wife.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ziqiang.xia
 */
@Data
public class ComplexHeadData {
    @ExcelProperty({"主标题", "课程名称"})
    private String course;
    @ExcelProperty({"主标题", "代课老师"})
    private String teacher;
    @ExcelProperty({"主标题", "学生"})
    private List<Student> students;
}
