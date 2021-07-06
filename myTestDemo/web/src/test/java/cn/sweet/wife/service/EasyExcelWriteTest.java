package cn.sweet.wife.service;

import cn.sweet.wife.listener.IndexData;
import cn.sweet.wife.model.*;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * @author ziqiang.xia
 */
public class EasyExcelWriteTest {

    /**
     * 通用的数据生成
     * @return
     */
    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setName("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    /**
     * 最简单的写
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 直接写即可
     */
    @Test
    public void testDemoData(){
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx",DemoData.class).sheet("模板").doWrite(data());

        ExcelWriter excelWriter = EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx",DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(data(),writeSheet);
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }


    /**
     * 根据参数只导出指定列
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 根据自己或者排除自己需要的列
     * <p>
     * 3. 直接写即可
     *
     * @since 2.1.1
     */
    @Test
    public void testExcludeOrIncludeWrite(){
        /*// 根据用户传入字段 假设我们要忽略 date
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("date");
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx", DemoData.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("模板")
            .doWrite(data());*/


        // 根据用户传入字段 假设我们只要导出 date
        List<String> includeColumnFiledNames = new ArrayList<String>();
        includeColumnFiledNames.add("date");
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx", DemoData.class).includeColumnFiledNames(includeColumnFiledNames).sheet("模板1")
            .doWrite(data());
    }

    /**
     * 指定写入的列
     * <p>1. 创建excel对应的实体对象 参照{@link IndexData}
     * <p>2. 使用{@link ExcelProperty}注解指定写入的列
     * <p>3. 直接写即可
     */
    @Test
    public void testIndexWrite() {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx", IndexData.class).sheet("模板").doWrite(data());
    }

    @Test
    public void testComplexHead(){
        List<ComplexHeadData> complexHeadData = new ArrayList<ComplexHeadData>();
        Student student = new Student();
        student.setStudent("xzq");
        student.setSex("男");
        Student student1 = new Student();
        student1.setStudent("xzqwq");
        student1.setSex("女");

        ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students,student,student1);

        ComplexHeadData complexHeadData2 = new ComplexHeadData();
        complexHeadData2.setTeacher("xza");
        complexHeadData2.setCourse("爱江山");
        complexHeadData2.setStudents(students);

       complexHeadData.add(complexHeadData2);

        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx", ComplexHeadData.class).sheet("模板2").doWrite(complexHeadData);

    }

    /**
     * 重复多次写入(写到单个或者多个Sheet)
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ComplexHeadData}
     * <p>
     * 2. 使用{@link ExcelProperty}注解指定复杂的头
     * <p>
     * 3. 直接调用二次写入即可
     */
    @Test
    public void repeatedWrite() {
        // 方法1 如果写到同一个sheet
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx", DemoData.class).build();
        // 这里注意 如果同一个sheet只要创建一次
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
        for (int i = 0; i < 5; i++) {
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<DemoData> data = data();
            excelWriter.write(data, writeSheet);
        }
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();

        // 方法2 如果写到不同的sheet 同一个对象
        // 这里 指定文件
        excelWriter = EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx", DemoData.class).build();
        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
        for (int i = 0; i < 5; i++) {
            // 每次都要创建writeSheet 这里注意必须指定sheetNo
            writeSheet = EasyExcel.writerSheet(i, "模板").build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<DemoData> data = data();
            excelWriter.write(data, writeSheet);
        }
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();

        // 方法3 如果写到不同的sheet 不同的对象
        // 这里 指定文件
        excelWriter = EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx").build();
        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
        for (int i = 0; i < 5; i++) {
            // 每次都要创建writeSheet 这里注意必须指定sheetNo。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
            writeSheet = EasyExcel.writerSheet(i, "模板").head(DemoData.class).build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<DemoData> data = data();
            excelWriter.write(data, writeSheet);
        }
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }
    /**
     * 图片导出
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ImageData}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void imageWrite() throws Exception {
        // 如果使用流 记得关闭
        InputStream inputStream = null;
        try {
            List<ImageData> list = new ArrayList<ImageData>();
            ImageData imageData = new ImageData();
            list.add(imageData);

            // 放入五种类型的图片 实际使用只要选一种即可
            imageData.setUrl(new URL(
                "https://raw.githubusercontent.com/alibaba/easyexcel/master/src/test/resources/converter/img.jpg"));
            EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx", ImageData.class).sheet().doWrite(list);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * 根据模板写入
     * <p>1. 创建excel对应的实体对象 参照{@link IndexData}
     * <p>2. 使用{@link ExcelProperty}注解指定写入的列
     * <p>3. 使用withTemplate 写取模板
     * <p>4. 直接写即可
     */
    @Test
    public void templateWrite() {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my2.xlsx", DemoData.class).withTemplate("/Users/xiaziqiang/Downloads/test/my3.xlsx").sheet().doWrite(data());
    }

    /**
     * 列宽、行高
     * <p>1. 创建excel对应的实体对象 参照{@link WidthAndHeightData}
     * <p>2. 使用注解{@link ColumnWidth}、{@link HeadRowHeight}、{@link ContentRowHeight}指定宽度或高度
     * <p>3. 直接写即可
     */
    @Test
    public void widthAndHeightWrite() {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my3.xlsx", WidthAndHeightData.class).sheet("模板").doWrite(data());
    }

    /**
     * 自定义样式
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 创建一个style策略 并注册
     * <p>3. 直接写即可
     */
    @Test
    public void styleWrite() {
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景设置为红色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short)20);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        contentWriteCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        contentWriteFont.setFontHeightInPoints((short)20);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
            new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my3.xlsx", DemoData.class).registerWriteHandler(horizontalCellStyleStrategy).sheet("模板")
            .doWrite(data());
    }

    /**
     * 简单的模板填充
     *   {} 代表普通变量 {.} 代表是list的变量
     */
    @Test
    public void testSimpleFill(){
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替

        //方式一：根据对象填充
//        FillData fillData = new FillData();
//        fillData.setName("xzq");
//        fillData.setNumber(1234);
//
//        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my6.xlsx").withTemplate("/Users/xiaziqiang/Downloads/test/my4.xlsx").sheet().doFill(fillData);

        //方式二： 根据Map填充
        Map<String, Object> map = new HashMap<>();
        map.put("name","xzq");
        map.put("number","1234");
        EasyExcel.write("/Users/xiaziqiang/Downloads/test/my6.xlsx").withTemplate("/Users/xiaziqiang/Downloads/test/my4.xlsx").sheet().doFill(map);
    }

    @Test
    public void testListFill(){
        //方案一：一下子全部放到内存里面并填充
        FillData fillData = new FillData();
        fillData.setName("xzq");
        fillData.setNumber(1234);
        EasyExcel.write().withTemplate("/Users/xiaziqiang/Downloads/test/my3.xlsx").sheet().doFill(fillData);

        // 方案2 分多次 填充 会使用文件缓存（省内存）
        ExcelWriter excelWriter = EasyExcel.write("/Users/xiaziqiang/Downloads/test/my3.xlsx").withTemplate("/Users/xiaziqiang/Downloads/test/my3.xlsx").build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        excelWriter.fill(data(), writeSheet);
        excelWriter.fill(data(), writeSheet);
        // 千万别忘记关闭流
        excelWriter.finish();

    }

    /**
     * 填充的写
     * @throws IOException
     */
    @Test
    public void testTemplateWrite() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("template/excel/融资融券情况分析模板.xlsx");
        File file = new File("/Users/xiaziqiang/Downloads/test/temp.xlsx");
        String code ="680000";
        String name="子衿集团";
        ExcelWriter excelWriter = EasyExcel.write(file).withTemplate(classPathResource.getInputStream()).build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
        excelWriter.fill(getData(),writeSheet);

        Map<String, Object> headMap = new HashMap<>(16);
        headMap.put("code", code);
        headMap.put("name", name);
        excelWriter.fill(headMap, writeSheet);
        excelWriter.finish();
    }

    public List<FinancingExcelData> getData(){
        FinancingExcelData financingExcelData = new FinancingExcelData();
        financingExcelData.setTradeDate("2021年06月15日");
        financingExcelData.setFinpurch("4,658.26万");
        financingExcelData.setFinpmt("5,187.61万");
        financingExcelData.setBuy("5.21亿");
        financingExcelData.setFinbalance("5.73亿");
        financingExcelData.setFinbalancetoliqmu("63.5356");
        financingExcelData.setSecsold("2.39万");
        financingExcelData.setSecpmt("28.77万");
        financingExcelData.setSales("-26.38万");
        financingExcelData.setSecbalancevol("126.38万");
        financingExcelData.setSecbalance("8.07亿");
        financingExcelData.setSecbalancetoliqmu("0.8955");
        List<FinancingExcelData> list = new ArrayList<>();
        list.add(financingExcelData);
        return list;
    }


}
