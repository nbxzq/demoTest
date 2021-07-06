package cn.sweet.wife.service;

import cn.sweet.wife.listener.ConverterDataListener;
import cn.sweet.wife.listener.NoModleDataListener;
import cn.sweet.wife.model.ConverterData;
import cn.sweet.wife.listener.DemoDataListener;
import cn.sweet.wife.listener.IndexOrNameListener;
import cn.sweet.wife.model.DemoData;
import cn.sweet.wife.model.FinancingExcelData;
import cn.sweet.wife.model.IndexOrNameData;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.converters.DefaultConverterLoader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ziqiang.xia
 */
public class EasyExcelReadTest {
    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>3. 直接读即可
     */
    @Test
    public void testSimpleRead(){
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        EasyExcel.read("/Users/xiaziqiang/Downloads/test/my1.xlsx", DemoData.class,new DemoDataListener()).sheet().doRead();
    }

    @Test
    public void testIndexOrNameData(){
        EasyExcel.read("/Users/xiaziqiang/Downloads/test/my1.xlsx", IndexOrNameData.class,new IndexOrNameListener()).sheet().doRead();
    }

    /**
     * 多个sheet的读取
     */
    @Test
    public void testRepeatedRead(){
        // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
        EasyExcel.read("/Users/xiaziqiang/Downloads/test/my1.xlsx", DemoData.class, new DemoDataListener()).doReadAll();

        // 读取部分sheet
        ExcelReader excelReader = EasyExcel.read("/Users/xiaziqiang/Downloads/test/my1.xlsx").build();
        // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
        ReadSheet readSheet1 =
            EasyExcel.readSheet(0).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
        ReadSheet readSheet2 =
            EasyExcel.readSheet(1).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
        // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
        excelReader.read(readSheet1, readSheet2);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }

    /**
     * 日期、数字或者自定义格式转换
     * <p>
     * 默认读的转换器{@link DefaultConverterLoader#loadDefaultReadConverter()}
     * <p>1. 创建excel对应的实体对象 参照{@link ConverterData}.里面可以使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link ConverterDataListener}
     * <p>3. 直接读即可
     */
    @Test
    public void testConverterRead(){
        EasyExcel.read("/Users/xiaziqiang/Downloads/test/my1.xlsx", ConverterData.class, new ConverterDataListener())
            // 这里注意 我们也可以registerConverter来指定自定义转换器， 但是这个转换变成全局了， 所有java为string,excel为string的都会用这个转换器。
            // 如果就想单个字段使用请使用@ExcelProperty 指定converter
            // .registerConverter(new CustomStringStringConverter())
            // 读取sheet
            .sheet().doRead();
    }

    /**
     * 不创建对象的读，不是特别推荐使用，都用String接收对日期的支持不是很好
     */
    @Test
    public void testNoModelDataRead(){
        EasyExcel.read("/Users/xiaziqiang/Downloads/test/my1.xlsx",new NoModleDataListener()).sheet(0).doRead();
    }



}
