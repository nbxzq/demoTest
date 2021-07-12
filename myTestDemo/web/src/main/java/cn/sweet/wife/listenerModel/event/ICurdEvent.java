package cn.sweet.wife.listenerModel.event;

/**
 * 事件接口
 * @author ziqiang.xia
 */
//定义增删改查事件
//C: Create
//U: Update
//R: Retrieve
//D: Delete
//通常对于事件对象，我们一般需要从事件对象中获取到事件源对象
public interface ICurdEvent{
    //声明事件类型
    String Create_EVENT = "create event";
    String Update_EVENT = "update event";
    String Retrieve_EVENT = "retrieve event";
    String Delete_EVENT = "delete event";
    //获取事件源对象
    IListenerable getEventSource();
    //获取事件类型
    String getEventType();

}