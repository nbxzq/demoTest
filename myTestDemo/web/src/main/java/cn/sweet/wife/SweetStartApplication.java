package cn.sweet.wife;

import com.rabbitmq.client.AMQP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author ziqiang.xia
 */
@SpringBootApplication
public class SweetStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SweetStartApplication.class);
    }
}
