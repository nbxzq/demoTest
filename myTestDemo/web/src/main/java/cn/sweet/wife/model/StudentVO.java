package cn.sweet.wife.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ziqiang.xia
 */
@Data
public class StudentVO implements Serializable {

    private String id;

    @Excel(name="学生姓名",height = 20,width = 30,isImportField = "true_st")
    private String name;

    @Excel(name="学生性别",replace = {"男_1","女_2"},suffix = "生",isImportField = "true_st")
    private Integer sex;

    @Excel(name="出生日期",databaseFormat="yyyyMMddHHmmss",format = "yyyy-MM-dd",isImportField = "true_st",width = 20)
    private Date birthday;

    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd",width = 20)
    private Date registrationDate;



}
