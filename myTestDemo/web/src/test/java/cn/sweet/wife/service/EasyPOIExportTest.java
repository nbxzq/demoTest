package cn.sweet.wife.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import cn.sweet.wife.entity.CourseEntity;
import cn.sweet.wife.entity.TeacherEntity;
import cn.sweet.wife.model.StudentVO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author ziqiang.xia
 */
public class EasyPOIExportTest {
    @Test
    public void testEntityDefine() throws FileNotFoundException {
        StudentVO studentVO1 = new StudentVO();
        studentVO1.setId("1611");
        studentVO1.setName("lw");
        studentVO1.setBirthday(new Date());
        studentVO1.setRegistrationDate(new Date());
        studentVO1.setSex(1);

        StudentVO studentVO2 = new StudentVO();
        studentVO2.setId("1612");
        studentVO2.setName("sc");
        studentVO2.setBirthday(new Date());
        studentVO2.setRegistrationDate(new Date());
        studentVO2.setSex(2);

        List<StudentVO> list = new ArrayList<>();
        list.add(studentVO1);
        list.add(studentVO2);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生"), StudentVO.class, list);

        File file = new File("/Users/xiaziqiang/Downloads/studentExcel.xlsx");
        if(file.exists()){
            return;
        }
        try(FileOutputStream fos = new FileOutputStream(file)){
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectdefine(){
        StudentVO studentVO1 = new StudentVO();
        studentVO1.setId("1611");
        studentVO1.setName("lw");
        studentVO1.setBirthday(new Date());
        studentVO1.setRegistrationDate(new Date());
        studentVO1.setSex(1);

        StudentVO studentVO2 = new StudentVO();
        studentVO2.setId("1612");
        studentVO2.setName("sc");
        studentVO2.setBirthday(new Date());
        studentVO2.setRegistrationDate(new Date());
        studentVO2.setSex(2);

        List<StudentVO> stulist = new ArrayList<>();
        stulist.add(studentVO1);
        stulist.add(studentVO2);

        TeacherEntity tea1 = new TeacherEntity();
        tea1.setId("2");
        tea1.setTeaName("zd");
        TeacherEntity tea2 = new TeacherEntity();
        tea2.setId("3");
        tea2.setTeaName("ld");

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId("12");
        courseEntity.setCourseName("撒空空");
        courseEntity.setTeacherEntity(tea1);
        courseEntity.setStudentVOS(stulist);
        CourseEntity courseEntity1 = new CourseEntity();
        courseEntity1.setId("2");
        courseEntity1.setCourseName("多少撒");
        courseEntity1.setTeacherEntity(tea2);
        courseEntity1.setStudentVOS(stulist);

        List<CourseEntity> courseEntities = new ArrayList<>();
        courseEntities.add(courseEntity);
        courseEntities.add(courseEntity1);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("2412312", "测试"),
            CourseEntity.class, courseEntities);
        File file = new File("/Users/xiaziqiang/Downloads/studentExcel-1.xlsx");
        try(FileOutputStream fos = new FileOutputStream(file)){
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2() {
        ImportParams params = new ImportParams();
        params.setTitleRows(2);
        params.setHeadRows(2);
        long start = new Date().getTime();
        List<CourseEntity> list = ExcelImportUtil.importExcel(
            new File("/Users/xiaziqiang/Downloads/studentExcel-1.xlsx"),
            CourseEntity.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
    }
    @Test
    public void fe_map() throws Exception {
        TemplateExportParams params = new TemplateExportParams(
            "专项支出用款申请书_map.xls");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2014-12-25");
        map.put("money", 2000000.00);
        map.put("upperMoney", "贰佰万");
        map.put("company", "执笔潜行科技有限公司");
        map.put("bureau", "财政局");
        map.put("person", "JueYue");
        map.put("phone", "1879740****");
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", i + 1 + "");
            lm.put("zijin", i * 10000 + "");
            lm.put("bianma", "A001");
            lm.put("mingcheng", "设计");
            lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
            lm.put("quancheng", "开源项目");
            lm.put("sqje", i * 10000 + "");
            lm.put("hdje", i * 10000 + "");

            listMap.add(lm);
        }
        map.put("maplist", listMap);

        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        FileOutputStream fos = new FileOutputStream("/Users/xiaziqiang/Downloads/studentExcel-2.xlsx");
        workbook.write(fos);
        fos.close();
    }
}
