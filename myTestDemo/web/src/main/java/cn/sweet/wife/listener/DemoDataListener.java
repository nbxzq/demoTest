package cn.sweet.wife.listener;

import cn.sweet.wife.model.DemoData;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author ziqiang.xia
 */
@Slf4j
public class DemoDataListener extends AnalysisEventListener<DemoData> {

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * public DemoDataListener(DemoDAO demoDAO) {
     *         this.demoDAO = demoDAO;
     *     }
     */

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        log.info("解析到一条数据{}", JSON.toJSONString(demoData));
        System.out.println(JSON.toJSONString(demoData));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
        System.out.println("所有数据解析完成！");
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
       // super.invokeHeadMap(headMap, context);
        System.out.println(JSON.toJSONString(headMap));
    }
}
