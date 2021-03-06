package cn.sweet.wife.listenerModel.impl;

import cn.sweet.wife.listenerModel.event.ICurdEvent;
import cn.sweet.wife.listenerModel.event.IListener;
import cn.sweet.wife.listenerModel.event.IListenerable;

/**
 * @author ziqiang.xia
 */
//事件源类
public class Some implements IListenerable {
    private IListener listener;
    //注册监听器
    @Override
    public void setListener(IListener listener) {
        this.listener = listener;
    }
    //触发监听器
    @Override
    public void triggerListener(ICurdEvent event) {
        listener.handle(event);
    }
    public void saveStudent(){
        System.out.println("插入了一条数据");
        ICurdEvent event = new CurdEvent(this,"saveStudent");
        this.triggerListener(event);
    }
    public void removeStudent(){
        System.out.println("删除了一条数据");
        ICurdEvent event = new CurdEvent(this,"removeStudent");
        this.triggerListener(event);
    }
    public void modifyStudent(){
        System.out.println("修改了一条数据");
        ICurdEvent event = new CurdEvent(this,"modifyStudent");
        this.triggerListener(event);
    }
    public void findStudent(){
        System.out.println("插入了一条数据");
        ICurdEvent event = new CurdEvent(this,"findStudent");
        this.triggerListener(event);
    }
}