package cn.sweet.wife.listenerModel.impl;

import cn.sweet.wife.listenerModel.event.ICurdEvent;
import cn.sweet.wife.listenerModel.event.IListener;

/**
 * @author ziqiang.xia
 */
//定义监听器类
public class Listener implements IListener {
    @Override
    public void handle(ICurdEvent event) {
        String eventType = event.getEventType();
        if (ICurdEvent.Create_EVENT.equals(eventType)){
            System.out.println("添加操作");
        }else if (ICurdEvent.Delete_EVENT.equals(eventType)){
            System.out.println("删除操作");
        }else if (ICurdEvent.Update_EVENT.equals(eventType)){
            System.out.println("修改操作");
        }else if (ICurdEvent.Retrieve_EVENT.equals(eventType)){
            System.out.println("查找操作");
        }
    }
}
