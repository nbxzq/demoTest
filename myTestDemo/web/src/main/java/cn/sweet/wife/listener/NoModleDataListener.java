package cn.sweet.wife.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author ziqiang.xia
 */
public class NoModleDataListener extends AnalysisEventListener<Map<Integer,String>> {
    @Override
    public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
        System.out.println("解析到一条数据：" + integerStringMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(" 解析完所有的数据！");
    }
}
