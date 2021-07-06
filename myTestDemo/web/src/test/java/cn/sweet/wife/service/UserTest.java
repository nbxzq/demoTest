package cn.sweet.wife.service;

import cn.sweet.wife.model.Apple;
import cn.sweet.wife.model.BuilderModelTwo.ComputerBuilder;
import cn.sweet.wife.model.Computer;
import cn.sweet.wife.model.User;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author ziqiang.xia
 */
@SpringBootTest
public class UserTest {
    @Test
    public void test1(){
        List<String> list = new ArrayList<String>();
        Collections.addAll(list,"a","b","c");
        for (String str : list) {
            if("b".equals(str)){
                break;
            }
            System.out.println(str);
        }
    }
    @Test
    public void test2(){
        String s ="https://an-announcement.oss-cn-shanghai.aliyuncs.com/asd";
        String[] split = s.split("/");
        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }
        System.out.println(split[split.length-1]);
    }
    @Test
    public void test3(){

        String tm = String.valueOf(System.currentTimeMillis());
        System.out.println("tm = " + tm);
    }
    /*
    * 解析excel表格中的数据
    * */
    @Test
    public void testExecl() throws Exception {
//        File file = new File("/Users/xiaziqiang/Downloads/股权激励对象导入模板.xlsx");
//        Workbook wb = ExcelUtil.initExcel(file.getAbsolutePath());
//        Sheet sheet = wb.getSheet("二类限制性股票");
//        Row row = sheet.getRow(2);
//        Object ejczjdm = (Object)ExcelUtil.getCellFormatValue(row.getCell(2));
//        System.out.println("ejczjdm = " + ejczjdm);
    }

    @Test
    public void test4(){
//        CompletableFuture.supplyAsync(String s->{
//               Integer.parseInt(s);
//        }).thenApply(r -> r * 2 * Math.PI)
//            .thenApply(s -> "apply>> " + s)
//            .handle((result, ex) -> {
//                if (result != null) {
//                    return result;
//                } else {
//                    return "Error handling: " + ex.getMessage();
//                }
//            });
    }
    @Test
    public void test5() throws IOException {
        File file = new File("/Users/xiaziqiang/Downloads/test.txt");
        if(!file.exists()){
            return;
        }
        InputStream in = new FileInputStream(file);
        byte[] bty=new byte[1024*8];
        int count =0;
        StringBuilder sb = new StringBuilder();
        while((count=in.read(bty))!=-1){
            sb.append(new String(bty,0,count));

        }
        in.close();
        System.out.println("sb = " + sb.toString());

//        //读取指定路径下面的文件
//        InputStream in = new FileInputStream(picFile);
//        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//        //创建存放文件内容的数组
//        byte[] buff =new byte[1024];
//        //所读取的内容使用n来接收
//        int n;
//        //当没有读取完时,继续读取,循环
//        while((n=in.read(buff))!=-1){
//            //将字节数组的数据全部写入到输出流中
//            outputStream.write(buff,0,n);
//        }
//        //强制将缓存区的数据进行输出
//        outputStream.flush();
//        //关流
//        outputStream.close();
//        in.close();
    }

    @Test
    public void test6(){
        User user = new User("xzq", 12, "ts");
        User user1 = new User("ln", 11, "tds");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        List<User> list = users.stream().map(source -> {
            source.setAge(source.getAge() + 1);
            return source;
        }).collect(Collectors.toList());
        System.out.println("list = " + list);
    }

    @Test
    public void test7(){
        Map<String, Object> map = new HashMap<>();
        map.put("aqw", "asdad");
        map.put("wqa", 123);
        User user = new User();
        user.setAge(12);
        String string = JSONObject.toJSONString(map);
        System.out.println(map.toString());
        System.out.println("string = " + string);

//        public static void main(String[] args) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("111", "asdad");
//            map.put("222", 123);
//            User user = new User();
//            user.setEmail("asaad");
//            user.setLevel(1);
//            System.out.println(map.toString());
//            System.out.println(JSONObject.toJSONString(map));
//            JSONObject result1 = JSONObject.parseObject(JSONObject.toJSONString(map));
//            JSONObject result = JSONObject.parseObject(map.toString());
//            System.out.println("result = " + result);
//        }



    }

    @Test
    public void testBuilderModel(){
        System.out.println(System.currentTimeMillis());
//        Apple apple = new Apple();
//        Apple.AppleBuilder a= apple.new AppleBuilder();

        Computer computer = Computer.computerBuilder("M1").setUsbCount(12).build();


        cn.sweet.wife.model.BuilderModelTwo.Computer computer1 = new ComputerBuilder("m1", "sax").setKeyboard("haisi").build();


        Apple apple = Apple.builder().color("red").prise(12.9).size("12").build();
        System.out.println("apple = " + apple);

        User user = new User();

    }


}
