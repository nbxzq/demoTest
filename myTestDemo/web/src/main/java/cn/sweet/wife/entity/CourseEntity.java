package cn.sweet.wife.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.sweet.wife.model.StudentVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ziqiang.xia
 */
@Data
public class CourseEntity implements Serializable {
    private String id;

    @Excel(name="课程名称",orderNum = "1",width = 25,needMerge = true)
    private String courseName;

    @ExcelEntity(id="absent")
    private TeacherEntity teacherEntity;

    @ExcelCollection(name="学生",orderNum = "4")
    private List<StudentVO> studentVOS;
}
