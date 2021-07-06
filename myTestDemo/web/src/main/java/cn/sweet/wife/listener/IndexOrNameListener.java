package cn.sweet.wife.listener;

import cn.sweet.wife.model.DemoData;
import cn.sweet.wife.model.IndexOrNameData;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

/**
 * @author ziqiang.xia
 */
public class IndexOrNameListener extends AnalysisEventListener<IndexOrNameData> {
    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * public DemoDataListener(DemoDAO demoDAO) {
     *         this.demoDAO = demoDAO;
     *     }
     */

    @Override
    public void invoke(IndexOrNameData indexOrNameData, AnalysisContext analysisContext) {
        System.out.println(JSON.toJSONString(indexOrNameData));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("所有数据解析完成！");
    }
}
