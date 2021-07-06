package cn.sweet.wife.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author ziqiang.xia
 */
@Data
public class DemoData {
    @ExcelProperty("字符串标题")
    private String name;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;

//    private Date date;
//    private Double doubleData;
//    private String string;
//    /**
//     * 忽略这个字段
//     */
//    @ExcelIgnore
//    private String ignore;

}
