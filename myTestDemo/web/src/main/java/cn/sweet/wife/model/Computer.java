package cn.sweet.wife.model;

import cn.sweet.wife.model.BuilderModelTwo.ComputerBuilder;
import org.apache.commons.collections4.sequence.EditScript;

/**
 * @author ziqiang.xia
 * 在Computer 中创建一个静态内部类 Builder，然后将Computer 中的参数都复制到Builder类中。
 * 在Computer中创建一个private的构造函数，参数为Builder类型
 * 在Builder中创建一个public的构造函数，参数为Computer中必填的那些参数，cpu 和ram。
 * 在Builder中创建设置函数，对Computer中那些可选参数进行赋值，返回值为Builder类型的实例
 * 在Builder中创建一个build()方法，在其中构建Computer的实例并返回
 */
public class Computer {
    private  String cpu;//必须
    private  int usbCount;//可选



    private Computer(Builder builder){
        this.cpu=builder.cpu;
        this.usbCount=builder.usbCount;
    }

    public static Computer.Builder computerBuilder(String cpu){
        return new Computer.Builder(cpu);
    }

    public static class Builder{
        private  String cpu;//必须
        private  int usbCount;//可选

        public Builder(String cpu){
            this.cpu=cpu;
        }

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }

        public Computer build(){
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            return new Computer(this);
        }
    }

    public String getCpu() {
        return cpu;
    }


    public int getUsbCount() {
        return usbCount;
    }
}
