package com.mashibing.cache.config;

/*
* 设置RedisTemplate的序列化方式
*/

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*因为添加了飞马框架依赖，这些就不用写了*/
/*@Configuration
public class RedisConfig {

    //配置好的 Redis 操作对象
    @Bean   //把这个方法交给Spring管理，Spring会把它做成一个全局可用的工具
    public <T> RedisTemplate<String, T> redisTemplate(RedisConnectionFactory factory) {
        //1.构建RedisTemplate对象
        RedisTemplate<String, T> redisTemplate = new RedisTemplate<>();

        //2.设置RedisConnectionFactory到redisTemplate
        redisTemplate.setConnectionFactory(factory);

        //3.设置redis的key的序列化方式（java里面的日期，对象，中文，必须序列化后才能存入redis，这里用字符串序列化方式）
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());

        //4.设置redis的value的序列化方式（用下面定义的redisSerializer()作为value的格式）
        redisTemplate.setValueSerializer(redisSerializer());
        redisTemplate.setHashValueSerializer(redisSerializer());

        //5.保证生效
        redisTemplate.afterPropertiesSet();

        //6.返回redisTemplate
        return redisTemplate;
    }

    //专门处理 Value 序列化的工具（默认的ObjectMapper不支持 JDK8 新日期（LocalDate/LocalDateTime））
    // Java 对象、中文，打包成人类能看懂的 JSON 字符串，例如：{"name":"张三","age":18}
    @Bean
    public RedisSerializer<Object> redisSerializer(){
        //1.构建Jackson的ObjectMapper

        *//*把 Java 对象 → JSON 字符串（存 Redis）
        * 把 JSON 字符串 → Java 对象（从 Redis 读）
        * Java 和 JSON 之间的专属翻译官*//*
        ObjectMapper objectMapper = new ObjectMapper();

        //2.设置jdk8日期格式的支持
        // 定义日期格式：只有年月日（2025-12-25）
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 定义时间格式：年月日+时分秒（2025-12-25 15:30:00）
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 创建JDK8日期专用模块（Jackson官方提供，专门处理新日期）
        Module timeModule = new JavaTimeModule()
                // 配置：读数据时 → 把JSON字符串转回 LocalDate
                .addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter))
                // 配置：读数据时 → 把JSON字符串转回 LocalDateTime
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter))
                // 配置：存数据时 → 把 LocalDate 转成指定格式字符串
                .addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter))
                // 配置：存数据时 → 把 LocalDateTime 转成指定格式字符串
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
        // 将日期处理模块 注册到 ObjectMapper 中，ObjectMapper 拥有处理 JDK8 日期的能力
        objectMapper.registerModule(timeModule);


        //3.构建Jackson2JsonRedisSerializer（Jackson2JsonRedisSerializer 是 Spring 官方提供的工具：把 Java 对象转成 JSON，存入 Redis）
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        //4.将我们配置好的 ObjectMapper（支持日期、格式化）绑定到序列化器上，让序列化器按照我们的规则转换数据
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        //5.返回Jackson2JsonRedisSerializer，供给 RedisTemplate 使用
        return jackson2JsonRedisSerializer;
    }
}*/
