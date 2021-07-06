package cn.sweet.wife.listener;

import cn.sweet.wife.model.ConverterData;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

/**
 * @author ziqiang.xia
 */
public class ConverterDataListener extends AnalysisEventListener<ConverterData> {
    @Override
    public void invoke(ConverterData converterData, AnalysisContext analysisContext) {
        System.out.println(JSON.toJSONString(converterData));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("所有数据解析完成！");
    }
}
