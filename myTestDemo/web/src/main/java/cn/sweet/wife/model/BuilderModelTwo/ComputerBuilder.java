package cn.sweet.wife.model.BuilderModelTwo;

/**
 * @author ziqiang.xia
 */
public class ComputerBuilder {
    private  String cpu;//必须
    private  String ram;//必须
    private  int usbCount;//可选
    private  String keyboard;//可选
    private  String display;//可选

    public ComputerBuilder(String cpu,String ram){
        this.cpu=cpu;
        this.ram=ram;
    }

    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public ComputerBuilder setRam(String ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setUsbCount(int usbCount) {
        this.usbCount = usbCount;
        return this;
    }

    public ComputerBuilder setKeyboard(String keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public ComputerBuilder setDisplay(String display) {
        this.display = display;
        return this;
    }
    public Computer build(){
        return new Computer(this.cpu,this.ram,this.usbCount,this.keyboard,this.display);
    }
}
