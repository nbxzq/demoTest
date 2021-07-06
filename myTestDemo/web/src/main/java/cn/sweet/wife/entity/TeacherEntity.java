package cn.sweet.wife.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ziqiang.xia
 */
@ExcelTarget("teacherEntity")
@Data
public class TeacherEntity implements Serializable {
    private String id;

    @Excel(name="主讲老师_major,代课老师_absent",orderNum = "1",needMerge = true,isImportField = "true_major,true_absent")
    private String teaName;
}
