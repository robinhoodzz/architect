package com.mashibing.arika;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2020/2/5.
 */
@SpringBootApplication
@MapperScan(value = "com.mashibing.arika.mapper")
public class ArikaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArikaApplication.class, args);
    }

}
