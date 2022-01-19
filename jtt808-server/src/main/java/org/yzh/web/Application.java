package org.yzh.web;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.yzh.web.service.impl.RegisterHandle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@EnableScheduling
@EnableSwagger2
@EnableWebSocketMessageBroker
@MapperScan("org.yzh.web.mapper")
@SpringBootApplication
public class Application implements ApplicationListener<ContextClosedEvent> {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    private final RegisterHandle registerHandle;

    public Application(RegisterHandle registerHandle) {
        this.registerHandle = registerHandle;
    }

    public static void main(String[] args) {
        //Hikari连接池提供的JDBC Connection连接有效性检测,默认为500毫秒
        System.setProperty("com.zaxxer.hikari.aliveBypassWindowMs", "2000");
        SpringApplication.run(Application.class, args);
        log.info("***Spring 启动成功***");

    }

    /**
     * 系统需要采用 kill -2的方式才会触发优雅停机
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.error("程序关闭了");
        registerHandle.stop();

    }
}