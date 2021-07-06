package cn.sweet.wife.service;

import cn.sweet.wife.SweetStartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ziqiang.xia
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SweetStartApplication.class)
public class ValueTest {
    @Value("#{'${app.name}'+'/sector?code=001001&tradeDate=%s'}")
    private String name;
    @Test
    public void test1(){
        System.out.println("name = "+name);
    }
}
