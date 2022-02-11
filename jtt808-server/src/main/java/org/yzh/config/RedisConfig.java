package org.yzh.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.util.Properties;

public class RedisConfig {

    private static String hosts;
    private static Integer ports;

    static {
        YamlPropertiesFactoryBean yamlProFb = new YamlPropertiesFactoryBean();
        yamlProFb.setResources(new ClassPathResource("application.yml"));
        Properties properties = yamlProFb.getObject();
        hosts =(String) properties.get("spring.redis.host");
        ports =(Integer) properties.get("spring.redis.port");
    }

    public static RedisTemplate<String, Object> getRedisTemplate() {
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setPort(ports);
        rsc.setHostName(hosts);

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        JedisConnectionFactory fac = new JedisConnectionFactory(rsc);

        fac.afterPropertiesSet();
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(fac);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }


//    @Bean(name = "findRedisTemplate")
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
//        rsc.setPort(port);
//        rsc.setHostName(host);
//
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//        JedisConnectionFactory fac = new JedisConnectionFactory(rsc);
//
//        fac.afterPropertiesSet();
//        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
//        redisTemplate.setConnectionFactory(fac);
//        redisTemplate.afterPropertiesSet();
//
//        return redisTemplate;
//    }


//    public static void main(String[] args) {
//        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
//        rsc.setPort(6379);
//        rsc.setHostName("127.0.0.1");
//
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//        JedisConnectionFactory fac = new JedisConnectionFactory(rsc);
//
//        fac.afterPropertiesSet();
//        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
//        redisTemplate.setConnectionFactory(fac);
//        redisTemplate.afterPropertiesSet();
//
////        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
//        HashOperations<String, String, Object> c = redisTemplate.opsForHash();
//
//        Map<String, Object> terminalKey = c.entries("terminalKey");
//
//        System.out.println(terminalKey.containsKey("test123"));
//
//    }

}
